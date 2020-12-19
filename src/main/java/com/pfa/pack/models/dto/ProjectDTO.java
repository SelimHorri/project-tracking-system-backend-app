package com.pfa.pack.models.dto;

import javax.validation.constraints.NotBlank;

import org.springframework.format.annotation.DateTimeFormat;

public class ProjectDTO {
	
	@NotBlank(message = "Must not blank**")
	private String title;
	
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private String startDate;
	
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private String endDate;
	
	@NotBlank(message = "Must not blank**")
	private String status;
	
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
	
	
	
}








