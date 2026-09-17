package com.gyutae.financiallab.account.application;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND) // 404에러를 반환하도록 설정
public class AccountNotFoundException extends RuntimeException {
	public AccountNotFoundException(Long id) {
		super("계좌를 찾을 수 없습니다. id=" + id);
	}
}
