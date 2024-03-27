package org.FoodDelivery.Model;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("loginToken")
@Scope("session")
public class LoginToken {
 
	private Integer userId;
	private String userName;
	private String password;
	
	public LoginToken() {
		super();
	}
	public LoginToken(Integer userId, String userName, String password) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.password = password;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}
