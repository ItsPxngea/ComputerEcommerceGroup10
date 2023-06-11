package za.ac.cput.service.impl;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.domain.Enquiry;
import za.ac.cput.factory.EnquiryFactory;

/*
    Author: Hanno Visser Immelman 221074414
    This is the test class EnquiryServiceImpl
    Date: 10 - 06 - 2023
*/

@TestMethodOrder(MethodOrderer.MethodName.class)
class EnquiryServiceImplTest {
    private static EnquiryServiceImpl service = EnquiryServiceImpl.getService();


    private static Enquiry enquiry = EnquiryFactory.buildEnquiry("1254574", "Motherboard Broken", "Computer does not turn on", "Motherboard does not seem to power the CPU");

    @Test
    void a_create() {
        Enquiry created = service.create(enquiry);
        assertEquals(enquiry.getEnquiryID(), created.getEnquiryID());
        System.out.println("Create: " + created);
    }

    @Test
    void b_read() {
        Enquiry read = service.read(enquiry);
        assertNotNull(read);
        System.out.println("Read: " + read);
    }

    @Test
    void c_update() {
        Enquiry updated = new Enquiry.Builder().copy(enquiry)
                .setEnquiryName("CPU Broken")
                .build();
        assertNotNull(service.update(updated));
        System.out.println("Updated: " + updated);
    }

    @Test
    void e_delete() {
        boolean success = service.delete(enquiry);
        assertTrue(success);
        System.out.println("Deleted: " + success);
    }

    @Test
    void d_getAll() {
        System.out.println("Show all: " + service.getAll());
    }
}
