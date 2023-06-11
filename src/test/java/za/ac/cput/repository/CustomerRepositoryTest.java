package za.ac.cput.repository;
/*
    Author: David Garrancho - 221475982
    This is the test class for Customer Repository
    Date: 06 - 04 - 2022
 */
import org.junit.jupiter.api.*;
import za.ac.cput.domain.Customer;
import za.ac.cput.factory.CustomerFactory;

import static org.junit.jupiter.api.Assertions.*;
@TestMethodOrder(MethodOrderer.MethodName.class)
class CustomerRepositoryTest {

    private static CustomerRepository repository = CustomerRepository.getRepository();
    private static Customer customer = CustomerFactory.buildCustomer("David", "Garrancho", "gd@gmail.com", "DavGar2002BMW");

    @org.junit.jupiter.api.Test
    void a_create() {
        Customer created = repository.create(customer);
        assertEquals(customer.getCustomerID(), created.getCustomerID());
        System.out.println("Create: " + created);
    }

    @org.junit.jupiter.api.Test
    void b_read() {
        Customer read = repository.read(customer.getCustomerID());
        assertNotNull(read);
        System.out.println("Read: " + read);
    }

    @org.junit.jupiter.api.Test
    void c_update() {
        Customer updated = new Customer.Builder().copy(customer)
                .setLastName("Yerra")
                .setEmail("garDav@gmail.com")
                .build();
        assertNotNull(repository.update(updated));
        System.out.println("Updated: " + updated);
    }

    @org.junit.jupiter.api.Test
    void d_getAll() {
        System.out.println("Show all: ");
        System.out.println(repository.getAll());
    }

    @org.junit.jupiter.api.Test
    void e_delete() {
        boolean success = repository.delete(customer.getCustomerID());
        assertTrue(success);
        System.out.println("Deleted: " + success);
    }
}