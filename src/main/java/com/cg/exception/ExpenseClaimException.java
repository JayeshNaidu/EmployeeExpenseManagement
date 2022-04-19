package com.cg.exception;

public class ExpenseClaimException extends RuntimeException {
	public ExpenseClaimException () {};
	public ExpenseClaimException(String msg) {
		super(msg);
	}
}
