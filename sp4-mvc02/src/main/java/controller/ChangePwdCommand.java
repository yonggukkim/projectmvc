package controller;
// 비밀번호를 변경하기 위한 페이지의 command객체를 만들기 위한 클래스
public class ChangePwdCommand {
	private String currentPassword;
	private String newPassword;
	public String getCurrentPassword() {
		return currentPassword;
	}
	public void setCurrentPassword(String currentPassword) {
		this.currentPassword = currentPassword;
	}
	public String getNewPassword() {
		return newPassword;
	}
	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}
}
