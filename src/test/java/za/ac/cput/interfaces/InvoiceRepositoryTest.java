package za.ac.cput.interfaces;
/*
    Author: Alexander Draai - 220118744
    This is the test class for Invoice repository
    Date: 06 - 04 - 2023
 */

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.domain.Invoice;
import za.ac.cput.factory.InvoiceFactory;
import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.MethodName.class)
class InvoiceRepositoryTest {
    private static InvoiceRepository repository = InvoiceRepository.getRepository();
     private static Invoice invoice =  InvoiceFactory.buildInvoice("GT312", "CPT105", "GTX 4090",
                                                                    "NVIDIA Graphics Card", 1,
                                                                    42000.00,48300.00,
                                                                    15,"06-04-2023");

    @org.junit.jupiter.api.Test
    void a_create() {
        Invoice created = repository.create(invoice);
        assertEquals(invoice.getInvoiceNumber(),created.getInvoiceNumber());
        System.out.println("Create: " + created);
    }

    @org.junit.jupiter.api.Test
    void b_read() {
        Invoice read = repository.read(invoice.getInvoiceNumber());
        assertNotNull(read);
        System.out.println("Read: " + read);
    }

    @org.junit.jupiter.api.Test
    void c_update() {
        Invoice updated = new Invoice.Builder().copy(invoice)
                .setProductID("GTY564")
                .setProductName("Ryzen 7")
                .setProductDescription("Ryzen 7 is an AMD product")
                .build();
        assertNotNull(repository.update(updated));
        System.out.println("Updated: " + updated);
    }

    @org.junit.jupiter.api.Test
    void e_delete() {
        boolean success = repository.delete(invoice.getInvoiceNumber());
        assertTrue(success);
        System.out.println("Deleted: " + success);
    }

    @org.junit.jupiter.api.Test
    void d_getAll() {
        System.out.println("Show All: ");
        System.out.println(repository.getAll());
    }
}