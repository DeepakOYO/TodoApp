package com.example.todoapp.repository;

import com.example.todoapp.model.TodoTaskModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TodoRepository extends MongoRepository<TodoTaskModel, String> {

    TodoTaskModel findByDescriptionAndUserId(String description, long userId);

    void deleteByDescriptionAndUserId(String description, long userId);

    void deleteByUserId(long userId);
}
