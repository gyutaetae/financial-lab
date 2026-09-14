package com.gyutae.financiallab.account.domain;
// balance는 입금하면 증가 출금하면 감소 잔액보다 많이 출금하면 InsufficientBalanceException 발생 0원보다작은 금액은 입출금할수없다. 

import java.math.BigDecimal;

public class Account {
    private Long id;
    private BigDecimal balance;

    public Account() {
        this.balance = BigDecimal.ZERO;
    }

    public void deposit(BigDecimal amount) {

        if (amount == null) {
            throw new IllegalArgumentException("입금 금액이 null입니다.");
        }
        if (amount.compareTo(BigDecimal.ZERO) < 0 || amount.compareTo(BigDecimal.ZERO) == 0) {
            throw new IllegalArgumentException("입금 금액은 0원보다 커야 합니다.");
        }
        balance=balance.add(amount);
    } // amount가 0원보다 작으면 오류출력 0보다크면 balance에서 추가 

    public void withdraw(BigDecimal amount){
        if (amount == null){
            throw new IllegalArgumentException("출금 금액이 null입니다.");
        }
        if (amount.compareTo(BigDecimal.ZERO) < 0 || amount.compareTo(BigDecimal.ZERO) == 0){
            throw new IllegalArgumentException("출금 금액은 0원보다 커야 합니다.");
        }
        if (balance.compareTo(amount) < 0){
            throw new InsufficientBalanceException();
        }
        balance=balance.subtract(amount);
        }

    public BigDecimal getBalance(){
        return balance;
    }
}
