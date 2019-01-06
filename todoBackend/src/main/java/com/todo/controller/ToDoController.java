package com.todo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.todo.bean.ToDoBean;

@RestController
@RequestMapping("/todo")
public class ToDoController {
	
//	@Autowired
	//public 
	
	@RequestMapping(value="/fetchTask",method=RequestMethod.GET)
	public ToDoBean fetchAllTask() {  
		ToDoBean todoBean=new ToDoBean();
		System.out.println("Name = succ");
		todoBean.setId(1);
		todoBean.setTask("hi");
		todoBean.setStatus("DONE");
		
		todoBean.setId(2);
		todoBean.setTask("hiii");
		todoBean.setStatus("NOT DONE");

        return todoBean;  
    }


}