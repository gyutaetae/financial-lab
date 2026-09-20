package com.gyutae.financiallab.account.api;

import java.math.BigDecimal;

public record TransferRequest(
		Long toAccountId,
		BigDecimal amount) {
}
