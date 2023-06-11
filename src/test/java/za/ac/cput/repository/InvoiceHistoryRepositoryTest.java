package za.ac.cput.repository;
/*
    Author: Alexander Draai - 220118744
    This is the test class for InvoiceHistory repository
    Date: 06 - 04 - 2023
 */
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.domain.InvoiceHistory;
import za.ac.cput.factory.InvoiceHistoryFactory;
import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.MethodName.class)
class InvoiceHistoryRepositoryTest {

    private static InvoiceHistoryRepository repository = InvoiceHistoryRepository.getRepository();
    private static InvoiceHistory invoiceHistory =
                   InvoiceHistoryFactory.buildInvoiceHistory("NVIDIA Graphics Card");

    @org.junit.jupiter.api.Test
    void a_create() {
        InvoiceHistory created = repository.create(invoiceHistory);
        assertEquals(invoiceHistory.getHistoryID(), created.getHistoryID());
        System.out.println("Create: " + created);
    }

    @org.junit.jupiter.api.Test
    void b_read() {
        InvoiceHistory read = repository.read(invoiceHistory.getHistoryID());
        assertNotNull(read);
        System.out.println("Read: " + read);
    }

    @org.junit.jupiter.api.Test
    void c_update() {
        InvoiceHistory updated = new InvoiceHistory.Builder().copy(invoiceHistory)
                .setInvoiceDescription("Cool graphics card")
                .build();
        assertNotNull(repository.update(updated));
        System.out.println("Updated: " + updated);
    }

    @org.junit.jupiter.api.Test
    void e_delete() {
        boolean success = repository.delete(invoiceHistory.getHistoryID());
        assertTrue(success);
        System.out.println("Deleted: " + success);
    }

    @org.junit.jupiter.api.Test
    void d_getAll() {
        System.out.println("Show All: ");
        System.out.println(repository.getAll());
    }


}