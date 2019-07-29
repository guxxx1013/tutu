package SampleTest;


import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.HttpVersion;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.conn.ssl.AllowAllHostnameVerifier;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.message.BasicHttpResponse;

import java.io.IOException;
/**
 * @author quanju.gu
 * @date 2019-07-24
 */
public class HTTPUtils {
    public static HttpResponse getHtml(HttpClient client, String url) {
        //获取响应文件，即HTML，采用get方法获取响应数据
        HttpGet getMethod = new HttpGet(url);
        HttpResponse response = new BasicHttpResponse(HttpVersion.HTTP_1_1, HttpStatus.SC_OK, "OK");

        try {
            SSLSocketFactory.getSocketFactory().setHostnameVerifier(new AllowAllHostnameVerifier());
            //通过client执行get方法
            response = client.execute(getMethod);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //getMethod.abort();
        }

        return response;
    }
}
