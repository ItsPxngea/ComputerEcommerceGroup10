package za.ac.cput.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Customer;

import static org.junit.jupiter.api.Assertions.*;

class CustomerFactoryTest {

    @Test
    void createCustomer(){
        Customer c = CustomerFactory.buildCustomer("David", "Garrancho", "gd@gmail.com", "DavGar2002BMW");
        System.out.println(c.toString());
        assertNotNull(c);
    }

    @Test
    void emptyParameters1(){
        Customer c = CustomerFactory.buildCustomer("", "Garrancho", "gd@gmail.com", "DavGar2002BMW");
        assertNull(c);
    }

    @Test
    void emptyParameters2(){
        Customer c = CustomerFactory.buildCustomer("David", "", "gd@gmail.com", "DavGar2002BMW");
        assertNull(c);
    }

    @Test
    void emptyParameters3(){
        Customer c = CustomerFactory.buildCustomer("David", "Garrancho", "", "DavGar2002BMW");
        assertNull(c);
    }

    @Test
    void emptyParameters4(){
        Customer c = CustomerFactory.buildCustomer("David", "Garrancho", "gd@gmail.com", "");
        assertNull(c);
    }

    @Test
    void invalidParameters1(){
        Customer c = CustomerFactory.buildCustomer("David", "Garrancho", "gd@gmail", "DavGar2002BMW");
        assertNull(c);
    }

    @Test
    void invalidParameters2(){
        Customer c = CustomerFactory.buildCustomer("David", "Garrancho", "gd@.com", "DavGar2002BMW");
        assertNull(c);
    }

    @Test
    void testEquality(){
        Customer c = CustomerFactory.buildCustomer("David", "Garrancho", "gd@gmail.com", "DavGar2002BMW");
        Customer c2 = CustomerFactory.buildCustomer("Daven", "Gary", "gd2@gmail.com", "GaryDaven@2341");
        System.out.println(c.toString());
        System.out.println(c2.toString());
        assertNotEquals(c, c2);
    }

    @Test
    void testEquality2(){
        Customer c = CustomerFactory.buildCustomer("David", "Garrancho", "gd@gmail.com", "DavGar2002BMW");
        Customer c2 = c;
        System.out.println(c.toString());
        assertEquals(c, c2);
    }
}