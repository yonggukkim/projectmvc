package validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import command.ChangePwdCommand;

// 오류검사하기 위해서는 Validator 인터페이스를 상속 받는다.
public class ChangePwdCommandValidator implements Validator{
	
	public boolean supports(Class<?> clazz) {
		return ChangePwdCommand.class.isAssignableFrom(clazz);
	}
	
	public void validate(Object target, Errors errors) {
		// 입력을 하지 않았을 때 발생할 오류 (필수항목임을 알려주기 위해 사용)
		ValidationUtils.rejectIfEmpty(errors, "currentPassword", "required");
		ValidationUtils.rejectIfEmpty(errors, "newPassword", "required");
	}
}
