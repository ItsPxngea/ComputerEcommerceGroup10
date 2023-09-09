package za.ac.cput.service.impl;

import jakarta.transaction.Transactional;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.*;
import za.ac.cput.factory.*;
import za.ac.cput.repository.*;
import za.ac.cput.service.CountryService;

import static org.junit.jupiter.api.Assertions.*;
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Transactional
class StoreAddressServiceImplTest {
    private static final StoreDetails storeDetails = StoreDetailsFactory.buildStoreDetails("Walmart","29 Dean Street","0817629877","221094040@mycput.ac.za");

    private static final Country country = CountryFactory.createCountry("South Africa");

    private static final City city = CityFactory.createCity("Cairo",country);

    private static final Address address = AddressFactory.buildAddress("69 Road","7780",city);

    private static final StoreAddress storeAddress = StoreAddressFactory.build(address,storeDetails);

    @Autowired
    private StoreAddressServiceImpl storeAddressService;
  /*  @Autowired
    private CityRepository cityRepository;
    @Autowired
    private CountryRepository countryRepository;
    @Autowired
    private AddressRepository addressRepository;
    @Autowired
    private StoreDetailsRepository storeDetailsRepository;

   */


    @Order(1)
    @Test
    @Transactional
    void create() {
        //save other private static finals to the database
        //StoreDetails
       /* cityRepository.save(city);
        countryRepository.save(country);
        addressRepository.save(address);
        storeDetailsRepository.save(storeDetails);

        */

        //StoreAddress created = storeAddressService.create(storeAddress);
        StoreAddress created = storeAddressService.create(storeAddress);
        System.out.println(storeAddress);
        assertEquals(storeAddress.getStoreAddressID(), created.storeAddressID);
        System.out.println("Create: "+ created);
    }

    @Order(2)
    @Test
    @Transactional
    void read() {
       StoreAddress read = storeAddressService.read(storeAddress.getStoreAddressID());
        System.out.println(read);
        System.out.println(storeAddress.getStoreAddressID());
        assertNotNull(storeAddress.getStoreAddressID());
        assertNotNull(read);
        System.out.println("Read: "+read);
    }

    @Order(3)
    @Test
    @Transactional
    void update() {
       /* StoreAddress updated = new StoreAddress.Builder().copy(storeAddress)
                .setStoreDetails((StoreDetailsFactory.buildStoreDetails("Checkers","29 Dean Street","0817629877","221094040@mycput.ac.za")))
                .build();

        */
        StoreDetails updated = new StoreDetails.Builder()
                .copy(storeDetails)
                .setStoreName("Checkers")
                .build();
        System.out.println(updated);
        assertNotNull(updated);
        System.out.println("Updated: "+updated);
    }

    @Order(5)
    @Test
    @Transactional
    @Disabled
    void delete() {
        boolean success = storeAddressService.delete(storeAddress.getStoreAddressID());
        assertTrue(success);
    }

    @Order(4)
    @Test
    @Transactional
    void getAll() {
        System.out.println("Show All:");
        System.out.println(storeAddressService.getAll());
    }
}