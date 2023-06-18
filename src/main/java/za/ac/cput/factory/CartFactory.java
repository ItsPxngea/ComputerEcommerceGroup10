package za.ac.cput.factory;

/*
    CartFactory.java
    Factory for the Cart
    Author: David Henriques Garrancho (221475982)
    Date: 20 March 2023
*/

import za.ac.cput.domain.Cart;
import za.ac.cput.domain.Customer;
import za.ac.cput.domain.Product;
import za.ac.cput.util.Helper;


public class CartFactory {

    public static Cart buildCart(Customer customer, Product product, int Quantity){

        if(Helper.isInvalidInt(Quantity)){
            return null;
        }

        String cartID = Helper.generateID();

        return new Cart.Builder().setCartID(cartID)
                .setCustomer(customer)
                .setProduct(product)
                .setQuantity(Quantity)
                .build();
    }
}
