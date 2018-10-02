package controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import spring.AuthInfo;
import spring.ChangePasswordService;
import spring.IdPasswordNotMatchingException;

@Controller
@RequestMapping("/edit/changePassword")
public class ChangePwdController {
	
	private ChangePasswordService changePasswordService;

	@Autowired
	public void setChangePasswordService(
				ChangePasswordService changePasswordService) {
		this.changePasswordService = changePasswordService;
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public String form(@ModelAttribute("command") ChangePwdCommand pwdCnd) {
		
		return "edit/changePassForm";
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String submit(ChangePwdCommand command, Errors errors, HttpSession session) {
		new ChangePwdCommandValidator().validate(command, errors);
		if(errors.hasErrors())	return "edit/changePassForm";
		try {
			AuthInfo authInfo = (AuthInfo)session.getAttribute("authInfo");
			changePasswordService.changePassword(authInfo.getEmail(), command.getCurrentPassword(), command.getNewPassword());
			return "edit/changedPwd";
		}catch(IdPasswordNotMatchingException e) {
			errors.rejectValue("CurrentPassword", "notMatching");
			return "edit/changePassForm";
		}
		
	}
}
