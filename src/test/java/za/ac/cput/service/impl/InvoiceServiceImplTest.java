package za.ac.cput.service.impl;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.Customer;
import za.ac.cput.domain.Invoice;
import za.ac.cput.domain.Sales;
import za.ac.cput.domain.StoreDetails;
import za.ac.cput.factory.CustomerFactory;
import za.ac.cput.factory.InvoiceFactory;
import za.ac.cput.factory.SalesFactory;
import za.ac.cput.factory.StoreDetailsFactory;

import static org.junit.jupiter.api.Assertions.*;

/*
    InvoiceServiceImplTest.java
    Author: Alexander Draai - 220118744
    This is the test class InvoiceServiceImpl
    Date: 10 - 06 - 2023
 */
@TestMethodOrder(MethodOrderer.MethodName.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class InvoiceServiceImplTest {

    @Autowired
    private static InvoiceServiceImpl service;


    private static final Customer customer_one = CustomerFactory.buildCustomer(
            "Jason",
            "King",
            "KingJason@gmail.com",
            "AlexDraai143"
    );
    private static final Sales sales_one = SalesFactory.buildSales(
            "05-08-2023",
            7000.00,
            customer_one
    );
    private static final StoreDetails storeDetails_one = StoreDetailsFactory.buildStoreDetails(
            "Evetech",
            "7 De Calstone",
            "021 445 9912",
            "techEve@gmail.com"
    );

    private static final Invoice invoice = InvoiceFactory.buildInvoice(
            storeDetails_one,
            sales_one
    );


    @Test
    void a_create(){
        Invoice invoiceCreated = service.create(invoice);
        assertEquals(invoice.getInvoiceNumber(), invoiceCreated.getInvoiceNumber());
        System.out.println("Created Invoice: " + invoiceCreated);
    }
    @Test
    void b_read(){
        Invoice invoiceRead = service.read(invoice.getInvoiceNumber());
        assertNotNull(invoiceRead);
        System.out.println("Read ->" + invoiceRead);
    }
    @Test
    @Disabled
    void c_update(){
        Invoice updatedInvoice = new Invoice.Builder().copy(invoice)
                .build();
        assertNotNull(service.update(updatedInvoice));
        System.out.println("Updated -> " + updatedInvoice);
    }
    @Test
    void d_delete(){
        boolean success = service.delete(invoice.getInvoiceNumber());
        assertTrue(success);
        System.out.println("Deleted -> " + success);
    }
    @Test
    void getAll(){
        System.out.println("Get All:");
        System.out.println(service.getAll());
    }

}