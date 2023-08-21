/*
package za.ac.cput.domain;


    POJO for the Cart
    Author: David Henriques Garrancho (221475982)
    Date: 20 March 2023



import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Objects;

@Entity
public class Cart implements Serializable {

    @Id
    @GeneratedValue
    private String cartID;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride( name = "productID", column = @Column(name = "customer_customerid")),
    })
    @OneToOne(cascade = CascadeType.ALL, targetEntity = Customer.class)
    private Customer customer;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride( name = "productName", column = @Column(name = "product_product_name")),
            @AttributeOverride( name = "productPrice", column = @Column(name = "product_product_price")),
    })
    @ManyToOne(cascade = CascadeType.ALL, targetEntity = Product.class)
    public Product;

    public int Quantity;

    public Cart(String cartID) {
        super();
        this.cartID = cartID;
    }

    public Cart() {

    }

    public String getCartID() {
        return cartID;
    }

    public Customer getCustomer() {
        return customer;
    }

    public Product getProduct() {
        return product;
    }

    public int getQuantity() {
        return Quantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cart cart = (Cart) o;
        return Quantity == cart.Quantity && Objects.equals(cartID, cart.cartID) && Objects.equals(customer, cart.customer) && Objects.equals(product, cart.product);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cartID, customer, product, Quantity);
    }

    @Override
    public String toString() {
        return "Cart{" +
                "cartID='" + cartID + '\'' +
                ", customer=" + customer +
                ", product=" + product +
                ", Quantity=" + Quantity +
                '}';
    }

    private Cart(Cart.Builder b){
        this.cartID = b.cartID;
        this.customer = b.customer;
        this.product = b.product;
        this.Quantity = b.Quantity;
    }

    public static class Builder {
        private String cartID;

        public Customer customer;

        public Product product;

        public int Quantity;


        public Cart.Builder setCartID(String cartID) {
            this.cartID = cartID;
            return this;
        }

        public Cart.Builder setCustomer(Customer customer){
            this.customer = customer;
            return this;
        }

        public Cart.Builder setProduct(Product product){
            this.product = product;
            return this;
        }

        public Cart.Builder setQuantity(int Quantity){
            this.Quantity = Quantity;
            return this;
        }

        public Builder copy(Cart cart){
            this.cartID = cart.cartID;
            this.customer = cart.customer;
            this.product = cart.product;
            this.Quantity = cart.Quantity;
            return this;
        }

        public Cart build(){
            return new Cart(this);
        }
    }

} */
