package za.ac.cput.interfaces;

import za.ac.cput.domain.Cart;

import java.util.Set;

public interface iCartRepository {
    public Set<Cart> getAll();
}
