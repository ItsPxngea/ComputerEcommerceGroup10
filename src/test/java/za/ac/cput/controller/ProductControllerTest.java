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

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@TestMethodOrder(MethodOrderer.MethodName.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ProductControllerTest {

    private static final List<Product> products = Arrays.asList(
            ProductFactory.buildProduct("RTX 3060 TI", "Item", "Next Generation gaming with the RTX 4050", 4800.00),
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
            4560.00,
            customer
    );

    private static final SalesItem salesItem = SalesItemFactory.buildSales(sales, products, 2, 1200);

    @Autowired
    private TestRestTemplate restTemplate;

    private final String baseURL = "http://localhost:8080/product";

    @Test
    void a_create() {
        for (Product product : products) {
            String url = baseURL + "/create";
            ResponseEntity<Product> postResponse = restTemplate.postForEntity(url, product, Product.class);
            assertNotNull(postResponse);
            assertNotNull(postResponse.getBody());
            //assertEquals(postResponse.getStatusCode(), HttpStatus.OK);
            Product savedProduct = postResponse.getBody();
            System.out.println("Saved data: " + savedProduct);
            assertEquals(product.getProductID(), postResponse.getBody().getProductID());
        }
    }

    @Test
    void b_read() {
        for (Product product : products) {
            String url = baseURL + "/read/" + product.getProductID();
            System.out.println("URL: " + url);
            ResponseEntity<Product> response = restTemplate.getForEntity(url, Product.class);
            assertEquals(product.getProductID(), response.getBody().getProductID());
            System.out.println(response.getBody());
        }
    }
    @Test
    void c_update() {
        for (Product product : products) {
            Product updated = new Product.Builder().copy(product).setProductName("Evga RTX 3060 Ti").build();
            String url = baseURL + "/update";
            System.out.println("URL: " + url);
            System.out.println("Post data: " + updated);
            ResponseEntity<Product> response = restTemplate.postForEntity(url, updated, Product.class);
            assertNotNull(response.getBody());
        }
    }

    @Test
    @Disabled
    void e_delete() {
        for (Product product : products) {
            String url = baseURL + "/delete/" + product.getProductID();
            System.out.println("URL: " + url);
            restTemplate.delete(url);
        }
    }

    @Test
    void d_getAll() {
        for (Product product : products) {
            String url = baseURL + "/getAll";
            HttpHeaders headers = new HttpHeaders();
            HttpEntity<String> entity = new HttpEntity<>(null, headers);
            ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);
            System.out.println("Show ALL:");
            System.out.println(response);
            System.out.println(response.getBody());
        }
    }
}
