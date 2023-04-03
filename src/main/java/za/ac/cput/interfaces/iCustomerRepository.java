package za.ac.cput.interfaces;

import za.ac.cput.domain.Customer;

import java.util.Set;

public interface iCustomerRepository {
    public Set<Customer> getAll();
}
