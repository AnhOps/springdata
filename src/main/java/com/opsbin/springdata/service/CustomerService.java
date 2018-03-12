package com.opsbin.springdata.service;

import com.opsbin.springdata.entity.Customer;

import java.util.Optional;

public interface CustomerService {

    /**
     * get all customers
     * @return
     */
    public Iterable<Customer> getCustomers();

    /**
     * get a customer based on the customerId
     * @param customerId
     * @return
     */
    public Optional<Customer> getCustomer(Long customerId);

    /**
     * update existing customer
     * @param customer
     * @return
     */
    public Customer updateCustomer(Customer customer);

    /**
     * add a customer
     * @param customer
     * @return
     */
    public Customer addCustomer(Customer customer);

    /**
     * delete a customer
     * @param customerId
     */
    public void deleteCustomer(Long customerId);
}
