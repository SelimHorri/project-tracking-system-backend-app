package com.pfa.pack.model.dto;

import java.util.List;

public class AssignEmployeesDto {
	
	private String projectId;
	private String title;
	private List<String> assignedEmployees;
	
	public AssignEmployeesDto() {
		
	}
	
	public AssignEmployeesDto(final String projectId, final String title, final List<String> assignedEmployees) {
		this.projectId = projectId;
		this.title = title;
		this.assignedEmployees = assignedEmployees;
	}
	
	@Override
	public String toString() {
		return "AssignEmployeesDto [projectId=" + projectId + ", title=" + title + ", assignedEmployees=" + assignedEmployees + "]";
	}
	
	public String getProjectId() {
		return projectId;
	}
	
	public void setProjectId(final String projectId) {
		this.projectId = projectId;
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public List<String> getAssignedEmployees() {
		return assignedEmployees;
	}
	
	public void setAssignedEmployees(final List<String> assignedEmployees) {
		this.assignedEmployees = assignedEmployees;
	}
	
	
	
}








