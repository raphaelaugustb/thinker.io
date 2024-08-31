package com.leah.thinker.io.Service;

import com.leah.thinker.io.dto.request.AccountRequest;
import com.leah.thinker.io.entity.Account;
import com.leah.thinker.io.exception.InvalidRequestException;
import com.leah.thinker.io.exception.UserNotFoundException;
import com.leah.thinker.io.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.module.InvalidModuleDescriptorException;
import java.util.UUID;

@Service
public class AccountService {
    AccountRepository accountRepository;

    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public void createNewAccount(AccountRequest accountRequest) {
        if (accountRequest.email() == null || accountRequest.password() == null || accountRequest.username() == null)
            throw new InvalidRequestException("Missing fields");
        Account account = new Account();
        account.setUsername(accountRequest.username());
        account.setPassword(accountRequest.password());
        account.setEmail(accountRequest.email());
        accountRepository.save(account);
    }

    public Account getAccountInfoById(UUID id) {
        return accountRepository.findById(id).orElseThrow(() -> new UserNotFoundException("User not found"));
    }

    public void deleteAccountById(UUID id) {
        accountRepository.deleteById(
                accountRepository.findById(id).orElseThrow(() -> new UserNotFoundException("User not found")).getId()
        );
    }

    public void updateAccount(UUID id, AccountRequest accountRequest) {
        Account account = accountRepository.findById(id).orElseThrow(() -> new UserNotFoundException("User not found"));
        if (accountRequest.email() == null || accountRequest.password() == null || accountRequest.username() == null)
            throw new InvalidRequestException("Missing fields");
        account.setEmail(accountRequest.email());
        account.setUsername(accountRequest.username());
        account.setPassword(account.getPassword());
        accountRepository.save(account);
    }
}
