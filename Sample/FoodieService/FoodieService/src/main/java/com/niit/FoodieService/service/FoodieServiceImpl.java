package com.niit.FoodieService.service;

import com.niit.FoodieService.DTODomain.CartDTO;
import com.niit.FoodieService.config.CartProducer;
import com.niit.FoodieService.config.FavProducer;
import com.niit.FoodieService.domain.Cusine;

import com.niit.FoodieService.domain.Restaurant;
import com.niit.FoodieService.domain.User;
import com.niit.FoodieService.exception.*;
import com.niit.FoodieService.proxy.UserAuthProxy;
import com.niit.FoodieService.repository.CusineRepository;
import com.niit.FoodieService.repository.RestaurantRepository;
import com.niit.FoodieService.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Service
public class FoodieServiceImpl implements FoodieService{
    private UserRepository userRepository;
    private RestaurantRepository restaurantRepository;
    private CusineRepository cusineRepository;
    private UserAuthProxy userAuthProxy;
    private CartProducer cartProducer;
    private FavProducer favProducer;

    @Autowired
    public FoodieServiceImpl(UserRepository userRepository, RestaurantRepository restaurantRepository, CusineRepository cusineRepository, UserAuthProxy userAuthProxy, CartProducer cartProducer, FavProducer favProducer) {
        this.userRepository = userRepository;
        this.restaurantRepository = restaurantRepository;
        this.cusineRepository = cusineRepository;
        this.userAuthProxy = userAuthProxy;
        this.cartProducer=cartProducer;
        this.favProducer=favProducer;
    }

    @Override
    public User registerUser(User user) throws UserAlreadyExistsException {
        if(userRepository.findById(user.getEmail()).isPresent())
        {
            throw new UserAlreadyExistsException();
        }
        userAuthProxy.saveUser(user);
        return userRepository.save(user);
    }

    @Override
    public List<Cusine> getAllCusine() {
        return cusineRepository.findAll();
    }

    @Override
    public List<Restaurant> getAllRestaurant() {
        return restaurantRepository.findAll();
    }

    @Override
    public List<Cusine> getAllCusineByCity(String city) {
        return cusineRepository.findByCityIgnoreCase(city);
    }

    @Override
    public List<Restaurant> getAllRestaurantByCity(String city) {
        return restaurantRepository.findByCityIgnoreCase();
    }

    @Override
    public Cusine getCusineByID(int id) throws CusineNotFoundException {
        return cusineRepository.getById();
    }

    @Override
    public Restaurant getRestaurantByID(int id) throws RestaurantNotFoundException {
        return restaurantRepository.getById();
    }

    @Override
    public List<Cusine> getCusineByName(String name) {
        return cusineRepository.findByCusineNameIgnoreCase(name);
    }

    @Override
    public User getUserByID(String email) throws UserNotFoundException {
        return userRepository.findById(email).get();
    }

    @Override
    public CartDTO addCusineToCart(String email, int cusineID) {
        CartDTO cart=new CartDTO();
        cart.setEmail(email);
        cart.setCusineID(cusineID);
        cartProducer.sendMessageTORabbitMQ(cart);
        return cart;
    }

    @Override
    public CartDTO addCusineToFavourite(String email, int cusineID) {
        CartDTO fav=new CartDTO();
        fav.setEmail(email);
        fav.setCusineID(cusineID);
        favProducer.sendMessageTORabbitMQ(fav);
        return fav;
    }

    @Override
    public CartDTO addRestaurantToFavourite(String email, int restaurantID) {
        CartDTO fav=new CartDTO();
        fav.setEmail(email);
        fav.setResturantID(restaurantID);
        favProducer.sendMessageTORabbitMQ(fav);
        return fav;
    }

    @Override
    public String saveProfileImage(MultipartFile file) throws IOException {
        file.transferTo(new File("D:\\uploadedfiles\\"+file.getOriginalFilename()));
        return "D:\\uploadedfiles\\"+file.getOriginalFilename();
    }
}
