package za.ac.cput.repository;

/*
    Author: David Henriques Garrancho (221475982)
    Repository for the Cart
    Date: 20 March 2023
*/

import za.ac.cput.domain.Cart;
import java.util.*;

public class CartRepository implements iCartRepository {

    private Set<Cart> cartDB = null;
    private static CartRepository repository = null;
    private CartRepository(){
        cartDB = new HashSet<Cart>();
    }

    public static CartRepository getRepository(){
        if(repository == null){
            repository = new CartRepository();
        }
        return repository;
    }

    public Cart create(Cart cart) {
        boolean success = cartDB.add(cart);
        if(!success) {
            return null;
        }
        return cart;
    }

    public Cart read(String cartID) {
        Cart c = cartDB.stream()
                .filter(e -> e.getCartID().equals(cartID))
                .findAny()
                .orElse(null);
        return c;
    }

    public Cart update(Cart cart) {
        Cart oldCart = read(cart.getCartID());
        if(oldCart != null){
            cartDB.remove(oldCart);
            cartDB.add(cart);
            return cart;
        }
        return null;
    }

    public boolean delete(String cartID) {
        Cart cartToDelete = read(cartID);
        if(cartToDelete == null){
            return false;
        }
        cartDB.remove(cartToDelete);
        return true;
    }

    @Override
    public Set<Cart> getAll() {
        return cartDB;
    }
}
