package za.ac.cput.service.impl;

/* AddressServiceImplTest.java
Implementation test class for AddressServiceImpl.java
Author: Michael Daniel Johnson 221094040
Date: 5 September 2023
*/

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.Address;
import za.ac.cput.domain.City;
import za.ac.cput.domain.Country;
import za.ac.cput.factory.AddressFactory;
import za.ac.cput.factory.CityFactory;
import za.ac.cput.factory.CountryFactory;
import za.ac.cput.repository.AddressRepository;
import za.ac.cput.service.AddressService;

import static org.junit.jupiter.api.Assertions.*;
@TestMethodOrder(MethodOrderer.MethodName.class)
@SpringBootTest
class AddressServiceImplTest {

    @Autowired
    private AddressService addressService;
    @Autowired
    private AddressRepository addressRepository;

    private static final Country southAfrica = CountryFactory.createCountry(
            "South Africa"
    );
    private static final City homeCity = CityFactory.createCity(
            "Cape Town",
            southAfrica
    );
    private static final Address homeAddress = AddressFactory.buildAddress(
            "53 Main Road",
            "6045",
            homeCity
    );

    @Test
    void a_create() {
        Address created = addressService.create(homeAddress);
        assertEquals(homeAddress.getAddressID(), created.getAddressID());
        System.out.println("Created: " + created);
    }

    @Test
    void b_read() {
        Address read = addressService.read(homeAddress.getAddressID());
        assertNotNull(read);
        System.out.println("Read " + read);
    }

    @Test
    void c_update() {
        Address updated = new Address.Builder().copy(homeAddress)
                .setStreetAddress("6 Basset Road")
                .build();
        addressRepository.save(updated);
        assertNotNull(updated);
        System.out.println("Updated " + updated);
    }

    @Test
    @Disabled
    void e_delete() {
        boolean delete = addressService.delete(homeAddress.getAddressID());
        assertTrue(delete);
        System.out.println("Deleted " + delete);
    }

    @Test
    void d_getAll() {
        System.out.println("Show All");
        System.out.println(addressService.getAll());
    }
}