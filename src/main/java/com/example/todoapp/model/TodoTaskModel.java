package com.example.todoapp.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import static com.example.todoapp.constants.Constants.MONGODB_COLLECTION_TEST;

@Document(collection = MONGODB_COLLECTION_TEST)
public class TodoTaskModel {

    public enum Status {
        TODO, IN_PROGRESS, COMPLETED;
    }

    @Id
    private String id;
    private String description;
    private Status status;
    private long userId;

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public TodoTaskModel() {
        super();
    }

    public TodoTaskModel(String description, Status status) {
        this.description = description;
        this.status = status;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
