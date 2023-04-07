package za.ac.cput.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Invoice;
import static org.junit.jupiter.api.Assertions.*;
/*
    Author: Alexander Draai - 220118744
    This is the test class for invoiceFactory
    Date: 04 - 02 - 2023
 */
class InvoiceFactoryTest {

    @Test
    void createInvoice() throws Exception {
        Invoice invoice = InvoiceFactory.buildInvoice("PR103","CPT902","GTX 1660 Super",
                                                "Graphics card manufactured by NVIDIA", 1,
                                                    12900.00,14835.00,15,"03-04-2023");
        System.out.println(invoice.toString());
        assertNotNull(invoice);
    }

    @Test
    void emptyParameter_ProductID() throws Exception {
        Invoice invoice = InvoiceFactory.buildInvoice("","CPT902","GTX 1660 Super",
                "Graphics card manufactured by NVIDIA", 1,
                12900.00,14835.00,15,"03-04-2023");
        assertNull(invoice);
    }
    @Test
    void emptyParameter_StoreID() throws Exception {
        Invoice invoice = InvoiceFactory.buildInvoice("PR103","","GTX 1660 Super",
                "Graphics card manufactured by NVIDIA", 1,
                12900.00,14835.00,15,"03-04-2023");
        assertNull(invoice);
    }
    @Test
    void emptyParameter_ProductName() throws Exception {
        Invoice invoice = InvoiceFactory.buildInvoice("PR103","CPT902","",
                "Graphics card manufactured by NVIDIA", 1,
                12900.00,14835.00,15,"03-04-2023");
        assertNull(invoice);
    }
    @Test
    void emptyParameter_Product_Desc() throws Exception {
        Invoice invoice = InvoiceFactory.buildInvoice("PR103","CPT902","GTX 1660 Super",
                "", 1,
                12900.00,14835.00,15,"03-04-2023");
        assertNull(invoice);
    }
    @Test
    void emptyParameter_Product_Date() throws Exception {
        Invoice invoice = InvoiceFactory.buildInvoice("PR103","CPT902","GTX 1660 Super",
                "", 1,
                12900.00,14835.00,15,"");
        assertNull(invoice);
    }

    @Test
    void testEquality_One() throws Exception {
        Invoice invoice_one = InvoiceFactory.buildInvoice("PR103","CPT902","GTX 1660 Super",
                "Graphics card manufactured by NVIDIA", 1,
                12900.00,14835.00,15,"03-04-2023");

        Invoice invoice_two = InvoiceFactory.buildInvoice("PR104","CPT902","GTX 4090",
                "Graphics card manufactured by NVIDIA", 1,
                49000.00,56350.00,15,"02-04-2023");
        System.out.println(invoice_one);
        System.out.println(invoice_two);
        assertNotEquals(invoice_one, invoice_two);
    }
    @Test
    void testEquality_Two() throws Exception {
        Invoice invoice_one = InvoiceFactory.buildInvoice("PR103","CPT902","GTX 1660 Super",
                "Graphics card manufactured by NVIDIA", 1,
                12900.00,14835.00,15,"03-04-2023");
        Invoice invoice_two = invoice_one;
        System.out.println(invoice_two.toString());
        assertEquals(invoice_one, invoice_two);
    }

}