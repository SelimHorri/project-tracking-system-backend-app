package com.pfa.pack.model.dto;

public class EmployeeAssignedProjectDto {
	
	private Integer employeeId;
	// private Integer projectId;
	private String fullName;
	private Boolean verif;
	
	public EmployeeAssignedProjectDto() {
		
	}
	
	public EmployeeAssignedProjectDto(Integer employeeId, String fullName, Boolean verif) {
		this.employeeId = employeeId;
		this.fullName = fullName;
		this.verif = verif;
	}
	
	public Integer getEmployeeId() {
		return employeeId;
	}
	
	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
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









