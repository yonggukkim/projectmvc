package spring;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

public class MemberListService {
	private MemberDao memberDao;
	
	@Autowired
	public void setMemberDao(MemberDao memberDao) {
		this.memberDao = memberDao;
	}
	public List<Member> getMemberList(Date from, Date to) {
		List<Member> results = memberDao.selectByRegisterDate(from, to);
		return results;
	}
}
