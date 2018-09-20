package spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class MemberInfoPrinter {
	// 의존객체
	@Autowired
	private MemberDao memberDao; // property
	@Autowired
	private MemberPrinter printer;
	
	public void setMemberDao(MemberDao memberDao) {
		// 객체 주입
		this.memberDao = memberDao;
	}
	
    public void setPrinter(MemberPrinter printer) {
		// 객체 주입
		this.printer = printer;
	}
	public void printMemberInfo(String email) {
		Member member = memberDao.selectByEmail(email);
		if(member == null) {
			System.out.println("데이터 없음\n");
			return;
		}
		printer.print(member);
		System.out.println();
	}
	
}
