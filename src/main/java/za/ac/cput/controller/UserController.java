package za.ac.cput.controller;

/* CustomerController.java
Controller for Customer
Author: David Henriques Garrancho (221475982)
Date: 17 June 2023
*/

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.dto.LoginDto;
import za.ac.cput.dto.RegisterDto;
import za.ac.cput.domain.User;
import za.ac.cput.service.UserService;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/create")
    public User create(@RequestBody User customer) {
        return userService.create(customer);
    }

    @GetMapping("/read/{id}")
    public User read(@PathVariable Long id) {
        return userService.read(id);
    }

    @PutMapping("/update")
    public User update(@RequestBody User customer) {
        return userService.update(customer);
    }

    @DeleteMapping("/delete/{id}")
    public boolean delete(@PathVariable Long id) {
        return userService.delete(id);
    }

    @GetMapping("/getAll")
    public List<User> getAll() {
        return userService.getAll();
    }

    @PostMapping("/register")
    public ResponseEntity<?> register (@RequestBody RegisterDto registerDto)
    { return  userService.register(registerDto);}

    @PostMapping("/authenticate")
    public String authenticate(@RequestBody LoginDto loginDto)
    { return  userService.authenticate(loginDto);}

}
