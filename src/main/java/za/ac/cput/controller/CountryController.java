package za.ac.cput.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.Country;
import za.ac.cput.service.CountryService;

import java.util.List;

@RestController
@RequestMapping("/country")
public class CountryController {

    @Autowired
    private CountryService countryService;

    @PostMapping("/create")
    public Country create(@RequestBody Country country){return countryService.create(country);}

    @GetMapping("/read/{id}")
    public Country read(@PathVariable String id){return countryService.read(id);}

    @PutMapping("/update/{id}")
    public Country update(@RequestBody Country country){return countryService.update(country);}

    @DeleteMapping("/delete/{id}")
    public boolean delete(@PathVariable String id){return countryService.delete(id);}

    @GetMapping("/getAll")
    public List<Country> getAll(){return countryService.getAll();}


}