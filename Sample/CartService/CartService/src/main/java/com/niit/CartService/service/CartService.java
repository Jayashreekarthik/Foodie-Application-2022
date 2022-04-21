package com.niit.CartService.service;

import com.niit.CartService.domain.Cart;

import java.util.List;

public interface CartService {
    public List<Cart> getAllCartItemsFromEmail(String email);
    public boolean deleteCartItem(int id);
    public Cart saveCusineToCart(Cart cart);
    public Cart saveCusineToCartAlt(String email,int cusineID);
}
