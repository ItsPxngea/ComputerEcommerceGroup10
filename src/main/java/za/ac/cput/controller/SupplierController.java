package za.ac.cput.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.Supplier;
import za.ac.cput.service.SupplierService;

import java.util.List;

@RestController
@RequestMapping("/supplier")
public class SupplierController {

    @Autowired
    private SupplierService supplierService;


    @PostMapping("/create")
    public Supplier create(@RequestBody Supplier supplier) {
        return supplierService.create(supplier);
    }


    @GetMapping("/read/{id}")
    public Supplier read(@PathVariable String id) {
        return supplierService.read(id);
    }


    @PutMapping("/update/{id}")
    public Supplier update(@RequestBody Supplier supplier) {
        return supplierService.update(supplier);
    }


    @DeleteMapping("/delete/{id}")
    public boolean delete(@PathVariable String id) {
        return supplierService.delete(id);
    }


    @GetMapping("/getAll")
    public List<Supplier> getAll() {
        return supplierService.getAll();
    }
}
