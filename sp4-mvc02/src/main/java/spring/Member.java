package spring;

import java.util.Date;

public class Member {
	private Long id;
	private String email;
	private String password;
	private String name;
	private Date registerDate;
	public Member() {}
	public Member(String email,String password,
			String name,Date registerDate) {
		this.email =email;
		this.password = password;
		this.name = name;
		this.registerDate = registerDate;
	}

	public Long getId() {return id;}
	public void setId(Long id) {this.id = id;}
	public String getEmail() {return email;}
	public void setEmail(String email) {
		this.email = email;}
	public String getPassword() {return password;}
	public void setPassword(String password) {
		this.password = password;}
	public String getName() {return name;}
	public void setName(String name) {
		this.name = name;}
	public Date getRegisterDate() {
		return registerDate;
	}
	public void setRegisterDate(Date registerDate) {
		this.registerDate = registerDate;
	}
	// 비밀번호 비교하기 위한 메소드 
	public void changePassword(String oldPassword,
								String newPasswors) {
		if(password.equals(oldPassword))
					password= newPasswors;
		else
			throw // 사용자정의 예외처리
				new IdPasswordNotMatchingException(
						"비밀번호가 다릅니다.");
	}
}
