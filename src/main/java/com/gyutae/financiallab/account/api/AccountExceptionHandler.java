package com.gyutae.financiallab.account.api;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.gyutae.financiallab.account.application.AccountNotFoundException;
import com.gyutae.financiallab.account.domain.InsufficientBalanceException;

/**
 * 계좌 관련 예외를 처리하는 클래스
 */
@RestControllerAdvice // 예외를 이 클래스에서 처리
public class AccountExceptionHandler {
	@ExceptionHandler(AccountNotFoundException.class) // AccountNotFoundException이 발생하면 이 메서드가 실행됨
	@ResponseStatus(HttpStatus.NOT_FOUND) // 404에러를 반환하도록 설정
	public ErrorResponse handleAccountNotFound( // 메서드이름은 자유롭게가능
			AccountNotFoundException exception) { // accountNotFoundException 타입의 예외객체를 exception이라는 변수로 받음
		return new ErrorResponse( // 오류 응답 객체 생성후 반환
				"ACCOUNT_NOT_FOUND",
				exception.getMessage() // super에 저장했던 메시지를 꺼냄
		);
	}

	@ExceptionHandler(InsufficientBalanceException.class) // InsufficientBalanceException이 발생하면 이 메서드가 실행됨
	@ResponseStatus(HttpStatus.CONFLICT) // CONFLICT 409에러를 반환하도록 설정
	public ErrorResponse handleInsufficientBalance(
			InsufficientBalanceException exception) {
		return new ErrorResponse(
				"INSUFFICIENT_BALANCE",
				exception.getMessage());
	}

	@ExceptionHandler(IllegalArgumentException.class) // 스프링은 변수를 보고 실행하는게 아니라 이 에너테이션을 보고실행함
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ErrorResponse handleIllegalArgument( // 이메서드의 반환타입은 errorResponse, 매개변수는 IllegalArgumentException
			IllegalArgumentException exception) { // 매개변수임
		return new ErrorResponse(
				"ILLEGAL_ARGUMENT",
				exception.getMessage());
	}
}
