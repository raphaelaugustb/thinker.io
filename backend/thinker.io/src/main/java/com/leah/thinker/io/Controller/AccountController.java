package com.leah.thinker.io.Controller;

import com.leah.thinker.io.Request.AccountRequest;
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
    @PostMapping("/accounts")
    public ResponseEntity<Account> createAccount(@RequestBody Account account) {
        accountService.createNewAccount(account);
        return ResponseEntity.ok(account);
    }
    @DeleteMapping("/accounts/{id}")
    public void deleteAccount( @RequestParam  UUID id) {
        accountService.deleteAccountById(id);
    }
    @GetMapping("/accounts/{id}")
    public ResponseEntity<Account> getAccountById(@RequestParam UUID id) {
        return  ResponseEntity.ok(accountService.getAccountInfoById(id));
    }
    @PutMapping("/accounts/{id}")
    public ResponseEntity<Account> updateAccount(@RequestParam UUID id, @RequestBody AccountRequest accountRequest){
        accountService.updateAccount(id, accountRequest);
        return ResponseEntity.ok(accountService.getAccountInfoById(id));
    }
}
