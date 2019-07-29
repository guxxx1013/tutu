package SampleTest;


import Mail.MailTool;
import org.apache.http.ParseException;
import org.apache.http.client.HttpClient;

import java.io.IOException;


/**
 * @author quanju.gu
 * @date 2019-07-24
 */
public class TutuMain {
    public static void main(String[] args) throws Exception {
        int oldValue = 0;
        int round = 0;

        //生成一个客户端，通过客户端可url向服务器发送请求，并接收响应
//        HttpClient client = new DefaultHttpClient();
        HttpClient client = new SSLClient();
        //爬虫URL
        String url = "https://www.hermes.cn/cn/en/women/bags-and-small-leather-goods/bags-and-clutches/";
        //发送者邮箱
        String email = "416016498@qq.com";
        String stmlAccessCode = "xxx";
        String sendingEmail = "416016498@qq.com";
        while (true) {
            Thread.sleep(30000);
            System.out.println("round:" + round++);
            //System.out.println("test");
            try {
//            bookList = URLHandle.urlParser(client, url);
                String numberValue = URLHandle.urlSearch(client, url);
//                System.out.println("The total value is " + numberValue);
                //System.out.println("test");
                int newValue = Integer.parseInt(numberValue);
                if (oldValue != newValue) {
                    System.out.println("Come on, Go to buy the Bag. New Value :" + newValue);
                    MailTool.sendMail(email, stmlAccessCode, sendingEmail);
                    oldValue = newValue;
                }
            } catch (ParseException | IOException e) {
                e.printStackTrace();
            }

        }

//        System.out.println("System End");
    }
}
