package com.pfa.pack.service.impl;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pfa.pack.converter.ProjectDtoProjectConverter;
import com.pfa.pack.converter.ProjectProjectDtoConverter;
import com.pfa.pack.exception.custom.ObjectNotFoundException;
import com.pfa.pack.model.dto.ChartData;
import com.pfa.pack.model.dto.ManagerProjectData;
import com.pfa.pack.model.dto.ProjectCommitInfoDTO;
import com.pfa.pack.model.dto.ProjectDTO;
import com.pfa.pack.model.dto.collection.DtoCollection;
import com.pfa.pack.model.entity.Project;
import com.pfa.pack.repository.ProjectRepository;
import com.pfa.pack.service.ProjectService;

@Service
@Transactional
public class ProjectServiceImpl implements ProjectService {
	
	private final ProjectRepository rep;
	private final ProjectDtoProjectConverter projectDtoProjectConverter;
	private final ProjectProjectDtoConverter projectProjectDtoConverter;
	private static final Logger logger = LoggerFactory.getLogger(ProjectServiceImpl.class);
	
	static {
		logger.info("************ entering " + ProjectServiceImpl.class.getName() + " ************");
	}
	
	@Autowired
	public ProjectServiceImpl(final ProjectRepository rep, final ProjectDtoProjectConverter projectDtoProjectConverter, final ProjectProjectDtoConverter projectProjectDtoConverter) {
		this.rep = rep;
		this.projectDtoProjectConverter = projectDtoProjectConverter;
		this.projectProjectDtoConverter = projectProjectDtoConverter;
	}
	
	@Override
	public DtoCollection<Project> findAll() {
		return new DtoCollection<>(Collections.unmodifiableList(this.rep.findAll()));
	}
	
	@Override
	public Project findById(final Integer projectId) {
		return this.rep.findById(projectId).orElseThrow(() -> new ObjectNotFoundException("###### NO Project object FOUND! ######"));
	}
	
	@Override
	public ProjectDTO findProjectDtoById(final Project project) {
		return this.projectProjectDtoConverter.convert(project);
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
	public Project update(final Integer projectId, final ProjectDTO projectDTO) {
		final Project project = this.findById(projectId);
		project.setTitle(projectDTO.getTitle());
		project.setStartDate(LocalDate.parse(projectDTO.getStartDate()));
		project.setEndDate(LocalDate.parse(projectDTO.getEndDate()));
		project.setStatus(projectDTO.getStatus());
		return this.rep.save(project);
	}
	
	@Override
	public void deleteById(final Integer projectId) {
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
		return this.rep.findByUsernameAndProjectId(username, projectId).orElseThrow(() -> new ObjectNotFoundException("###### NO ProjectCommitInfoDTO object FOUND! ######"));
	}
	
	@Override
	public List<ManagerProjectData> findByEmployeeId(int employeeId) {
		return this.rep.findByEmployeeId(employeeId);
	}
	
	
	
}










