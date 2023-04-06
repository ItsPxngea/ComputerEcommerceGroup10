package za.ac.cput.interfaces;

/*
    Author: David Henriques Garrancho (221475982)
    Interface for the Customer Repository
    Date: 20 March 2023
*/

import za.ac.cput.domain.Customer;

import java.util.Set;

public interface iCustomerRepository {
    public Set<Customer> getAll();
}
