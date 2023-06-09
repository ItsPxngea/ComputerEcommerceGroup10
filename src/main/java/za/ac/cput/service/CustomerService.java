package za.ac.cput.service;

import za.ac.cput.domain.Customer;

import java.util.Set;

public interface CustomerService extends IService<Customer, String>{

    Set<Customer> getAll();
}
