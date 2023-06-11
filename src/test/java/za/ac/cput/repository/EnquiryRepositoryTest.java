package za.ac.cput.repository;
/*
    Author: Hanno Visser Immelman 221074414
    This is the test class for Enquiry Repository
    Date: 06 - 04 - 2022
 */
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.domain.Enquiry;
import za.ac.cput.factory.EnquiryFactory;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
@TestMethodOrder(MethodOrderer.MethodName.class)
class EnquiryRepositoryTest {
    private static EnquiryRepository repository = EnquiryRepository.getRepository();
    private static Enquiry enquiry = EnquiryFactory.buildEnquiry("1254574","Motherboard Broken","Computer does not turn on","Motherboard does not seem to power the CPU");

    @Test
    void a_create() {
        Enquiry createE = repository.create(enquiry);
        assertEquals(enquiry.getEnquiryID(),createE.getEnquiryID());
        System.out.println("Create: " + createE); 
    }

    @Test
    void b_read() {
        Enquiry readE = repository.read(enquiry.getEnquiryID());
        assertNotNull(readE);
        System.out.println("Read: " + readE);
    }

    @Test
    void c_update() {
        Enquiry updateE = new Enquiry.Builder().copy(enquiry)
                .setEnquiryName("Power supply broken")
                .setEnquiryBodyContent("Power supply was faulty that caused motherboard not to turn on")
                .build();
        assertNotNull(repository.update(updateE));
        System.out.println("Updated: " + updateE);
    }

    @Test
    void e_delete() {
        boolean suc = repository.delete(enquiry.getEnquiryID());
        assertTrue(suc);
        System.out.println("Deleted: " + suc);
    }

    @Test
    void d_getAll() {
        System.out.println("Show everything: ");
        System.out.println(repository.getAll());
    }
}
