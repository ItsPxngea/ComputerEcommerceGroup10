package za.ac.cput.factory;

/* CustomerFactory.java
Factory for Customer
Author: David Henriques Garrancho (221475982)
Date: 20 March 2023
*/

import za.ac.cput.domain.Customer;
import za.ac.cput.util.Helper;


public class CustomerFactory {

    public static Customer buildCustomer(String firstName, String lastName, String email, String password) {
        if (Helper.isNullOrEmpty(firstName) || Helper.isNullOrEmpty(lastName) || Helper.isNullOrEmpty(password)) {
            return null;
        }

        if (!Helper.isValidEmail(email)) {
            return null;
        }

        return new Customer.Builder()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setEmail(email)
                .setPassword(password)
                .build();
    }

    public static Customer buildTestCustomer(Long id) {

        return new Customer.Builder().setCustomerID(id)
                .build();
    }

}
