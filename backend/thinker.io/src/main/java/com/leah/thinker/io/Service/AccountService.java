package com.leah.thinker.io.Service;

import com.leah.thinker.io.dto.request.AccountRequest;
import com.leah.thinker.io.entity.Account;
import com.leah.thinker.io.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class AccountService {
    @Autowired
    AccountRepository accountRepository;
    public void createNewAccount(Account account) {
        if (account == null){
            throw  new NullPointerException("Conta inválida");
        } else {
            accountRepository.save(account);
        }
    }
    public Account getAccountInfoById(UUID id) {
        if (accountRepository.existsById(id)) {
            return accountRepository.findById(id).get();
        } else {
            throw new RuntimeException("Usuário não cadastrado");
        }
    }
    public void deleteAccountById(UUID id) {
        if (accountRepository.existsById(id)) {
            accountRepository.deleteById(id);
        } else {
            throw new RuntimeException("Conta não encontrada");
        }
    }
    public void updateAccount(UUID id, AccountRequest accountRequest) {
        if (accountRepository.existsById(id)) {
            Account account = accountRepository.findById(id).get();
            account.setEmail(accountRequest.getEmail());
            account.setUsername(accountRequest.getUsername());
            account.setPassword(account.getPassword());
        } else {
            throw new RuntimeException("Conta não encontrada");
        }

    }
}
