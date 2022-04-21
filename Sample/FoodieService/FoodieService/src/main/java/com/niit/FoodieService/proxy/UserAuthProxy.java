package com.niit.FoodieService.proxy;

import com.niit.FoodieService.domain.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public interface UserAuthProxy {
    @PostMapping("api/v3/register")
    public ResponseEntity saveUser(@RequestBody User user);
}
