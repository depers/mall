package cn.bravedawn.requestparam.filter;


import jakarta.servlet.ReadListener;
import jakarta.servlet.ServletInputStream;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author : depers
 * @program : jasper
 * @description:
 * @date : Created in 2023/4/8 18:00
 */
public class CachedBodyServletInputStream extends ServletInputStream {

    private InputStream cachedBodyInputStream;

    public CachedBodyServletInputStream(byte[] cachedBody) {
        this.cachedBodyInputStream = new ByteArrayInputStream(cachedBody);
    }


    /**
     * 如果已经读取了流中的所有数据，isFinish ()方法将返回 true，否则它将返回 false。
     */
    @Override
    public boolean isFinished() {
        try {
            return cachedBodyInputStream.available() == 0;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }


    /**
     * 如果可以在不阻塞的情况下读取流中的数据，isReady ()方法将返回 true，否则它将返回 false。
     * 因为我们已经在一个字节数组中复制了 InputStream，所以我们将返回 true 来表示它始终可用:
     */
    @Override
    public boolean isReady() {
        return true;
    }

    /**
     * SetReadListener 方法用于指示 ServletInputStream在可以读取时调用提供的 ReadListener。
     */
    @Override
    public void setReadListener(ReadListener readListener) {
        throw new UnsupportedOperationException();
    }

    @Override
    public int read() throws IOException {
        return cachedBodyInputStream.read();
    }
}
