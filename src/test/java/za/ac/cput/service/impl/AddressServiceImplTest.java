package za.ac.cput.service.impl;

import jakarta.transaction.Transactional;
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
import za.ac.cput.repository.CityRepository;
import za.ac.cput.repository.CountryRepository;
import za.ac.cput.service.AddressService;

import static org.junit.jupiter.api.Assertions.*;
@TestMethodOrder(MethodOrderer.MethodName.class)
@SpringBootTest
//@Transactional
class AddressServiceImplTest {

    @Autowired
    private AddressService addressService;
   // @Autowired
   // private CityRepository cityRepository;
   // @Autowired
   // private CountryRepository countryRepository;


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
    //@Transactional
    void a_create() {
        //addressRepository.save(homeAddress);
       //cityRepository.save(homeCity);
        //countryRepository.save(southAfrica);



        Address created = addressService.create(homeAddress);
        System.out.println(homeAddress.getAddressID());
        System.out.println(created.getAddressID());

        assertEquals(homeAddress.getAddressID(), created.getAddressID());
        System.out.println("Created: " + created);
    }

    @Test
    //@Transactional
    void b_read() {
        Address read = addressService.read(homeAddress.getAddressID());
        assertNotNull(read);
        System.out.println("Read " + read);
    }

    @Test
    //@Transactional
    void c_update() {
        Address updated = new Address.Builder().copy(homeAddress)
                .setStreetAddress("6 Basset Road")
                .build();
        assertNotNull(updated);
        System.out.println("Updated " + updated);
    }

    @Test
    @Disabled
    //@Transactional
    void e_delete() {
        boolean delete = addressService.delete(homeAddress.getAddressID());
        assertTrue(delete);
        System.out.println("Deleted " + delete);
    }

    @Test
    //@Transactional
    void d_getAll() {
        System.out.println("Show All");
        System.out.println(addressService.getAll());
    }
}