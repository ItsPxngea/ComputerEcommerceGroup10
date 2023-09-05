package za.ac.cput.controller;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import za.ac.cput.domain.*;
import za.ac.cput.factory.*;
import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.MethodName.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class StoreAddressControllerTest {
    private static final StoreDetails storeDetails = StoreDetailsFactory.buildStoreDetails("Walmart","29 Dean Street","0817629877","221094040@mycput.ac.za");

    private static final Country country = CountryFactory.createCountry("South Korea");

    private static final City city = CityFactory.createCity("Cairo",country);

    private static final Address address = AddressFactory.buildAddress("420 Road","7780",city);

    private static final StoreAddress storeAddress = StoreAddressFactory.build(address,storeDetails);

    @Autowired
    private TestRestTemplate restTemplate;

    private final String baseURL = "http://localhost:8080/storeaddress";
    @Test
    void a_create() {
        String url = baseURL + "/create";
        ResponseEntity<StoreAddress> postResponse = restTemplate
                .postForEntity(url, storeAddress, StoreAddress.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());

        StoreAddress savedStoreAddress = postResponse.getBody();
        System.out.println("Saved: "+ savedStoreAddress);

        Assertions.assertEquals(storeAddress.getStoreAddressID(), postResponse.getBody().getStoreAddressID());
    }

    @Test
    void b_read() {
        String url = baseURL + "/read/" + storeAddress.getStoreAddressID();
        System.out.println("Url: "+ url);
        ResponseEntity<StoreAddress> response = restTemplate.getForEntity(url, StoreAddress.class);
        assertEquals(storeAddress.getStoreAddressID(), response.getBody().getStoreAddressID());
        System.out.println(response.getBody());
    }

    @Test
    void c_update() {
        StoreAddress updated = new StoreAddress.Builder()
                .copy(storeAddress)
                .setAddress(AddressFactory.buildAddress("69 Street", "7780", city))
                .build();
        System.out.println(updated);
        String url = baseURL + "/update";
        System.out.println("URL: " + url);
        System.out.println("Post data: " + updated);
        ResponseEntity<StoreAddress> response = restTemplate.postForEntity(url, updated , StoreAddress.class);
        assertNotNull(response.getBody());
    }

    @Test
    @Disabled
    void e_delete() {
        String url = baseURL + "/delete/" + storeAddress.getStoreAddressID();
        System.out.println("URL: " + url);
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