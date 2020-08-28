package com.example.todoapp;

import com.example.todoapp.todotask.TStatus;
import com.example.todoapp.todotask.TTodoTaskModel;
import com.example.todoapp.todotask.TTodoTaskService;
import org.apache.thrift.TException;
import org.apache.thrift.protocol.TJSONProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.THttpClient;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
class TodoAppApplicationTests {

	@Test
	void getTaskTest() {
		try {
			TTodoTaskService.Client client = getClient();
			TTodoTaskModel tTodoTaskModel = client.getTodoTask("HOUSE chores", 114);
			System.out.println(tTodoTaskModel);
		} catch (TException e) {
			e.printStackTrace();
		}
	}

	@Test
	void getAllTasksTest() {
		try {
			TTodoTaskService.Client client = getClient();
			List<TTodoTaskModel> tTodoTaskModels = client.getAllTasks();
			System.out.println(tTodoTaskModels);
		} catch (TException e) {
			e.printStackTrace();
		}
	}

	@Test
	void createTaskTest() {
		try {
			TTodoTaskService.Client client = getClient();
			TTodoTaskModel taskModel = new TTodoTaskModel(null, "Science Project", TStatus.IN_PROGRESS, 868);
			TTodoTaskModel tTodoTaskModel = client.createTodoTask(taskModel);
			System.out.println(tTodoTaskModel);
		} catch (TException e) {
			e.printStackTrace();
		}
	}

	@Test
	void updateTaskTest() {
		try {
			TTodoTaskService.Client client = getClient();
			TTodoTaskModel taskModel = new TTodoTaskModel(null, "Science Project", TStatus.TODO, 868);
			TTodoTaskModel tTodoTaskModel = client.updateTodoTask(taskModel);
			System.out.println(tTodoTaskModel);
		} catch (TException e) {
			e.printStackTrace();
		}
	}

	TTodoTaskService.Client getClient() {
		THttpClient tHttpClient;
		try {
			tHttpClient = new THttpClient("http://localhost:8080/todoTaskService/");
			tHttpClient.setConnectTimeout(3000);
		} catch (TException e) {
			e.printStackTrace();
			return null;
		}
		TProtocol tProtocol = new TJSONProtocol(tHttpClient);
		TTodoTaskService.Client client = new TTodoTaskService.Client(tProtocol);
		return client;
	}

}
