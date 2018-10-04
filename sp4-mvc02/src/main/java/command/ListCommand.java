package command;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class ListCommand {
	@DateTimeFormat(pattern="yyyyMMddHH") // 커멘드 객체에 저장이 안 되게 하기 위한 패턴을 잡아 주는 것
	private Date from;
	@DateTimeFormat(pattern="yyyyMMddHH")
	private Date to;
	public Date getFrom() {
		return from;
	}
	public void setFrom(Date from) {
		this.from = from;
	}
	public Date getTo() {
		return to;
	}
	public void setTo(Date to) {
		this.to = to;
	}
}
