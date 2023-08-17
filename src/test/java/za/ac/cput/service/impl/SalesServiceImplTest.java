package za.ac.cput.service.impl;

import jakarta.transaction.Transactional;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.*;
import za.ac.cput.factory.*;
import za.ac.cput.repository.*;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.MethodName.class)
@SpringBootTest
@Transactional
class SalesServiceImplTest {

    @Autowired
    private SalesServiceImpl service;

    @Autowired
    private CustomerRepository customerRepository;

    private static Customer customer = CustomerFactory.buildCustomer("W", "C", "WC@gmail.com", "WC@2002");

    private static Sales sales = SalesFactory.buildSales("16-08-2023", 4520.00, customer);


    @Test
    @Transactional
    void a_create() {
        customerRepository.save(customer);
        Sales created = service.create(sales);
        System.out.println("Created " + created);
    }

    @Test
    @Transactional
    void b_read() {
        Sales read = service.read(sales.getSaleID());
        System.out.println("Read: "+ read);
        assertNotNull(read);
    }

    @Test
    @Transactional
    void c_update() {
        Sales updated = new Sales.Builder().copy(sales).setSaleDate("15-09-2023").setTotalAmount(3520.00).build();
        assertNotNull(updated);
        System.out.println("Updated: " + updated);
    }

    @Test
    @Disabled
    void delete() {
    }

    @Test
    @Transactional
    void d_getAll() {
        System.out.println("Show All:");
        System.out.println(service.getAll());
    }
}