package com.project.todoBackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.bean.TodoBean;
import com.project.service.TodoService;

@SpringBootApplication
@RestController
public class TodoBackendApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context=SpringApplication.run(TodoBackendApplication.class, args);
	}
	@GetMapping("/fetchTask")
	public TodoBean fetchTask()
	{
		TodoBean todoBean;
		 System.out.println("Rest Web");
		 TodoService todoService=new TodoService();
		 todoBean=todoService.fetchTask();
		 
		 return todoBean;
	}
}

