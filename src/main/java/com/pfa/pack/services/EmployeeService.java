package com.pfa.pack.services;

import java.util.List;
import java.util.Set;

import com.pfa.pack.models.collectionwrappers.EmployeesCollection;
import com.pfa.pack.models.dto.EmployeeAssignedProject;
import com.pfa.pack.models.entities.Employee;

public interface EmployeeService {
	
	public abstract EmployeesCollection findAll();
	public abstract Employee findById(final Integer employeeId);
	public abstract Employee save(final Employee employee);
	public abstract Employee update(final Employee employee);
	public abstract void delete(final Integer employeeId);
	public abstract List<Employee> findByDepartmentId(final Integer departmentId);
	public abstract List<Employee> findByManagerId(final Integer managerId);
	public abstract Set<EmployeeAssignedProject> findByManagerIdAndProjectId(final Integer managerId, final Integer projectId);
	
}
