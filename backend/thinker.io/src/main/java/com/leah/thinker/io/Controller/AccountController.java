package com.leah.thinker.io.Controller;

import com.leah.thinker.io.dto.request.AccountRequest;
import com.leah.thinker.io.Service.AccountService;
import com.leah.thinker.io.entity.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
public class AccountController {
    @Autowired
    AccountService accountService;
    @PostMapping("/user")
    public ResponseEntity<Account> createAccount(@RequestBody Account account) {
        accountService.createNewAccount(account);
        return ResponseEntity.ok(account);
    }
    @DeleteMapping("/user/{id}")
    public void deleteAccount( @PathVariable  UUID id) {
        accountService.deleteAccountById(id);
    }
    @GetMapping("/user/{id}")
    public ResponseEntity<Account> getAccountById(@PathVariable UUID id) {
        return  ResponseEntity.ok(accountService.getAccountInfoById(id));
    }
    @PutMapping("/user/{id}")
    public ResponseEntity<Account> updateAccount(@PathVariable UUID id, @RequestBody AccountRequest accountRequest){
        accountService.updateAccount(id, accountRequest);
        return ResponseEntity.ok(accountService.getAccountInfoById(id));
    }
}
