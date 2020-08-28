package com.example.todoapp.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

import static com.example.todoapp.constants.Constants.MONGODB_COLLECTION_USERS;

@Document(collection = MONGODB_COLLECTION_USERS)
public class UserModel {

    @Id
    private String id;
    private long userId;
    private List<String> taskList;

    public UserModel(long userId, List<String> taskList) {
        this.userId = userId;
        this.taskList = taskList;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public List<String> getTaskList() {
        return taskList;
    }

    public void setTaskList(List<String> taskList) {
        this.taskList = taskList;
    }
}
