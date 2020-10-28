package com.example.todoapp.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import static com.example.todoapp.constants.Constants.MONGODB_COLLECTION_TEST;

@Document(collection = MONGODB_COLLECTION_TEST)
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class TodoTaskModel {

    public enum Status {
        TODO, IN_PROGRESS, COMPLETED;
    }

    @Id
    private String id;
    private String description;
    private Status status;
    private long userId;
}
