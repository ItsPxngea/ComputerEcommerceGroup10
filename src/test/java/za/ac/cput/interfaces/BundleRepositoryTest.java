package za.ac.cput.interfaces;
/*
     Author: Reece Bergstedt - 221075240
     Entity for the BundleRepositoryTest
     Date: 22 March 2023
*/
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.domain.Bundle;
import za.ac.cput.factory.BundleFactory;

import static org.junit.jupiter.api.Assertions.*;
@TestMethodOrder(MethodOrderer.MethodName.class)
class BundleRepositoryTest {

    private static BundleRepository repository = BundleRepository.getRepository();
    private static Bundle bundle = BundleFactory.buildBundle("Ryzen Bundle", "Gaming Pc", "Complete ryzen only pc",
            1, "2 Years", "Gaming", "Great System, Great Service", "06-04-2023", "4/5", 2000.00, "Ryzen Setup");

    @org.junit.jupiter.api.Test
    void a_create() {
        Bundle created = repository.create(bundle);
        assertEquals(bundle.getBundleID(), created.getBundleID());
        System.out.println("Create: " + created);
    }

    @org.junit.jupiter.api.Test
    void b_read() {
        Bundle read = repository.read(bundle.getBundleID());
        assertNotNull(read);
        System.out.println("Read: " + read);
    }

    @org.junit.jupiter.api.Test
    void c_update() {
        Bundle updated = new Bundle.Builder().copy(bundle)
                .setBundleQuantity(2)
                .setBundlePrice(4000)
                .build();
        assertNotNull(repository.update(updated));
        System.out.println("Updated: " + updated);
    }

    @org.junit.jupiter.api.Test
    void e_delete() {
        boolean success = repository.delete(bundle.getBundleID());
        assertTrue(success);
        System.out.println("Deleted: " + success);
    }

    @org.junit.jupiter.api.Test
    void d_getAll() {
        System.out.println("Show all: ");
        System.out.println(repository.getAll());
    }
}