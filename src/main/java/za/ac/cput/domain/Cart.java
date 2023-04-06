package za.ac.cput.domain;

/*
    POJO for the Cart
    Author: David Henriques Garrancho (221475982)
    Date: 20 March 2023
*/

import java.util.Objects;
public class Cart {
    private String cartID;
    public String customerID;
    public String productID;
    public String productName;
    public int productQuantity;
    public double productPrice;

    public Cart() {
    }

    public String getCartID() {
        return cartID;
    }

    public String getCustomerID() {
        return customerID;
    }

    public String getProductID() {
        return productID;
    }

    public String getProductName() {
        return productName;
    }

    public int getProductQuantity() {
        return productQuantity;
    }

    public double getProductPrice() {
        return productPrice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cart cart = (Cart) o;
        return Objects.equals(cartID, cart.cartID) && Objects.equals(customerID, cart.customerID) && Objects.equals(productID, cart.productID) && Objects.equals(productName, cart.productName) && Objects.equals(productQuantity, cart.productQuantity) && Objects.equals(productPrice, cart.productPrice);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cartID, customerID, productID, productName, productQuantity, productPrice);
    }

    @Override
    public String toString() {
        return "Cart{" +
                "cartID='" + cartID + '\'' +
                ", customerID='" + customerID + '\'' +
                ", productID='" + productID + '\'' +
                ", productName='" + productName + '\'' +
                ", productQuantity='" + productQuantity + '\'' +
                ", productPrice='" + productPrice + '\'' +
                '}';
    }

    private Cart(Cart.Builder b){
        this.cartID = b.cartID;
        this.customerID = b.customerID;
        this.productID = b.productID;
        this.productName = b.productName;
        this.productQuantity = b.productQuantity;
        this.productPrice = b.productPrice;
    }

    public static class Builder {
        private String cartID;
        public String customerID;
        public String productID;
        public String productName;
        public int productQuantity;
        public double productPrice;

        public Cart.Builder setCartID(String cartID){
            this.cartID = cartID;
            return this;
        }

        public Cart.Builder setCustomerID(String customerID){
            this.customerID = customerID;
            return this;
        }

        public Cart.Builder setProductID(String productID){
            this.productID = productID;
            return this;
        }

        public Cart.Builder setProductName(String productName){
            this.productName = productName;
            return this;
        }

        public Cart.Builder setProductQuantity(int productQuantity){
            this.productQuantity = productQuantity;
            return this;
        }

        public Cart.Builder setProductPrice(double productPrice){
            this.productPrice = productPrice;
            return this;
        }

        public Cart.Builder copy(Cart cart){
            this.cartID = cart.cartID;
            this.customerID = cart.customerID;
            this.productID = cart.productID;
            this.productName = cart.productName;
            this.productQuantity = cart.productQuantity;
            this.productPrice = cart.productPrice;
            return this;
        }

        public Cart build(){
            return new Cart(this);
        }
    }

}
