package com.codesoft.exception;

public class AmountIsGreaterThanBalanceException extends RuntimeException {

	
	public AmountIsGreaterThanBalanceException(String desc) {
		super(desc);
	}
}
