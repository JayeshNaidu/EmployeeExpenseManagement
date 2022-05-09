package com.cg.exception;

@SuppressWarnings("serial")
public class ExpenseClaimException extends RuntimeException {
	public ExpenseClaimException() {
	};

	public ExpenseClaimException(String msg) {
		super(msg);
	}
}
