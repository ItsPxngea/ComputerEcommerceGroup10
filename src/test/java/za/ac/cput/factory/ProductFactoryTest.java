package za.ac.cput.factory;

import org.junit.jupiter.api.Test;

import za.ac.cput.domain.Bundle;
import za.ac.cput.domain.Product;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
/*
    Author: Reece Bergstedt
    This is the test class for Product Factory
    Date: 06 - 04 - 2022
 */
public class ProductFactoryTest {

    @Test
    void createProduct(){
        Product p = ProductFactory.buildProduct("RTX 3060 TI", "Graphics Card", "Next Generation gaming with the RTX 3060 TI",
                1, "Nvidea", "1", "Gaming", "Great Product, Great Service","05-04-2023","4/5", 3000.00);
        System.out.println(p.toString());
        assertNotNull(p);
    }

    @Test
    void emptyParameters1(){
        Product p = ProductFactory.buildProduct("", "Graphics Card", "Next Generation gaming with the RTX 3060 TI",
                1, "Nvidea", "1", "Gaming", "Great Product, Great Service","05-04-2023","4/5", 3000.00);
        assertNull(p);
    }

    @Test
    void emptyParameters2(){
        Product p = ProductFactory.buildProduct("RTX 3060 TI", "", "Next Generation gaming with the RTX 3060 TI",
                1, "Nvidea", "1", "Gaming", "Great Product, Great Service","05-04-2023","4/5", 3000.00);
        assertNull(p);
    }

    @Test
    void emptyParameters3(){
        Product p = ProductFactory.buildProduct("RTX 3060 TI", "Graphics Card", "",
                1, "Nvidea", "1", "Gaming", "Great Product, Great Service","05-04-2023","4/5", 3000.00);
        assertNull(p);
    }

    @Test
    void emptyParameters4(){
        Product p = ProductFactory.buildProduct("RTX 3060 TI", "Graphics Card", "Next Generation gaming with the RTX 3060 TI",
                1, "", "1", "Gaming", "Great Product, Great Service","05-04-2023","4/5", 3000.00);
        assertNull(p);
    }

    @Test
    void emptyParameters5(){
        Product p = ProductFactory.buildProduct("RTX 3060 TI", "Graphics Card", "Next Generation gaming with the RTX 3060 TI",
                1, "Nvidea", "", "Gaming", "Great Product, Great Service","05-04-2023","4/5", 3000.00);
        assertNull(p);
    }

    @Test
    void emptyParameters6(){
        Product p = ProductFactory.buildProduct("RTX 3060 TI", "Graphics Card", "Next Generation gaming with the RTX 3060 TI",
                1, "Nvidea", "1", "", "Great Product, Great Service","05-04-2023","4/5", 3000.00);
        assertNull(p);
    }


    @Test
    void emptyParameters7(){
        Product p = ProductFactory.buildProduct("RTX 3060 TI", "Graphics Card", "Next Generation gaming with the RTX 3060 TI",
                1, "Nvidea", "1", "Gaming", "","05-04-2023","4/5", 3000.00);
        assertNull(p);
    }

    @Test
    void emptyParameters8(){
        Product p = ProductFactory.buildProduct("RTX 3060 TI", "Graphics Card", "Next Generation gaming with the RTX 3060 TI",
                1, "Nvidea", "1", "Gaming", "Great Product, Great Service","05-04-2023","", 3000.00);
        assertNull(p);
    }

    @Test
    void invalidParameters1(){
        Product p = ProductFactory.buildProduct("RTX 3060 TI", "Graphics Card", "Next Generation gaming with the RTX 3060 TI",
                -1, "Nvidea", "1", "Gaming", "Great Product, Great Service","05-04-2023","4/5", 3000.00);
        assertNull(p);
    }

    @Test
    void invalidParameters2(){
        Product p = ProductFactory.buildProduct("RTX 3060 TI", "Graphics Card", "Next Generation gaming with the RTX 3060 TI",
                1, "Nvidea", "1", "Gaming", "Great Product, Great Service","05-04-2023","4/5", -3000.00);
        assertNull(p);
    }

    @Test
    void invalidParameters3(){
        Product p = ProductFactory.buildProduct("RTX 3060 TI", "Graphics Card", "Next Generation gaming with the RTX 3060 TI",
                1, "Nvidea", "1", "Gaming", "Great Product, Great Service","29-02-2023","4/5", -3000.00);
        assertNull(p);
    }





    @Test
    void testInvalidDate() {
        Product p = ProductFactory.buildProduct("RTX 3060 TI", "Graphics Card", "Next Generation gaming with the RTX 3060 TI",
                1, "Nvidea", "1", "Gaming", "Great Product, Great Service","jvj","4/5", 3000.00);
        assertNull(p);
    }
}
