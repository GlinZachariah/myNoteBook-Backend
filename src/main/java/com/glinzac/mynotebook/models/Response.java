package com.glinzac.mynotebook.models;

public class Response {
	private String message;
	private Object payLoad;
	
	public Response() {
		super();
	}
	
	public Response(String message) {
		super();
		this.message = message;
	}

	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Object getPayLoad() {
		return payLoad;
	}
	public void setPayLoad(Object payLoad) {
		this.payLoad = payLoad;
	}
	
	
}
