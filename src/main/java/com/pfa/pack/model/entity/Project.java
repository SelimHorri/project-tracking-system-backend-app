package com.pfa.pack.model.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Collections;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;

@Entity
@Table(name = "projects")
public final class Project implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "project_id", unique = true, nullable = false, precision = 10)
	private Integer projectId;
	
	@NotBlank(message = "Must not blank*")
	@Column(name = "title", length = 200)
	private String title;
	
	@DateTimeFormat(pattern = "dd-MM-yyyy")
	@JsonFormat(shape = Shape.STRING, pattern = "dd-MM-yyyy")
	@JsonSerialize(using = LocalDateSerializer.class)
	@JsonDeserialize(using = LocalDateDeserializer.class)
	@Column(name = "start_date")
	private LocalDate startDate;
	
	@DateTimeFormat(pattern = "dd-MM-yyyy")
	@JsonFormat(shape = Shape.STRING, pattern = "dd-MM-yyyy")
	@JsonSerialize(using = LocalDateSerializer.class)
	@JsonDeserialize(using = LocalDateDeserializer.class)
	@Column(name = "end_date")
	private LocalDate endDate;
	
	@NotBlank(message = "Must not blank*")
	@Column(name = "status", length = 200)
	private String status;
	
	@JsonIgnore
	@OneToMany(mappedBy = "project", cascade = CascadeType.ALL)
	private Set<Assignment> assignments;
	
	public Project() {
		
	}
	
	@Override
	public String toString() {
		return "Project [projectId=" + getProjectId() + ", title=" + title + ", startDate=" + startDate + ", endDate="
				+ endDate + ", status=" + status + "]";
	}
	
	public Integer getProjectId() {
		return projectId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(final String title) {
		this.title = title;
	}

	public LocalDate getStartDate() {
		return startDate;
	}

	public void setStartDate(final LocalDate startDate) {
		this.startDate = startDate;
	}

	public LocalDate getEndDate() {
		return endDate;
	}

	public void setEndDate(final LocalDate endDate) {
		this.endDate = endDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(final String status) {
		this.status = status;
	}

	public Set<Assignment> getAssignments() {
		return Collections.unmodifiableSet(this.assignments);
	}

	public void setAssignments(final Set<Assignment> assignments) {
		this.assignments = assignments;
	}

	public void setProjectId(Integer projectId) {
		this.projectId = projectId;
	}
	
	
	
}











