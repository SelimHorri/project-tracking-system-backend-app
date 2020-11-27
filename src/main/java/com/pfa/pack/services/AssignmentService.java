package com.pfa.pack.services;

import java.time.LocalDateTime;

import com.pfa.pack.models.collectionwrappers.AssignmentsCollection;
import com.pfa.pack.models.entities.Assignment;

public interface AssignmentService {
	
	public abstract AssignmentsCollection findAll();
	public abstract Assignment findByCompositeIds(final Integer employeeId, final Integer projectId, final LocalDateTime commitDate);
	public abstract Assignment save(final Assignment assignment);
	public abstract Assignment update(final Assignment assignment);
	public abstract void delete(final Integer employeeId, final Integer projectId, final LocalDateTime commitDate);
	
}
