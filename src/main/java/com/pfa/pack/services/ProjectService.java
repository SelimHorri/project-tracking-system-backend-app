package com.pfa.pack.services;

import java.util.List;

import com.pfa.pack.models.collectionwrappers.ProjectsCollection;
import com.pfa.pack.models.dto.ChartData;
import com.pfa.pack.models.dto.ManagerProjectData;
import com.pfa.pack.models.dto.ProjectCommitInfoDTO;
import com.pfa.pack.models.dto.ProjectDTO;
import com.pfa.pack.models.entities.Project;

public interface ProjectService {
	
	public abstract ProjectsCollection findAll();
	public abstract Project findById(final Integer projectId);
	public abstract ProjectDTO findProjectDtoById(final Project project);
	public abstract Project save(final Project project);
	public abstract Project save(final ProjectDTO projectDTO);
	public abstract Project update(final Project project);
	public abstract Project update(final ProjectDTO projectDTO);
	public abstract void deleteById(final Integer projectId);
	public abstract List<ChartData> getProjectStatus();
	public abstract ProjectCommitInfoDTO findByUsernameAndProjectId(final String username, final Integer projectId);
	public abstract List<ManagerProjectData> findByEmployeeId(final int employeeId);
	
}








