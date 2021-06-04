package com.pfa.pack.service.impl;

import java.util.Collections;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pfa.pack.exception.custom.ObjectNotFoundException;
import com.pfa.pack.model.dto.collection.DtoCollection;
import com.pfa.pack.model.entity.Department;
import com.pfa.pack.repository.DepartmentRepository;
import com.pfa.pack.service.DepartmentService;

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
	public DtoCollection<Department> findAll() {
		return new DtoCollection<>(Collections.unmodifiableList(this.rep.findAll()));
	}
	
	@Override
	public Department findById(final Integer departmentId) {
		return this.rep.findById(departmentId).orElseThrow(() -> new ObjectNotFoundException("###### NO Department object FOUND! ######"));
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
	public void deleteById(final Integer departmentId) {
		this.rep.delete(this.findById(departmentId));
	}
	
	
	
}










