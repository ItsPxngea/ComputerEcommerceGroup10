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
import za.ac.cput.dto.BearerToken;
import za.ac.cput.dto.LoginDto;
import za.ac.cput.dto.RegisterDto;
import za.ac.cput.jwt.JwtService;
import za.ac.cput.domain.User;
import za.ac.cput.domain.Role;
import za.ac.cput.domain.RoleName;
import za.ac.cput.repository.UserRepository;
import za.ac.cput.repository.RoleRepository;
import za.ac.cput.service.UserService;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository repository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private JwtService jwtService;

    private AuthenticationManager authenticationManager;

    @Override
    public User create(User user) {
        return this.repository.save(user);
    }

    @Override
    public User read(Long customerID) {
        return this.repository.findById(customerID).orElse(null);
    }

    @Override
    public User update(User user) {
        if (this.repository.existsById((user.getCustomerID())))
            return this.repository.save(user);
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
    public List<User> getAll() {
        return this.repository.findAll();
    }

    @Autowired
    private PasswordEncoder passwordEncoder;

    /*public Customer authenticate(String email, String password) {
        Customer user = repository.findByEmail(email);

        if (user != null && passwordEncoder.matches(password, user.getPassword())) {
            return user;
        }

        return null;
    }*/

    @Override
    public ResponseEntity<?> register(RegisterDto registerDto) {
        if(repository.existsByEmail(registerDto.getEmail()))
        { return  new ResponseEntity<>("email is already taken !", HttpStatus.SEE_OTHER); }
        else
        { User user = new User();
            user.setEmail(registerDto.getEmail());
            user.setFirstName(registerDto.getFirstName());
            user.setLastName(registerDto.getLastName());
            user.setPassword(passwordEncoder.encode(registerDto.getPassword()));
            //By Default , he/she is a simple user
            Role role = roleRepository.findByRoleName(RoleName.CUSTOMER);
            user.setRoles(Collections.singletonList(role));
            repository.save(user);
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
        User user = repository.findByEmail(authentication.getName()).orElseThrow(() -> new UsernameNotFoundException("User not found"));
        List<String> rolesNames = new ArrayList<>();
        user.getRole().forEach(r-> rolesNames.add(r.getRoleName().toString()));
        String token = jwtService.generateToken(user.getEmail(), rolesNames);
        return token;
    }

}

