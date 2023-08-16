package za.ac.cput.service;

import za.ac.cput.domain.Customer;
import za.ac.cput.domain.Sales;

import java.util.List;

public interface SalesService extends IService<Sales, String>{
    List<Sales> getAll();
}
