package com.pfa.pack.models.dto;

import java.util.List;

public class AssignEmployeesDto {
	
	private String projectId;
	private List<String> assignedEmployees;
	
	public AssignEmployeesDto() {
		
	}
	
	public String getProjectId() {
		return projectId;
	}
	
	public void setProjectId(final String projectId) {
		this.projectId = projectId;
	}
	
	public List<String> getAssignedEmployees() {
		return assignedEmployees;
	}
	
	public void setAssignedEmployees(final List<String> assignedEmployees) {
		this.assignedEmployees = assignedEmployees;
	}
	
	
	
}








