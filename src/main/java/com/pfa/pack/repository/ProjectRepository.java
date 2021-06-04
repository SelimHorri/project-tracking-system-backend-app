package com.pfa.pack.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.pfa.pack.model.dto.ChartData;
import com.pfa.pack.model.dto.ManagerProjectData;
import com.pfa.pack.model.dto.ProjectCommitInfoDTO;
import com.pfa.pack.model.entity.Project;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Integer> {
	
	@Query(name = "List.getProjectStatus", nativeQuery = true)
	public abstract List<ChartData> getProjectStatus();
	
	@Query(name = "ProjectCommitInfoDTO.findByUsernameAndProjectId", nativeQuery = true)
	public abstract Optional<ProjectCommitInfoDTO> findByUsernameAndProjectId(@Param("username") final String username, @Param("projectId") final int projectId);
	
	@Query(name = "List<ManagerProjectData>.findByEmployeeId", nativeQuery = true)
	public abstract List<ManagerProjectData> findByEmployeeId(@Param("employeeId") final int employeeId);
	
}








