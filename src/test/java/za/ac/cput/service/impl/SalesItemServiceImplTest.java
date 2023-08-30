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

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class SalesItemServiceImplTest {

    @Autowired
    private SalesItemServiceImpl service;

    //private static final List<Product> products = Arrays.asList(
    //        ProductFactory.buildProduct("FX 3060", "Item", "Next Generation gaming with the RTX 3060 TI", 3000.00),
    //        ProductFactory.buildProduct("RX 4050", "Item", "Next Generation gaming with the RTX 4050", 4800.00)
    //);

    private static final Product product = ProductFactory.buildProduct("FX 3060", "Item", "Next Generation gaming with the RTX 3060 TI", 3000.00);

    private static final Customer customer = CustomerFactory.buildTestCustomer(
            "Test2456",
            "Luke",
            "Ben",
            "LW@gmail.com",
            "wufh%2465"
    );


    private static final Sales sales = SalesFactory.buildSales(
            "16-08-2023",
            4560.00,
            customer
    );

    //private static final SalesItem salesItem = SalesItemFactory.buildSales(sales, products, 4, 4800);
    private static final SalesItem salesItem = SalesItemFactory.buildSales(sales, product, 4, 4800);


    @Test
    @Order(1)
    @Transactional
    void create() {
        SalesItem created = service.create(salesItem);
        System.out.println("Created " + created);
    }

    @Test
    @Order(2)
    @Transactional
    void read() {
        SalesItem read = service.read(salesItem.getSalesItemID());
        assertNotNull(read);
        System.out.println("Read: "+ read);
    }

    @Test
    @Order(3)
    @Transactional
    void update() {
        SalesItem updated = new SalesItem.Builder().copy(salesItem).setItemPrice(1200).build();
        assertNotNull(updated);
        System.out.println("Updated: " + updated);
    }

    @Test
    @Disabled
    @Transactional
    void delete() {
        boolean success = service.delete(salesItem.getSalesItemID());
        assertTrue(success);
        System.out.println("Deleted: " + success);
    }

    @Test
    @Order(4)
    @Transactional
    void getAll() {
        System.out.println("Show All:");
        System.out.println(service.getAll());
    }
}
