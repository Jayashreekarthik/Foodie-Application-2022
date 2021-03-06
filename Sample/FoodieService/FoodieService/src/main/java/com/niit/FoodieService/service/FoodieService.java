package com.niit.FoodieService.service;

import com.niit.FoodieService.DTODomain.CartDTO;
import com.niit.FoodieService.domain.*;
import com.niit.FoodieService.exception.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface FoodieService {
    public User registerUser(User user) throws UserAlreadyExistsException;
    public List<Cusine> getAllCusine();
    public List<Restaurant> getAllRestaurant();
    public List<Cusine> getAllCusineByCity(String city);
    public List<Restaurant> getAllRestaurantByCity(String city);
    public Cusine getCusineByID(int id) throws CusineNotFoundException;
    public Restaurant getRestaurantByID(int id) throws RestaurantNotFoundException;
    public List<Cusine> getCusineByName(String name);
    public User getUserByID(String email) throws UserNotFoundException;
    public CartDTO addCusineToCart(String email,int cusineID);
    public CartDTO addCusineToFavourite(String email, int cusineID);
    public CartDTO addRestaurantToFavourite(String email, int restaurantID);
    public String saveProfileImage(MultipartFile file) throws IOException;
}
