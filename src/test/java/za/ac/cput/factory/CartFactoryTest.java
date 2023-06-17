package za.ac.cput.factory;
/*
    Author: David Garrancho
    This is the test class for Cart Factory
    Date: 06 - 04 - 2022
 */
import org.junit.jupiter.api.Test;
import za.ac.cput.domain.*;

import static org.junit.jupiter.api.Assertions.*;


class CartFactoryTest {
    public static Customer customer = CustomerFactory.buildCustomer();

    public static Product product = ProductFactory.buildProduct("GTX850", 4500.00);
    Cart c = CartFactory.buildCart(customer, product, 5);

    @Test
    void createCart(){
        System.out.println(c.toString());
        assertNotNull(c);
    }



}