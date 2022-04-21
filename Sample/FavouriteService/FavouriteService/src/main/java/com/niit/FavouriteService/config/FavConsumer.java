package com.niit.FavouriteService.config;
import com.niit.FavouriteService.DTODomain.FavouriteDTO;
import com.niit.FavouriteService.service.FavouriteServiceImpl;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FavConsumer {
    @Autowired
    private FavouriteServiceImpl favouriteService;

    @RabbitListener(queues = "fav_queue")
    public void getCartFromRabbitMQ(FavouriteDTO favouriteDTO)
    {
        String email=favouriteDTO.getEmail();
        int cusineID=favouriteDTO.getCusineID();
        int restaurantID=favouriteDTO.getResturantID();

        favouriteService.addFavourite(email,cusineID,restaurantID);
    }
}
