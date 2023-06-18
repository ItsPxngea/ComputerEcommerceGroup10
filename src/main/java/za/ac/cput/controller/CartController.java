package za.ac.cput.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.Cart;
import za.ac.cput.domain.Customer;
import za.ac.cput.domain.Product;
import za.ac.cput.factory.CartFactory;
import za.ac.cput.factory.CustomerFactory;
import za.ac.cput.factory.ProductFactory;
import za.ac.cput.service.CartService;

import java.util.List;

@RestController
@RequestMapping("/cart")
public class CartController {

    @Autowired
    private CartService cartService;

    @PostMapping("/create")
    public Cart create(@RequestBody Cart cart) {
        Customer customerCreated = CustomerFactory.buildCustomer();

        String productName = cart.getProduct().getProductName();
        double productPrice = cart.getProduct().getProductPrice();
        Product productCreated = ProductFactory.buildProduct(productName, productPrice);

        Cart cartCreated = CartFactory.buildCart(customerCreated, productCreated, cart.getQuantity());
        return cartService.create(cartCreated);
    }

    @PostMapping("/read/{id}")
    public Cart read(@PathVariable String id){
        return cartService.read(id);
    }

    @PostMapping("/update/{id}")
    public Cart update(@RequestBody Cart cart){
        return  cartService.update(cart);
    }

    @DeleteMapping("/delete/{id}")
    public boolean delete(@PathVariable String id){
        return  cartService.delete(id);
    }

    @GetMapping("/getAll")
    public List<Cart> getAll(){
        return cartService.getAll();
    }



}
