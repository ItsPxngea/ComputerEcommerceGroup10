package za.ac.cput.service.impl;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.Employee;
import za.ac.cput.factory.EmployeeFactory;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class EmployeeServiceImplTest {

    @Autowired
    private EmployeeServiceImpl service;

    private static final Employee employee = EmployeeFactory.buildEmployee(
            "T",
            "T",
            "T@gmail.com",
            "T"
    );

    @Test
    @Order(1)
    void create() {
        Employee created = service.create(employee);
        System.out.println("Created " + created);
    }

    @Test
    @Order(2)
    void read() {
        Employee read = service.read(employee.getEmployeeID());
        assertNotNull(read);
        System.out.println("Read: "+ read);
    }

    @Test
    @Order(3)
    void update() {
        Employee updated = new Employee.Builder().copy(employee).setLastName("Gary").build();
        assertNotNull(updated);
        System.out.println("Updated: " + updated);
    }

    @Test
    @Disabled
    void delete() {
        boolean success = service.delete(employee.getEmployeeID());
        assertTrue(success);
        System.out.println("Deleted -> " + success);
    }

    @Test
    @Order(4)
    void d_getAll() {
        System.out.println("Show All:");
        System.out.println(service.getAll());
    }
}