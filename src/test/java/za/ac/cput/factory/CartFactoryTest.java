package za.ac.cput.factory;
/*
    Author: David Garrancho
    This is the test class for Cart Factory
    Date: 06 - 04 - 2022
 */
import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Cart;

import static org.junit.jupiter.api.Assertions.*;

class CartFactoryTest {

    @Test
    void createCart(){
        Cart c = CartFactory.buildCart("GTX850", 5, 4500.00);
        System.out.println(c.toString());
        assertNotNull(c);
    }

    @Test
    void emptyParameters1(){
        Cart c = CartFactory.buildCart("", 5, 4500.00);
        assertNull(c);
    }

    @Test
    void invalidParameters1(){
        Cart c = CartFactory.buildCart("GTX850", -5, 4500.00);
        assertNull(c);
    }

    @Test
    void invalidParameters2(){
        Cart c = CartFactory.buildCart("GTX850", 5, -4500.00);
        assertNull(c);
    }

    @Test
    void testEquality(){
        Cart c = CartFactory.buildCart("GTX850", 5, 4500.00);
        Cart c2 = CartFactory.buildCart("GTX650", 2, 2250.00);
        System.out.println(c.toString());
        System.out.println(c2.toString());
        assertNotEquals(c, c2);
    }

    @Test
    void testEquality2(){
        Cart c = CartFactory.buildCart("GTX850", 5, 4500.00);
        Cart c2 = c;
        System.out.println(c.toString());
        assertEquals(c, c2);
    }


}