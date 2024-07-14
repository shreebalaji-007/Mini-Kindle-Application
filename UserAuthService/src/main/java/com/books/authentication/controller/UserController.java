package com.books.authentication.controller;

import com.books.authentication.exception.UserAlreadyExistsException;
import com.books.authentication.exception.InvalidCredentialsException;
import com.books.authentication.security.SecurityTokenGenerator;
import com.books.authentication.service.IUserService;
import com.books.authentication.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;


@RestController
@RequestMapping("/api/auth")
public class UserController {
    private IUserService userService;
    private SecurityTokenGenerator securityTokenGenerator;
    @Autowired
    public UserController(IUserService userService, SecurityTokenGenerator securityTokenGenerator) {
        this.userService = userService;
        this.securityTokenGenerator = securityTokenGenerator;
    }
    @PostMapping("/save")
    public ResponseEntity<?> saveUser(@RequestBody User user) {
        try {
            User retrievedUser = userService.getUserByUsernameAndPassword(user.getUsername(), user.getPassword());

            if (retrievedUser == null) {
                return new ResponseEntity<>(userService.saveUser(user), HttpStatus.CREATED);
            } else {
                throw new UserAlreadyExistsException();
            }
        } catch (UserAlreadyExistsException e) {
            return new ResponseEntity<>("User already exists.", HttpStatus.CONFLICT);
        } catch (InvalidCredentialsException e) {
            return new ResponseEntity<>("User credentials is invalid.", HttpStatus.UNAUTHORIZED);
        }
    }


    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody User user) throws InvalidCredentialsException
    {
        User retrievedUser = userService.getUserByUsernameAndPassword(user.getUsername(),user.getPassword());

        if(retrievedUser==null)
        {
            throw new InvalidCredentialsException();
        }
        Map<String,String> map = securityTokenGenerator.generateToken(retrievedUser);
        return new ResponseEntity<>(map,HttpStatus.OK);
    }
}
