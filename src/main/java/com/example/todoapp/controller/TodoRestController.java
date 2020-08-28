package com.example.todoapp.controller;

import com.example.todoapp.model.TodoTaskModel;
import com.example.todoapp.model.UserModel;
import com.example.todoapp.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.example.todoapp.constants.Constants.URL_PARAMETER_TASKNAME;

@RestController
public class TodoRestController {

    @Autowired
    TodoService todoService;

    @PostMapping(value = "/Task")
    public TodoTaskModel createTodoTask(@RequestBody TodoTaskModel todoTaskModel) {
         return todoService.createTodoTask(todoTaskModel);
    }

    @GetMapping(value = "/Task")
    @ResponseBody
    public TodoTaskModel retrieveTask(@RequestParam(value = URL_PARAMETER_TASKNAME) String description,
                                      @RequestParam long userId) {
        return todoService.getTodoTask(description, userId);
    }

    @GetMapping(value = "/Task/list")
    @ResponseBody
    public List<TodoTaskModel> retrieveAllTasks() {
        return todoService.getAllTasks();
    }

    @PutMapping(value = "/Task")
    public TodoTaskModel updateTaskStatus(@RequestBody TodoTaskModel todoTaskModel) {
        return todoService.updateTaskStatus(todoTaskModel);
    }

    @DeleteMapping(value = "/Task")
    public void removeTask(@RequestParam(name = URL_PARAMETER_TASKNAME) String description,
                           @RequestParam long userId) {
        todoService.deleteTodoTask(description, userId);
    }

    @PostMapping(value = "/User")
    @ResponseBody
    public UserModel createUser() {
        return todoService.createUser();
    }

    @DeleteMapping(value = "/User")
    public void deleteUser(@RequestParam long userId){
        todoService.deleteUser(userId);
    }

}
