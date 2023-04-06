package za.ac.cput.interfaces;
/*
Author: Hanno Visser Immelman 221074414
 */
import za.ac.cput.domain.Enquiry;
import za.ac.cput.factory.EnquiryFactory;

import java.sql.SQLOutput;

import static org.junit.jupiter.api.Assertions.*;

class EnquiryRepositoryTest {
    private static EnquiryRepository repository = EnquiryRepository.getRepository();
    private static Enquiry enquiry = EnquiryFactory.buildEnquiry("1254574","Motherboard Broken","Computer does not turn on","Motherboard does not seem to power the CPU");

    @org.junit.jupiter.api.Test
    void create() {
        Enquiry createE = repository.create(enquiry);
        assertEquals(enquiry.getEnquiryID(),createE.getEnquiryID());
        System.out.println("Create: " + createE);
    }

    @org.junit.jupiter.api.Test
    void read() {
        Enquiry readE = repository.read(enquiry.getEnquiryID());
        assertNotNull(readE);
        System.out.println("Read: " + readE);
    }

    @org.junit.jupiter.api.Test
    void update() {
        Enquiry updateE = new Enquiry.Builder().copy(enquiry)
                .setEnquiryName("Power supply broken")
                .setEnquiryBodyContent("Power supply was faulty that caused motherboard not to turn on")
                .build();
        assertNotNull(repository.update(updateE));
        System.out.println("Updated: " + updateE);
    }

    @org.junit.jupiter.api.Test
    void delete() {
        boolean suc = repository.delete(enquiry.getEnquiryID());
        assertTrue(suc);
        System.out.println("Deleted: " + suc);
    }

    @org.junit.jupiter.api.Test
    void getAll() {
        System.out.println("Show everything: ");
        System.out.println(repository.getAll());
    }
}
