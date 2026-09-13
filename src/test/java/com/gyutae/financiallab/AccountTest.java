package com.gyutae.financiallab;

import org.junit.jupiter.api.Test;

public class AccountTest {
    @Test
    void deposit(){
        //given
        Account account = new Account();
        //when
        account.deposit(new BigDecimal("3000"));
        //then
        assertThat(account.balance).isEqualTo("3000");
    }
}
