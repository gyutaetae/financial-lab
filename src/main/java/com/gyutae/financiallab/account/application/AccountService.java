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
}
