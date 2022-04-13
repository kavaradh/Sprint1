package com.example.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.Trainee;

@Repository
public interface TraineeRepository extends JpaRepository<Trainee, Integer> {
	Optional<Trainee> findByTraineeName(String name);
	void deleteByTraineeName(String name);

}
