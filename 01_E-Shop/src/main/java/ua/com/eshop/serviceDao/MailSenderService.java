package ua.com.eshop.serviceDao;

public interface MailSenderService {

	void sendMail (String content, String mailBody, String email);
	
	
}
