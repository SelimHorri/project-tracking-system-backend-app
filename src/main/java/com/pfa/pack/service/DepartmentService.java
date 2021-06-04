package com.pfa.pack.service;

import com.pfa.pack.model.dto.collection.DtoCollection;
import com.pfa.pack.model.entity.Department;

public interface DepartmentService {
	
	public abstract DtoCollection<Department> findAll();
	public abstract Department findById(final Integer departmentId);
	public abstract Department save(final Department department);
	public abstract Department update(final Department department);
	public abstract void delete(final Integer departmentId);
	
}
