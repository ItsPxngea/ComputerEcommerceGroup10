package za.ac.cput.service.impl;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.domain.Supplier;
import za.ac.cput.factory.SupplierFactory;

import static org.junit.jupiter.api.Assertions.*;




    /*
        Author: Ethan Botes - 220101299
        This is the test class for SupplierServiceImpl
        Date: 11 - 06 - 2023
    */


@TestMethodOrder(MethodOrderer.MethodName.class)
public class SupplierServiceImplTest {

    private static SupplierServiceImpl service = SupplierServiceImpl.getService();

    private static Supplier supplier = SupplierFactory.buildSupplier
            ("supplier@intel.com",
                    "0214564389", "5 Alvin Road, Woodstock", "Intel® Core™ Processors",
                    "Intel");

    @Test
    void a_create() {
        Supplier created = service.create(supplier);
        assertEquals(supplier.getSupplierID(), created.getSupplierID());
        System.out.println("Create: " + created);
    }

    @Test
    void b_read() {
        Supplier read = service.read(supplier.getSupplierID());
        assertNotNull(read);
        System.out.println("Read: " + read);
    }

    @Test
    void c_update(){
        Supplier updated = new Supplier.Builder().copy(supplier)
                .setSupplierTel("0217509999")
                .build();
        assertNotNull(service.update(updated));
        System.out.println("Updated: " + updated);
    }

    @Test
    void e_delete(){
        boolean success = service.delete(supplier.getSupplierID());
        assertTrue(success);
        System.out.println("Deleted: " + success);
    }

    @Test
    void d_getAll(){
        System.out.println("Show all: " + service.getAll());
    }



}