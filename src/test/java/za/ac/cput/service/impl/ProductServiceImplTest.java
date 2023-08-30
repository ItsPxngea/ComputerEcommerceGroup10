package za.ac.cput.service.impl;
/* ProductServiceImpl.java
 This is the test class ProductService
 Author: Reece Bergstedt - 221075240
 Date: 10 June 2023
*/
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.Product;
import za.ac.cput.factory.ProductFactory;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.MethodName.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ProductServiceImplTest {

    @Autowired
    private static ProductServiceImpl service;

    private static final Product product = ProductFactory.buildProduct("RX 4050", "Item", "Next Generation gaming with the RTX 4050", 4800.00);

    @Test
    void a_create() {
        Product created = service.create(product);
        System.out.println("Create: " + created);
    }

    @Test
    void b_read() {
        Product read = service.read(product.getProductID());
        assertNotNull(read);
        System.out.println("Read: " + read);
    }

    @Test
    void c_update() {
        Product updated = new Product.Builder().copy(product)
                .setProductPrice(6000)
                .build();
        assertNotNull(service.update(updated));
        System.out.println("Updated: " + updated);
    }

    @Test
    @Disabled
    void e_delete() {
        boolean success = service.delete(product.getProductID());
        assertTrue(success);
        System.out.println("Deleted: " + success);
    }

    @Test
    void d_getAll() {
        System.out.println("Show all: ");
        System.out.println(service.getAll());
    }
}
