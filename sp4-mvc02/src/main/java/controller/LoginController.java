package controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import command.LoginCommand;
import exception.IdPasswordNotMatchingException;
import service.AuthService;
import spring.AuthInfo;
import validator.LoginCommandValidator;

@Controller
@RequestMapping("/login")
public class LoginController {
	private AuthService authService;
	// 
	@Autowired
	public void setAuthService(AuthService authService) {
		this.authService = authService;
	}
	@RequestMapping(method = RequestMethod.GET)
	public String form(LoginCommand loginCommand, @CookieValue(value="REMEMBER",required=false)
	Cookie rememberCookie) {
		// 아이디 기억하기
		if(rememberCookie != null) {
			loginCommand.setEmail(rememberCookie.getValue());
			loginCommand.setRememberEmail(true);
		}
		return "login/loginForm";
	}
	// 로그인 될 때
	@RequestMapping(method = RequestMethod.POST)
	public String submit(LoginCommand loginCommand, Errors errors, HttpSession session, HttpServletResponse response) {
		new LoginCommandValidator().validate(loginCommand, errors);
		// loginForm페이지에서 넘어온 값에 오류가 있다면 다시 loginForm 페이지로 이동
		if(errors.hasErrors()) {
			return "login/loginForm";
		}
		try {
			// authService에서 DAO로 부터 정상적으로 값을 전달 AuthInfo에 저장해서 반환
			AuthInfo authInfo = authService.authenticate(loginCommand.getEmail(), loginCommand.getPassword());
			session.setAttribute("authInfo", authInfo);
			Cookie cookie = new Cookie("REMEMBER", loginCommand.getEmail());
			if(loginCommand.isRememberEmail()) {
			cookie.setMaxAge(60*60*24*30);
			}else {
			cookie.setMaxAge(0);
			}
			response.addCookie(cookie);
			return "login/loginSuccess";
		}catch(IdPasswordNotMatchingException e) {
			errors.reject("idPasswordNotMatching");
			return "login/loginForm";
		}
	}
}
