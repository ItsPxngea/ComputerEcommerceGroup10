package za.ac.cput.interfaces;
/*
     Author: Reece Bergstedt - 221075240
     Entity for the ProductRepositoryTest
     Date: 22 March 2023
*/
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;
import za.ac.cput.domain.Product;
import za.ac.cput.factory.ProductFactory;

@TestMethodOrder(MethodOrderer.MethodName.class)
class ProductRepositoryTest {

    private static ProductRepository repository = ProductRepository.getRepository();
    private static Product product = ProductFactory.buildProduct("RTX 3060 TI", "Graphics Card", "Next Generation gaming with the RTX 3060 TI",
            1, "Nvidea", "1", "Gaming", "Great Product, Great Service","06-04-2023","4/5", 3000.00);

    @org.junit.jupiter.api.Test
    void a_create() {
        Product created = repository.create(product);
        assertEquals(product.getProductID(), created.getProductID());
        System.out.println("Create: " + created);
    }

    @org.junit.jupiter.api.Test
    void c_read() {
        Product read = repository.read(product.getProductID());
        assertNotNull(read);
        System.out.println("Read: " + read);
    }

    @org.junit.jupiter.api.Test
    void d_update() {
        Product updated = new Product.Builder().copy(product)
                .setProductQuantity(2)
                .setProductPrice(6000)
                .build();
        assertNotNull(repository.update(updated));
        System.out.println("Updated: " + updated);
    }

    @org.junit.jupiter.api.Test
    void f_delete() {
        boolean success = repository.delete(product.getProductID());
        assertTrue(success);
        System.out.println("Deleted: " + success);
    }

    @org.junit.jupiter.api.Test
    void e_getAll() {
        System.out.println("Show all: ");
        System.out.println(repository.getAll());
    }
}