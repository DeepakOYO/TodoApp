package com.example.todoapp.controller;

import com.example.todoapp.service.TodoService;
import com.example.todoapp.todotask.TTodoTaskModel;
import com.example.todoapp.todotask.TTodoTaskService;
import com.example.todoapp.util.TodoTaskModelUtil;
import org.apache.thrift.TException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TodoTaskServiceHandler implements TTodoTaskService.Iface {

    @Autowired
    TodoService todoService;

    @Override
    public TTodoTaskModel getTodoTask(String description, long userId) throws TException {
        return TodoTaskModelUtil.getTodoTaskThriftResponse(todoService.getTodoTask(description, userId));
    }

    @Override
    public List<TTodoTaskModel> getAllTasks() throws TException {
        return TodoTaskModelUtil.getAllTasksThriftResponse(todoService.getAllTasks());
    }

    @Override
    public TTodoTaskModel createTodoTask(TTodoTaskModel tTodoTaskModel) throws TException {
        return TodoTaskModelUtil.getTodoTaskThriftResponse(
                todoService.createTodoTask(TodoTaskModelUtil.getTodoTaskDbResponse(tTodoTaskModel)));
    }

    @Override
    public TTodoTaskModel updateTodoTask(TTodoTaskModel tTodoTaskModel) throws TException {
        return TodoTaskModelUtil.getTodoTaskThriftResponse(
                todoService.updateTaskStatus(TodoTaskModelUtil.getTodoTaskDbResponse(tTodoTaskModel)));
    }
}
