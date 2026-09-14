package com.gyutae.financiallab;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;

import com.gyutae.financiallab.account.domain.Account;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import com.gyutae.financiallab.account.domain.InsufficientBalanceException;

public class AccountTest {
    @Test
    void deposit(){
        //given
        Account account = new Account();
        //when
        account.deposit(new BigDecimal("3000"));
        //then
        assertThat(account.getBalance()).isEqualTo(new BigDecimal("3000"));
    }

    @Test
    void initialbalance(){
        //given
        Account account = new Account();
        //when
        BigDecimal balance = account.getBalance();
        //then
        assertThat(balance).isEqualTo(new BigDecimal("0"));
    }

    @Test 
    void doubleDeposit(){
        Account account = new Account();
        account.deposit(new BigDecimal("3000"));
        account.deposit(new BigDecimal("5000"));
        assertThat(account.getBalance()).isEqualTo(new BigDecimal("8000"));
    }

    @Test 
    void withdraw(){
        Account account = new Account();
        account.deposit( new BigDecimal("10000"));
        account.withdraw(new BigDecimal("3000"));
        assertThat(account.getBalance()).isEqualTo(new BigDecimal("7000"));
    }

    @Test 
    void InsufficientBalanceException(){
        //given
        Account account = new Account();
        account.deposit(new BigDecimal("10000"));
        //when
        assertThatThrownBy(
            () -> account.withdraw(new BigDecimal("13000"))
        ).isInstanceOf(InsufficientBalanceException.class);

        //then
        assertThat(account.getBalance()).isEqualByComparingTo(new BigDecimal("10000"));
    }
}
