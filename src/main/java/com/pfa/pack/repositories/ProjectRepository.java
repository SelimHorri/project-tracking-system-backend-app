package com.pfa.pack.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pfa.pack.models.entities.Project;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Integer> {
	
	
	
}
