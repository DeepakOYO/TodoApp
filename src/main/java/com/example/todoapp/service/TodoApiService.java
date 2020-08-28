package com.example.todoapp.service;

import com.example.todoapp.model.TodoTaskModel;
import com.example.todoapp.model.UserModel;
import com.example.todoapp.repository.TodoRepository;
import com.example.todoapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TodoApiService implements TodoService {

    @Autowired
    TodoRepository todoRepository;

    @Autowired
    UserRepository userRepository;

    public TodoTaskModel createTodoTask(TodoTaskModel todoTaskModel) {
        UserModel userModel = userRepository.findByUserId(todoTaskModel.getUserId());
        List<String> taskList = new ArrayList<>();
        if (userModel.getTaskList() != null) {
            taskList = userModel.getTaskList();
        }
        taskList.add(todoTaskModel.getDescription());
        userModel.setTaskList(taskList);
        userRepository.save(userModel);
        todoRepository.save(todoTaskModel);
        return todoTaskModel;
    }

    public TodoTaskModel getTodoTask(String description, long userId) {
        return todoRepository.findByDescriptionAndUserId(description, userId);
    }

    public List<TodoTaskModel> getAllTasks() {
        return todoRepository.findAll();
    }

    public TodoTaskModel updateTaskStatus(TodoTaskModel todoTaskModel) {
        TodoTaskModel updatedTodoTaskModel = todoRepository.findByDescriptionAndUserId(
                todoTaskModel.getDescription(), todoTaskModel.getUserId());
        assert updatedTodoTaskModel != null;
        updatedTodoTaskModel.setStatus(todoTaskModel.getStatus());
        todoRepository.save(updatedTodoTaskModel);
        return updatedTodoTaskModel;
    }

    public void deleteTodoTask(String description, long userId) {
        UserModel userModel = userRepository.findByUserId(userId);
        List<String> taskList = userModel.getTaskList();
        taskList.remove(description);
        userModel.setTaskList(taskList);
        userRepository.save(userModel);
        todoRepository.deleteByDescriptionAndUserId(description, userId);
    }

    public UserModel createUser() {
        long userId;
        do {
            userId = (long)(Math.random()*1000);
        } while (userRepository.findByUserId(userId) != null);
        UserModel userModel = new UserModel(userId, new ArrayList<>());
        userRepository.save(userModel);
        return userModel;
    }

    public void deleteUser(long userId) {
        todoRepository.deleteByUserId(userId);
        userRepository.deleteByUserId(userId);
    }
}
