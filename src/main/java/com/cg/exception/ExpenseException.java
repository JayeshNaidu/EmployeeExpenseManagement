package com.cg.exception;

public class ExpenseException extends RuntimeException{
	public ExpenseException () {};
	public ExpenseException(String msg) {
		super(msg);
	}
}
