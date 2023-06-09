package za.ac.cput.service.impl;

import za.ac.cput.domain.Cart;
import za.ac.cput.repository.CartRepository;
import za.ac.cput.service.CartService;

import java.util.Set;

public class CartServiceImpl implements CartService {

    private static CartServiceImpl service = null;
    private CartRepository repository = null;

    private CartServiceImpl(){
        if(repository == null) {
            repository =  CartRepository.getRepository();
        }
    }

    public static CartServiceImpl getService(){
        if(service == null){
            service = new CartServiceImpl();
        }
        return service;
    }

    @Override
    public Cart create(Cart cart) {
        Cart readCart = repository.create(cart);
        return readCart;
    }

    @Override
    public Cart read(Cart id) {
        Cart read = repository.read(id.getCartID());
        return read;
    }

    @Override
    public Cart update(Cart cartID) {
        Cart cartUpdated = repository.update(cartID);
        return cartUpdated;
    }

    @Override
    public boolean delete(Cart cartID) {
        return repository.delete(cartID.getCartID());
    }
    @Override
    public Set<Cart> getAll() {
        return repository.getAll();
    }
}
