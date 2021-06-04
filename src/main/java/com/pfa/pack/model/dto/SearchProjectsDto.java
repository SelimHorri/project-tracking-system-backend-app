package com.pfa.pack.model.dto;

import java.util.List;

import javax.validation.constraints.NotBlank;

public class SearchProjectsDto {
	
	// @NotBlank(message = "*Must not blank**")
	private String projectId;
	
	@NotBlank(message = "*Must not blank**")
	private String commitDateFrom;
	
	@NotBlank(message = "*Must not blank**")
	private String commitDateTo;
	private List<ManagerProjectData> dataProjects;
	
	public SearchProjectsDto() {
		
	}
	
	@Override
	public String toString() {
		return "SearchProjectsDto [projectId=" + projectId + ", commitDateFrom=" + commitDateFrom + ", commitDateTo="
				+ commitDateTo + ", dataProjects=" + dataProjects + "]";
	}
	
	public String getProjectId() {
		return projectId;
	}
	
	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}
	
	public String getCommitDateFrom() {
		return commitDateFrom;
	}
	
	public void setCommitDateFrom(String commitDateFrom) {
		this.commitDateFrom = commitDateFrom;
	}
	
	public String getCommitDateTo() {
		return commitDateTo;
	}
	
	public void setCommitDateTo(String commitDateTo) {
		this.commitDateTo = commitDateTo;
	}
	
	public List<ManagerProjectData> getDataProjects() {
		return dataProjects;
	}
	
	public void setDataProjects(List<ManagerProjectData> dataProjects) {
		this.dataProjects = dataProjects;
	}
	
	
	
}








