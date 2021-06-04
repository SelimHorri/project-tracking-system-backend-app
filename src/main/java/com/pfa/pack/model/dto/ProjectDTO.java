package com.pfa.pack.model.dto;

import java.util.List;

import javax.validation.constraints.NotBlank;

import org.springframework.format.annotation.DateTimeFormat;

public class ProjectDTO {
	
	@NotBlank(message = "Must not blank**")
	private String title;
	
	@NotBlank(message = "Must not blank**")
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private String startDate;
	
	@NotBlank(message = "Must not blank**")
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private String endDate;
	
	@NotBlank(message = "Must not blank**")
	private String status;
	
	private List<String> assignedEmployees;
	
	public ProjectDTO() {
		
	}
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public List<String> getAssignedEmployees() {
		return assignedEmployees;
	}

	public void setAssignedEmployees(final List<String> assignedEmployees) {
		this.assignedEmployees = assignedEmployees;
	}
	
	
	
}








