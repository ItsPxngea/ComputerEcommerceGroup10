package za.ac.cput.repository;
/*
    Author: Michael Daniel Johnson
    This is the test class for PreBuilt Repository
    Date: 06 - 04 - 2022
 */
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.factory.PreBuiltFactory;
import za.ac.cput.repository.impl.PreBuiltRepositoryImpl;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.MethodName.class)
class PreBuiltRepositoryTest {

    private static PreBuiltRepositoryImpl repo = PreBuiltRepositoryImpl.getRepo();
    private static za.ac.cput.domain.PreBuilt p = PreBuiltFactory.buildPreBuilt("GTX500", "Your product is good.", "5 Stars","29-03-2023", "Graphics Card", "Gaming", "Valid", 4590);

    @Test
    void a_create() {
        za.ac.cput.domain.PreBuilt created = repo.create(p);
        assertEquals(p.getBuildID(), p.getBuildID());
        System.out.println("Create: " + created);
    }

    @Test
    void b_read() {
        za.ac.cput.domain.PreBuilt read = repo.read(p.getBuildID());
        assertNotNull(read);
        System.out.println("Read: " + read);
    }

    @Test
    void c_update() {
        za.ac.cput.domain.PreBuilt updated = new za.ac.cput.domain.PreBuilt.Builder().copy(p)
                .setBuildType("Commercial")
                .setBuildWarranty("invalid")
                .build();
        assertNotNull(repo.update(updated));
        System.out.println("Updated: " + updated);
    }

    @Test
    void e_delete() {
        boolean success = repo.delete(p.getBuildID());
        assertTrue(success);
        System.out.println("Deleted: " + success);
    }

    @Test
    void d_getAll() {
        System.out.println("Show all: ");
        System.out.println(repo.getAll());
    }
}