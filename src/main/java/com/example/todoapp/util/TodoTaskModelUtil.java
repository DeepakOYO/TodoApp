package com.example.todoapp.util;

import com.example.todoapp.model.TodoTaskModel;
import com.example.todoapp.todotask.TStatus;
import com.example.todoapp.todotask.TTodoTaskModel;

import java.util.ArrayList;
import java.util.List;

public class TodoTaskModelUtil {

    public static TTodoTaskModel getTodoTaskThriftResponse(TodoTaskModel todoTaskModel) {
        TTodoTaskModel tTodoTaskModel = new TTodoTaskModel();
        tTodoTaskModel.setId(todoTaskModel.getId());
        tTodoTaskModel.setDescription(todoTaskModel.getDescription());
        switch (todoTaskModel.getStatus()) {
            case IN_PROGRESS: tTodoTaskModel.setStatus(TStatus.IN_PROGRESS);
            break;
            case COMPLETED: tTodoTaskModel.setStatus(TStatus.COMPLETED);
            break;
            default: tTodoTaskModel.setStatus(TStatus.TODO);
        }
        tTodoTaskModel.setUserId(todoTaskModel.getUserId());
        return tTodoTaskModel;
    }

    public static List<TTodoTaskModel> getAllTasksThriftResponse(List<TodoTaskModel> TodoTasks) {
        List<TTodoTaskModel> TTodoTasks = new ArrayList<>();
        for (TodoTaskModel todoTaskModel : TodoTasks) {
            TTodoTasks.add(getTodoTaskThriftResponse(todoTaskModel));
        }
        return TTodoTasks;
    }

    public static TodoTaskModel getTodoTaskDbResponse(TTodoTaskModel tTodoTaskModel) {
        TodoTaskModel todoTaskModel = new TodoTaskModel();
        todoTaskModel.setDescription(tTodoTaskModel.getDescription());
        switch (tTodoTaskModel.getStatus()) {
            case TODO: todoTaskModel.setStatus(TodoTaskModel.Status.TODO);
            break;
            case IN_PROGRESS: todoTaskModel.setStatus(TodoTaskModel.Status.IN_PROGRESS);
            break;
            default: todoTaskModel.setStatus(TodoTaskModel.Status.COMPLETED);
        }
        todoTaskModel.setUserId(tTodoTaskModel.getUserId());
        return todoTaskModel;
    }
}
