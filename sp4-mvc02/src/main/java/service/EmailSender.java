package service;

import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;

import spring.Email;

public class EmailSender {
	@Autowired
	protected JavaMailSender mailSender;
	
	public void setMailSender(JavaMailSender mailSender) {
		this.mailSender = mailSender;
	}
	// Email DTO에 있는 값을 JavaMailSender에 전달
	public void SendEmail(Email email) throws Exception {
		MimeMessage msg = mailSender.createMimeMessage(); // 초기화???
		msg.setSubject(email.getSubject()); // 제목
		msg.setText(email.getContent()); // 내용
		msg.setFrom(new InternetAddress(email.getFromName())); // 보내는 사람
		msg.setRecipient(MimeMessage.RecipientType.TO, new InternetAddress(email.getReciver()));
		/*msg.setText(text,"utf-8","html");*/
		
		try {
		mailSender.send(msg);
		}catch(MailException e) {
			System.out.println("MailException발생");
		}
	}
}
