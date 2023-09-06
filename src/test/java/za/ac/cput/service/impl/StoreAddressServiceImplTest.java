package za.ac.cput.service.impl;

/* StoreAddressServiceImplTest.java
Implementation test class for StoreAddressServiceImpl.java
Author: Michael Daniel Johnson 221094040
Date: 5 September 2023
*/

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.*;
import za.ac.cput.factory.*;
import za.ac.cput.repository.*;

import static org.junit.jupiter.api.Assertions.*;
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class StoreAddressServiceImplTest {
    private static final StoreDetails storeDetails = StoreDetailsFactory.buildStoreDetails("Walmart","29 Dean Street","0817629877","221094040@mycput.ac.za");

    private static final Country country = CountryFactory.createCountry("South Africa");

    private static final City city = CityFactory.createCity("Cairo",country);

    private static final Address address = AddressFactory.buildAddress("69 Road","7780",city);

    private static final StoreAddress storeAddress = StoreAddressFactory.build(address,storeDetails);

    @Autowired
    private StoreAddressServiceImpl storeAddressService;
    @Autowired
    private CityRepository cityRepository;
    @Autowired
    private CountryRepository countryRepository;
    @Autowired
    private AddressRepository addressRepository;
    @Autowired
    private StoreDetailsRepository storeDetailsRepository;

    @Order(1)
    @Test
    void create() {
        //Saving values to relevant tables
        cityRepository.save(city);
        countryRepository.save(country);
        addressRepository.save(address);
        storeDetailsRepository.save(storeDetails);

        StoreAddress created = storeAddressService.create(storeAddress);

        assertEquals(storeAddress.getStoreAddressID(), created.storeAddressID);
        System.out.println("Create: "+ created);
    }

    @Order(2)
    @Test
    void read() {
       StoreAddress read = storeAddressService.read(storeAddress.getStoreAddressID());
        assertNotNull(read);
        System.out.println("Read: "+read);
    }

    @Order(3)
    @Test
    @Disabled
    void update() {

        StoreDetails updated = new StoreDetails.Builder()
                .copy(storeDetails)
                .setStoreAddress("CPUT Admin Office")
                .setStoreName("Checkers")
                .build();

        City updatedCity = new City.Builder()
                .copy(city)
                .setCityName("Cape Town")
                .build();

        storeDetailsRepository.save(updated);
        cityRepository.save(updatedCity);

        assertNotNull(updatedCity);
        assertNotNull(updated);
        System.out.println("Updated: "+updated);
        System.out.println("Updated City: "+ updatedCity);
    }

    @Order(5)
    @Test
    @Disabled
    void delete() {
        boolean success = storeAddressService.delete(storeAddress.getStoreAddressID());
        assertTrue(success);
    }

    @Order(4)
    @Test
    void getAll() {
        System.out.println("Show All:");
        System.out.println(storeAddressService.getAll());
    }
}