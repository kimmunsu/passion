package com.springapp.user.domain;

import org.junit.Test;

import com.springapp.user.User;

public class UserTests {
	private User user;
	
	@Test
	public void isEquals(){
		String userId = "testId";
		String password = "testPwd";
		String name = "testName";
		String email = "testEmail";
		this.user = new User(userId, password, name, email);
		
		User userClone = new User(this.user.getUserId(), this.user.getPassword(), this.user.getName(), this.user.getEmail());
		
	}
}
