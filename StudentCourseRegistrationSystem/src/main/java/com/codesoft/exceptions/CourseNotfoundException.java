package com.codesoft.exceptions;

//exception than can occure at runtime

public class CourseNotfoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CourseNotfoundException(String desc) {
	super(desc);
	}
}
