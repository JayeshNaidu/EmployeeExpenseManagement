package com.cg.exception;

@SuppressWarnings("serial")
public class ExpenseException extends RuntimeException {
	public ExpenseException() {
	};

	public ExpenseException(String msg) {
		super(msg);
	}
}
