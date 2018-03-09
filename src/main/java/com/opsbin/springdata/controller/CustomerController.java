package com.opsbin.springdata.controller;

import com.opsbin.springdata.entity.Customer;
import com.opsbin.springdata.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class CustomerController {

    @Autowired
    private CustomerRepository customerRepository;

    /**
     * URL: http://hostname:port/api/customers
     * HTTP method: GET
     */
    @RequestMapping(value = "/api/customers", method = RequestMethod.GET)
    public ResponseEntity<?> getCustomers() {
        Iterable<Customer> customersList = customerRepository.findAll();
        return new ResponseEntity<>(customersList, HttpStatus.OK);
    }

    /**
     * URL: http://hostname:port/api/customers/{customerId}
     * HTTP method: GET
     */
    @RequestMapping(value="/api/customers/{customerId}", method = RequestMethod.GET)
    public ResponseEntity<?> getCustomer(@PathVariable long customerId) {
        Optional<Customer> customer = customerRepository.findById(customerId);
        return new ResponseEntity<>(customer, HttpStatus.OK);
    }

}
