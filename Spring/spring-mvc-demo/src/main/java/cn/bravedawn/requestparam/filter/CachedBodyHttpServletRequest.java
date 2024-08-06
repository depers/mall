package cn.bravedawn.requestparam.filter;

import cn.hutool.core.io.IoUtil;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import jakarta.servlet.ServletInputStream;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletRequestWrapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.catalina.connector.CoyoteInputStream;
import org.apache.catalina.connector.InputBuffer;
import org.apache.catalina.connector.Request;
import org.apache.catalina.connector.RequestFacade;
import org.springframework.beans.BeanUtils;
import org.springframework.util.ReflectionUtils;
import org.springframework.util.StreamUtils;


import java.io.*;
import java.lang.reflect.Field;
import java.nio.ByteBuffer;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.nio.channels.WritableByteChannel;

/**
 * @author : depers
 * @program : jasper
 * @description:
 * @date : Created in 2023/4/8 17:28
 */

@Slf4j
public class CachedBodyHttpServletRequest extends HttpServletRequestWrapper {

    private  byte[] cachedBody;


    public CachedBodyHttpServletRequest(HttpServletRequest request) throws IOException, IllegalAccessException {
        super(request);
        try {
            Field requestFacadeField = ReflectionUtils.findField(RequestFacade.class, "request");
            requestFacadeField.setAccessible(true);
            Object realRequest = requestFacadeField.get(request);
            Field field = ReflectionUtils.findField(Request.class, "inputStream");
            field.setAccessible(true);
            CoyoteInputStream requestInputStream = (CoyoteInputStream) field.get(realRequest);

            // ByteBuffer wrap = ByteBuffer.wrap(new byte[0]);
            // InputBuffer inputBuffer = new InputBuffer();
            // inputBuffer.setByteBuffer(wrap);
            // CoyoteInputStream coyoteInputStream = new MyCoyoteInputStream(inputBuffer);

            // 采用jackson进行深拷贝
            Gson gson = new GsonBuilder().setPrettyPrinting()
                    .excludeFieldsWithoutExposeAnnotation()
                    .create();

            CoyoteInputStream coyoteInputStream = gson.fromJson(gson.toJson(requestInputStream), CoyoteInputStream.class);
            this.cachedBody = StreamUtils.copyToByteArray(coyoteInputStream);
            log.info("完成");
        } catch (Throwable e) {
            e.printStackTrace();
        }


        // 重置inputStream

        /*ByteBuffer wrap = ByteBuffer.wrap(this.cachedBody);
        InputBuffer inputBuffer = new InputBuffer();
        inputBuffer.setByteBuffer(wrap);
        CoyoteInputStream coyoteInputStream = new MyCoyoteInputStream(inputBuffer);
        Field inputBufferField = ReflectionUtils.findField(CoyoteInputStream.class, "inputBuffer");
        inputBufferField.setAccessible(true);
        InputBuffer inputBuffer1 = (InputBuffer) inputBufferField.get(requestInputStream);
        coyoteInputStream.setReadListener();
        Field field = ReflectionUtils.findField(Request.class, "inputStream");
        Field usingInputStreamField = ReflectionUtils.findField(Request.class, "usingInputStream");
        Field request1 = ReflectionUtils.findField(RequestFacade.class, "request");
        request1.setAccessible(true);
        Object realRequest = request1.get(request);

        field.setAccessible(true);
        usingInputStreamField.setAccessible(true);
        try {
            field.set(realRequest, coyoteInputStream);
            usingInputStreamField.set(realRequest, false);
        } catch (Throwable e) {
            log.error("error", e);
        }


        log.info("inputStream={}", coyoteInputStream);*/
    }

    @Override
    public ServletInputStream getInputStream() throws IOException {
        return new CachedBodyServletInputStream(this.cachedBody);
    }

    @Override
    public BufferedReader getReader() throws IOException {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(this.cachedBody);
        return new BufferedReader(new InputStreamReader(byteArrayInputStream));
    }


    public static void copyInputStreamToAnother(InputStream source, OutputStream destination) throws IOException {
        // 将InputStream转换为ReadableByteChannel
        ReadableByteChannel sourceChannel = Channels.newChannel(source);
        // 使用destination创建WritableByteChannel
        WritableByteChannel destChannel = Channels.newChannel(destination);

        // 创建ByteBuffer作为中间存储
        ByteBuffer buffer = ByteBuffer.allocate(1024); // 缓冲区大小可以根据需要调整

        while (sourceChannel.read(buffer) != -1) {
            // 切换buffer的模式从写入变为读取
            buffer.flip();
            // 将buffer中的数据写入到目标通道
            destChannel.write(buffer);
            // 清空buffer，准备下一次读取
            buffer.clear();
        }

        // 刷新目标通道，确保所有数据都被写入
        destChannel.close();

        // 关闭源通道
        sourceChannel.close();
    }

}
