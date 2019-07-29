package Mail;

import com.sun.mail.util.MailSSLSocketFactory;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;

/**
 * @author quanju.gu
 * @date 2019-07-25
 */
public class MailTool {

    public static void sendMail(String email, String password, String senderEmail) throws AddressException, MessagingException, GeneralSecurityException {
        Properties props = new Properties();
        // 开启debug调试
        props.setProperty("mail.debug", "true");
        // 发送服务器需要身份验证
        props.setProperty("mail.smtp.auth", "true");
        // 设置邮件服务器主机名
        props.setProperty("mail.host", "smtp.qq.com");
        // 发送邮件协议名称
        props.setProperty("mail.transport.protocol", "smtp");
        //开启了 SSL 加密
        MailSSLSocketFactory sf = new MailSSLSocketFactory();
        sf.setTrustAllHosts(true);
        props.put("mail.smtp.ssl.enable", "true");
        props.put("mail.smtp.ssl.socketFactory", sf);

        Session session = Session.getInstance(props);

        Message msg = new MimeMessage(session);
        msg.setSubject("抢包数量更新啦");
        StringBuilder builder = new StringBuilder();
        builder.append("url = " + email);
        builder.append("\n 兔兔公司1.0版本");
        builder.append("\n时间 " + new Date());
        msg.setText(builder.toString());
        msg.setFrom(new InternetAddress(email));//**发送人的邮箱地址**

        Transport transport = session.getTransport();
        transport.connect("smtp.qq.com", email, password);
        List<String> list = new ArrayList<>();
//实现群发，下面的方法也是可以实现群发，但是不太理想
//        transport.sendMessage(msg, InternetAddress.parse("416016498@qq.com,416016498@qq.com"));
        transport.sendMessage(msg, InternetAddress.parse(senderEmail));

/*transport.sendMessage(msg, new Address[] {
new InternetAddress("3306907224@qq.com"),
new InternetAddress("269056581@qq.com"),
new InternetAddress("zhengmm@gz2000.net")
}
);*/

    }
}
