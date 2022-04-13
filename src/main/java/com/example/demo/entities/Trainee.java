package com.example.demo.entities;

import javax.persistence.Entity;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.persistence.Id;
@Entity
public class Trainee {
	@Id
	@NotNull(message="trainee Id cannot be empty, its a mandatory feild!!!")
	private int id;
	@NotEmpty(message="trainee name cannot be empty,its mandatory feild!!!")
	private String traineeName;
	@NotEmpty(message="trainee domain cannot be empty,its mandatory feild!!!")
	private String traineeDomain;
	private String traineeLocation;
	public Trainee(){}
	public int getId() {
	return id;
	}
	public void setId(int id) {
	this.id = id;
	}
	public String getTraineeName() {
	return traineeName;
	}
	public void setTraineeName(String traineeName) {
	this.traineeName = traineeName;
	}
	public String getTraineeDomain() {
	return traineeDomain;
	}
	public void setTraineeDomain(String traineeDomain) {
	this.traineeDomain = traineeDomain;
	}
	public String getTraineeLocation() {
	return traineeLocation;
	}
	public void setTraineeLocation(String traineeLocation) {
	this.traineeLocation = traineeLocation;
	}
	@Override
	public String toString() {
	return "Trainee [id=" + id + ", traineeName=" + traineeName + ", traineeDomain=" + traineeDomain
	+ ", traineeLocation=" + traineeLocation + "]";
	}
	public Trainee(int id, String traineeName, String traineeDomain, String traineeLocation) {
	super();
	this.id = id;
	this.traineeName = traineeName;
	this.traineeDomain = traineeDomain;
	this.traineeLocation = traineeLocation;
	}


}
