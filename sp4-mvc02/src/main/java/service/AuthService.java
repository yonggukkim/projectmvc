package service;

import org.springframework.beans.factory.annotation.Autowired;

import exception.IdPasswordNotMatchingException;
import spring.AuthInfo;
import spring.Member;
import spring.MemberDao;

public class AuthService {
	private MemberDao memberDao;
	// 의존 객체를 받기 위한 생성자
	@Autowired
	public void setMemberDao(MemberDao memberDao) {
		this.memberDao = memberDao;
	}
	
	public AuthInfo authenticate(String email, String password) {
		Member member = memberDao.selectByEmail(email);
		if(member == null) {
			throw new IdPasswordNotMatchingException("아이디가 존재하지않는다.");
		}
		// 비밀번호 틀린 경우
		if(!member.getPassword().equals(password)) {
			throw new IdPasswordNotMatchingException("비밀번호가 일치하지 않는다.");
		}
		// 일치하면 AuthInfo 반환
		return new AuthInfo(member.getId(), member.getEmail(), member.getName());
	}
}
