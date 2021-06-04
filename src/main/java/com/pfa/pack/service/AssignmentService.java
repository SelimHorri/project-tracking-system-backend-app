package com.pfa.pack.service;

import java.time.LocalDateTime;
import java.util.List;

import com.pfa.pack.model.dto.EmployeeProjectData;
import com.pfa.pack.model.dto.ProjectCommit;
import com.pfa.pack.model.dto.SearchProjectsDto;
import com.pfa.pack.model.dto.collection.DtoCollection;
import com.pfa.pack.model.entity.Assignment;

public interface AssignmentService {
	
	DtoCollection<Assignment> findAll();
	Assignment findById(final Integer employeeId, final Integer projectId, final LocalDateTime commitDate);
	Assignment save(final Assignment assignment);
	Assignment update(final Assignment assignment);
	void deleteById(final Integer employeeId, final Integer projectId, final LocalDateTime commitDate);
	List<EmployeeProjectData> findByEmployeeId(final Integer employeeId);
	List<ProjectCommit> findByProjectId(final Integer projectId);
	List<ProjectCommit> findByEmployeeIdAndProjectId(final Integer employeeId, final Integer projectId);
	void deleteByProjectId(final Integer projectId);
	ProjectCommit findByEmployeeIdAndProjectIdAndCommitDate(final Integer employeeId, final Integer projectId, final LocalDateTime commitDate);
	List<ProjectCommit> findByProjectIdAndCommitDateFromAndCommitDateTo(final SearchProjectsDto searchProjectsDto);
	
}
