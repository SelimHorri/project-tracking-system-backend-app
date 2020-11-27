package com.pfa.pack.services;

import com.pfa.pack.models.collectionwrappers.ProjectsCollection;
import com.pfa.pack.models.entities.Project;

public interface ProjectService {
	
	public abstract ProjectsCollection findAll();
	public abstract Project findById(final Integer projectId);
	public abstract Project save(final Project project);
	public abstract Project update(final Project project);
	public abstract void delete(final Integer projectId);
	
}
