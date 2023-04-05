package za.ac.cput.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.domain.InvoiceHistory;
import static org.junit.jupiter.api.Assertions.*;
/*
Author: Alexander Draai - 220118744
This is the test class for InvoiceHistoryFactory
Date: 04 - 02 - 2023
 */
class InvoiceHistoryFactoryTest {

    @Test
    void createInvoiceHistory() throws Exception {
        InvoiceHistory invoiceHistory = InvoiceHistoryFactory.buildInvoiceHistory
        ("CPTWQL125","2 NVIDIA Grapgics cards bought at 12900 each.");
        System.out.println(invoiceHistory);
        assertNotNull(invoiceHistory);
    }

    @Test
    void emptyParameter_HistoryID() throws Exception {
        InvoiceHistory invoiceHistory = InvoiceHistoryFactory.buildInvoiceHistory
                ("","2 NVIDIA Grapgics cards bought at 12900 each.");
        assertNull(invoiceHistory);
    }
    @Test
    void emptyParameter_invoiceDesc() throws Exception {
        InvoiceHistory invoiceHistory = InvoiceHistoryFactory.buildInvoiceHistory
                ("CPTWQL125","");
        assertNull(invoiceHistory);
    }

    @Test
    void textEquality_One() throws Exception {
        InvoiceHistory invoiceHistory_One = InvoiceHistoryFactory.buildInvoiceHistory
        ("CPTWQL125","2 NVIDIA Grapgics cards bought at 12900 each.");
        InvoiceHistory invoiceHistory_Two = InvoiceHistoryFactory.buildInvoiceHistory
        ("CPTWQL125","2 NVIDIA Grapgics cards bought at 12900 each.");
        System.out.println(invoiceHistory_One);
        System.out.println(invoiceHistory_Two);
        assertNotEquals(invoiceHistory_One, invoiceHistory_Two);
    }

    @Test
    void testEquality_Two() throws Exception {
        InvoiceHistory invoiceHistory_One = InvoiceHistoryFactory.buildInvoiceHistory
                ("CPTWQL125","2 NVIDIA Grapgics cards bought at 12900 each.");
        InvoiceHistory invoiceHistory_Two = invoiceHistory_One;
        System.out.println(invoiceHistory_Two.toString());
        assertEquals(invoiceHistory_One,invoiceHistory_Two);
    }

}