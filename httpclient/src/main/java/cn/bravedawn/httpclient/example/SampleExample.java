package cn.bravedawn.httpclient.example;

import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.IOUtils;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

/**
 * @author : depers
 * @program : httpclient
 * @description: 简单测试
 * @date : Created in 2021/9/10 17:14
 */
@Slf4j
public class SampleExample {

    public static void main(String[] args) throws IOException {
        CloseableHttpClient httpclient = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet("http://localhost:8088/getType");
        CloseableHttpResponse response1 = httpclient.execute(httpGet);

        try {
            log.info(response1.getStatusLine().getStatusCode() + "");
            HttpEntity entity1 = response1.getEntity();
            log.info(IOUtils.toString(entity1.getContent()));
            EntityUtils.consume(entity1);

        } finally {
            response1.close();
        }

    }
}
