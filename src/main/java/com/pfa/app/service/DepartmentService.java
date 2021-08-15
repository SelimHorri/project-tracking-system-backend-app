package com.pfa.app.service;

import com.pfa.app.model.dto.collection.DtoCollection;
import com.pfa.app.model.entity.Department;

public interface DepartmentService {
	
	DtoCollection<Department> findAll();
	Department findById(final Integer departmentId);
	Department save(final Department department);
	Department update(final Department department);
	void deleteById(final Integer departmentId);
	
}
