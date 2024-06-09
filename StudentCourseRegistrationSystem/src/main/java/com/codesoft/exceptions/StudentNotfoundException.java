package com.codesoft.exceptions;
//exception than can occure at runtime

public class StudentNotfoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5836450536992093892L;

	public StudentNotfoundException(String desc) {
		super(desc);
	}
}
