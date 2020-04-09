package com.jsp.exception;

public class NotFoundIdException extends Exception {

	private static final long serialVersionUID = 1L;

	public NotFoundIdException() {
		super("존재하지 않는 아이디입니다.");
	}
	
}
