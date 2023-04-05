package za.ac.cput.factory;

/* CartFactory.java
Factory for the Cart
Author: David Henriques Garrancho (221475982)
Date: 20 March 2023
*/

import za.ac.cput.domain.Cart;
import za.ac.cput.util.Helper;

import java.util.UUID;

public class CartFactory {

    public static Cart buildCart(String productName, int productQuantity, double productPrice){
        if(Helper.isNullOrEmpty(productName)){
            return null;
        }

        if(Helper.isInvalidInt(productQuantity)){
            return null;
        }

        if(Helper.isInvalidDouble(productPrice)){
            return null;
        }

        String cartID = Helper.generateID();

        String productID = "GPU1263";
        String customerID = Helper.generateCustomerID("George", "Armin");

        return new Cart.Builder().setCartID(cartID)
                .setProductID(productID)
                .setCustomerID(customerID)
                .setProductName(productName)
                .setProductQuantity(productQuantity)
                .setProductPrice(productPrice)
                .build();
    }
}
