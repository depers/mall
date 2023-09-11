package cn.bravedawn.resource;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.EncodedResource;
import org.springframework.util.FileCopyUtils;

import java.io.IOException;

/**
 * @author : depers
 * @program : 1.spring4.x
 * @description:
 * @date : Created in 2023/9/11 20:12
 */
public class EncodedResourceExample {

    /**
     * 使用EncodedResource 对文件资源进行编码处理
     */

    public static void main(String[] args) throws IOException {
        Resource res = new ClassPathResource("file.txt");
        EncodedResource encRes = new EncodedResource(res,"UTF-8");
        String content  = FileCopyUtils.copyToString(encRes.getReader());
        System.out.println(content);
    }

}
