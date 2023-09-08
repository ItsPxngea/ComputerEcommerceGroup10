/*package za.ac.cput.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.StoreAddress;
import za.ac.cput.service.StoreAddressService;

import java.util.List;

@RestController
@RequestMapping("/storeaddress")
public class StoreAddressController {

    @Autowired
    private StoreAddressService storeAddressService;

    @PostMapping("/create")
    public StoreAddress create(@RequestBody StoreAddress storeAddress) {
        return storeAddressService.create(storeAddress);
    }

    @GetMapping("/read/{id}")
    public StoreAddress read(@PathVariable String id) {
        return storeAddressService.read(id);
    }

    @PutMapping("/update")
    public StoreAddress update(@RequestBody StoreAddress storeAddress) {
        return storeAddressService.update(storeAddress);
    }

    @DeleteMapping("/delete/{id}")
    public boolean delete(@PathVariable String id) {
        return storeAddressService.delete(id);
    }

    @GetMapping("/getAll")
    public List<StoreAddress> getAll() {
        return storeAddressService.getAll();
    }

}
*/