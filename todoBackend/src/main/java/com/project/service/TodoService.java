package com.project.service;

import com.project.bean.TodoBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import java.util.List;



//import com.project.config.DatabaseConfiguration;

@Repository
public class TodoService {

	@Autowired
    JdbcTemplate template;
	
	public List<TodoBean> fetchTask()
	{
		List<TodoBean> todoBean = template.query("select id, task,status from todo",(result,rowNum)->new TodoBean(result.getInt("id"),
                result.getString("task"),result.getString("status")));
		 return todoBean;
	}
	
	  public int createTask(String task,String status,int id){
	        String query = "INSERT INTO todo VALUES(?,?,?)";
	        return template.update(query,task,status,id);
	    }
	  
	  public int deleteTask(int id){
	        String query = "DELETE FROM todo WHERE ID =?";
	        return template.update(query,id);
	    }
	  
	  public int updateTask(int id,String status){
	        String query = "UPDATE todo SET status=? WHERE ID =?";
	        return template.update(query,status,id);
	    }
}







//@Repository
//public class ItemRepository {
//
//    @Autowired
//    JdbcTemplate template;
//
//    /*Getting all Items from table*/
//    public List<Item> getAllItems(){
//        List<Item> items = template.query("select id, name,category from item",(result,rowNum)->new Item(result.getInt("id"),
//                result.getString("name"),result.getString("category")));
//        return items;
//    }
//
//}

