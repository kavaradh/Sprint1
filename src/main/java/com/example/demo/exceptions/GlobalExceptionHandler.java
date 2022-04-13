package com.example.demo.exceptions;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.demo.controllers.ErrorInfo;
@RestControllerAdvice
public class GlobalExceptionHandler {
	@ExceptionHandler(MethodArgumentNotValidException.class)
	ResponseEntity<ErrorInfo> myExceptionHandler(MethodArgumentNotValidException ie,HttpServletRequest req)
	{
		Map<String,String> m=new LinkedHashMap<>();
		List<ObjectError> listErrors=ie.getAllErrors();
		listErrors.forEach(obj->{
			FieldError fe=(FieldError)obj;
			m.put(fe.getField(),fe.getDefaultMessage());
		});
		ErrorInfo rinfo= new ErrorInfo(HttpStatus.BAD_REQUEST.value(),HttpStatus.BAD_REQUEST.name(),m.toString(),req.getRequestURI());
		return new ResponseEntity<ErrorInfo>(rinfo, HttpStatus.BAD_REQUEST);
	}
	@ExceptionHandler(Exception.class)
	ResponseEntity<ErrorInfo> myExceptionHandler(Exception ie,HttpServletRequest req)
	{
		ErrorInfo rinfo= new ErrorInfo(HttpStatus.NOT_FOUND.value(),HttpStatus.NOT_FOUND.name(),ie.getMessage(),req.getRequestURI());
		return new ResponseEntity<ErrorInfo>(rinfo, HttpStatus.NOT_FOUND);
	}
}

