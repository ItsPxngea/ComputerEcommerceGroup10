package za.ac.cput.service.impl;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.domain.StoreDetails;
import za.ac.cput.factory.StoreDetailsFactory;

import static org.junit.jupiter.api.Assertions.*;

/*
    StoreDetailsServiceImplTest.java
    Author: Hanno Visser Immelman 221074414
    This is the test class StoreDetailsServiceImpl
    Date: 10 - 06 - 2023
*/

@TestMethodOrder(MethodOrderer.MethodName.class)
class StoreDetailsServiceImplTest{
    private static StoreDetailsServiceImpl service = StoreDetailsServiceImpl.getService();
    private static StoreDetails storeDetails = StoreDetailsFactory.buildStoreDetails("M computers","69 Nice Street, Cape Town","0988422548","MComp@gmail.com");

    @Test
    void a_create(){
        StoreDetails created = service.create(storeDetails);
        assertEquals(storeDetails.getStoreID(), created.getStoreID());
        System.out.println();
    }

    @Test
    void b_read(){
        StoreDetails read = service.read(storeDetails.getStoreID());
        assertNotNull(read);
        System.out.println("Read: "+read);
    }

    @Test
    void c_update(){
        StoreDetails updated = new StoreDetails.Builder().copy(storeDetails)
                .setStoreName("N Computers")
                .build();
        assertNotNull(service.update(updated));
        System.out.println("Updated: "+updated);
    }

    @Test
    void e_delete(){
        boolean success = service.delete(storeDetails.getStoreID());
        assertTrue(success);
        System.out.println("Deleted: " + success);
    }

    @Test
    void d_getAll(){
        System.out.println("Show all: "+service.getAll());
    }
}
