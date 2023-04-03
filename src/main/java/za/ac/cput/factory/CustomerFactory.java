package za.ac.cput.factory;

import za.ac.cput.domain.Customer;
import za.ac.cput.util.Helper;

public class CustomerFactory {

    public static Customer buildCustomer(String firstName, String lastName, String email, String password){
        if(Helper.isNullOrEmpty(firstName) || Helper.isNullOrEmpty(lastName) || Helper.isNullOrEmpty(password)){
            return null;
        }

        if(!Helper.isValidEmail(email)){
            return null;
        }

        String customerID = Helper.generateCustomerID(firstName, lastName);

        return new Customer.Builder().setCustomerID(customerID)
                .setFirstName(firstName)
                .setLastName(lastName)
                .setEmail(email)
                .setPassword(password)
                .build();
    }


}
