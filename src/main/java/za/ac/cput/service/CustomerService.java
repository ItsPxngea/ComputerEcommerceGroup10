package za.ac.cput.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.ResponseEntity;
import za.ac.cput.config.dto.LoginDto;
import za.ac.cput.config.dto.RegisterDto;
import za.ac.cput.domain.Customer;
import za.ac.cput.domain.Role;

import java.util.List;

/*
    CustomerService.java
    Author: David Henriques Garrancho
    This is the Service for the service the Customer entity
    Date: 09 - 06 - 2023
 */

public interface CustomerService extends IService<Customer, Long> {
    List<Customer> getAll();

    String authenticate(LoginDto loginDto);

    ResponseEntity<?> register (RegisterDto registerDto);
    Role saveRole(Role role);
}
