package com.books.userservice.repository;

import com.books.userservice.domain.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {
    // You can define custom query methods here if needed
}
