package com.gyutae.financiallab.account.application;

import org.springframework.stereotype.Service;
import com.gyutae.financiallab.account.domain.Account;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

//application: 계좌 생성·조회 같은 업무 흐름
//실제 api에서는 사용자가 만들지않고 서비스가 자동으로 ID를 생성함 
@Service //이걸붙이면 new AccountService() 안해도 스프링이 알아서 만들어줌
public class AccountService {
    Map<Long,Account> accounts = new ConcurrentHashMap<>(); //동시성 문제를 해결하기 위해 ConcurrentHashMap 사용

    public Account createAccount(BigDecial, initialBalance){
        Account
    }
}



