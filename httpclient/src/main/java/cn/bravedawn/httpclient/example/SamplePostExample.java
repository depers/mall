package cn.bravedawn.httpclient.example;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.protocol.HttpContext;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

/**
 * @author : depers
 * @program : httpclient
 * @description: Post请求简单测试
 * @date : Created in 2021/9/30 10:34
 */
public class SamplePostExample {

    public static void main(String[] args) throws IOException, URISyntaxException {
        CloseableHttpClient httpclient = HttpClients.createDefault();

        HttpPost httpPost = new HttpPost("your request url");

        URI uri = new URIBuilder(httpPost.getURI())
                .addParameter("param1", "value1")
                .addParameter("param2", "value2")
                .build();
        httpPost.setURI(uri);
        HttpEntity entity = new StringEntity("json");

        httpPost.setEntity(entity);
        CloseableHttpResponse res = httpclient.execute(httpPost);
    }
}
