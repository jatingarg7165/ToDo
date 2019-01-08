package com.project.bean;

public class TodoBean {

	private int id;
	private String task;
	private String status;
	 public TodoBean(int id, String task, String status) {
	        this.id = id;
	        this.task = task;
	        this.status = status;
	    }
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTask() {
		return task;
	}
	public void setTask(String task) {
		this.task = task;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public TodoBean() {
	
	}
	
}
