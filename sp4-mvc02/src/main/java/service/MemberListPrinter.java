package service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;

import spring.Member;
import spring.MemberDao;
import spring.MemberPrinter;

public class MemberListPrinter {
	private MemberDao memberDao;
	private MemberPrinter printer; 
	// 객체를 매개변수가 받아서 멤버변수에게 전달 : 객체주입
	@Autowired
	public MemberListPrinter(MemberDao memberDao,
				MemberPrinter printer) {
		this.memberDao = memberDao;
		this.printer = printer;
	}
	public void printAll() {
		Collection<Member> members = 
				memberDao.selectAll();
		System.out.println("전체 회원 수 : " + 
				memberDao.count());
		for(Member m : members) {
			printer.print(m);
		}
	}
}
