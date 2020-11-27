package com.pfa.pack.services.impls;

import java.util.Collections;
import java.util.NoSuchElementException;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pfa.pack.models.collectionwrappers.DepartmentsCollection;
import com.pfa.pack.models.entities.Department;
import com.pfa.pack.repositories.DepartmentRepository;
import com.pfa.pack.services.DepartmentService;

@Service
@Transactional
public class DepartmentServiceImpl implements DepartmentService {
	
	private final DepartmentRepository rep;
	private static final Logger logger = LoggerFactory.getLogger(DepartmentServiceImpl.class);
	
	static {
		logger.info("************ entering " + DepartmentServiceImpl.class.getName() + " ************");
	}
	
	@Autowired
	public DepartmentServiceImpl(final DepartmentRepository rep) {
		this.rep = rep;
	}
	
	@Override
	public DepartmentsCollection findAll() {
		return new DepartmentsCollection(Collections.unmodifiableList(this.rep.findAll()));
	}
	
	@Override
	public Department findById(final Integer departmentId) {
		return this.rep.findById(departmentId).orElseThrow(() -> new NoSuchElementException("\\n------------ NO ELEMENT FOUND !!!!! ------------\\n"));
	}
	
	@Override
	public Department save(final Department department) {
		return this.rep.save(department);
	}
	
	@Override
	public Department update(final Department department) {
		return this.rep.save(department);
	}
	
	@Override
	public void delete(final Integer departmentId) {
		this.rep.delete(this.findById(departmentId));
	}
	
	
	
}










