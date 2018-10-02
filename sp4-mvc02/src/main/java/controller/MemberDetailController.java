package controller;

import java.io.IOException;

import org.springframework.beans.TypeMismatchException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import spring.Member;
import spring.MemberDetailService;
import spring.MemberNotFoundException;

@Controller
public class MemberDetailController {
	private MemberDetailService memberDetailService;
	
	@Autowired
	public void setMemberDetailService(MemberDetailService memberDetailService) {
		this.memberDetailService = memberDetailService;
	}
	
	@RequestMapping("/member/detail/{id}")
	public String detail(@PathVariable("id") Long memId, Model model) {
		Member member = memberDetailService.selectById(memId);
		if(member == null) {
			throw new MemberNotFoundException();
		}
		model.addAttribute("member", member);
		return "member/memberDetail";
	}
	@ExceptionHandler(MemberNotFoundException.class)
	public String handleNotFoundException() throws IOException {
		return "member/noMember";
	}
	@ExceptionHandler(TypeMismatchException.class)
	public String typeError(TypeMismatchException ex) throws IOException{
		return "member/invalidId";
	}
}
