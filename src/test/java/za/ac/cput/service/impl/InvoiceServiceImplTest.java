package za.ac.cput.service.impl;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.domain.Invoice;
import za.ac.cput.factory.InvoiceFactory;

import static org.junit.jupiter.api.Assertions.*;

/*
    InvoiceServiceImplTest.java
    Author: Alexander Draai - 220118744
    This is the test class InvoiceServiceImpl
    Date: 10 - 06 - 2023
 */
@TestMethodOrder(MethodOrderer.MethodName.class)
class InvoiceServiceImplTest {

    private static InvoiceServiceImpl service = InvoiceServiceImpl.getService();
    private static Invoice invoice_One = InvoiceFactory.buildInvoice("4845","124","GTX4090",
                                                                    "Graphics Card",6,49500.50,
                                                                    52400.60,15,"20-05-2023");

    @Test
    void a_create(){
        Invoice invoiceCreated = service.create(invoice_One);
        assertEquals(invoice_One.getInvoiceNumber(), invoiceCreated.getInvoiceNumber());
        System.out.println("Created Invoice: " + invoiceCreated);
    }
    @Test
    void b_read(){
        Invoice invoiceRead = service.read(invoice_One);
        assertNotNull(invoiceRead);
        System.out.println("Read ->" + invoiceRead);
    }
    @Test
    void c_update(){
        Invoice updatedInvoice = new Invoice.Builder().copy(invoice_One)
                .setProductName("GTX 4090ti")
                .setPrice(53600.60)
                .build();
        assertNotNull(service.update(updatedInvoice));
        System.out.println("Updated -> " + updatedInvoice);
    }
    @Test
    void d_delete(){
        boolean success = service.delete(invoice_One);
        assertTrue(success);
        System.out.println("Deleted -> " + success);
    }
    @Test
    void getAll(){
        System.out.println("Get All:");
        System.out.println(service.getAll());
    }

}