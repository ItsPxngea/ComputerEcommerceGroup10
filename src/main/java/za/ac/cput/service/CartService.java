package za.ac.cput.service;

import za.ac.cput.domain.Cart;
import za.ac.cput.domain.Customer;

import java.util.Set;

/*
    CartService.java
    Author: David Henriques Garrancho
    This is the Service for the service the Cart entity
    Date: 09 - 06 - 2023
 */

public interface CartService extends IService<Cart, String>{
    Set<Cart> getAll();
}
