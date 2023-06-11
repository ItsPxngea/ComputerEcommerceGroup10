package za.ac.cput.service.impl;
/*
Ethan Botes - 220101299
This is the SupplierOrderImpl Test
Date: 11 - 060 2023
 */
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.domain.Supplier;
import za.ac.cput.domain.SupplierOrder;
import za.ac.cput.factory.SupplierFactory;
import za.ac.cput.factory.SupplierOrderFactory;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.MethodName.class)
class SupplierOrderServiceImplTest {

    private static SupplierOrderServiceImpl service = SupplierOrderServiceImpl.getService();

    private static SupplierOrder supplierOrder = SupplierOrderFactory.buildSupplierOrder
            ("06-01-2022", "12-01-2022", "11-01-2022",
                    120.00, 12120.00, 2, 6000.00, "Int847");

    @Test
    void a_create() {
        SupplierOrder created = service.create(supplierOrder);
        assertEquals(supplierOrder.getOrderID(), created.getOrderID());
        System.out.println("Create: " + created);
    }

    @Test
    void b_read() {
        SupplierOrder read = service.read(supplierOrder);
        assertNotNull(read);
        System.out.println("Read: " + read);
    }

    @Test
    void c_update(){
        SupplierOrder updated = new SupplierOrder.Builder().copy(supplierOrder)
                .setImportTax(100.00)
                .build();
        assertNotNull(service.update(updated));
        System.out.println("Updated: " + updated);
    }

    @Test
    void e_delete(){
        boolean success = service.delete(supplierOrder);
        assertTrue(success);
        System.out.println("Deleted: " + success);
    }

    @Test
    void d_getAll(){
        System.out.println("Show all: " + service.getAll());
    }

}