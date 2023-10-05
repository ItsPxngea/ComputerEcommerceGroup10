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
import za.ac.cput.domain.Product;
import za.ac.cput.factory.ProductFactory;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@TestMethodOrder(MethodOrderer.MethodName.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ProductControllerTest {

    private static final Product product = ProductFactory.buildProduct("RTX 3060 TI", "Item", "Next Generation gaming with the RTX 4050", 4800.00, 4200.00, true);

    @Autowired
    private TestRestTemplate restTemplate;

    private final String baseURL = "http://localhost:8080/product";

    @Test
    void a_create() {
        String url = baseURL + "/create";
        ResponseEntity<Product> postResponse = restTemplate.postForEntity(url, product, Product.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
        //assertEquals(postResponse.getStatusCode(), HttpStatus.OK);
        Product savedProduct = postResponse.getBody();
        System.out.println("Saved data: " + savedProduct);
        assertEquals(savedProduct.getProductID(), postResponse.getBody().getProductID());
    }

    @Test
    void b_read() {
            String url = baseURL + "/read/" + product.getProductID();
            System.out.println("URL: " + url);
            ResponseEntity<Product> response = restTemplate.getForEntity(url, Product.class);
            assertEquals(product.getProductID(), response.getBody().getProductID());
            System.out.println(response.getBody());
    }
    @Test
    void c_update() {
            Product updated = new Product.Builder().copy(product).setStock(false).build();
            String url = baseURL + "/update";
            System.out.println("URL: " + url);
            System.out.println("Post data: " + updated);
            ResponseEntity<Product> response = restTemplate.postForEntity(url, updated, Product.class);
            assertNotNull(response.getBody());
    }

    @Test
    @Disabled
    void e_delete() {
        String url = baseURL + "/delete/" + product.getProductID();
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
