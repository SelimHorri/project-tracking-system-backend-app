package com.pfa.pack.service;

import java.util.List;

import com.pfa.pack.model.dto.ChartData;
import com.pfa.pack.model.dto.ManagerProjectData;
import com.pfa.pack.model.dto.ProjectCommitInfoDTO;
import com.pfa.pack.model.dto.ProjectDTO;
import com.pfa.pack.model.dto.collection.DtoCollection;
import com.pfa.pack.model.entity.Project;

public interface ProjectService {
	
	DtoCollection<Project> findAll();
	Project findById(final Integer projectId);
	ProjectDTO findProjectDtoById(final Project project);
	Project save(final Project project);
	Project save(final ProjectDTO projectDTO);
	Project update(final Project project);
	Project update(final Integer projectId, final ProjectDTO projectDTO);
	void deleteById(final Integer projectId);
	List<ChartData> getProjectStatus();
	ProjectCommitInfoDTO findByUsernameAndProjectId(final String username, final Integer projectId);
	List<ManagerProjectData> findByEmployeeId(final int employeeId);
	
}








