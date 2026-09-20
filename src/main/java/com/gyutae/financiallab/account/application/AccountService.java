package com.gyutae.financiallab.account.application;

import java.math.BigDecimal;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Service;

import com.gyutae.financiallab.account.domain.Account;

//application: 계좌 생성·조회 같은 업무 흐름
//실제 api에서는 사용자가 만들지않고 서비스가 자동으로 ID를 생성함
@Service // 이걸붙이면 new AccountService() 안해도 스프링이 알아서 만들어줌
public class AccountService {
	private final AtomicLong idGenerator = new AtomicLong(1);
	private final ConcurrentHashMap<Long, Account> accounts = new ConcurrentHashMap<>();

	public Account createAccount(BigDecimal initialBalance) {
		Long id = idGenerator.getAndIncrement();
		Account account = new Account(id, initialBalance);
		accounts.put(id, account);
		return account;
	}

	public Account findAccount(Long id) {
		Account account = accounts.get(id);
		if (account == null) {
			throw new AccountNotFoundException(id); // throw: 예외를 호출한쪽으로 전달하며 실행을 중단
		}
		return account;
	}

	public Account deposit(Long id, BigDecimal amount) {
		Account account = findAccount(id);
		account.deposit(amount);
		return account;
	}

	public Account withdraw(Long id, BigDecimal amount) {
		Account account = findAccount(id);
		account.withdraw(amount);
		return account;
	}

	public TransferResult transfer(
			Long fromAccountId,
			Long toAccountId,
			BigDecimal amount) { // 이렇게 매개변수는 타입과 변수선언과 같다 메서드를 밑에서 호출할때 구체적인 값이 들어온다
		if (fromAccountId.equals(toAccountId)) {
			throw new IllegalArgumentException("같은 계좌로 이체할 수 없습니다.");
		}
		Account fromAccount = findAccount(fromAccountId);
		Account toAccount = findAccount(toAccountId);

		fromAccount.withdraw(amount);
		toAccount.deposit(amount);

		// 서비스는 http를 몰라도되는 내부결과인 tranferresult를 반환함 request는 외부에서 들어오는값 result는 서비스가
		// 처리한 내부결과 response는 외부로 내보낼 값
		// 자바는 하나만 반환할수있으므로 fromaccouint, toaccount 두개의 계좌를 반환하기 위해 하나의 결과 객체로 묶음
		return new TransferResult(
				fromAccount,
				toAccount);
	}
}
