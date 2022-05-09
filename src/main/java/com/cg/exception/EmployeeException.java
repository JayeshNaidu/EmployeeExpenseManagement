package com.cg.exception;

@SuppressWarnings("serial")
public class EmployeeException extends RuntimeException {
	public EmployeeException() {
	};

	public EmployeeException(String msg) {
		super(msg);
	}
}
