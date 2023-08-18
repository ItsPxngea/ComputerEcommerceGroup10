package za.ac.cput.service.impl;
/* BundleServiceImplTest.java
 This is the test class ProductService
 Author: Reece Bergstedt - 221075240
 Date: 10 June 2023
*/
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.domain.Bundle;
import za.ac.cput.factory.BundleFactory;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.MethodName.class)
class BundleServiceImplTest {

    private static BundleServiceImpl bundleservice = BundleServiceImpl.getService();

    private static Bundle bundle = BundleFactory.buildBundle("Ryzen Bundle", "Gaming Pc", "Complete ryzen only pc",
            1, "2 Years", "Gaming", "Great System, Great Service", "05-04-2023","4/5",2000.00, "Ryzen Setup");

    @Test
    void a_create() {
        Bundle created = bundleservice.create(bundle);
        assertEquals(bundle.getBundleID(), created.getBundleID());
        System.out.println("Create: " + created);
    }

    @Test
    void b_read() {
        Bundle read =  bundleservice.read(bundle.getBundleID());
        assertNotNull(read);
        System.out.println("Read: " + read);
    }

    @Test
    void c_update() {
        Bundle updated = new Bundle.Builder().copy(bundle)
                .setBundleQuantity(2)
                .setBundlePrice(4000)
                .build();
        assertNotNull( bundleservice.update(updated));
        System.out.println("Updated: " + updated);
    }

    @Test
    void e_delete() {
        boolean success = bundleservice.delete(bundle.getBundleID());
        assertTrue(success);
        System.out.println("Deleted: " + success);
    }

    @Test
    void d_getAll() {
        System.out.println("Show all: ");
        System.out.println(bundleservice.getAll());
    }
}
