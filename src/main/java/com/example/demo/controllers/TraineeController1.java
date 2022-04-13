package com.example.demo.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import com.example.demo.services.TraineeServices;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Trainee;

@RestController
public class TraineeController1 {
	@Autowired
	private TraineeServices traineeServices;
     @Operation(summary="All the trainees fetched!!!!")
	 @GetMapping("/trainees")
	List<Trainee> fetchAllTrainee(){
	return traineeServices.fetchAllTrainee();
	}
     @ApiResponses(value= {
    		 @ApiResponse(
    				 responseCode="404",
    				 description="This id is not found",
    				 content= {
    						 
    					@Content(
    							mediaType="application/json",schema=@Schema(implementation=ErrorInfo.class)
    							)			 
    				 }
    				 ),
    		 @ApiResponse(
    				 responseCode="200",
    				 description="Trainee entity data",
    				 content= {
    						 
    					@Content(
    							mediaType="application/json",schema=@Schema(implementation=Trainee.class)
    							)			 
    				 }
    				 )
     })
	@GetMapping("/trainees/{id}")
	Trainee fetchById(@PathVariable("id") int eid) {
	return traineeServices.fetchById(eid);

	}
	@GetMapping("/trainees/name/{name}")
	Trainee fetchByName(@PathVariable("name") String ename) {
	return traineeServices.fetchByName(ename);

	}
	@DeleteMapping("/trainees/{id}")
	ResponseEntity<ResponseInfo> deleteById(@PathVariable("id") int eid,HttpServletRequest req) {
	String msg=traineeServices.deleteById(eid);
	ResponseInfo res=new ResponseInfo(HttpStatus.ACCEPTED.value(),HttpStatus.ACCEPTED.name(),msg,req.getRequestURI());
	return new ResponseEntity<ResponseInfo>(res,HttpStatus.ACCEPTED);
	}
	@DeleteMapping("/trainees/traineeName/{name}")
	ResponseEntity<ResponseInfo> deleteByName(@PathVariable("name") String ename,HttpServletRequest req) {
		String msg= traineeServices.deleteByName(ename);
		ResponseInfo res=new ResponseInfo(HttpStatus.ACCEPTED.value(),HttpStatus.ACCEPTED.name(),msg,req.getRequestURI());
		return new ResponseEntity<ResponseInfo>(res,HttpStatus.ACCEPTED);
	}
	@PutMapping("/trainees")
    ResponseEntity<ResponseInfo> updateTrainee(@RequestBody Trainee tra,HttpServletRequest req) {
		String msg= traineeServices.updateTrainee(tra);
		ResponseInfo res=new ResponseInfo(HttpStatus.ACCEPTED.value(),HttpStatus.ACCEPTED.name(),msg,req.getRequestURI());
		return new ResponseEntity<ResponseInfo>(res,HttpStatus.ACCEPTED);
	}
	
	@PostMapping("/trainees")
	ResponseEntity<ResponseInfo> insertTrainee(@Valid @RequestBody Trainee tra,HttpServletRequest req) {
		String msg= traineeServices.insertTrainee(tra);
		ResponseInfo res=new ResponseInfo(HttpStatus.CREATED.value(),HttpStatus.CREATED.name(),msg,req.getRequestURI());
        return new ResponseEntity<ResponseInfo>(res,HttpStatus.CREATED);
	}

	

}
