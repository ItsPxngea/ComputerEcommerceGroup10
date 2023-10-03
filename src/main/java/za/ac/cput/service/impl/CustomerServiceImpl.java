package za.ac.cput.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import za.ac.cput.config.dto.BearerToken;
import za.ac.cput.config.dto.LoginDto;
import za.ac.cput.config.dto.RegisterDto;
import za.ac.cput.config.jwt.JwtService;
import za.ac.cput.domain.Customer;
import za.ac.cput.domain.Role;
import za.ac.cput.domain.RoleName;
import za.ac.cput.repository.CustomerRepository;
import za.ac.cput.repository.RoleRepository;
import za.ac.cput.service.CustomerService;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository repository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private JwtService jwtService;

    private AuthenticationManager authenticationManager;

    @Override
    public Customer create(Customer customer) {
        return this.repository.save(customer);
    }

    @Override
    public Customer read(Long customerID) {
        return this.repository.findById(customerID).orElse(null);
    }

    @Override
    public Customer update(Customer customer) {
        if (this.repository.existsById((customer.getCustomerID())))
            return this.repository.save(customer);
        return null;
    }

    @Override
    public boolean delete(Long customerID) {
        if (this.repository.existsById(customerID)) {
            this.repository.deleteById(customerID);
            return true;
        }
        return false;
    }

    @Override
    public List<Customer> getAll() {
        return this.repository.findAll();
    }

    @Autowired
    private PasswordEncoder passwordEncoder;

    /*public Customer authenticate(String email, String password) {
        Customer customer = repository.findByEmail(email);

        if (customer != null && passwordEncoder.matches(password, customer.getPassword())) {
            return customer;
        }

        return null;
    }*/

    @Override
    public ResponseEntity<?> register(RegisterDto registerDto) {
        if(repository.existsByEmail(registerDto.getEmail()))
        { return  new ResponseEntity<>("email is already taken !", HttpStatus.SEE_OTHER); }
        else
        { Customer customer = new Customer();
            customer.setEmail(registerDto.getEmail());
            customer.setFirstName(registerDto.getFirstName());
            customer.setLastName(registerDto.getLastName());
            customer.setPassword(passwordEncoder.encode(registerDto.getPassword()));
            //By Default , he/she is a simple user
            Role role = roleRepository.findByRoleName(RoleName.CUSTOMER);
            customer.setRoles(Collections.singletonList(role));
            repository.save(customer);
            String token = jwtService.generateToken(registerDto.getEmail(),Collections.singletonList(role.getRoleName()));
            return new ResponseEntity<>(new BearerToken(token , "Bearer "),HttpStatus.OK);

        }
    }

    @Override
    public Role saveRole(Role role) {
        return roleRepository.save(role);
    }

    @Override
    public String authenticate(LoginDto loginDto) {
        Authentication authentication= authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginDto.getEmail(),
                        loginDto.getPassword()
                )
        );
        SecurityContextHolder.getContext().setAuthentication(authentication);
        Customer customer = repository.findByEmail(authentication.getName());
        List<String> rolesNames = new ArrayList<>();
        customer.getRole().forEach(r-> rolesNames.add(r.getRoleName().toString()));
        String token = jwtService.generateToken(customer.getEmail(), rolesNames);
        return token;
    }

}

