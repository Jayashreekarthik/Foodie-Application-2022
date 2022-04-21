package com.niit.FavouriteService.service;

import com.niit.FavouriteService.domain.Favourite;
import com.niit.FavouriteService.exception.*;
import com.niit.FavouriteService.repository.FavouriteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class FavouriteServiceImpl implements FavouriteService {

    FavouriteRepository favouriteRepository;

    @Autowired
    public FavouriteServiceImpl(FavouriteRepository favouriteRepository) {
        this.favouriteRepository = favouriteRepository;
    }


    @Override
    public boolean deleteCusine(Integer id, String email) throws CusineNotFoundException {
        Favourite fav=favouriteRepository.findById(email).get();
        List<Integer> cusines=fav.getCusines();
        if(cusines==null)
        {
            throw new CusineNotFoundException();
        }
        cusines.remove(id);
        fav.setCusines(cusines);
        favouriteRepository.save(fav);
        return true;
    }

    @Override
    public boolean deleteResturant(Integer id, String email) throws ResturantNotFoundException {
        Favourite fav=favouriteRepository.findById(email).get();
        List<Integer> restaurants=fav.getRestaurants();
        if(restaurants==null)
        {
            throw new ResturantNotFoundException();
        }
        restaurants.remove(id);
        fav.setCusines(restaurants);
        favouriteRepository.save(fav);
        return true;
    }

    @Override
    public Favourite getFavouritesByEmail(String email) throws UserNotFoundException {
        return favouriteRepository.findById(email).get();
    }

    @Override
    public Favourite addFavourite(String email, int cusineID, int restaurantID) {
        if(favouriteRepository.findById(email).isEmpty())
        {
            Favourite fav1=new Favourite();
            fav1.setEmail(email);
            favouriteRepository.save(fav1);
        }
        Favourite fav=favouriteRepository.findById(email).get();
        if(restaurantID==0)
        {
            List<Integer> cusines=fav.getCusines();
            cusines.add(cusineID);
            fav.setCusines(cusines);
            favouriteRepository.save(fav);
        }
        if(cusineID==0)
        {
            List<Integer> restaurants=fav.getRestaurants();
            restaurants.add(restaurantID);
            fav.setRestaurants(restaurants);
            favouriteRepository.save(fav);
        }
        return fav;

    }

}
