package com.gyutae.financiallab.account.api;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.gyutae.financiallab.account.application.AccountNotFoundException;

/**
 * 계좌 관련 예외를 처리하는 클래스
 */
@RestControllerAdvice // 예외를 이 클래스에서 처리
public class AccountExceptionHandler {
	@ExceptionHandler(AccountNotFoundException.class) // AccountNotFoundException이 발생하면 이 메서드가 실행됨
	@ResponseStatus(HttpStatus.NOT_FOUND) // 404에러를 반환하도록 설정
	public ErrorResponse handleAccountNotFound( // 메서드이름은 자유롭게가능
			AccountNotFoundException e) {
		return new ErrorResponse( // 오류 응답 객체 생성후 반환
				"ACCOUNT_NOT_FOUND",
				e.getMessage() // super에 저장했던 메시지를 꺼냄
		);
	}
}
