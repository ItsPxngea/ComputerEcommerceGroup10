package za.ac.cput.service;

/* SalesService.java
Service for the Sales
Author: David Henriques Garrancho (221475982)
Date: 16 August 2023
*/

import za.ac.cput.domain.Customer;
import za.ac.cput.domain.Sales;

import java.util.List;

public interface SalesService extends IService<Sales, Long>{
    List<Sales> getAll();
}
