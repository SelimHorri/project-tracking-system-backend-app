package com.pfa.pack.model.collection;

import java.io.Serializable;
import java.util.List;

import com.pfa.pack.model.entity.Employee;

public final class EmployeesCollection implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private List<Employee> employees;
	
	public EmployeesCollection() {
		
	}
	
	public EmployeesCollection(final List<Employee> employees) {
		this.employees = employees;
	}
	
	public List<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(final List<Employee> employees) {
		this.employees = employees;
	}
	
	
	
}








