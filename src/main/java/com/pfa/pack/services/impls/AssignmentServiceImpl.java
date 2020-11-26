package com.pfa.pack.services.impls;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pfa.pack.repositories.AssignmentRepository;
import com.pfa.pack.services.AssignmentService;

@Service
@Transactional
public class AssignmentServiceImpl implements AssignmentService {
	
	private final AssignmentRepository rep;
	
	@Autowired
	public AssignmentServiceImpl(final AssignmentRepository rep) {
		this.rep = rep;
	}
	
	
	
}










