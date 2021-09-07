package com.pfa.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pfa.app.model.entity.Location;

@Repository
public interface LocationRepository extends JpaRepository<Location, Integer> {
	
	
	
}
