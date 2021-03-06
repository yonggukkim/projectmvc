package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import command.ListCommand;
import service.MemberListService;
import spring.Member;
@Controller
public class MemberListController {
	private MemberListService memberListService;
	
	@Autowired
	public void setMemberListService(MemberListService memberListService) {
		this.memberListService = memberListService;
	}


	@RequestMapping("/member/list")
	public String list(@ModelAttribute("cmd") ListCommand listCommand, Errors errors, Model model) {
		if(errors.hasErrors()) {
		return "member/memberList";
		}
		if(listCommand.getFrom() != null && listCommand.getTo() != null) {
			List<Member> members = memberListService.getMemberList(listCommand.getFrom(), listCommand.getTo());
			model.addAttribute("members", members);
		}
		return "member/memberList";
	}
}
