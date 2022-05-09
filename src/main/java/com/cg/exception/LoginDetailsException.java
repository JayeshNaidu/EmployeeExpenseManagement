package com.cg.exception;

@SuppressWarnings("serial")
public class LoginDetailsException extends RuntimeException {

	public LoginDetailsException() {
	}

	public LoginDetailsException(String msg) {
		super(msg);
	}

}
