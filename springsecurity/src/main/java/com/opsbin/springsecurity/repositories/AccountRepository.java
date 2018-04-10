package com.opsbin.springsecurity.repositories;

import com.opsbin.springsecurity.entities.Account;
import org.springframework.dao.DataAccessException;
import org.springframework.data.repository.Repository;

public interface AccountRepository extends Repository<Account, Long> {
    Account findByUsername(String username) throws DataAccessException;
}
