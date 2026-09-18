package com.gyutae.financiallab.account.application;

/**
 * 계좌를 찾을 수 없는 경우 발생하는 예외
 * http 처리는 핸들러에 맞기고 예외는 예외 역할만 담당
 */
public class AccountNotFoundException extends RuntimeException {
	public AccountNotFoundException(Long id) {
		super("계좌를 찾을 수 없습니다. id=" + id);
	}
}
