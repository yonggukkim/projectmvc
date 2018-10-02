package spring;

import org.springframework.beans.factory.annotation.Autowired;

public class MemberDetailService {
	private MemberDao memberDao;
	
	@Autowired
	public void setMemberDao(MemberDao memberDao) {
		this.memberDao = memberDao;
	}
	
	public Member selectById(Long id) {
		Member member = memberDao.selectById(id);
		return member;
	}
}
