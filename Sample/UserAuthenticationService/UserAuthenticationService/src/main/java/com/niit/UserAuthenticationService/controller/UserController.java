package com.niit.UserAuthenticationService.controller;

import com.niit.UserAuthenticationService.exception.EmailAlreadyExists;
import com.niit.UserAuthenticationService.exception.UserNotFoundException;
import com.niit.UserAuthenticationService.model.User;
import com.niit.UserAuthenticationService.service.SecurityTokenGenerator;
import com.niit.UserAuthenticationService.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/v3")
@CrossOrigin
public class UserController {
    private UserService userService;
    private SecurityTokenGenerator securityTokenGenerator;

    @Autowired
    public UserController(UserService userService, SecurityTokenGenerator securityTokenGenerator) {
        this.userService = userService;
        this.securityTokenGenerator = securityTokenGenerator;
    }

    private ResponseEntity responseEntity;

    @PostMapping("/register")
    public ResponseEntity registerUser(@RequestBody User user)
    {
        try{
            responseEntity=new ResponseEntity<>(userService.saveUser(user), HttpStatus.CREATED);
        }
        catch(EmailAlreadyExists e)
        {
            responseEntity=new ResponseEntity<>("Email already exist", HttpStatus.CONFLICT);
        }
        catch(Exception e)
        {
            responseEntity=new ResponseEntity<>("Try again later",HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return responseEntity;
    }
    @PostMapping("/login")
    public ResponseEntity loginUser(@RequestBody User user)
    {
        Map<String,String> map=null;
        try{
            User loggedInUser=userService.findByEmailAndPassword(user.getEmail(), user.getPassword());
            if(loggedInUser!=null)
            {
                map=securityTokenGenerator.generateToken(user);
            }
            responseEntity=new ResponseEntity<>(map,HttpStatus.OK);

        }
        catch(UserNotFoundException e)
        {
            responseEntity=new ResponseEntity<>("User not found", HttpStatus.NOT_FOUND);
        }
        catch(Exception e)
        {
            responseEntity=new ResponseEntity<>("Try again later",HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return responseEntity;
    }
    @GetMapping("/api/v1/users")
    public ResponseEntity getAllUsers()
    {
        return new ResponseEntity<>(userService.getAllUsers(),HttpStatus.OK);
    }
}
