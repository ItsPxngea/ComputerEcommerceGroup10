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
    public static Customer customer = CustomerFactory.buildCustomer("David", "Garrancho", "gd@gmail.com", "DavGar2002BMW");

    public static Product product = ProductFactory.buildProduct("RTX 3060 TI", "Graphics Card", "Next Generation gaming with the RTX 3060 TI",
            1, "Nvidea", "1", "Gaming", "Great Product, Great Service","05-04-2023","4/5", 3000.00);
    Cart c = CartFactory.buildCart(customer, product, 5);

    @Test
    void createCart(){
        System.out.println(c.toString());
        assertNotNull(c);
    }



}