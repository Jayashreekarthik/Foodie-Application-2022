package com.niit.FoodieService.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.niit.FoodieService.domain.User;
import com.niit.FoodieService.exception.UserAlreadyExistsException;
import com.niit.FoodieService.exception.UserNotFoundException;
import com.niit.FoodieService.service.FileSaveService;
import com.niit.FoodieService.service.FoodieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("api/v1/")
public class FoodieController {

    private FoodieService foodieService;
    private FileSaveService fileSaveService;
    private ResponseEntity responseEntity;

    @Autowired
    public FoodieController(FoodieService foodieService,FileSaveService fileSaveService) {
        this.foodieService = foodieService;
        this.fileSaveService=fileSaveService;
    }

    String filename;
    @PostMapping("users/image")
    public ResponseEntity saveUserProfileImage(@RequestParam("file") MultipartFile file)
    {
        try
        {
            filename=fileSaveService.save(file);
            responseEntity=new ResponseEntity<>(filename, HttpStatus.CREATED);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return  responseEntity;
    }

    @PostMapping("users/register")
    public ResponseEntity registerUser(@RequestBody User user)
    {
        try
        {
            user.setProfileImage(filename);
            responseEntity=new ResponseEntity<>(foodieService.registerUser(user), HttpStatus.CREATED);
        }
        catch(UserAlreadyExistsException e)
        {
            e.printStackTrace();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return  responseEntity;
    }

    @GetMapping("users/image/{name}")
    public ResponseEntity getUserImage(@PathVariable String image)
    {
        try{
            responseEntity=new ResponseEntity<>(fileSaveService.load(image), HttpStatus.OK);
        }

        catch(Exception e)
        {
            e.printStackTrace();
        }
        return  responseEntity;
    }

    @GetMapping("users/{email}")
    public ResponseEntity getUser(@PathVariable String email)
    {
        try{
            responseEntity=new ResponseEntity<>(foodieService.getUserByID(email), HttpStatus.OK);
        }
        catch(UserNotFoundException e)
        {
            e.printStackTrace();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return  responseEntity;
    }

    @GetMapping("restaurants")
    public ResponseEntity getAllRestaurant()
    {
        try{
            responseEntity=new ResponseEntity<>(foodieService.getAllRestaurant(), HttpStatus.OK);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return  responseEntity;
    }

    @GetMapping("cusine")
    public ResponseEntity getAllCusine()
    {
        try{
            responseEntity=new ResponseEntity<>(foodieService.getAllCusine(), HttpStatus.OK);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return  responseEntity;
    }

    @GetMapping("cusine/{city}")
    public ResponseEntity getAllCusinesFromACity(@PathVariable String city)
    {
        try{
            responseEntity=new ResponseEntity<>(foodieService.getAllCusineByCity(city), HttpStatus.OK);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return  responseEntity;
    }

    @GetMapping("restaurant/{city}")
    public ResponseEntity getAllRestaurantFromACity(@PathVariable String city)
    {
        try{
            responseEntity=new ResponseEntity<>(foodieService.getAllRestaurantByCity(city), HttpStatus.OK);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return  responseEntity;
    }

    @GetMapping("cusine/all/{name}")
    public ResponseEntity getAllCusinesFromName(@PathVariable String name)
    {
        try{
            responseEntity=new ResponseEntity<>(foodieService.getCusineByName(name), HttpStatus.OK);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return  responseEntity;
    }

    @PostMapping("cart/{email}/{id}")
    public ResponseEntity addCusineToCart(@PathVariable String email,@PathVariable int id)
    {
        try{
            responseEntity=new ResponseEntity<>(foodieService.addCusineToCart(email,id), HttpStatus.OK);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return  responseEntity;
    }

    @PostMapping("cusine/{email}/{cusineID}")
    public ResponseEntity addCusineToFavourite(@PathVariable String email,@PathVariable int cusineID)
    {
        try{
            responseEntity=new ResponseEntity<>(foodieService.addCusineToFavourite(email,cusineID), HttpStatus.OK);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return  responseEntity;
    }

    @PostMapping("restaurant/{email}/{restaurantID}")
    public ResponseEntity addRestaurantToFavourite(@PathVariable String email,@PathVariable int restaurantID)
    {
        try{
            responseEntity=new ResponseEntity<>(foodieService.addRestaurantToFavourite(email, restaurantID), HttpStatus.OK);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return  responseEntity;
    }

}
