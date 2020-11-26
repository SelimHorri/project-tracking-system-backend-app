package com.pfa.pack.services.impls;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
	
	
	
}










