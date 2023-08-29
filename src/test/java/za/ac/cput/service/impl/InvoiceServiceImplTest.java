package za.ac.cput.service.impl;

import jakarta.transaction.Transactional;
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
import za.ac.cput.repository.InvoiceRepository;

import static org.junit.jupiter.api.Assertions.*;
@TestMethodOrder(MethodOrderer.MethodName.class)
@SpringBootTest
@Transactional
class InvoiceServiceImplTest {

    @Autowired
    private  InvoiceServiceImpl invoiceService ;
    @Autowired
    private InvoiceRepository invoiceRepository ;
    private static final Customer customer_one = CustomerFactory.buildCustomer(
            "Alexander",
            "Draai",
            "alec.draai@gmail.com",
            "AlexDraai143"
    );
    private static final Sales sales_one = SalesFactory.buildSales(
            "20-08-2023",
            4000.00,
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
        Invoice created = invoiceRepository.save(invoice);
        assertEquals(invoice.getInvoiceNumber(), created.getInvoiceNumber());
        System.out.println("Created " + created);
    }

    @Test
    void b_read(){
        Invoice read = invoiceService.read(invoice.getInvoiceNumber());
        assertNotNull(read);
        System.out.println("Read " + read);
    }

    @Test
    void c_update(){
        Customer customer_one = CustomerFactory.buildCustomer("Gemma", "Chauhan", "gemma@gmail.com", "gemma143");
        Sales sales_one = SalesFactory.buildSales("15-07-2023",8000.00,customer_one);
        StoreDetails storeDetails_one = StoreDetailsFactory.buildStoreDetails("Chaos","48 Main Road","021 254 0000","ChaosComputers@gmail.com");
        Invoice invoice = InvoiceFactory.buildInvoice(storeDetails_one,sales_one);

        Invoice updated = new Invoice.Builder().copy(invoice)
                .setStoreDetails(storeDetails_one)
                .setSales(sales_one)
                .build();
        assertNotNull(invoiceService.update(updated));
        System.out.println("Updated " + updated);

    }

    @Test
    void d_delete(){
        boolean delete = invoiceService.delete(invoice.getInvoiceNumber());
        assertTrue(delete);
        System.out.println("Deleted " + delete);
    }

    @Test
    void e_getAll(){
        System.out.println("Show All");
        System.out.println(invoiceService.getAll());
    }

}