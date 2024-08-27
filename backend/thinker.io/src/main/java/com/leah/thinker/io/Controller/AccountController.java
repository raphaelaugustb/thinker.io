package com.leah.thinker.io.Controller;

import com.leah.thinker.io.dto.request.AccountRequest;
import com.leah.thinker.io.Service.AccountService;
import com.leah.thinker.io.entity.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
public class AccountController {
    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    AccountService accountService;
    @PostMapping("/user")
    public ResponseEntity<AccountRequest> createAccount(@RequestBody AccountRequest accountRequest) {
        accountService.createNewAccount(accountRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(accountRequest);
    }
    @DeleteMapping("/user/{id}")
    public ResponseEntity<Void> deleteAccount( @PathVariable  UUID id) {
        accountService.deleteAccountById(id);
        return ResponseEntity.ok().build();
    }
    @GetMapping("/user/{id}")
    public ResponseEntity<Account> getAccountById(@PathVariable UUID id) {
        return  ResponseEntity.status(HttpStatus.FOUND).body(accountService.getAccountInfoById(id));
    }
    @PutMapping("/user/{id}")
    public ResponseEntity<Account> updateAccount(@PathVariable UUID id, @RequestBody AccountRequest accountRequest){
        accountService.updateAccount(id, accountRequest);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(accountService.getAccountInfoById(id));
    }
}
