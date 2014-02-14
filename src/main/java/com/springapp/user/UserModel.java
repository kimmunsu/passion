package com.springapp.user;

import java.util.ArrayList;
import java.util.List;

public class UserModel {
	
	private List<User> userList = new ArrayList<User>();
	private static volatile UserModel INSTANCE;
	
	private UserModel(){}
	
	public static UserModel getInstance(){
		if(INSTANCE == null) synchronized (UserModel.class) {
			if(INSTANCE == null)
				INSTANCE = new UserModel();
		}
		return INSTANCE;
	}
	
	public List<User> add(User user) {
		this.userList.add(user);
		return this.userList;
	}

	public User findByUserId(String id) {
		int userListCount = this.userList.size();
		for (int index = 0; index < userListCount; index++) {
			if (this.userList.get(index).getUserId().equals(id))
				return this.userList.get(index);
		}
		return null;
	}

	public boolean delete(String id) {
		int userListCount = this.userList.size();
		for (int index = 0; index < userListCount; index++) {
			if (this.userList.get(index).getUserId().equals(id)) {
				this.userList.remove(index);
				return true;
			}
		}
		return false;
	}
}