package com.books.userservice.proxy;

import com.books.userservice.domain.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@FeignClient(name="user-auth-service",url="localhost:8090")
public interface UserProxy {
    @PostMapping("/api/auth/save")
    public ResponseEntity<?> saveUser(@RequestBody User user);
}