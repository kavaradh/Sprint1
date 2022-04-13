package com.example.demo.controllers;

public class ErrorInfo {
	private int statusCode;
	private String Status;
	private String errors;
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
	public String getErrors() {
		return errors;
	}
	public void setMessage(String errors) {
		this.errors = errors;
	}
	
	public ErrorInfo(int statusCode, String status, String message, String path) {
		super();
		this.statusCode = statusCode;
		this.Status = status;
		this.errors = message;
		this.path = path;
	}
	public ErrorInfo() {
		super();
		
	}
	@Override
	public String toString() {
		return "ResponseInfo [statusCode=" + statusCode + ", Status=" + Status + ", errors=" + errors + ", path="
				+ path + "]";
	}
	

}
