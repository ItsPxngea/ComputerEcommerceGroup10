package za.ac.cput.service.impl;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.Customer;
import za.ac.cput.factory.CustomerFactory;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class CustomerServiceImplTest {

    @Autowired
    private CustomerServiceImpl service;

    private static final Customer customer = CustomerFactory.buildCustomer(
            "Damien",
            "Garrancho",
            "DavidGary@gmail.com",
            "Gary!s23"
    );

    @Test
    @Order(1)
    void create() {
        Customer created = service.create(customer);
        System.out.println("Created " + created);
    }

    @Test
    @Order(2)
    void read() {
        Customer read = service.read(customer.getCustomerID());
        assertNotNull(read);
        System.out.println("Read: "+ read);
    }

    @Test
    @Order(3)
    void update() {
        Customer updated = new Customer.Builder().copy(customer).setLastName("Gary").build();
        assertNotNull(updated);
        System.out.println("Updated: " + updated);
    }

    @Test
    void delete() {
        boolean success = service.delete(customer.getCustomerID());
        assertTrue(success);
        System.out.println("Deleted -> " + success);
    }

    @Test
    @Order(4)
    void d_getAll() {
        System.out.println("Show All:");
        System.out.println(service.getAll());
    }
}