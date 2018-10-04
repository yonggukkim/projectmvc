package service;

import org.springframework.beans.factory.annotation.Autowired;

import exception.MemberNotFoundException;
import spring.Member;
import spring.MemberDao;

public class ChangePasswordService {
	private MemberDao memberDao; //의존객체
	// 생성자를 통해서 의존 객체 주입
	@Autowired
	public ChangePasswordService(MemberDao memberDao){
		this.memberDao = memberDao;
	}
	public void changePassword(String email, 
			String oldPwd, String newPwd) {
		Member member = memberDao.selectByEmail(email);
		if(member == null)
			throw new MemberNotFoundException();
		member.changePassword(oldPwd, newPwd);
		memberDao.update(member);		
	}
}
