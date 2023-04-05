package za.ac.cput.factory;
/* ProductFactoryTest.java
 Entity for the ProductFactoryTest
 Author: Reece Bergstedt - 221075240
 Date: 22 March 2023
*/
import org.junit.jupiter.api.Test;

import za.ac.cput.domain.Product;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ProductFactoryTest {

    @Test
    void createProduct(){
        Product p = ProductFactory.buildProduct("RTX 3060 TI", "Graphics Card", "Next Generation gaming with the RTX 3060 TI",
                1, "Nvidea", "1", "Gaming", "Great Product, Great Service","2023-04-02","4/5", 3000.00);
        System.out.println(p.toString());
        assertNotNull(p);
    }

    @Test
    void emptyParameters1(){
        Product p = ProductFactory.buildProduct("", "Graphics Card", "Next Generation gaming with the RTX 3060 TI",
                1, "Nvidea", "1", "Gaming", "Great Product, Great Service","2023-04-02","4/5", 3000.00);
        assertNull(p);
    }

    @Test
    void emptyParameters2(){
        Product p = ProductFactory.buildProduct("RTX 3060 TI", "", "Next Generation gaming with the RTX 3060 TI",
                1, "Nvidea", "1", "Gaming", "Great Product, Great Service","2023-04-02","4/5", 3000.00);
        assertNull(p);
    }

    @Test
    void emptyParameters3(){
        Product p = ProductFactory.buildProduct("RTX 3060 TI", "Graphics Card", "",
                1, "Nvidea", "1", "Gaming", "Great Product, Great Service","2023-04-02","4/5", 3000.00);
        assertNull(p);
    }

    @Test
    void emptyParameters4(){
        Product p = ProductFactory.buildProduct("RTX 3060 TI", "Graphics Card", "Next Generation gaming with the RTX 3060 TI",
                1, "", "1", "Gaming", "Great Product, Great Service","2023-04-02","4/5", 3000.00);
        assertNull(p);
    }

    @Test
    void emptyParameters5(){
        Product p = ProductFactory.buildProduct("RTX 3060 TI", "Graphics Card", "Next Generation gaming with the RTX 3060 TI",
                1, "Nvidea", "", "Gaming", "Great Product, Great Service","2023-04-02","4/5", 3000.00);
        assertNull(p);
    }

    @Test
    void emptyParameters6(){
        Product p = ProductFactory.buildProduct("RTX 3060 TI", "Graphics Card", "Next Generation gaming with the RTX 3060 TI",
                1, "Nvidea", "1", "", "Great Product, Great Service","2023-04-02","4/5", 3000.00);
        assertNull(p);
    }


    @Test
    void emptyParameters7(){
        Product p = ProductFactory.buildProduct("RTX 3060 TI", "Graphics Card", "Next Generation gaming with the RTX 3060 TI",
                1, "Nvidea", "1", "Gaming", "","2023-04-02","4/5", 3000.00);
        assertNull(p);
    }

    @Test
    void emptyParameters8(){
        Product p = ProductFactory.buildProduct("RTX 3060 TI", "Graphics Card", "Next Generation gaming with the RTX 3060 TI",
                1, "Nvidea", "1", "Gaming", "Great Product, Great Service","","4/5", 3000.00);
        assertNull(p);
    }

    @Test
    void emptyParameters9(){
        Product p = ProductFactory.buildProduct("RTX 3060 TI", "Graphics Card", "Next Generation gaming with the RTX 3060 TI",
                1, "Nvidea", "1", "Gaming", "Great Product, Great Service","2023-04-02","", 3000.00);
        assertNull(p);
    }

    @Test
    void invalidParameters1(){
        Product p = ProductFactory.buildProduct("RTX 3060 TI", "Graphics Card", "Next Generation gaming with the RTX 3060 TI",
                -1, "Nvidea", "1", "Gaming", "Great Product, Great Service","2023-04-02","4/5", 3000.00);
        assertNull(p);
    }

    @Test
    void invalidParameters2(){
        Product p = ProductFactory.buildProduct("RTX 3060 TI", "Graphics Card", "Next Generation gaming with the RTX 3060 TI",
                1, "Nvidea", "1", "Gaming", "Great Product, Great Service","2023-04-02","4/5", -3000.00);
        assertNull(p);
    }

    @Test
    void testEquality(){
        Product p = ProductFactory.buildProduct("RTX 3060 TI", "Graphics Card", "Next Generation gaming with the RTX 3060 TI",
                1, "Nvidea", "1", "Gaming", "Great Product, Great Service","2023-04-02","4/5", 3000.00);
        Product p2 = ProductFactory.buildProduct("GTX 1060 TI", "Graphics Card", "Game with the powerful GTX 1060 TI",
                1, "Nvidea", "1", "Gaming", "Great Product, Great Service","2022-04-02","3/5", 1000.00);
        System.out.println(p.toString());
        System.out.println(p2.toString());
        assertNotEquals(p, p2);
    }

    @Test
    void testEquality2(){
        Product p = ProductFactory.buildProduct("RTX 3060 TI", "Graphics Card", "Next Generation gaming with the RTX 3060 TI",
                1, "Nvidea", "1", "Gaming", "Great Product, Great Service","2023-04-02","4/5", 3000.00);
        Product p2 = p;
        System.out.println(p.toString());
        assertEquals(p, p2);
    }

   /* @Test
    void testDate(){
        Bundle b = BundleFactory.buildBundle("Ryzen Bundle", "Gaming Pc", "Complete ryzen only pc",
                1, "2 Years", "Gaming", "Great System, Great Service", "2023-04-05","4/5",2000.00, "Ryzen Setup");
        Bundle b2 = b;
        System.out.println(b.toString());
        assertEquals(b, b2);
    }*/
}
