package com.pfa.pack.model.dto;

import java.time.LocalDateTime;

import org.springframework.format.annotation.DateTimeFormat;

public interface ProjectCommit {
	
	public abstract Integer getEmployeeId();
	public abstract String getFirstName();
	public abstract String getLastName();
	public abstract Integer getProjectId();
	
	@DateTimeFormat(pattern = "dd-MM-yyyyHH:mm:ss")
	public abstract LocalDateTime getCommitDate();
	
	public abstract String getCommitEmpDesc();
	public abstract String getCommitMgrDesc();
	
}








