package com.pfa.pack.models.collectionwrappers;

import java.io.Serializable;
import java.util.List;

import com.pfa.pack.models.entities.Department;

public final class DepartmentsCollection implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private List<Department> departments;
	
	public DepartmentsCollection() {
		
	}
	
	public DepartmentsCollection(final List<Department> departments) {
		this.departments = departments;
	}
	
	public List<Department> getDepartments() {
		return departments;
	}

	public void setDepartments(final List<Department> departments) {
		this.departments = departments;
	}
	
	
	
}








