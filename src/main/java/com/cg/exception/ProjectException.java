package com.cg.exception;

@SuppressWarnings("serial")
public class ProjectException extends RuntimeException {
	public ProjectException() {
	}

	public ProjectException(String msg) {
		super(msg);
	}

}
