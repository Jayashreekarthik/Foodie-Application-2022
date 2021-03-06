package com.niit.FoodieService.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.CONFLICT, reason = "email already exists")
public
class UserAlreadyExistsException extends Exception {
}
