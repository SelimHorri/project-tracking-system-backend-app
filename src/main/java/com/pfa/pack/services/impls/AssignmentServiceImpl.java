package com.pfa.pack.services.impls;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pfa.pack.models.collectionwrappers.AssignmentsCollection;
import com.pfa.pack.models.dto.EmployeeProjectData;
import com.pfa.pack.models.entities.Assignment;
import com.pfa.pack.repositories.AssignmentRepository;
import com.pfa.pack.services.AssignmentService;

@Service
@Transactional
public class AssignmentServiceImpl implements AssignmentService {
	
	private final AssignmentRepository rep;
	private static final Logger logger = LoggerFactory.getLogger(AssignmentServiceImpl.class);
	
	static {
		logger.info("************ entering " + AssignmentServiceImpl.class.getName() + " ************");
	}
	
	@Autowired
	public AssignmentServiceImpl(final AssignmentRepository rep) {
		this.rep = rep;
	}
	
	@Override
	public AssignmentsCollection findAll() {
		return new AssignmentsCollection(Collections.unmodifiableList(this.rep.findAll()));
	}
	
	@Override
	public Assignment findByCompositeIds(final Integer employeeId, final Integer projectId, final LocalDateTime commitDate) {
		return this.rep.findByCompositeIds(employeeId, projectId, commitDate).orElseThrow(() -> new NoSuchElementException("\\n------------ NO ELEMENT FOUND !!!!! ------------\\n"));
	}
	
	@Override
	public Assignment save(final Assignment assignment) {
		return this.rep.save(assignment);
	}
	
	@Override
	public Assignment update(final Assignment assignment) {
		return this.rep.save(assignment);
	}
	
	@Override
	public void delete(final Integer employeeId, final Integer projectId, final LocalDateTime commitDate) {
		this.rep.delete(this.findByCompositeIds(employeeId, projectId, commitDate));
	}
	
	@Override
	public List<EmployeeProjectData> findByEmployeeId(final Integer employeeId) {
		return this.rep.findByEmployeeId(employeeId);
	}
	
	
	
}










