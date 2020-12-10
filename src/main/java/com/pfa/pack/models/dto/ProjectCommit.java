package com.pfa.pack.models.dto;

import java.time.LocalDateTime;

import org.springframework.format.annotation.DateTimeFormat;

public interface ProjectCommit {
	
	public abstract Integer getProjectId();
	
	@DateTimeFormat(pattern = "dd/MM/yyyy HH:mm:ss")
	public abstract LocalDateTime getCommitDate();
	
	public abstract String getCommitEmpDesc();
	public abstract String getCommitMgrDesc();
	
}








