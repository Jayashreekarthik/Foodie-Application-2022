package com.niit.vendorService.service;

import com.niit.vendorService.exception.CusineNotFoundException;
import com.niit.vendorService.exception.RestaurantNotFoundException;
import com.niit.vendorService.model.Cusine;
import com.niit.vendorService.model.Restaurant;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface VendorService {

    public Cusine addCusine(Cusine cusine);
    public Restaurant addRestaurant(Restaurant restaurant);
    public boolean deleteCusine(int id) throws CusineNotFoundException, CusineNotFoundException;
    public boolean deleteResturant(int id) throws RestaurantNotFoundException, RestaurantNotFoundException;
    public List<Cusine> getCusineFromEmail(String email);
    public List<Restaurant> getRestaurantFromEmail(String email);
    public String saveProfileImage(MultipartFile file) throws IOException;
}

