package com.opsbin.springdata.service.impl;

import com.opsbin.springdata.entity.Customer;
import com.opsbin.springdata.repository.CustomerRepository;
import com.opsbin.springdata.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public Iterable<Customer> getCustomers() {
        //-- if there is no data in the database, populate one for initial testing
        if (customerRepository.count() == 0) {
            Customer customer = new Customer();
            customer.setName("Right Inc.,");
            customer.setAddress("100 Right way");
            customer.setPhone("1-800-111-2222");
            customer.setContact("CEO");
            customerRepository.save(customer);
        }
        return customerRepository.findAll();
    }

    @Override
    public Optional<Customer> getCustomer(Long customerId) {
        return customerRepository.findById(customerId);
    }

    @Override
    public Customer updateCustomer(Customer customer) {
        Customer newCustomer = new Customer();
        if (customerRepository.existsById(customer.getId())) {
            newCustomer = getCustomer(customer.getId()).get();
            newCustomer.setAddress(customer.getAddress());
            newCustomer.setContact(customer.getContact());
            newCustomer.setName(customer.getName());
            newCustomer.setPhone(customer.getPhone());
        }
        return customerRepository.save(newCustomer);
    }

    @Override
    public Customer addCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public void deleteCustomer(Long customerId) {
        if (customerRepository.existsById(customerId)) {
            customerRepository.delete(getCustomer(customerId).get());
        }
    }
}
