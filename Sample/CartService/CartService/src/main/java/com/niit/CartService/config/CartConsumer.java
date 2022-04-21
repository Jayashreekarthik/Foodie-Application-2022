package com.niit.CartService.config;


import com.niit.CartService.DTODomain.CartDTO;
import com.niit.CartService.domain.Cart;
import com.niit.CartService.service.CartServiceImpl;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CartConsumer {
    @Autowired
    private CartServiceImpl cartService;

    @RabbitListener(queues = "cart_queue")
    public void getCartFromRabbitMQ(CartDTO cartDTO)
    {
        String email=cartDTO.getEmail();
        int cusineID=cartDTO.getCusineID();
        Cart cart=new Cart(email,cusineID);
        cartService.saveCusineToCart(cart);
    }
}

