package za.ac.cput.service.impl;

/* CountryServiceImplTest.java
Implementation test class for CountryService.java
Author: Michael Daniel Johnson 221094040
Date: 19 August 2023
*/

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.Country;
import za.ac.cput.factory.CountryFactory;
import za.ac.cput.repository.CountryRepository;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class CountryServiceImplTest {
    @Autowired
    private CountryServiceImpl countryService;

    @Autowired
    private CountryRepository countryRepository;
    private static final Country country = CountryFactory.createCountry("Pluto");

    @Order(1)
    @Test
   // @Transactional
    void a_create() {
        countryRepository.save(country);
        Country created = countryService.create(country);
        assertEquals(country.getCountryID(), created.getCountryID());
        System.out.println("Created: "+ created);
    }

    @Order(2)
    @Test
    //@Transactional
    void b_read() {
        Country read = countryService.read(country.getCountryID());
        assertNotNull(read);
        System.out.println("Read: "+read);
    }

    @Order(3)
    @Test
   // @Transactional
    void c_update() {
        Country updated = new Country.Builder().copy(country)
                .setCountryName("Iceland")
                .build();
        assertNotNull(updated);
        countryRepository.save(updated);
        System.out.println("Updated: "+ updated);
    }

    @Order(5)
    @Test
    @Disabled
    void e_delete() {
        boolean success = countryService.delete(country.getCountryID());
        assertTrue(success);
        System.out.println("Deleted: "+success);
    }

    @Order(4)
    @Test
    //@Transactional
    void d_getAll() {
        System.out.println("Show All:");
        System.out.println(countryService.getAll());
    }
}