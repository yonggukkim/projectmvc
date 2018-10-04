package exception;

public class MemberNotFoundException 
	extends RuntimeException{
	public MemberNotFoundException() {
		System.out.println("멤버가 없습니다.");
	}
}
