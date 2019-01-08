package com.project.todoBackend;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.project.bean.ResponseBean;
import com.project.bean.TodoBean;
import com.project.service.TodoService;

@RestController
public class TodoBackendApplication {

	@Autowired
	TodoService todoService;
		
	@GetMapping("/fetchTask")
	public ResponseBean fetchTask()
	{
		ResponseBean resBean=new ResponseBean();
		 List<TodoBean> todoBean;
		 System.out.println("Rest Web");
		 todoBean=todoService.fetchTask();
		 resBean.setResponseCode(1000);
		 resBean.setResponseMsg("Success");
		 resBean.setResponseData(todoBean);
		 return resBean;
	}
	
	@PostMapping("/createTask")
	public ResponseBean createTask(@RequestBody TodoBean toDoBean)
	{
		ResponseBean resBean=new ResponseBean();
		 String task=toDoBean.getTask();
		 String status=toDoBean.getStatus();
		 int id = toDoBean.getId();
		 System.out.println("Rest Web");
		 int res=todoService.createTask(task,status,id);
		 System.out.println("create api"+res);
		 resBean.setResponseCode(1000);
		 resBean.setResponseMsg("created Successsfully");
		 return resBean;
	}
	
	@PostMapping("/deleteTask")
	public ResponseBean deleteTask(@RequestBody TodoBean toDoBean)
	{
		ResponseBean resBean=new ResponseBean();
		 int id = toDoBean.getId();
		 System.out.println("Rest Web");
		 int res=todoService.deleteTask(id);
		 System.out.println("delete api"+res);
		 resBean.setResponseCode(1000);
		 resBean.setResponseMsg("Deleted Successsfully");
		 return resBean;
	}
	
	@PostMapping("/updateTask")
	public ResponseBean updateTask(@RequestBody TodoBean toDoBean)
	{
		ResponseBean resBean=new ResponseBean();
		 int id = toDoBean.getId();
		 String status=toDoBean.getStatus();
		 System.out.println("Rest Web");
		 int res=todoService.updateTask(id,status);
		 System.out.println("update api"+res);
		 resBean.setResponseCode(1000);
		 resBean.setResponseMsg("updated Successsfully");
		 return resBean;
	}
	
	
	
}

