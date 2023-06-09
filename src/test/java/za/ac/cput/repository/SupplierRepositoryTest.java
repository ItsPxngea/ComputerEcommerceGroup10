package za.ac.cput.repository;
/*
    Author: Ethan Botes
    This is the test class for SupplierRepository
    Date: 06 - 04 - 2023
 */

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.domain.Supplier;
import za.ac.cput.factory.SupplierFactory;
import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.MethodName.class)
class SupplierRepositoryTest {

    private static SupplierRepository repository = SupplierRepository.getRepository();
    private static Supplier supplier = SupplierFactory.buildSupplier("ryzen@technologies.com", "0214580649",
            "12 Treebard Close, Sea Point", "2.4 Zen 3 based",
            "Ryzen");


    @org.junit.jupiter.api.Test
    void a_create() {
        Supplier created = repository.create(supplier);
        assertEquals(supplier.getSupplierID(), created.getSupplierID());
        System.out.println("Create: " + created);
    }


    @org.junit.jupiter.api.Test
    void b_read() {
        Supplier read = repository.read(supplier.getSupplierID());
        assertNotNull(read);
        System.out.println("Read: " + read);
    }

    @org.junit.jupiter.api.Test
    void c_update() {
        Supplier updated = new Supplier.Builder().copy(supplier)
                .setSupplierEmail("technologies@intelsupply.com")
                .setSupplierTel("0213007322")
                .setSupplierCompanyName("Intel")
                .build();
        assertNotNull(repository.update(updated));
        System.out.println("Updated: " + updated);

    }

    @org.junit.jupiter.api.Test
    void e_delete() {
        boolean success = repository.delete(supplier.getSupplierID());
        assertTrue(success);
        System.out.println("Deleted: " + success);

    }

    @org.junit.jupiter.api.Test
    void d_getAll() {
        System.out.println("Show all: ");
        System.out.println(repository.getAll());
    }
}