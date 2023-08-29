package za.ac.cput.controller;

import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import za.ac.cput.domain.Supplier;
import za.ac.cput.factory.SupplierFactory;

import static org.junit.jupiter.api.Assertions.*;


@TestMethodOrder(MethodOrderer.MethodName.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class SupplierControllerTest {

    private static Supplier supplier = SupplierFactory.buildSupplier(
            "intel@intelqueries.com",
            "0213459876",
            "21 Rodes Street, Woodstock",
            "Intel"
    );

    @Autowired
    private TestRestTemplate restTemplate;

    private final String baseURL = "http://localhost:8080/supplier";

    @Test
    @Transactional
    @Order(1)
    void create() {
        String url = baseURL + "/create";
        ResponseEntity<Supplier> postResponse = restTemplate.postForEntity(url, supplier, Supplier.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
        Supplier savedSupplier = postResponse.getBody();
        System.out.println("Saved data: " + savedSupplier);
        assertEquals(supplier.getSupplierID(), postResponse.getBody().getSupplierID());



    }

    @Order(2)
    @Transactional
    @Test
    void read() {
        String url = baseURL + "/read/" + supplier.getSupplierID();
        System.out.println("URL: " + url);
        ResponseEntity<Supplier> response = restTemplate.getForEntity(url, Supplier.class);
        assertEquals(supplier.getSupplierID(), response.getBody().getSupplierID());
        System.out.println(response.getBody());
    }

    @Test
    @Transactional
    @Order(3)
    void update() {
        Supplier updated = new Supplier.Builder().copy(supplier).setSupplierTel("0215003434").build();
        String url = baseURL + "/update";
        System.out.println("URL: " + url);
        System.out.println("Post data: " + updated);
        ResponseEntity<Supplier> response = restTemplate.postForEntity(url, updated, Supplier.class);
        assertNotNull(response.getBody());
    }


    @Test
    @Transactional
    @Order(5)
    @Disabled
    void delete(){
    String url = baseURL + "/delete/" + supplier.getSupplierID();
        System.out.println("URL: " + url);
        restTemplate.delete(url);
}

    @Test
    @Transactional
    @Order(4)
    void getAll() {
        String url = baseURL + "/getAll";
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<>(null, headers);
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);
        System.out.println("Show ALL:");
        System.out.println(response);
        System.out.println(response.getBody());
    }
}