package com.example.todoapp.service;

import com.example.todoapp.model.TodoTaskModel;
import com.example.todoapp.model.UserModel;

import java.util.List;

public interface TodoService {
    TodoTaskModel createTodoTask(TodoTaskModel todoTaskModel);

    TodoTaskModel getTodoTask(String description, long userId);

    List<TodoTaskModel> getAllTasks();

    TodoTaskModel updateTaskStatus(TodoTaskModel todoTaskModel);

    void deleteTodoTask(String description, long userId);

    UserModel createUser();

    void deleteUser(long userId);
}
