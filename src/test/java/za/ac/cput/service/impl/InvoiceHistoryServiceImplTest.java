package za.ac.cput.service.impl;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.domain.InvoiceHistory;
import za.ac.cput.factory.InvoiceHistoryFactory;
import za.ac.cput.service.InvoiceHistoryService;

import static org.junit.jupiter.api.Assertions.*;

/*
    Author: Alexander Draai - 220118744
    This is the test class InvoiceHistoryServiceImpl
    Date: 10 - 06 - 2023
 */

@TestMethodOrder(MethodOrderer.MethodName.class)
class InvoiceHistoryServiceImplTest {

    private static InvoiceHistoryService serviceHistory = InvoiceHistoryServiceImpl.getService();
    private static InvoiceHistory invoiceHistory_One = InvoiceHistoryFactory
                                                       .buildInvoiceHistory("Late generation GTX4090s");

    @Test
    void a_create(){
        InvoiceHistory invoiceHistory = serviceHistory.create(invoiceHistory_One);
        assertEquals(invoiceHistory_One.getHistoryID(), invoiceHistory.getHistoryID());
        System.out.println("Created -> " + invoiceHistory);
    }
    @Test
    void b_read(){
        InvoiceHistory invoiceRead = serviceHistory.read(invoiceHistory_One);
        assertNotNull(invoiceRead);
        System.out.println("Read -> " + invoiceRead);
    }
    @Test
    void c_update(){
        InvoiceHistory updatedInvoice = new InvoiceHistory.Builder().copy(invoiceHistory_One)
                .setInvoiceNumber("5135143685")
                .build();
        assertNotNull(serviceHistory.update(updatedInvoice));
        System.out.println("Update -> " + updatedInvoice);
    }
    @Test
    void d_delete(){
        boolean success = serviceHistory.delete(invoiceHistory_One);
        assertTrue(success);
        System.out.println("Success -> " + success);
    }
    @Test
    void e_getAll(){
        System.out.println("Get All:");
        System.out.println(serviceHistory.getAll());
    }
}