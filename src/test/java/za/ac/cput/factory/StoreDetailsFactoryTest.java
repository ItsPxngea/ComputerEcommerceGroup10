package za.ac.cput.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.domain.StoreDetails;
import static org.junit.jupiter.api.Assertions.*;

class StoreDetailsFactoryTest {

    @Test
    void createStoreDetails(){
        StoreDetails sd = StoreDetailsFactory.buildStoreDetails("PC Warehouse","65 Church street, Cape Town","089 564 3684","PCWarehouseStore@gmail.com");
        System.out.println(sd.toString());
        assertNotNull(sd);
    }

    @Test
    void emptyParameters1(){
        StoreDetails sd = StoreDetailsFactory.buildStoreDetails("","65 Church street, Cape Town","089 564 3684","PCWarehouseStore@gmail.com");
        assertNull(sd);
    }

    @Test
    void emptyParameters2(){
        StoreDetails sd = StoreDetailsFactory.buildStoreDetails("PC Warehouse","","089 564 3684","PCWarehouseStore@gmail.com");
        assertNull(sd);
    }

    @Test
    void invalidTel(){
        StoreDetails sd = StoreDetailsFactory.buildStoreDetails("PC Warehouse","65 Church street, Cape Town","654","PCWarehouseStore@gmail.com");
        assertNull(sd);
    }

    @Test
    void invalidEmail(){
        StoreDetails sd = StoreDetailsFactory.buildStoreDetails("PC Warehouse","65 Church street, Cape Town","089 564 3684","PCWarehouseStore@gmail.com");
        assertNull(sd);
    }

    @Test
    void testEquality(){
        StoreDetails sd1 = StoreDetailsFactory.buildStoreDetails("PC Warehouse","65 Church street, Cape Town","089 564 3684","PCWarehouseStore@gmail.com");
        StoreDetails sd2 = StoreDetailsFactory.buildStoreDetails("PC Mark","69 Nice street, Cape Town","065 564 3684","PCMarkStore@gmail.com");
        System.out.println(sd1.toString());
        System.out.println(sd2.toString());
        assertNotEquals(sd1,sd2);
    }

    @Test
    void testEquality2(){
        StoreDetails sd1 = StoreDetailsFactory.buildStoreDetails("PC Warehouse","65 Church street, Cape Town","089 564 3684","PCWarehouseStore@gmail.com");
        StoreDetails sd2 = sd1;
        System.out.println(sd1.toString());
        assertEquals(sd1,sd2);
    }



}