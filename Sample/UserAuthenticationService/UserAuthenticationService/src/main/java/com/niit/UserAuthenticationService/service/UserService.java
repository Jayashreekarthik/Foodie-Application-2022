package com.niit.UserAuthenticationService.service;
import com.niit.UserAuthenticationService.exception.EmailAlreadyExists;
import com.niit.UserAuthenticationService.exception.UserNotFoundException;
import com.niit.UserAuthenticationService.model.User;

import java.util.List;

public interface UserService {
    public User saveUser(User user) throws EmailAlreadyExists;
    public User findByEmailAndPassword(String email, String password) throws UserNotFoundException;
    List<User> getAllUsers();
}

