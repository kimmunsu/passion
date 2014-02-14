package com.springapp.guestBook;

public class NotExistGuestBookException extends Exception {
	
	private static final long serialVersionUID = -7977425212082526451L;

	@Override
	public String getMessage() {
		return "요청하신 방명록은 존재하지 않습니다.";
	}
}
