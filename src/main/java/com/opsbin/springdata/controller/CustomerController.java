package com.opsbin.springdata.controller;

import com.opsbin.springdata.constants.UrlConstants;
import com.opsbin.springdata.entity.Customer;
import com.opsbin.springdata.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
public class CustomerController extends AbstractController {

    @Autowired
    private CustomerService customerService;

    protected static final String VIEW_CREATE_FORM_CUSTOMER = "customer/customer-create-form";
    protected static final String VIEW_UPDATE_FORM_CUSTOMER = "customer/customer-update-form";
    protected static final String VIEW_LIST_CUSTOMERS = "customer/customer";

    protected static final String MODEL_ATTRIBUTE_CUSTOMERS = "customers";
    protected static final String MODEL_ATTRIBUTE_CUSTOMER = "customer";

    protected static final String PARAMETER_CUSTOMER_ID = "customerId";

    /**
     * URL: http://{hostname}:{port}/customers/new
     * HTTP method: GET
     */
    @GetMapping(UrlConstants.CUSTOMERS_CREATE)
    public String createCustomerForm(Model model) {
        Customer customer = new Customer();
        model.addAttribute(customer);
        return VIEW_CREATE_FORM_CUSTOMER;
    }

    /**
     * URL: http://{hostname}:{port}/customers/new
     * HTTP method: POST
     */
    @PostMapping(UrlConstants.CUSTOMERS_CREATE)
    public String createCustomer(Customer customer) {
        Customer addedCustomer = customerService.addCustomer(customer);
        return redirectTo(UrlConstants.CUSTOMERS_RETRIEVE);
    }

    /**
     * URL: http://{hostname}:{port}/customers/list
     * HTTP method: GET
     */
    @GetMapping(UrlConstants.CUSTOMERS_RETRIEVE)
    public String retrieveCustomers(Model model) {
        Iterable<Customer> customersList = customerService.getCustomers();
        model.addAttribute(MODEL_ATTRIBUTE_CUSTOMERS, customersList);
        return VIEW_LIST_CUSTOMERS;
    }

    /**
     * URL: http://{hostname}:{port}/customers/update/{customerId}
     * HTTP method: GET
     */
    @GetMapping(UrlConstants.CUSTOMERS_UPDATE)
    public String updateCustomerForm(@PathVariable(PARAMETER_CUSTOMER_ID) Long customerId, Model model) {
        Optional<Customer> customer = customerService.getCustomer(customerId);
        model.addAttribute(MODEL_ATTRIBUTE_CUSTOMER, customer);
        return VIEW_UPDATE_FORM_CUSTOMER;
    }

    /**
     * URL: http://{hostname}:{port}/customers/update/{customerId}
     * HTTP method: POST
     */
    @PostMapping(UrlConstants.CUSTOMERS_UPDATE)
    public String updateCustomer(@ModelAttribute(MODEL_ATTRIBUTE_CUSTOMER) Customer customer) {
        Customer updatedCustomer = customerService.updateCustomer(customer);
        return redirectTo(UrlConstants.CUSTOMERS_RETRIEVE);
    }

    /**
     * URL: http://{hostname}:{port}/customers/delete/{customerId}
     * HTTP method: GET
     */
    @GetMapping(UrlConstants.CUSTOMERS_DELETE)
    public String deleteCustomer(@PathVariable(PARAMETER_CUSTOMER_ID) Long customerId) {
        customerService.deleteCustomer(customerId);
        return redirectTo(UrlConstants.CUSTOMERS_RETRIEVE);
    }

}
