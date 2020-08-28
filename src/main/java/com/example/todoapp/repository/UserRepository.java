package com.example.todoapp.repository;

import com.example.todoapp.model.UserModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<UserModel, String> {

    UserModel findByUserId(long userId);

    void deleteByUserId(long userId);
}
