package za.ac.cput.service.impl;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.*;
import za.ac.cput.factory.*;
import za.ac.cput.repository.AddressRepository;
import za.ac.cput.repository.CityRepository;
import za.ac.cput.repository.CountryRepository;
import za.ac.cput.repository.SupplierRepository;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class SupplierAddressServiceImplTest {

    private static final Supplier supplier = SupplierFactory.buildSupplier("supplier@intel.com",
            "0214564389", "5 Alvin Road, Woodstock",
            "Intel");

    private static final Country country = CountryFactory.createCountry("South Africa");

    private static final City city = CityFactory.createCity("Cairo",country);

    private static final Address address = AddressFactory.buildAddress("69 Road","7780",city);

   private static final SupplierAddress supplierAddress = SupplierAddressFactory.build(address,supplier);


    @Autowired
    private SupplierAddressServiceImpl supplierAddressService;
    @Autowired
    private SupplierRepository supplierRepository;
    @Autowired
    private CityRepository cityRepository;
    @Autowired
    private CountryRepository countryRepository;
    @Autowired
    private AddressRepository addressRepository;


    @Order(1)
    @Test
    void create() {
        cityRepository.save(city);
        countryRepository.save(country);
        addressRepository.save(address);
        supplierRepository.save(supplier);

        SupplierAddress created = supplierAddressService.create(supplierAddress);

        assertEquals(supplierAddress.getSupplierAddressID(),created.getSupplierAddressID());
        System.out.println("Create: "+ created);
    }

    @Order(2)
    @Test
    void read() {
        SupplierAddress read = supplierAddressService.read(supplierAddress.getSupplierAddressID());
        assertNotNull(read);
        System.out.println("Read: "+read);
    }

    @Order(3)
    @Test
    @Disabled
    void update() {
        Supplier updated = new Supplier.Builder()
                .copy(supplier)
                .setSupplierCompanyName("GForce")
                .build();

        supplierRepository.save(updated);
        assertNotNull(updated);
        System.out.println("Updated: "+updated);

    }

    @Order(5)
    @Test
    @Disabled
    void delete() {
        boolean success = supplierAddressService.delete(supplier.getSupplierID());
        assertTrue(success);
    }

    @Order(4)
    @Test
    void getAll() {
        System.out.println("Show All:");
        System.out.println(supplierAddressService.getAll());
    }
}