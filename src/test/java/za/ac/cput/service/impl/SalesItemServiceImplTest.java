package za.ac.cput.service.impl;

import jakarta.transaction.Transactional;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.Customer;
import za.ac.cput.domain.Product;
import za.ac.cput.domain.Sales;
import za.ac.cput.domain.SalesItem;
import za.ac.cput.factory.CustomerFactory;
import za.ac.cput.factory.ProductFactory;
import za.ac.cput.factory.SalesFactory;
import za.ac.cput.factory.SalesItemFactory;
import za.ac.cput.repository.SalesItemRepository;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class SalesItemServiceImplTest {

    @Autowired
    private SalesItemServiceImpl service;

    @Autowired
    private SalesItemRepository repository;

    private static final List<Product> products = Arrays.asList(
            ProductFactory.buildProduct("FX 1050", "GPU", "Next Generation gaming with the RTX 1050", 2000.00),
            ProductFactory.buildProduct("RX 950", "GPU", "Next Generation gaming with the RTX 950", 1200.00)
    );

    private static final Customer customer = CustomerFactory.buildTestCustomer(
            "Test123",
            "David",
            "Garrancho",
            "Garranchod@gmail.com",
            "what2465"
    );


    private static final Sales sales = SalesFactory.buildSales(
            "30-08-2023",
            4560.00,
            customer
    );

    private static final SalesItem salesItem = SalesItemFactory.buildSales(sales, products, 2, 3200.00);



    @Test
    @Order(1)
    //@Transactional
    void create() {
        SalesItem created = service.create(salesItem);
        System.out.println("Created " + created);
    }

    @Test
    @Order(2)
    //@Transactional
    void read() {
        SalesItem read = service.read(salesItem.getSalesItemID());
        assertNotNull(read);
        System.out.println("Read: "+ read);
    }

    @Test
    @Order(3)
    //@Transactional
    void update() {
        SalesItem updated = new SalesItem.Builder().copy(salesItem).setItemPrice(1200).build();
        repository.save(updated);
        assertNotNull(updated);
        System.out.println("Updated: " + updated);
    }

    @Test
    @Disabled
    //@Transactional
    void delete() {
        boolean success = service.delete(salesItem.getSalesItemID());
        assertTrue(success);
        System.out.println("Deleted: " + success);
    }

    @Test
    @Order(4)
    //@Transactional
    void getAll() {
        System.out.println("Show All:");
        System.out.println(service.getAll());
    }
}
