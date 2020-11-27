package com.pfa.pack.services;

import com.pfa.pack.models.collectionwrappers.EmployeesCollection;
import com.pfa.pack.models.entities.Employee;

public interface EmployeeService {
	
	public abstract EmployeesCollection findAll();
	public abstract Employee findById(final Integer employeeId);
	public abstract Employee save(final Employee employee);
	public abstract Employee update(final Employee employee);
	public abstract void delete(final Integer employeeId);
	
}
