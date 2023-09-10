package za.ac.cput.service.impl;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.Customer;
import za.ac.cput.domain.Enquiry;
import za.ac.cput.factory.CustomerFactory;
import za.ac.cput.factory.EnquiryFactory;
import za.ac.cput.repository.CustomerRepository;
import za.ac.cput.repository.EnquiryRepository;

import static org.junit.jupiter.api.Assertions.*;
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@SpringBootTest
class EnquiryServiceImplTest {
@Autowired
private EnquiryServiceImpl service;
@Autowired
private EnquiryRepository repository;
    @Autowired
    private CustomerRepository customerrepository;

    private static final Customer customer = CustomerFactory.buildTestCustomer(
            "e0295579-70a0-48f3-b0c8-3f3fbe66b6cc",
            "Luke",
            "Ben",
            "LW@gmail.com",
            "wufh%2465"
    );

    private static final Enquiry enquiry = EnquiryFactory.buildEnquiry(customer,"Delivery complaint","Did not get my delivery","Payed but did not receive my product");
    @Test
    @Order(1)
    void create() {
        customerrepository.save(customer);
        Enquiry created = service.create(enquiry);
        System.out.println("Created "+created);
    }

    @Test
    @Order(2)
    void read() {
        Enquiry read = service.read(enquiry.getEnquiryID());
        assertNotNull(read);
        System.out.println("Read:" + read);
    }

    @Test
    @Order(3)
    void update() {
        Enquiry updated = new Enquiry.Builder().copy(enquiry).setEnquirySubjectLine("Got the wrong delivery").build();
        repository.save(updated);
        assertNotNull(updated);
        System.out.println("Updated: "+updated);
    }

    @Test
    @Order(4)
    @Disabled
    void delete() {

    }

    @Test
    @Order(5)
    void getAll() {
        System.out.println("Show All: ");
        System.out.println(service.getAll());
    }
}
