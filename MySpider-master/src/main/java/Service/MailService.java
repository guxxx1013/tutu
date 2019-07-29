package Service;

/**
 * @author quanju.gu
 * @date 2019-07-25
 */

public interface MailService {

    public void sendSimplemail(String from, String to, String subject, String content);

}
