package za.ac.cput.repository;

/*
    Author: David Henriques Garrancho (221475982)
    Interface for the Cart Repository
    Date: 20 March 2023
*/

import za.ac.cput.domain.Cart;

import java.util.Set;

public interface iCartRepository {
    public Set<Cart> getAll();
}
