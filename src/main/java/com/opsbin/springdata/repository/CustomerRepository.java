package com.opsbin.springdata.repository;

import com.opsbin.springdata.entity.Customer;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<Customer, Long> {

}
