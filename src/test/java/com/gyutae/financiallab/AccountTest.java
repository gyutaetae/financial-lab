package com.gyutae.financiallab;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;

import com.gyutae.financiallab.account.domain.Account;

import static org.assertj.core.api.Assertions.assertThat;


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
}
