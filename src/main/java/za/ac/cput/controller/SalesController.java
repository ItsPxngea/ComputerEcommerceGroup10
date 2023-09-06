package za.ac.cput.controller;

/* SalesController.java
Controller for Sales
Author: David Henriques Garrancho (221475982)
Date: 16 August 2023
*/

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.Sales;
import za.ac.cput.service.SalesService;

import java.util.List;

@RestController
@RequestMapping("/sales")
public class SalesController {
    
    @Autowired
    private SalesService salesService;
    
    @PostMapping("/create")
    public Sales create(@RequestBody Sales sales) {
        return salesService.create(sales);
    }

    @GetMapping("/read/{id}")
    public Sales read(@PathVariable String id) {
        return salesService.read(id);
    }

    @PutMapping("/update")
    public Sales update(@RequestBody Sales sales) {
        return salesService.update(sales);
    }

    @DeleteMapping("/delete/{id}")
    public boolean delete(@PathVariable String id) {
        return salesService.delete(id);
    }

    @GetMapping("/getAll")
    public List<Sales> getAll() {
        return salesService.getAll();
    }
}
