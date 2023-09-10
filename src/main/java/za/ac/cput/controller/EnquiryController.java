package za.ac.cput.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.Enquiry;
import za.ac.cput.service.EnquiryService;

import java.util.List;

@RestController
@RequestMapping("/enquiry")
public class EnquiryController {

    @Autowired
    private EnquiryService enquiryService;

    @PostMapping("/create")
    public Enquiry create (@RequestBody Enquiry enquiry){
        return enquiryService.create(enquiry);
    }

    @GetMapping("/read/{id}")
    public Enquiry read(@PathVariable String id){
        return enquiryService.read(id);
    }

    @PutMapping("/update/{id}")
    public Enquiry update(@RequestBody Enquiry enquiry){
        return enquiryService.update(enquiry);
    }
    @DeleteMapping("/delete/{id}")
    public boolean delete(@PathVariable String id){
        return enquiryService.delete(id);
    }

    @GetMapping("/getAll")
    public List<Enquiry> getAll(){
        return enquiryService.getAll();
    }
}
