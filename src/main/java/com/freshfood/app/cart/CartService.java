package com.freshfood.app.cart;

import com.freshfood.app.entities.sandwich.Sandwich;
import com.freshfood.app.entities.sandwich.SandwichService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

@Service
public class CartService {
    private final CartRepository cartRepository;
    private final SandwichService sandwichService;
    @Autowired
    public CartService(CartRepository cartRepository, SandwichService sandwichService)
    {
        this.cartRepository = cartRepository;
        this.sandwichService = sandwichService;
    }

    public Cart getCart(Integer id){
        return cartRepository
                .findById(id)
                .orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND,"Cart not found"));
    }

    public Integer addCart() {
       return cartRepository.save(Cart.builder().build()).getId();
    }

    @Transactional
    public void addSandwichToCart(Integer cartId, Integer sandwichId) {
       Cart current = getCart(cartId);
       current.getSandwiches().add(sandwichService.getSandwich(sandwichId));
       current.setPrice(current.getPrice()+sandwichService.getSandwich(sandwichId).getPrice());
    }


    @Transactional
    public void removeSandwichToCart(Integer cartId, Integer sandwichId) {
        Cart current = getCart(cartId);
        current.getSandwiches().removeIf(sandwich -> sandwich.getId().equals(sandwichId));
        current.setPrice(current.getPrice()-sandwichService.getSandwich(sandwichId).getPrice());
    }


}
