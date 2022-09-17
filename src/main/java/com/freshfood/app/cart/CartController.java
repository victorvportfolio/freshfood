package com.freshfood.app.cart;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/carts")
public class CartController {
    private final CartService cartService;

    @Autowired
    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    @PostMapping("/add-cart")
    public Integer addCart() {
        return cartService.addCart();

    }
    @PostMapping("/add-sandwich")
    public void addSandwich(@RequestParam("cartId") Integer cartId,@RequestParam("sandwichId")Integer sandwichId){
        cartService.addSandwichToCart(cartId,sandwichId);
    }

    //todo method to remove sandwich
    @PostMapping("/remove-sandwich")
    public void removeSandwich(@RequestParam("cartId") Integer cartId,@RequestParam("sandwichId")Integer sandwichId){
        cartService.removeSandwichToCart(cartId,sandwichId);
    }
    //todo method to get price of cart
}
