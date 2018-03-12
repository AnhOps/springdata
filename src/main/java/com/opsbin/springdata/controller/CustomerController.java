package com.opsbin.springdata.controller;

import com.opsbin.springdata.entity.Customer;
import com.opsbin.springdata.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    /**
     * URL: http://{hostname}:{port}/api/customers
     * HTTP method: GET
     */
    @RequestMapping(value = "/api/customers", method = RequestMethod.GET)
    public ResponseEntity<?> getCustomers() {
        Iterable<Customer> customersList = customerService.getCustomers();
        return new ResponseEntity<>(customersList, HttpStatus.OK);
    }

    /**
     * URL: http://{hostname}:{port}/api/customers/{customerId}
     * HTTP method: GET
     */
    @RequestMapping(value="/api/customers/{customerId}", method = RequestMethod.GET)
    public ResponseEntity<?> getCustomer(@PathVariable long customerId) {
        Optional<Customer> customer = customerService.getCustomer(customerId);
        return new ResponseEntity<>(customer, HttpStatus.OK);
    }

    /**
     * URL: http://{hostname}:{port}/api/customers
     * HTTP method: POST
     */
    @RequestMapping(value="/api/customers", method = RequestMethod.POST)
    public ResponseEntity<?> addCustomer(@RequestBody Customer customer) {
        Customer newCustomer = customerService.addCustomer(customer);
        return new ResponseEntity<>(newCustomer, HttpStatus.CREATED);
    }

    /**
     * URL: http://{hostname}:{port}/api/customers
     * HTTP method: PUT
     */
    @RequestMapping(value = "/api/customers", method = RequestMethod.PUT)
    public ResponseEntity<?> updateCustomer(@RequestBody Customer customer) {
        Customer updatedCustomer = customerService.updateCustomer(customer);
        return new ResponseEntity<>(updatedCustomer, HttpStatus.OK);
    }

    /**
     * URL: http://{hostname}:{port}/api/customers/{customerId}
     * HTTP method: DELETE
     */
    @RequestMapping(value = "/api/customers/{customerId}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteCustomer(@PathVariable long customerId) {
        customerService.deleteCustomer(customerId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
