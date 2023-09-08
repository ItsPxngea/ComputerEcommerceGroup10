package za.ac.cput.controller;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import za.ac.cput.domain.*;
import za.ac.cput.factory.*;
import za.ac.cput.repository.SupplierRepository;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.MethodName.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class SupplierAddressControllerTest {
    private static final Supplier supplier = SupplierFactory.buildSupplier("supplier@intel.com",
            "0214564389", "5 Alvin Road, Woodstock",
            "Intel");

    private static final Country country = CountryFactory.createCountry("South Africa");

    private static final City city = CityFactory.createCity("Cairo",country);

    private static final Address address = AddressFactory.buildAddress("69 Road","7780",city);

    private static final SupplierAddress supplierAddress = SupplierAddressFactory.build(address,supplier);

    @Autowired
    private SupplierRepository supplierRepository;

    @Autowired
    private TestRestTemplate restTemplate;

    private final String baseURL = "http://localhost:8080/supplieraddress";
    @Test
    void a_create() {
        String url = baseURL + "/create";
        ResponseEntity<SupplierAddress> postResponse = restTemplate
                .postForEntity(url, supplierAddress,SupplierAddress.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());

        SupplierAddress savedSupplierAddress = postResponse.getBody();
        System.out.println("Saved: "+savedSupplierAddress);
        assertEquals(supplierAddress.getSupplierAddressID(), postResponse.getBody().getSupplierAddressID());
    }

    @Test
    void b_read() {
        String url = baseURL + "/read/" + supplierAddress.getSupplierAddressID();
        System.out.println("Url: "+url);
        ResponseEntity<SupplierAddress> response = restTemplate.getForEntity(url, SupplierAddress.class);
        assertEquals(supplierAddress.getSupplierAddressID(), response.getBody().getSupplierAddressID());
        System.out.println(response.getBody());
    }

    @Test
    void c_update() {
        Supplier updated = new Supplier.Builder()
                .copy(supplier)
                .setSupplierCompanyName("GForce")
                .build();
        supplierRepository.save(updated);
        String url = baseURL + "/update";
        ResponseEntity<SupplierAddress> response = restTemplate.postForEntity(url,updated, SupplierAddress.class);
        assertNotNull(response.getBody());
        System.out.println("Post Data: "+ updated);
    }

    @Test
    @Disabled
    void e_delete() {
        String url = baseURL + "/delete/" + supplierAddress.getSupplierAddressID();
        restTemplate.delete(url);
    }

    @Test
    void d_getAll() {
        String url = baseURL + "/getAll";
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<>(null, headers);
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);
        System.out.println("Show ALL:");
        System.out.println(response);
        System.out.println(response.getBody());
    }
}