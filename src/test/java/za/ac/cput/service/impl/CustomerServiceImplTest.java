package za.ac.cput.service.impl;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.Customer;
import za.ac.cput.factory.CustomerFactory;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.MethodName.class)
@SpringBootTest
class CustomerServiceImplTest {

    @Autowired
    private CustomerServiceImpl service;

    private static Customer customer = CustomerFactory.buildCustomer("W", "C", "WC@gmail.com", "WC@2002");

    @Test
    void a_create() {
        Customer created = service.create(customer);
        //assertEquals(customer.getCustomerID(), created.getCustomerID());
        System.out.println("Created " + created);
    }

    @Test
    void b_read() {
        Customer read = service.read(customer.getCustomerID());
        assertNotNull(read);
        System.out.println("Read: "+ read);
    }

    @Test
    void c_update() {
        Customer updated = new Customer.Builder().copy(customer).setFirstName("David Henriques").build();
        assertNotNull(updated);
        System.out.println("Updated: " + updated);
    }

    @Test
    @Disabled
    void delete() {
    }

    @Test
    void d_getAll() {
        System.out.println("Show All:");
        System.out.println(service.getAll());
    }
}