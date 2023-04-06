package za.ac.cput.interfaces;
/*
    Author: Hanno Visser Immelman 221074414
    This is the test class for StoreDetailsRepositoryTest
    Date: 06 - 04 - 2023
 */
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.domain.StoreDetails;
import za.ac.cput.factory.StoreDetailsFactory;

import static org.junit.jupiter.api.Assertions.*;
@TestMethodOrder(MethodOrderer.MethodName.class)
class StoreDetailsRepositoryTest {
    private static StoreDetailsRepository repository = StoreDetailsRepository.getRepository();
    private static StoreDetails sd = StoreDetailsFactory.buildStoreDetails("M computers","69 Nice Street, Cape Town","0988422548","MComp@gmail.com");

    @org.junit.jupiter.api.Test
    void a_create() {
        StoreDetails createSD = repository.create(sd);
        assertEquals(sd.getStoreID(),createSD.getStoreID());
        System.out.println("Create: " + createSD);
    }

    @org.junit.jupiter.api.Test
    void b_read() {
        StoreDetails readSD = repository.read(sd.getStoreID());
        assertNotNull(readSD);
        System.out.println("Read: " + readSD);
    }

    @org.junit.jupiter.api.Test
    void c_update() {
        StoreDetails updateSD = new StoreDetails.Builder().copy(sd)
                .setStoreTel("072589652")
                .build();
        assertNotNull(repository.update(updateSD));
        System.out.println("Updated: " + updateSD);
    }

    @org.junit.jupiter.api.Test
    void e_delete() {
        boolean suc = repository.delete(sd.getStoreID());
        assertTrue(suc);
        System.out.println("Deleted: " + suc);
    }

    @org.junit.jupiter.api.Test
    void d_getAll() {
        System.out.println("Show everything: ");
        System.out.println(repository.getAll());
    }
}
