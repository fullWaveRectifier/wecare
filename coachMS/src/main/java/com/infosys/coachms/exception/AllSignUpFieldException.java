package com.infosys.coachms.exception;

public class AllSignUpFieldException extends Exception{

	private static final long serialVersionUID = 1L;
	
	public AllSignUpFieldException() {
		super();
	}
	public AllSignUpFieldException(String errors) {
		super(errors);
		System.out.println(errors);
	}
}
