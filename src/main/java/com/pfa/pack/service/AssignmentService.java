package com.pfa.pack.service;

import java.time.LocalDateTime;
import java.util.List;

import com.pfa.pack.model.dto.EmployeeProjectData;
import com.pfa.pack.model.dto.ProjectCommit;
import com.pfa.pack.model.dto.SearchProjectsDto;
import com.pfa.pack.model.dto.collection.DtoCollection;
import com.pfa.pack.model.entity.Assignment;

public interface AssignmentService {
	
	public abstract DtoCollection<Assignment> findAll();
	public abstract Assignment findByCompositeIds(final Integer employeeId, final Integer projectId, final LocalDateTime commitDate);
	public abstract Assignment save(final Assignment assignment);
	public abstract Assignment update(final Assignment assignment);
	public abstract void delete(final Integer employeeId, final Integer projectId, final LocalDateTime commitDate);
	public abstract List<EmployeeProjectData> findByEmployeeId(final Integer employeeId);
	public abstract List<ProjectCommit> findByProjectId(final Integer projectId);
	public abstract List<ProjectCommit> findByEmployeeIdAndProjectId(final Integer employeeId, final Integer projectId);
	public abstract void deleteByProjectId(final Integer projectId);
	public abstract ProjectCommit findByEmployeeIdAndProjectIdAndCommitDate(final Integer employeeId, final Integer projectId, final LocalDateTime commitDate);
	public abstract List<ProjectCommit> findByProjectIdAndCommitDateFromAndCommitDateTo(final SearchProjectsDto searchProjectsDto);
	
}
