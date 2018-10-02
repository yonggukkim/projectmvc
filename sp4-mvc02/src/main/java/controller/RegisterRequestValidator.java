package controller;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import spring.RegisterRequest;

public class RegisterRequestValidator implements Validator{
	
	// 자바스크립트에서 alert을 사용하는 것 대신 Validator객체 사용
	private static final String emailRegExp = "^[_A-Za-z0-9\\+]+(\\.[_A-Za-z0-9-]+)*@[_A-Za-z0-9]+(\\.[_A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$";
	private Pattern pattern;
	
	public RegisterRequestValidator() {
		pattern = Pattern.compile(emailRegExp);
	}
	
	public boolean supports(Class<?> clazz) {
		return RegisterRequest.class.isAssignableFrom(clazz);
	}
	
	public void validate(Object target, Errors errors) {
		// object는 모든 객체의 부모 객체가 된다.
		// 그러므로 object 변수는 모든 객체를 저장할 수 있지만
		// 객체변수는 object객체가 부모 객체이므로 저장할 수 없어
		// 형변환을 해야 한다.
		// 부모 변수 = 객체
		// object test = new RegisterRequest();
		// 객체 변수 = 부모 객체 (x)
		// RegisterRequest regReq = new object(); (x)
		// RegisterRequest regReq = (RegisterRequest)(new object()); 이런 식으로 형 변환을 해줘야 한다.
		// isEmpty() 비어있냐고?
		RegisterRequest regReq = (RegisterRequest)target;
		if(regReq.getEmail()==null || regReq.getEmail().isEmpty()) {
			errors.rejectValue("email", "required");
		}else {
			// boolean
			Matcher matcher = pattern.matcher(regReq.getEmail());
			if(!matcher.matches()) {
				errors.rejectValue("email", "bad");
			}
		}
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "required");
		ValidationUtils.rejectIfEmpty(errors, "password", "required");
		ValidationUtils.rejectIfEmpty(errors, "confirmPassword", "required");
		if(!regReq.getPassword().isEmpty()) {
			if(!regReq.isPasswordEqualToConfirmPassword()) {
				errors.rejectValue("confirmPassword", "nomatch");
			}
		}
	}
}

