package cn.bravedawn.httpclient.example;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.IOUtils;
import org.apache.http.HttpEntity;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.conn.HttpHostConnectException;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.net.ConnectException;
import java.net.SocketTimeoutException;

/**
 * @author : depers
 * @program : httpclient
 * @description: 超时测试
 * @date : Created in 2021/9/10 17:35
 */

@Slf4j
public class TimeoutExample {

    public static void main(String[] args) throws IOException {
        log.info("request start-------------------");

        RequestConfig requestConfig = RequestConfig.custom()
                .setConnectTimeout(5000)
                .setSocketTimeout(5000)
                .build();

        CloseableHttpClient httpclient = HttpClients.custom()
                .setDefaultRequestConfig(requestConfig)
                .build();

        HttpGet httpGet = new HttpGet("http://localhost:8088/getType");
        CloseableHttpResponse response1 = null;

        try {
            response1 = httpclient.execute(httpGet);
        } catch (Throwable t) {
            if (t instanceof SocketTimeoutException) {
                log.error("---SocketTimeoutException={}", t.getMessage(), t);
            } else if (t instanceof ConnectException) {
                log.error("---ConnectTimeoutException={}", t.getMessage(), t);
            } else {
                log.error("---other exception ", t);
            }

        }

        try {
            if (response1 != null) {
                log.info(response1.getStatusLine().getStatusCode() + "");
                HttpEntity entity1 = response1.getEntity();
                log.info(IOUtils.toString(entity1.getContent()));
                EntityUtils.consume(entity1);
            }


        } finally {
            log.info("request end-------------------");
            if (response1 != null) {
                response1.close();
            }


        }



    }
}
