package com.niit.FavouriteService.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Cusine Not Found")
public class CusineNotFoundException extends Exception{
}
