package za.ac.cput.repository;
/*
    Author: Ethan Botes
    This is the test class for SupplierOrderRepository
    Date: 06 - 04 - 2023
 */

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.factory.SupplierOrderFactory;
import za.ac.cput.repository.impl.SupplierOrderRepositoryImpl;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.MethodName.class)
class SupplierOrderRepositoryTest {

    private static SupplierOrderRepositoryImpl repository = SupplierOrderRepositoryImpl.getRepository();
    private static za.ac.cput.domain.SupplierOrder supplierOrder = SupplierOrderFactory.buildSupplierOrder("06-01-2023", "12-01-2023", "12-01-2023",
            120.00, 12120.00, 2, 6000.00, "Int847");


    @org.junit.jupiter.api.Test
    void a_create() {
        za.ac.cput.domain.SupplierOrder created = repository.create(supplierOrder);
        assertEquals(supplierOrder.getOrderID(), created.getOrderID());
        System.out.println("Create: " + created);
    }


    @org.junit.jupiter.api.Test
    void b_read() {
        za.ac.cput.domain.SupplierOrder read = repository.read(supplierOrder.getOrderID());
        assertNotNull(read);
        System.out.println("Read: " + read);
    }

    @org.junit.jupiter.api.Test
    void c_update() {
        za.ac.cput.domain.SupplierOrder updated = new za.ac.cput.domain.SupplierOrder.Builder().copy(supplierOrder)
                .setDateOfOrder("2023-01-07")
                .setExpectedDeliveryDate("2023-01-14")
                .setActualDeliveryDate("2023-01-15")
                .setImportTax(300)
                .setTotalCost(30000)
                .build();
        assertNotNull(repository.update(updated));
        System.out.println("Updated: " + updated);
    }

    @org.junit.jupiter.api.Test
    void e_delete() {
        boolean success = repository.delete(supplierOrder.getOrderID());
        assertTrue(success);
        System.out.println("Deleted: " + success);
    }

    @org.junit.jupiter.api.Test
    void d_getAll() {
        System.out.println("Show all: ");
        System.out.println(repository.getAll());
    }
}

