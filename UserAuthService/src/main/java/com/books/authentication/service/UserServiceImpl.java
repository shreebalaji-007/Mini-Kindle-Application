package com.books.authentication.service;

import com.books.authentication.exception.InvalidCredentialsException;
import com.books.authentication.exception.UserAlreadyExistsException;
import com.books.authentication.repository.UserRepository;
import com.books.authentication.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements IUserService {
    private UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Override
    public User saveUser(User user) throws UserAlreadyExistsException {
        User loggedInUser = userRepository.findByUsernameAndPassword(user.getUsername(),user.getPassword());
        if(loggedInUser != null)
        {
            throw new UserAlreadyExistsException();
        }
        return userRepository.save(user);
    }

    @Override
    public User getUserByUsernameAndPassword(String username, String password) throws InvalidCredentialsException {
        //validate the credentials

        User loggedInUser = userRepository.findByUsernameAndPassword(username,password);
        return loggedInUser;
    }

}
