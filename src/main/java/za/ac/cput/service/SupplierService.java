package za.ac.cput.service;

/*
Ethan Botes - 220101299
This is the SupplierService interface
Date: 11 - 060 2023
 */

import org.springframework.stereotype.Service;
import za.ac.cput.domain.Supplier;

import java.util.List;
import java.util.Set;
@Service
public interface SupplierService extends IService<Supplier, String>{

    List<Supplier> getAll();


}
