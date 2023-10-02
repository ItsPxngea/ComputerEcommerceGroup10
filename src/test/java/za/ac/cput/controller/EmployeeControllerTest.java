package za.ac.cput.controller;

/* CustomerControllerTest.java
Test for Controller for Employee
Author: David Henriques Garrancho (221475982)
Date: 17 June 2023
*/

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;
import za.ac.cput.domain.Employee;
import za.ac.cput.factory.CustomerFactory;
import za.ac.cput.factory.EmployeeFactory;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.MethodName.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class EmployeeControllerTest {

    private static final Employee employee = EmployeeFactory.buildEmployee(
            "Hanno",
            "Immleman",
            "HI@gmail.com",
            "Hello2023"
    );

    @Autowired
    private TestRestTemplate restTemplate;

    private final String baseURL = "http://localhost:8080/employee";

    @Test
    void a_create() {
        String url = baseURL + "/create";
        ResponseEntity<Employee> postResponse = restTemplate.postForEntity(url, employee, Employee.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
        //assertEquals(postResponse.getStatusCode(), HttpStatus.OK);
        Employee savedCustomer = postResponse.getBody();
        System.out.println("Saved data: " + savedCustomer);
        assertEquals(savedCustomer.getEmployeeID(), postResponse.getBody().getEmployeeID());
    }

    @Test
    void b_read() {
        String url = baseURL + "/read/" + employee.getEmployeeID();
        System.out.println("URL: " + url);
        ResponseEntity<Employee> response = restTemplate.getForEntity(url, Employee.class);
        assertEquals(employee.getEmployeeID(), response.getBody().getEmployeeID());
        System.out.println(response.getBody());
    }
    @Test
    void c_update() {
        Employee updated = new Employee.Builder()
                .copy(employee)
                .setFirstName("David")
                .setLastName("Smith")
                .setEmail("david@example.com")
                .build();

        String url = baseURL + "/update";
        System.out.println("URL: " + url);
        System.out.println("Post data: " + updated);

        ResponseEntity<Employee> response = restTemplate.postForEntity(url, updated, Employee.class);
        assertNotNull(response.getBody());
    }


    @Test
    void e_delete() {
        String url = baseURL + "/delete/" + employee.getEmployeeID();
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