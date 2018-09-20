package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import spring.MemberRegisterService;

@Controller
public class RegisterController {
	
	private MemberRegisterService memberRegisterService;
	@Autowired
	public RegisterController(MemberRegisterService memberRegisterService) {
		this.memberRegisterService = memberRegisterService;
	}
	@RequestMapping("/register/step1")
	public String handleStep1() {
		return "register/step1";
	}
	@RequestMapping("/register/step2")
	public String handleStep2(Model model, @RequestParam(value="agree", defaultValue="false") boolean agree) {
		if(!agree) {
			return "register/step1";
		}
		return "register/step2";
	}
}
