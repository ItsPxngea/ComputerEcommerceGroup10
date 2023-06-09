package za.ac.cput.service.impl;

import za.ac.cput.domain.Customer;
import za.ac.cput.repository.CustomerRepository;
import za.ac.cput.service.CustomerService;

import java.util.Set;

public class CustomerServiceImpl implements CustomerService {


    private static CustomerServiceImpl service = null;
    private CustomerRepository repository = null;

    private CustomerServiceImpl(){
        if(repository == null){
            repository = CustomerRepository.getRepository();
        }
    }

    private static CustomerServiceImpl getService(){
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
