package com.books.authentication.service;

import com.books.authentication.exception.InvalidCredentialsException;
import com.books.authentication.exception.UserAlreadyExistsException;
import com.books.authentication.domain.User;

public interface IUserService {
    User saveUser(User user) throws UserAlreadyExistsException;
    User getUserByUsernameAndPassword(String username, String password) throws InvalidCredentialsException;
}

