package com.pfa.pack.models.dto;

public class EmployeeAssignedProjectDto {
	
	private Integer employeeId;
	private Integer projectId;
	private String fullName;
	private Boolean verif;
	
	public EmployeeAssignedProjectDto() {
		
	}
	
	public EmployeeAssignedProjectDto(Integer employeeId, Integer projectId, String fullName, Boolean verif) {
		this.employeeId = employeeId;
		this.projectId = projectId;
		this.fullName = fullName;
		this.verif = verif;
	}
	
	public Integer getEmployeeId() {
		return employeeId;
	}
	
	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
	}
	
	public Integer getProjectId() {
		return projectId;
	}
	
	public void setProjectId(Integer projectId) {
		this.projectId = projectId;
	}
	
	public String getFullName() {
		return fullName;
	}
	
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	
	public Boolean getVerif() {
		return verif;
	}
	
	public void setVerif(Boolean verif) {
		this.verif = verif;
	}
	
	
	
}









