package com.gyutae.financiallab.account.domain;
// balance는 입금하면 증가 출금하면 감소 잔액보다 많이 출금하면 InsufficientBalanceException 발생 0원보다작은 금액은 입출금할수없다. 

import java.math.BigDecimal;

class Account {
    Long id;
    BigDecimal balance;

    public void deposit(BigDecimal amount) {
        Account account = new Account();
        account.balance = new BigDecimal("0");

        if (amount == null) {
            System.out.println("입금 금액이 null입니다.");
            break;
        }
        if (amount.compareTo(BigDecimal.ZERO) < 0) {
            System.out.println("입금 금액이 0원보다 작습니다.");
            break;
        }
        balance=balance.add(amount);
    } // amount가 0원보다 작으면 오류출력 0보다크면 balance에서 추가 

    public void withdraw(BigDecimal amount){
        if (amount == null){
            System.out.println("출금 금액이 null입니다.");
        }
        if (amount.compareTo(BigDecimal.ZERO)<0){
            System.out.println("출금 금액이 0원보다 작습니다.");
        }
        if (balance.compareTo(amount)<0){
            throw new InsufficientBalanceException();
        }
        balance=balance.subtract(amount);
        }
    }
