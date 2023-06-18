package za.ac.cput.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.Cart;
import za.ac.cput.repository.CartRepository;
import za.ac.cput.service.CartService;

import java.util.List;

/*
    CartServiceImpl.java
    Author: David Henriques Garrancho 221475982
    This is the implementation for the service CartService.java
    Date: 09 - 06 - 2023
 */

@Service
public class CartServiceImpl implements CartService {

    private CartRepository repository;

    @Autowired
    private CartServiceImpl(CartRepository repository){
        this.repository = repository;
    }

    @Override
    public Cart create(Cart cart) {
        return this.repository.save(cart);
    }

    @Override
    public Cart read(String CartID) {
        return this.repository.findById(CartID).orElse(null);
    }

    @Override
    public Cart update(Cart cart) {
        if(this.repository.existsById(cart.getCartID()))
            return this.repository.save(cart);
        return null;
    }

    @Override
    public boolean delete(String CartID) {
        if (this.repository.existsById(CartID)){
            this.repository.deleteById(CartID);
            return  true;
        }
        return false;
    }

    @Override
    public List<Cart> getAll() {
        return this.repository.findAll();
    }
}
