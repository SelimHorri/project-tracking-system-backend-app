package com.pfa.pack.models.collectionwrappers;

import java.io.Serializable;
import java.util.List;

import com.pfa.pack.models.entities.Project;

public final class ProjectsCollection implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private List<Project> projects;
	
	public ProjectsCollection() {
		
	}
	
	public ProjectsCollection(final List<Project> projects) {
		this.projects = projects;
	}
	
	public List<Project> getProjects() {
		return projects;
	}

	public void setProjects(final List<Project> projects) {
		this.projects = projects;
	}
	
	
	
}








