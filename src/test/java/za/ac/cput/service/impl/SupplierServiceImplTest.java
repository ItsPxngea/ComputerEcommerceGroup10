package za.ac.cput.service.impl;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.Address;
import za.ac.cput.domain.City;
import za.ac.cput.domain.Country;
import za.ac.cput.domain.Supplier;
import za.ac.cput.factory.AddressFactory;
import za.ac.cput.factory.CityFactory;
import za.ac.cput.factory.CountryFactory;
import za.ac.cput.factory.SupplierFactory;

import static org.junit.jupiter.api.Assertions.*;




    /*
        Author: Ethan Botes - 220101299
        This is the test class for SupplierServiceImpl
        Date: 11 - 06 - 2023
    */


@TestMethodOrder(MethodOrderer.MethodName.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class SupplierServiceImplTest {

    @Autowired
    private SupplierServiceImpl service;

    private final static Country southAfrica = CountryFactory.createCountry(
            "South Africa"
    );
    private final static City homeCity = CityFactory.createCity(
            "Cape Town",
            southAfrica
    );
    private final static Address homeAddress = AddressFactory.buildAddress(
            "53 Main Road",
            "6045",
            homeCity
    );

    private final static Supplier supplier = SupplierFactory.buildSupplier
            ("supplier@intel.com",
                    "0214564389",
                    homeAddress,
                    "Intel");

    @Test
    @Order(1)
    void a_create() {
        Supplier created = service.create(supplier);
        assertEquals(supplier.getSupplierID(), created.getSupplierID());
        System.out.println("Create: " + created);
    }

    @Test
    @Order(2)
    void b_read() {
        Supplier read = service.read(supplier.getSupplierID());
        assertNotNull(read);
        System.out.println("Read: " + read);
    }

    @Test
    @Order(3)
    void c_update(){
        Supplier updated = new Supplier.Builder().copy(supplier)
                .setSupplierTel("0217509999")
                .build();
        assertNotNull(service.update(updated));
        System.out.println("Updated: " + updated);
    }

    @Test
    @Disabled
    void e_delete(){
        boolean success = service.delete(supplier.getSupplierID());
        assertTrue(success);
        System.out.println("Deleted: " + success);
    }

    @Test
    @Order(4)
    void d_getAll(){
        System.out.println("Show all: " + service.getAll());
    }



}