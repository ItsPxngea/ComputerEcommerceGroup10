package za.ac.cput.service.impl;

import za.ac.cput.domain.Customer;
import za.ac.cput.repository.CustomerRepository;
import za.ac.cput.service.CustomerService;

import java.util.Set;
/*
    Author: David Henriques Garrancho 221475982
    This is the implementation for the service CustomerService.java
    Date: 09 - 06 - 2023
 */
public class CustomerServiceImpl implements CustomerService {


    private static CustomerServiceImpl service = null;
    private CustomerRepository repository = null;

    private CustomerServiceImpl(){
        if(repository == null){
            repository = CustomerRepository.getRepository();
        }
    }

    public static CustomerServiceImpl getService(){
        if(service == null){
            service = new CustomerServiceImpl();
        }
        return service;
    }

    @Override
    public Customer create(Customer customer) {
        return repository.create(customer);
    }

    @Override
    public Customer read(Customer id) {
        return repository.read(id.getCustomerID());
    }

    @Override
    public Customer update(Customer customer) {
        return repository.update(customer);
    }

    @Override
    public boolean delete(Customer id) {
        return repository.delete(id.getCustomerID());
    }

    @Override
    public Set<Customer> getAll() {
        return repository.getAll();
    }
}
