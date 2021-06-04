package com.pfa.pack.model.id;

import java.io.Serializable;
import java.time.LocalDateTime;

public final class AssignmentId implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Integer employeeId;
	private Integer projectId;
	private LocalDateTime commitDate;
	
	public AssignmentId() {
		
	}
	
	public AssignmentId(final Integer employeeId, final Integer projectId, final LocalDateTime commitDate) {
		this.employeeId = employeeId;
		this.projectId = projectId;
		this.commitDate = commitDate;
	}
	
	public Integer getEmployeeId() {
		return employeeId;
	}
	
	public void setEmployeeId(final Integer employeeId) {
		this.employeeId = employeeId;
	}
	
	public Integer getProjectId() {
		return projectId;
	}
	
	public void setProjectId(final Integer projectId) {
		this.projectId = projectId;
	}
	
	public LocalDateTime getCommitDate() {
		return commitDate;
	}
	
	public void setCommitDate(final LocalDateTime commitDate) {
		this.commitDate = commitDate;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((commitDate == null) ? 0 : commitDate.hashCode());
		result = prime * result + ((employeeId == null) ? 0 : employeeId.hashCode());
		result = prime * result + ((projectId == null) ? 0 : projectId.hashCode());
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AssignmentId other = (AssignmentId) obj;
		if (commitDate == null) {
			if (other.commitDate != null)
				return false;
		} else if (!commitDate.equals(other.commitDate))
			return false;
		if (employeeId == null) {
			if (other.employeeId != null)
				return false;
		} else if (!employeeId.equals(other.employeeId))
			return false;
		if (projectId == null) {
			if (other.projectId != null)
				return false;
		} else if (!projectId.equals(other.projectId))
			return false;
		return true;
	}

	
	
}









