package com.codesoft.exceptions;

//exception than can occure at runtime

public class CourseAlreadyExistException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CourseAlreadyExistException(String desc) {
		
		super(desc);
	}
}
