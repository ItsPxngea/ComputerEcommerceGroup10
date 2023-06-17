package za.ac.cput.service;

import za.ac.cput.domain.Cart;

import java.util.List;

/*
    CartService.java
    Author: David Henriques Garrancho
    This is the Service for the service the Cart entity
    Date: 09 - 06 - 2023
 */

public interface CartService extends IService<Cart, String>{
    List<Cart> getAll();
}
