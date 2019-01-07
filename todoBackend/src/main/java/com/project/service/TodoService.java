package com.project.service;

import com.project.bean.TodoBean;

public class TodoService {

	public TodoBean fetchTask()
	{
		TodoBean todoBean=new TodoBean();
		
		todoBean.setId(2);
		 todoBean.setTask("hi");
		 todoBean.setStatus("DONE");
		 return todoBean;
	}
}
