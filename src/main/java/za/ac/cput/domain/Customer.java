package za.ac.cput.domain;

/* Customer.java
POJO for the Customer
Author: David Henriques Garrancho (221475982)
Date: 20 March 2023
*/

import jakarta.persistence.*;

import javax.annotation.processing.Generated;
import java.io.Serializable;
import java.util.Objects;


@Entity
public class Customer implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // or other strategy
    private Long customerID;
    private String firstName;
    private String lastName;
    @Column(unique = true)
    private String email;
    private String password;

    public Customer(){
    }

    private Customer(Builder b){
        this.customerID = b.customerID;
        this.firstName = b.firstName;
        this.lastName = b.lastName;
        this.email = b.email;
        this.password = b.password;
    }

    public Long getCustomerID() {return customerID;}

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return Objects.equals(customerID, customer.customerID) && Objects.equals(firstName, customer.firstName) && Objects.equals(lastName, customer.lastName) && Objects.equals(email, customer.email) && Objects.equals(password, customer.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(customerID, firstName, lastName, email, password);
    }

    @Override
    public String toString() {
        return "Customer{" +
                "customerID='" + customerID + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public static class Builder {
        public Long customerID;
        private String firstName;
        private String lastName;
        private String email;
        private String password;

        public Builder setCustomerID(Long customerID){
            this.customerID = customerID;
            return this;
        }

        public Builder setFirstName(String firstName){
            this.firstName = firstName;
            return this;
        }

        public Builder setLastName(String lastName){
            this.lastName = lastName;
            return this;
        }

        public Builder setEmail(String email){
            this.email = email;
            return this;
        }

        public Builder setPassword(String password){
            this.password = password;
            return this;
        }

        public Builder copy(Customer customer){
            this.customerID = customer.customerID;
            this.firstName = customer.firstName;
            this.lastName = customer.lastName;
            this.email = customer.email;
            this.password = customer.password;
            return this;
        }

        public Customer build(){
            return new Customer(this);
        }
    }
}
