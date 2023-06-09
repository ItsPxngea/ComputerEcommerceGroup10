package za.ac.cput.service;

import za.ac.cput.domain.Cart;
import za.ac.cput.domain.Customer;

import java.util.Set;

public interface CartService extends IService<Cart, String>{
    Set<Cart> getAll();
}
