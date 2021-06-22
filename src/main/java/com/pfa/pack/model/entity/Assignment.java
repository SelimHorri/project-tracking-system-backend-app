package com.pfa.pack.model.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import com.pfa.pack.model.id.AssignmentId;

@Entity
@Table(name = "assignments")
@IdClass(AssignmentId.class)
public final class Assignment implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "employee_id")
	private Integer employeeId;
	
	@Id
	@Column(name = "project_id")
	private Integer projectId;
	
	@Id
	@DateTimeFormat(pattern = "dd-MM-yyyyHH:mm:ss")
	@JsonFormat(shape = Shape.STRING, pattern = "dd-MM-yyyyHH:mm:ss")
	@JsonSerialize(using = LocalDateTimeSerializer.class)
	@JsonDeserialize(using = LocalDateTimeDeserializer.class)
	@Column(name = "commit_date", unique = true, nullable = false)
	private LocalDateTime commitDate; // = LocalDateTime.now();
	
	@Column(name = "commit_emp_desc", length = 200)
	private String commitEmpDesc;
	
	@Column(name = "commit_mgr_desc", length = 200)
	private String commitMgrDesc;
	
	// @Id
	@ManyToOne(optional = false)
	@JoinColumn(name = "employee_id", nullable = false, insertable = false, updatable = false) // cause of the primary key in Employee entity must be NOT NULL
	private Employee employee;
	
	// @Id
	@ManyToOne(optional = false)
	@JoinColumn(name = "project_id", nullable = false, insertable = false, updatable = false) // cause of the primary key in Project entity must be NOT NULL
	private Project project;
	
	public Assignment() {
		
	}
	
	@Override
	public String toString() {
		return "Assignment [employeeId=" + getEmployeeId() + ", projectId=" + getProjectId() + ", commitDate=" + commitDate
				+ ", commitEmpDesc=" + commitEmpDesc + ", commitMgrDesc=" + commitMgrDesc + ", employeeId=" + employee.getEmployeeId()
				+ ", projectId=" + project.getProjectId() + "]";
	}
	
	public void setEmployeeId(final Integer employeeId) {
		this.employeeId = employeeId;
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

	public String getCommitEmpDesc() {
		return commitEmpDesc;
	}

	public void setCommitEmpDesc(final String commitEmpDesc) {
		this.commitEmpDesc = commitEmpDesc;
	}

	public String getCommitMgrDesc() {
		return commitMgrDesc;
	}

	public void setCommitMgrDesc(final String commitMgrDesc) {
		this.commitMgrDesc = commitMgrDesc;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(final Employee employee) {
		this.employee = employee;
	}

	public Project getProject() {
		return project;
	}

	public void setProject(final Project project) {
		this.project = project;
	}

	public Integer getEmployeeId() {
		return employeeId;
	}

	public Integer getProjectId() {
		return projectId;
	}
	
	
	
}










