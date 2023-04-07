package za.ac.cput.interfaces;
/*
    Author: David Garrncho
    This is the test class for Cart Repository
    Date: 06 - 04 - 2022
 */
import org.junit.jupiter.api.*;
import za.ac.cput.domain.Cart;
import za.ac.cput.factory.CartFactory;

import static org.junit.jupiter.api.Assertions.*;
@TestMethodOrder(MethodOrderer.MethodName.class)
class CartRepositoryTest {

    private static CartRepository repository = CartRepository.getRepository();
    private static Cart cart = CartFactory.buildCart("GTX850", 5, 4500.00);

    @org.junit.jupiter.api.Test
    void a_create() {
        Cart created = repository.create(cart);
        assertEquals(cart.getCartID(), created.getCartID());
        System.out.println("Create: " + created);
    }

    @org.junit.jupiter.api.Test
    void b_read() {
        Cart read = repository.read(cart.getCartID());
        assertNotNull(read);
        System.out.println("Read: " + read);
    }

    @org.junit.jupiter.api.Test
    void c_update() {
        Cart updated = new Cart.Builder().copy(cart)
                .setProductQuantity(8)
                .setProductPrice(4000)
                .build();
        assertNotNull(repository.update(updated));
        System.out.println("Updated: " + updated);
    }

    @org.junit.jupiter.api.Test
    void d_delete() {
        boolean success = repository.delete(cart.getCartID());
        assertTrue(success);
        System.out.println("Deleted: " + success);
    }

    @org.junit.jupiter.api.Test
    void e_getAll() {
        System.out.println("Show all: ");
        System.out.println(repository.getAll());
    }
}