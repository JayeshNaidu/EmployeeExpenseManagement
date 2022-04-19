package com.cg.exception;

public class EmployeeException extends RuntimeException {
	public EmployeeException() {
	}

	public EmployeeException(String msg) {
		super(msg);
	}
}
