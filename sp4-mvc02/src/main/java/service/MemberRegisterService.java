package service;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;

import exception.AlreadyExistingMemberException;
import spring.Member;
import spring.MemberDao;
import spring.RegisterRequest;

public class MemberRegisterService {
	private MemberDao memberDao;//의존객체
	//의존객체 주입
	@Autowired
	public MemberRegisterService(
			MemberDao memberDao) {
		this.memberDao = memberDao;
	}
	public void regist(RegisterRequest req) {
		Member member =
		memberDao.selectByEmail(req.getEmail());
		if(member!=null) {
			throw new AlreadyExistingMemberException(
					"dup email " + req.getEmail());
		}
		Member newMembwe =  new Member(
				req.getEmail(), req.getPassword(), 
				req.getName(), new Date());
		
		SimpleDateFormat dateFormat = 
				new SimpleDateFormat("MMddHHmmss");
		String prefix = dateFormat.format(new Date());
		long prefix1= Integer.valueOf(prefix);
		newMembwe.setId(prefix1);
		
		memberDao.insert(newMembwe);
	}
}
