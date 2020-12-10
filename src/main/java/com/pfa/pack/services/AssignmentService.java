package com.pfa.pack.services;

import java.time.LocalDateTime;
import java.util.List;

import com.pfa.pack.models.collectionwrappers.AssignmentsCollection;
import com.pfa.pack.models.dto.EmployeeProjectData;
import com.pfa.pack.models.dto.ProjectCommit;
import com.pfa.pack.models.entities.Assignment;

public interface AssignmentService {
	
	public abstract AssignmentsCollection findAll();
	public abstract Assignment findByCompositeIds(final Integer employeeId, final Integer projectId, final LocalDateTime commitDate);
	public abstract Assignment save(final Assignment assignment);
	public abstract Assignment update(final Assignment assignment);
	public abstract void delete(final Integer employeeId, final Integer projectId, final LocalDateTime commitDate);
	public abstract List<EmployeeProjectData> findByEmployeeId(final Integer employeeId);
	public abstract List<ProjectCommit> findByEmployeeIdAndProjectId(final Integer employeeId, final Integer projectId);
	
}
