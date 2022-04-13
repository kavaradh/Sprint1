package com.example.demo.controllers;

public class ResponseInfo {
	private int statusCode;
	private String Status;
	private String message;
	private String path;
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public int getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}
	public String getStatus() {
		return Status;
	}
	public void setStatus(String status) {
		Status = status;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	public ResponseInfo(int statusCode, String status, String message, String path) {
		super();
		this.statusCode = statusCode;
		this.Status = status;
		this.message = message;
		this.path = path;
	}
	public ResponseInfo() {
		super();
		
	}
	@Override
	public String toString() {
		return "ResponseInfo [statusCode=" + statusCode + ", Status=" + Status + ", message=" + message + ", path="
				+ path + "]";
	}
	

}
