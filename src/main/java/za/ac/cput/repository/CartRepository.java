package za.ac.cput.repository;

/*
    Author: David Henriques Garrancho (221475982)
    Interface for the Cart Repository
    Date: 20 March 2023
*/

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.Cart;

@Repository
public interface CartRepository extends JpaRepository<Cart, String> {
}
