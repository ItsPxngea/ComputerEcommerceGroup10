package za.ac.cput.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.Customer;
import za.ac.cput.repository.CustomerRepository;
import za.ac.cput.service.CustomerService;
import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {


    private CustomerRepository repository;

    @Autowired
    private CustomerServiceImpl(CustomerRepository repository){
        this.repository = repository;
    }

    @Override
    public Customer create(Customer customer) {
        return this.repository.save(customer);
    }

    @Override
    public Customer read(Long customerID) {
        return this.repository.findById(customerID).orElse(null);
    }

    @Override
    public Customer update(Customer customer) {
        if(this.repository.existsById((customer.getCustomerID())))
            return this.repository.save(customer);
        return null;
    }

    @Override
    public boolean delete(Long customerID) {
        if (this.repository.existsById(customerID)){
            this.repository.deleteById(customerID);
            return  true;
        }
        return false;
    }

    @Override
    public List<Customer> getAll() {
        return this.repository.findAll();
    }

    public Customer authenticate(String email, String password) {
        Customer customer = repository.findByEmail(email);

        if (customer != null && customer.getPassword().equals(password)) {
            return customer;
        }

        return null;
    }

}
