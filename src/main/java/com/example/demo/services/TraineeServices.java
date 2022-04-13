package com.example.demo.services;

import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.example.demo.entities.Trainee;
import com.example.demo.exceptions.IdNotFoundException;
import com.example.demo.exceptions.NameNotFoundException;
import com.example.demo.repository.TraineeRepository;
import com.example.demo.exceptions.IdNotFoundException;

@Service
@Transactional
public class TraineeServices {
	@Autowired
	private TraineeRepository traineeRepository;
	

	public List<Trainee> fetchAllTrainee(){
	return traineeRepository.findAll();
	}
	
	public Trainee fetchById(@PathVariable("id") int eid) {
	Optional<Trainee> tra=traineeRepository.findById(eid);
	if(tra.isPresent())
		return tra.get();
	else 
		throw new IdNotFoundException("Record not found with that id: "+eid);

	}
	
	public Trainee fetchByName(@PathVariable("name") String ename) {
		Optional<Trainee> tra=traineeRepository.findByTraineeName(ename);
		if(tra.isPresent())
			return tra.get();
		else 
			throw new NameNotFoundException("record not found with the name: "+ename);

	}
	
	public String deleteById(@PathVariable("id") int eid) {
		Optional<Trainee> tra=traineeRepository.findById(eid);
		if(tra.isPresent()) {
		traineeRepository.deleteById(eid);
	    return "deleted successfully";
		}
		else
			throw new IdNotFoundException("No record found with this id: "+eid);
	}
	public String deleteByName(@PathVariable("name") String ename) {
				traineeRepository.deleteByTraineeName(ename);
				return "deleted successfully";
		
	}
	
    public String updateTrainee(Trainee trainee) {
    	Trainee updatedTra=traineeRepository.save(trainee);
    	if(updatedTra!=null)
    		return "updated Successfully";
    	else
    		return "Not updated successfully";
		
	}

	
	public String insertTrainee(Trainee trainee) {
	Trainee savedTra=traineeRepository.save(trainee);
	if(savedTra!=null)
		return "Saved Successfully";
	else
		return "Not Saved successfully";

	}

}
