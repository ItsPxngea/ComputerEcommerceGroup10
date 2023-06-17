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
import za.ac.cput.domain.Cart;
import za.ac.cput.domain.Customer;
import za.ac.cput.domain.Product;
import za.ac.cput.factory.CartFactory;
import za.ac.cput.factory.CustomerFactory;
import za.ac.cput.factory.ProductFactory;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.MethodName.class)
@SpringBootTest(webEnvironment =  SpringBootTest.WebEnvironment.RANDOM_PORT)
class CartControllerTest {

    public static Product product = ProductFactory.buildProduct("GTX850", 4500.00);
    public static Customer customer = CustomerFactory.buildCustomer();
    private static Cart cart = CartFactory.buildCart(customer, product, 3);

    @Autowired
    private TestRestTemplate restTemplate;

    private final String baseURL = "http://localhost:8080/cart";

    @Test
    void a_create() {
        String url = baseURL + "/create";
        ResponseEntity<Cart> postResponse = restTemplate.postForEntity(url, cart, Cart.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
        //assertEquals(postResponse.getStatusCode(), HttpStatus.OK);
        Cart savedCart = postResponse.getBody();
        System.out.println("Saved data: " + savedCart);
        assertEquals(cart.getCartID(), postResponse.getBody().getCartID());
    }

    @Test
    void b_read() {
        String url = baseURL + "/read/" + cart.getCartID();
        System.out.println("URL: " + url);
        ResponseEntity<Cart> response = restTemplate.getForEntity(url, Cart.class);
        assertEquals(cart.getCartID(), response.getBody().getCartID());
        System.out.println(response.getBody());
    }
    @Test
    void c_update() {
        Cart updated = new Cart.Builder().copy(cart).setQuantity(5).build();
        String url = baseURL + "/update";
        System.out.println("URL: " + url);
        System.out.println("Post data: " + updated);
        ResponseEntity<Cart> response = restTemplate.postForEntity(url, updated, Cart.class);
        assertNotNull(response.getBody());
    }

    @Test
    @Disabled
    void e_delete() {
        String url = baseURL + "/delete/" + cart.getCartID();
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