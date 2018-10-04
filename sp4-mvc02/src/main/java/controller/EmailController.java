package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import service.EmailSender;
import spring.Email;

@Controller
@RequestMapping("/email")
public class EmailController {
	private EmailSender emailSender;
	@Autowired
	public void setEmailSender(EmailSender emailSender) {
		this.emailSender = emailSender;
	}
	@RequestMapping(method = RequestMethod.GET)
	public String mailView() {
		return "report/mailView";
	}
	@RequestMapping(method = RequestMethod.POST)
	public String sendMail(Email email) throws Exception{
		emailSender.SendEmail(email);
		return "report/success";
	}
}
