package za.ac.cput.service.impl;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.domain.Cart;
import za.ac.cput.domain.Customer;
import za.ac.cput.factory.CartFactory;
import za.ac.cput.factory.CustomerFactory;

import static org.junit.jupiter.api.Assertions.*;

/*
    CustomerServiceImplTest.java
    Author: David Henriques Garrancho 221475982
    This is the test class CustomerServiceImpl
    Date: 09 - 06 - 2023
*/

@TestMethodOrder(MethodOrderer.MethodName.class)
class CustomerServiceImplTest {

    private static CustomerServiceImpl service = CustomerServiceImpl.getService();

    private static Customer customer = CustomerFactory.buildCustomer("David", "Ga", "gd@gmail.com", "DavGar2002BMW");

    @Test
    void a_create() {
        Customer created = service.create(customer);
        assertEquals(customer.getCustomerID(), created.getCustomerID());
        System.out.println("Create: " + created);
    }

    @Test
    void b_read() {
        Customer read = service.read(customer);
        assertNotNull(read);
        System.out.println("Read: " + read);
    }

    @Test
    void c_update() {
        Customer updated = new Customer.Builder().copy(customer)
                .setLastName("Garrancho")
                .build();
        assertNotNull(service.update(updated));
        System.out.println("Updated: " + updated);
    }

    @Test
    void e_delete() {
        boolean success = service.delete(customer);
        assertTrue(success);
        System.out.println("Deleted: " + success);
    }

    @Test
    void d_getAll() {
        System.out.println("Show all: ");
        System.out.println(service.getAll());
    }
}