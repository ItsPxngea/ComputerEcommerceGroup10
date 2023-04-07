package za.ac.cput.interfaces;
/*
    Author: Alexander Draai - 220118744
    This is the test class for InvoiceHistory repository
    Date: 06 - 04 - 2023
 */
import za.ac.cput.domain.InvoiceHistory;
import za.ac.cput.factory.InvoiceHistoryFactory;
import static org.junit.jupiter.api.Assertions.*;
class InvoiceHistoryRepositoryTest {

    private static InvoiceHistoryRepository repository = InvoiceHistoryRepository.getRepository();
    private static InvoiceHistory invoiceHistory =
                   InvoiceHistoryFactory.buildInvoiceHistory("GT4524", "NVIDIA Graphics Card");

    @org.junit.jupiter.api.Test
    void create() {
        InvoiceHistory created = repository.create(invoiceHistory);
        assertEquals(invoiceHistory.getHistoryID(), created.getInvoiceNumber());
        System.out.println("Create: " + created);
    }

    @org.junit.jupiter.api.Test
    void read() {
        InvoiceHistory read = repository.read(invoiceHistory.getInvoiceNumber());
        assertNotNull(read);
        System.out.println("Read: " + read);
    }

    @org.junit.jupiter.api.Test
    void update() {
        InvoiceHistory updated = new InvoiceHistory.Builder().copy(invoiceHistory)
                .setHistoryId("GTX412523")
                .setInvoiceNumber("INV65403")
                .build();
        assertNotNull(repository.update(updated));
        System.out.println("Updated: " + updated);
    }

    @org.junit.jupiter.api.Test
    void delete() {
        boolean success = repository.delete(invoiceHistory.getInvoiceNumber());
        assertTrue(success);
        System.out.println("Deleted: " + success);
    }

    @org.junit.jupiter.api.Test
    void getAll() {
        System.out.println("Show All: ");
        System.out.println(repository.getAll());
    }


}