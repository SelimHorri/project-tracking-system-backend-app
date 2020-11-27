package com.pfa.pack.services;

import com.pfa.pack.models.collectionwrappers.DepartmentsCollection;
import com.pfa.pack.models.entities.Department;

public interface DepartmentService {
	
	public abstract DepartmentsCollection findAll();
	public abstract Department findById(final Integer departmentId);
	public abstract Department save(final Department department);
	public abstract Department update(final Department department);
	public abstract void delete(final Integer departmentId);
	
}
