package spring;

public class Email {
	private String subject;
	private String content;
	private String regdate;
	private String reciver;
	private String fromName;
	public Email (String fromName, String reciver, String subject, String content, String regdate) {
		this.fromName = fromName;
		this.reciver = reciver;
		this.subject = subject;
		this.content = content;
		this.regdate = regdate;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getRegdate() {
		return regdate;
	}
	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}
	public String getReciver() {
		return reciver;
	}
	public void setReciver(String reciver) {
		this.reciver = reciver;
	}
	public String getFromName() {
		return fromName;
	}
	public void setFromName(String fromName) {
		this.fromName = fromName;
	}
}
