package za.ac.cput.service.impl;

import org.junit.jupiter.api.*;
import za.ac.cput.domain.Cart;
import za.ac.cput.factory.CartFactory;


import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.MethodName.class)
class CartServiceImplTest {

    private static CartServiceImpl service = CartServiceImpl.getService();

    private static Cart cart = CartFactory.buildCart("GTX850", 5, 4500.00);

    @Test
    void a_create() {
        Cart created = service.create(cart);
        assertEquals(cart.getCartID(), created.getCartID());
        System.out.println("Create: " + created);
    }

    @Test
    void b_read() {
        Cart read = service.read(cart);
        assertNotNull(read);
        System.out.println("Read: " + read);
    }

    @Test
    void c_update() {
        Cart updated = new Cart.Builder().copy(cart)
                .setProductQuantity(2)
                .setProductPrice(4000)
                .build();
        assertNotNull(service.update(updated));
        System.out.println("Updated: " + updated);
    }

    @Test
    void e_delete() {
        boolean success = service.delete(cart);
        assertTrue(success);
        System.out.println("Deleted: " + success);
    }

    @Test
    void d_getAll() {
        System.out.println("Show all: ");
        System.out.println(service.getAll());
    }
}