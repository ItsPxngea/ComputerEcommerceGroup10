package za.ac.cput.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.SalesItem;
import za.ac.cput.service.SalesItemService;

import java.util.List;

@RestController
@RequestMapping("/salesItem")
public class SalesItemController {
    @Autowired
    private SalesItemService salesItemService;

    @PostMapping("/create")
    public SalesItem create(@RequestBody SalesItem salesItem) {
        return salesItemService.create(salesItem);
    }

    @GetMapping("/read/{id}")
    public SalesItem read(@PathVariable String id) {
        return salesItemService.read(id);
    }

    @PutMapping("/update")
    public SalesItem update(@RequestBody SalesItem salesItem) {
        return salesItemService.update(salesItem);
    }

    @DeleteMapping("/delete/{id}")
    public boolean delete(@PathVariable String id) {
        return salesItemService.delete(id);
    }

    @GetMapping("/getAll")
    public List<SalesItem> getAll() {
        return salesItemService.getAll();
    }
}

