package maven.p01.entity;

import javax.validation.constraints.Pattern;

public class Users {
	@Pattern(regexp="[a-z]{3}",message="请输入3个字母")
	private String account;
	@Pattern(regexp="[0-9|]{6}",message="请输入6位数字")
	private String password;
	public String getAccount() {
		return this.account;
	}
	public void setAccount(String username) {
		this.account = username;
	}
	public String getPassword() {
		return this.password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}
