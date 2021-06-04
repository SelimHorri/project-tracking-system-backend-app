package com.pfa.pack.repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.pfa.pack.model.dto.EmployeeProjectData;
import com.pfa.pack.model.dto.ProjectCommit;
import com.pfa.pack.model.entity.Assignment;
import com.pfa.pack.model.id.AssignmentId;

@Repository
public interface AssignmentRepository extends JpaRepository<Assignment, AssignmentId> {
	
	@Query(name = "List.findByEmployeeId", nativeQuery = true)
	List<EmployeeProjectData> findByEmployeeId(@Param("employeeId") final int employeeId);
	
	@Query(name = "List.findByProjectId", nativeQuery = true)
	List<ProjectCommit> findByProjectId(@Param("projectId") final int projectId);
	
	@Query(name = "List.findByEmployeeIdAndProjectId", nativeQuery = true)
	List<ProjectCommit> findByEmployeeIdAndProjectId(@Param("employeeId") final int employeeId, @Param("projectId") final int projectId);
	
	@Modifying
	@Query(name = "void.deleteByProjectId", nativeQuery = true)
	void deleteByProjectId(@Param("projectId") final int projectId);
	
	@Query(name = "ProjectCommit.findByEmployeeIdAndProjectIdAndCommitDate", nativeQuery = true)
	Optional<ProjectCommit> findByEmployeeIdAndProjectIdAndCommitDate(@Param("employeeId") final int employeeId, @Param("projectId") final int projectId, @Param("commitDate") final LocalDateTime commitDate);
	
	@Query(name = "Set<ProjectCommit>.findByProjectIdAndCommitDateFromAndCommitDateTo", nativeQuery = true)
	Set<ProjectCommit> findByProjectIdAndCommitDateFromAndCommitDateTo(@Param("projectId") final int projectId, @Param("commitDateFrom") final LocalDate commitDateFrom, @Param("commitDateTo") final LocalDate commitDateTo);
	
}






