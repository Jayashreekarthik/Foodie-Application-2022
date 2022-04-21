package com.niit.vendorService.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.niit.vendorService.model.Cusine;
import com.niit.vendorService.model.Restaurant;
import com.niit.vendorService.service.VendorService;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("api/v2")
public class VendorController {
    ResponseEntity responseEntity;
    @Autowired
    VendorService vendorService;

    @PostMapping("cusine")
    public ResponseEntity saveCusine(@RequestParam(value = "file")MultipartFile file,@RequestParam(value = "model") String model)
    {
        try
        {
            String location=vendorService.saveProfileImage(file);
            ObjectMapper mapper=new ObjectMapper();
            Cusine cusine=mapper.readValue(model,Cusine.class);
            cusine.setCusineImage(location);
            responseEntity = new ResponseEntity(vendorService.addCusine(cusine), HttpStatus.CREATED);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return responseEntity;
    }

    @PostMapping("restaurant")
    public ResponseEntity saveRestaurant(@RequestParam(value = "file") MultipartFile file, @RequestParam(value = "model") String model)
    {
        try
        {
            String location=vendorService.saveProfileImage(file);
            ObjectMapper mapper=new ObjectMapper();
            Restaurant restaurant=mapper.readValue(model,Restaurant.class);
            restaurant.setLogo(location);
            responseEntity = new ResponseEntity(vendorService.addRestaurant(restaurant), HttpStatus.CREATED);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return responseEntity;
    }

    @DeleteMapping("cusine/{id}")
    public ResponseEntity deleteCusine(@PathVariable int id)
    {
        try
        {
            responseEntity=new ResponseEntity(vendorService.deleteCusine(id),HttpStatus.OK);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return responseEntity;
    }

    @SneakyThrows
    @DeleteMapping("restaurant/{id}")
    public ResponseEntity deleteRestaurant(@PathVariable int id)
    {
        try
        {
            responseEntity=new ResponseEntity(vendorService.deleteResturant(id),HttpStatus.OK);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return responseEntity;
    }

    @GetMapping("cusine/{email}")
    public ResponseEntity getAllCusinesByEmail(@PathVariable String email)
    {
        try
        {
            responseEntity=new ResponseEntity(vendorService.getCusineFromEmail(email), HttpStatus.OK);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return responseEntity;
    }

    @GetMapping("restaurant/{email}")
    public ResponseEntity getAllRestaurantByEmail(@PathVariable String email)
    {
        try
        {
            responseEntity=new ResponseEntity(vendorService.getRestaurantFromEmail(email),HttpStatus.OK);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return responseEntity;
    }

}

