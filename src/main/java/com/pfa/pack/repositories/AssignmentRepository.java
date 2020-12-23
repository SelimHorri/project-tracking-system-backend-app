package com.pfa.pack.repositories;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.pfa.pack.models.dto.EmployeeProjectData;
import com.pfa.pack.models.dto.ProjectCommit;
import com.pfa.pack.models.entities.Assignment;

@Repository
public interface AssignmentRepository extends JpaRepository<Assignment, Integer> {
	
	@Query(name = "Optional.findByCompositeIds", nativeQuery = true)
	public abstract Optional<Assignment> findByCompositeIds(@Param("employeeId") final int employeeId, @Param("projectId") final int projectId, @Param("commitDate") final LocalDateTime commitDate);
	
	@Query(name = "List.findByEmployeeId", nativeQuery = true)
	public abstract List<EmployeeProjectData> findByEmployeeId(@Param("employeeId") final int employeeId);
	
	@Query(name = "List.findByProjectId", nativeQuery = true)
	public abstract List<ProjectCommit> findByProjectId(@Param("projectId") final int projectId);
	
	@Query(name = "List.findByEmployeeIdAndProjectId", nativeQuery = true)
	public abstract List<ProjectCommit> findByEmployeeIdAndProjectId(@Param("employeeId") final int employeeId, @Param("projectId") final int projectId);
	
	@Modifying
	@Query(name = "void.deleteByProjectId", nativeQuery = true)
	public abstract void deleteByProjectId(@Param("projectId") final int projectId);
	
}






