package com.gyutae.financiallab.account.api;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// controller는 처음에 http로 요청을받으면 json으로 변환해서 request에게 보냄 
// 컨트롤러는 서비스가 필요한데 직접만들지않고 에너테이션을 사용해서 스프링이 만들어서 생성자로 보냄 
import com.gyutae.financiallab.account.application.AccountService;
import com.gyutae.financiallab.account.domain.Account;

@RestController // 스프링아 클래스 컨트롤러 객체로만들어서 관리해줘
@RequestMapping("/accounts")
public class AccountController {
    private final AccountService accountService; // 컨트롤러는 계좌를 새성하기위해 service가필요함

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    } // 생성자 주입(DI)

    @PostMapping // post/accounts 를 이 메서드가 처리, 계좌를 새로만들것이므로 post
    public AccountResponse createAccount(
            @RequestBody CreateAccountRequest request // json request를 createaccountrequest를 전달받고 accountresponse를 보낸다
    ) {
        Account account = accountService.createAccount(request.initialBalance());

        return new AccountResponse(
                account.getId(),
                account.getBalance());
    }
}