package com.gyutae.financiallab.account.application;

public class AccountNotFoundException extends RuntimeException {
	public AccountNotFoundException(Long id) { super ("계좌를 찾을 수 없습니다. id=" + id );
	}
}
