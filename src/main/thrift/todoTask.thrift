namespace java com.example.todoapp.todotask

enum TStatus {
    TODO,
    IN_PROGRESS,
    COMPLETED
}

struct TTodoTaskModel {
    1: string id;
    2: string description;
    3: TStatus status;
    4: i64 userId;
}

service TTodoTaskService {
    TTodoTaskModel getTodoTask(1: string description, 2: i64 userId);
    list<TTodoTaskModel> getAllTasks();
    TTodoTaskModel createTodoTask(1: TTodoTaskModel tTodoTaskModel);
    TTodoTaskModel updateTodoTask(1: TTodoTaskModel tTodoTaskModel);
}