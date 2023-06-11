package za.ac.cput.service.impl;
/* ProductServiceImpl.java
 This is the test class ProductService
 Author: Reece Bergstedt - 221075240
 Date: 10 June 2023
*/
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.domain.Product;
import za.ac.cput.factory.ProductFactory;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.MethodName.class)
class ProductServiceImplTest {

    private static ProductServiceImpl productservice = ProductServiceImpl.getService();

    private static Product product = ProductFactory.buildProduct("RTX 3060 TI", "Graphics Card", "Next Generation gaming with the RTX 3060 TI",
            1, "Nvidea", "1", "Gaming", "Great Product, Great Service","05-04-2023","4/5", 3000.00);

    @Test
    void a_create() {
        Product created = productservice.create(product);
        assertEquals(product.getProductID(), created.getProductID());
        System.out.println("Create: " + created);
    }

    @Test
    void b_read() {
        Product read = productservice.read(product);
        assertNotNull(read);
        System.out.println("Read: " + read);
    }

    @Test
    void c_update() {
        Product updated = new Product.Builder().copy(product)
                .setProductQuantity(2)
                .setProductPrice(6000)
                .build();
        assertNotNull(productservice.update(updated));
        System.out.println("Updated: " + updated);
    }

    @Test
    void e_delete() {
        boolean success = productservice.delete(product);
        assertTrue(success);
        System.out.println("Deleted: " + success);
    }

    @Test
    void d_getAll() {
        System.out.println("Show all: ");
        System.out.println(productservice.getAll());
    }
}
