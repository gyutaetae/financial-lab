package com.gyutae.financiallab.account.api;

import java.math.BigDecimal;

public record WithdrawRequest(
		BigDecimal amount) {

}
