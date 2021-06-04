package com.pfa.pack.service;

import com.pfa.pack.model.dto.collection.DtoCollection;
import com.pfa.pack.model.entity.Department;

public interface DepartmentService {
	
	DtoCollection<Department> findAll();
	Department findById(final Integer departmentId);
	Department save(final Department department);
	Department update(final Department department);
	void deleteById(final Integer departmentId);
	
}
