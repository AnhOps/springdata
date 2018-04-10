package com.opsbin.springsecurity.services.impl;

import com.opsbin.springsecurity.entities.Account;
import com.opsbin.springsecurity.entities.AccountDetails;
import com.opsbin.springsecurity.repositories.AccountRepository;
import com.opsbin.springsecurity.services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements UserDetailsService, AccountService {

    private final AccountRepository accountRepository;

    @Autowired
    public AccountServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public AccountDetails loadUserByUsername(String username)
            throws UsernameNotFoundException {
        Account account = accountRepository.findByUsername(username);
        if(account == null) {
            throw new UsernameNotFoundException("Could not find account " + username);
        }
        return new AccountDetails(account);
    }
}
