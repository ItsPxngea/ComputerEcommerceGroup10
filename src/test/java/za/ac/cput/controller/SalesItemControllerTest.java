package za.ac.cput.controller;

import jakarta.transaction.Transactional;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import za.ac.cput.domain.Customer;
import za.ac.cput.domain.Product;
import za.ac.cput.domain.Sales;
import za.ac.cput.domain.SalesItem;
import za.ac.cput.factory.CustomerFactory;
import za.ac.cput.factory.ProductFactory;
import za.ac.cput.factory.SalesFactory;
import za.ac.cput.factory.SalesItemFactory;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class SalesItemControllerTest {

    private static final List<Product> products = Arrays.asList(
            ProductFactory.buildProduct("FX 3060", "Item", "Next Generation gaming with the RTX 3060 TI", 3000.00),
            ProductFactory.buildProduct("FX 950", "Item", "Next Generation gaming with the RTX 950", 4000.00),
            ProductFactory.buildProduct("RX 4050", "Item", "Next Generation gaming with the RTX 4050", 4800.00)
    );

    private static final Customer customer = CustomerFactory.buildTestCustomer(
            "Test2456",
            "Luke",
            "Ben",
            "LW@gmail.com",
            "wufh%2465"
    );


    private static final Sales sales = SalesFactory.buildSales(
            "16-08-2023",
            11800.00,
            customer
    );

    private static final SalesItem salesItem = SalesItemFactory.buildSales(sales, products, products.size(), 1200);

    @Autowired
    private TestRestTemplate restTemplate;

    private final String baseURL = "http://localhost:8080/salesItem";

    @Order(1)
    @Test
    @Transactional
    void create() {
        String url = baseURL + "/create";
        ResponseEntity<SalesItem> postResponse = restTemplate.postForEntity(url, salesItem, SalesItem.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());

        SalesItem savedSales = postResponse.getBody();
        System.out.println("Saved data: " + savedSales);

        assertEquals(salesItem.getSalesItemID(), postResponse.getBody().getSalesItemID());
    }

    @Order(2)
    @Test
    @Transactional
    void read() {
        String url = baseURL + "/read/" + salesItem.getSalesItemID();
        System.out.println("URL: " + url);
        ResponseEntity<SalesItem> response = restTemplate.getForEntity(url, SalesItem.class);
        assertEquals(salesItem.getSalesItemID(), response.getBody().getSalesItemID());
        System.out.println(response.getBody());
    }

    @Order(3)
    @Test
    @Transactional
    void update() {
        SalesItem updated = new SalesItem.Builder().copy(salesItem).setItemPrice(3560.00).build();
        String url = baseURL + "/update";
        System.out.println("URL: " + url);
        System.out.println("Post data: " + updated);
        ResponseEntity<SalesItem> response = restTemplate.postForEntity(url, updated, SalesItem.class);
        assertNotNull(response.getBody());
    }

    @Order(5)
    @Test
    @Transactional
    @Disabled
    void delete() {
        String url = baseURL + "/delete/" + salesItem.getSalesItemID();
        System.out.println("URL: " + url);
        restTemplate.delete(url);
    }

    @Order(4)
    @Test
    @Transactional
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