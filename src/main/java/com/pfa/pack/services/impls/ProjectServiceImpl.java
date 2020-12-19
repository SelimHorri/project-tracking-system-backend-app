package com.pfa.pack.services.impls;

import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pfa.pack.converters.ProjectDtoProjectConverter;
import com.pfa.pack.models.collectionwrappers.ProjectsCollection;
import com.pfa.pack.models.dto.ChartData;
import com.pfa.pack.models.dto.ManagerProjectData;
import com.pfa.pack.models.dto.ProjectCommitInfoDTO;
import com.pfa.pack.models.dto.ProjectDTO;
import com.pfa.pack.models.entities.Project;
import com.pfa.pack.repositories.ProjectRepository;
import com.pfa.pack.services.ProjectService;

@Service
@Transactional
public class ProjectServiceImpl implements ProjectService {
	
	private final ProjectRepository rep;
	private final ProjectDtoProjectConverter projectDtoProjectConverter;
	private static final Logger logger = LoggerFactory.getLogger(ProjectServiceImpl.class);
	
	static {
		logger.info("************ entering " + ProjectServiceImpl.class.getName() + " ************");
	}
	
	@Autowired
	public ProjectServiceImpl(final ProjectRepository rep, final ProjectDtoProjectConverter projectDtoProjectConverter) {
		this.rep = rep;
		this.projectDtoProjectConverter = projectDtoProjectConverter;
	}
	
	@Override
	public ProjectsCollection findAll() {
		return new ProjectsCollection(Collections.unmodifiableList(this.rep.findAll()));
	}
	
	@Override
	public Project findById(final Integer projectId) {
		return this.rep.findById(projectId).orElseThrow(() -> new NoSuchElementException("\\n------------ NO ELEMENT FOUND !!!!! ------------\\n"));
	}
	
	@Override
	public Project save(final Project project) {
		return this.rep.save(project);
	}
	
	@Override
	public Project save(final ProjectDTO projectDTO) {
		return this.rep.save(this.projectDtoProjectConverter.convert(projectDTO));
	}
	
	@Override
	public Project update(final Project project) {
		return this.rep.save(project);
	}
	
	@Override
	public void delete(final Integer projectId) {
		this.rep.delete(this.findById(projectId));
	}
	
	/**
	 * get project status for pie chart
	 * @return list of ChartData
	 */
	@Override
	public List<ChartData> getProjectStatus() {
		return this.rep.getProjectStatus();
	}
	
	@Override
	public ProjectCommitInfoDTO findByUsernameAndProjectId(final String username, final Integer projectId) {
		return this.rep.findByUsernameAndProjectId(username, projectId).orElseThrow(() -> new NoSuchElementException("\\n------------ NO PROJECT FOUND !!!!! ------------\\n"));
	}
	
	@Override
	public List<ManagerProjectData> findByEmployeeId(int employeeId) {
		return this.rep.findByEmployeeId(employeeId);
	}
	
	
	
}










