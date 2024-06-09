package com.codesoft.exception;

public class AccountNotFoundEception  extends RuntimeException{

	public AccountNotFoundEception(String desc) {
		super(desc);
	}
}
