package com.example.todoapp;

import com.example.todoapp.controller.TodoTaskServiceHandler;
import com.example.todoapp.todotask.TTodoTaskService;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.thrift.TProcessor;
import org.apache.thrift.protocol.TJSONProtocol;
import org.apache.thrift.protocol.TProtocolFactory;
import org.apache.thrift.server.TServlet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;

import javax.servlet.Servlet;

@SpringBootApplication
public class TodoAppApplication {

	@Autowired
	TodoTaskServiceHandler todoTaskServiceHandler;

	public static void main(String[] args) {
		SpringApplication.run(TodoAppApplication.class, args);
	}

	@Bean
	public ServletRegistrationBean todoTaskService() {
		TProcessor processor = new TTodoTaskService.Processor<>(todoTaskServiceHandler);
		TProtocolFactory protocolFactory = new TJSONProtocol.Factory();
		Servlet servlet = new TServlet(processor, protocolFactory);
		ServletRegistrationBean regBean = new ServletRegistrationBean(servlet, "/todoTaskService/*");
		regBean.setName("TodoTaskServlet");
		return regBean;
	}

	@Bean
	public CloseableHttpClient closeableHttpClient() {
		HttpClientBuilder builder = HttpClientBuilder.create();
		CloseableHttpClient client = builder.build();
		return client;
	}
}
