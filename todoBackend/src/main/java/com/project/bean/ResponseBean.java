package com.project.bean;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class ResponseBean {
	
	private int responseCode;
	private String responseMsg;
	private List<TodoBean> responseData;
	public int getResponseCode() {
		return responseCode;
	}
	public void setResponseCode(int responseCode) {
		this.responseCode = responseCode;
	}
	public String getResponseMsg() {
		return responseMsg;
	}
	public void setResponseMsg(String responseMsg) {
		this.responseMsg = responseMsg;
	}
	public List<TodoBean> getResponseData() {
		return responseData;
	}
	public void setResponseData(List<TodoBean> responseData) {
		this.responseData = responseData;
	}
}
