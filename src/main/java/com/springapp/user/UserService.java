package com.springapp.user;

public class UserService {
	
	public UserService(){}
	
	public void join(User user) throws ExistedUserException{
		UserModel model = UserModel.getInstance();
		User existUser = model.findByUserId(user.getUserId());
		if(existUser != null)
			throw new ExistedUserException(user.getUserId());
		model.add(user);
	}
	
	public boolean deactive(User user){
		return UserModel.getInstance().delete(user.getUserId());
	}
	
	public User findByUserId(String userId){
		return UserModel.getInstance().findByUserId(userId);
	}
	
	public User findByUserIdNPassword(String userId, String password) throws NotFoundUserByUserIdNPasswordException{
		User user = UserModel.getInstance().findByUserId(userId);
		if(user == null || !(user.getPassword().equals(password)))
			throw new NotFoundUserByUserIdNPasswordException();
		return user;
	}
}
