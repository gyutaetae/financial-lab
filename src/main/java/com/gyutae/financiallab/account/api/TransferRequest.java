package com.gyutae.financiallab.account.api;

import java.math.BigDecimal;

public record TransferRequest(
		Long toAccountId,
		BigDecimal amount) {
}
// 클라이언트는 누구에게 얼마를 보낼지만은 보낸다 fromaccounid는 url로 받는다
// 클라이언트가 컨트롤러에보내는거임 무엇을 이체할지 담음
