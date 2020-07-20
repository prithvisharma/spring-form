package com.sform.model;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.validation.annotation.Validated;

@Validated			//validated tells spring that is validated
public class User {

	private int id;
	@Pattern(regexp="(^[A-Za-z]{3,16})([ ]{0,1})([A-Za-z]{3,16})?([ ]{0,1})?([A-Za-z]{3,16})?([ ]{0,1})?([A-Za-z]{3,16})", message="Enter a Valid Name")
	private String name;
	@Size(min=4 , max=10 , message="Username must be within 4 to 10 characters")
	private String username;
	@Size(min=8 , max=15 , message="Password must be within 8 to 15 characters")
	private String password;
	
	@Override
	public String toString() {
		return "User [name=" + name + ", username=" + username + ", password=" + password + "]";
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
}
