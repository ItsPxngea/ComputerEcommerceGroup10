package za.ac.cput.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.SupplierAddress;
import za.ac.cput.service.SupplierAddressService;

import java.util.List;

@RestController
@RequestMapping("/supplieraddress")
public class SupplierAddressController {

    @Autowired
    private SupplierAddressService supplierAddressService;

    @PostMapping("/create")
    public SupplierAddress create(@RequestBody SupplierAddress supplierAddress) {
        return supplierAddressService.create(supplierAddress);
    }

    @GetMapping("/read/{id}")
    public SupplierAddress read(@PathVariable String id) {
        return supplierAddressService.read(id);
    }


    @PostMapping("/update")
    public SupplierAddress update(@RequestBody SupplierAddress supplierAddress){
        return supplierAddressService.update(supplierAddress);
    }

    @DeleteMapping("/delete/{id}")
    public boolean delete(@PathVariable String id){
        return supplierAddressService.delete(id);
    }
    @GetMapping("/getAll")
    public List<SupplierAddress> getAll(){return supplierAddressService.getAll();}

}