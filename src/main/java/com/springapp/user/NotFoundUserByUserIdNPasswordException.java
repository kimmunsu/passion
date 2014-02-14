package com.springapp.user;

public class NotFoundUserByUserIdNPasswordException extends Exception {
	
	private static final long serialVersionUID = -511800988622582769L;
	
	@Override
	public String getMessage() {
		return "id 혹은 password를 잘못 입력하셨습니다. 다시 입력해주세요.";
	}

}
