package com.pfa.pack.repositories;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.pfa.pack.models.entities.Assignment;

@Repository
public interface AssignmentRepository extends JpaRepository<Assignment, Integer> {
	
	@Query(name = "Optional.findByCompositeIds", nativeQuery = true)
	public abstract Optional<Assignment> findByCompositeIds(@Param("employeeId") final int employeeId, @Param("projectId") final int projectId, @Param("commitDate") final LocalDateTime commitDate);
	
}
