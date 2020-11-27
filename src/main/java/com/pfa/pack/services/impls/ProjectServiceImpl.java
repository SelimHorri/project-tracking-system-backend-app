package com.pfa.pack.services.impls;

import java.util.Collections;
import java.util.NoSuchElementException;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pfa.pack.models.collectionwrappers.ProjectsCollection;
import com.pfa.pack.models.entities.Project;
import com.pfa.pack.repositories.ProjectRepository;
import com.pfa.pack.services.ProjectService;

@Service
@Transactional
public class ProjectServiceImpl implements ProjectService {
	
	private final ProjectRepository rep;
	
	@Autowired
	public ProjectServiceImpl(final ProjectRepository rep) {
		this.rep = rep;
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
	public Project update(final Project project) {
		return this.rep.save(project);
	}
	
	@Override
	public void delete(final Integer projectId) {
		this.rep.delete(this.findById(projectId));
	}
	
	
	
}










