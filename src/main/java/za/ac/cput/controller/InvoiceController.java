package za.ac.cput.controller;
/* InvoiceController.java
Controller for Invoice
Author: David Henriques Garrancho (221475982)
Date: 18 August 2023
*/

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.Invoice;
import za.ac.cput.domain.Sales;
import za.ac.cput.service.InvoiceService;

import java.util.List;

@RestController
@RequestMapping("/invoiceController")
public class InvoiceController {

    @Autowired
    private InvoiceService invoiceService;

    @PostMapping("/create")
    public Invoice create(@RequestBody Invoice invoice){return invoiceService.create(invoice);}


    @GetMapping("/read/{id}")
    public Invoice read(@PathVariable String id){return invoiceService.read(id);}

    @PutMapping("/update/{id}")
    public Invoice update(@RequestBody Invoice invoice){return invoiceService.update(invoice);}

    @DeleteMapping("/delete/{id}")
    public boolean delete(@PathVariable String id){return invoiceService.delete(id);}

    @GetMapping("/getAll")
    public List<Invoice> getAll(){return invoiceService.getAll();}


}
