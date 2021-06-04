package com.pfa.pack.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pfa.pack.model.entity.Location;

@Repository
public interface LocationRepository extends JpaRepository<Location, Integer> {
	
	
	
}
