package com.example.todoapp.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

import static com.example.todoapp.constants.Constants.MONGODB_COLLECTION_USERS;

@Document(collection = MONGODB_COLLECTION_USERS)
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
@Getter
public class UserModel {

    @Id
    private String id;
    private long userId;
    private List<String> taskList;
}
