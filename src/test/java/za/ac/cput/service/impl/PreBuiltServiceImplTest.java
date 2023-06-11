package za.ac.cput.service.impl;
/*
PreBuiltServiceImpl.java
Test for the PreBuiltService entity
Author: Michael Daniel Johnson 221094040
Date: 11/06/2023
 */
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.domain.PreBuilt;
import za.ac.cput.factory.PreBuiltFactory;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.MethodName.class)
class PreBuiltServiceImplTest {
    private static PreBuiltServiceImpl preBuiltService = PreBuiltServiceImpl.getService();

    private static PreBuilt preBuilt = PreBuiltFactory.buildPreBuilt("GTX500", "Your product is good.","5 Stars","29-03-2023","Graphics Card","Gaming","Valid", 4590);

    @Test
    void a_create() {
        PreBuilt created = preBuiltService.create(preBuilt);
        assertEquals(preBuilt.getBuildID(), created.getBuildID());
        System.out.println("Create: " + created);
    }

    @Test
    void b_read() {
        PreBuilt read =  preBuiltService.read(preBuilt);
        assertNotNull(read);
        System.out.println("Read: " + read);
    }

    @Test
    void c_update() {
        PreBuilt updated = new PreBuilt.Builder().copy(preBuilt)
                .setBuildType("Commercial")
                .setBuildWarranty("invalid")
                .build();
        assertNotNull(preBuiltService.update(updated));
        System.out.println("Updated: " + updated);
    }

    @Test
    void e_delete() {
        boolean success = preBuiltService.delete(preBuilt);
        assertTrue(success);
        System.out.println("Deleted: " + success);
    }

    @Test
    void d_getAll() {
        System.out.println("Show all: ");
        System.out.println(preBuiltService.getAll());
    }
}