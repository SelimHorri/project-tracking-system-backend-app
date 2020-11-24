package com.pfa.pack.models.entities;

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

@Entity(name = "assignments")
@Table(name = "assignments")
@IdClass(Assignment.AssignmentId.class)
public class Assignment implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	/**
	 * IdClass for primary key when using JPA annotations
	 */
	public class AssignmentId implements Serializable {
		java.time.LocalDate commitDate;
	}
	
	@ManyToOne(optional = false)
	@JoinColumn(name = "employee_id", nullable = false)
	private Employee employee;
	
	@ManyToOne(optional = false)
	@JoinColumn(name = "project_id", nullable = false)
	private Project project;
	
	@Id
	@DateTimeFormat(pattern = "dd/MM/yyyy HH:mm:ss")
	@JsonFormat(shape = Shape.STRING, pattern = "dd/MM/yyyy HH:mm:ss")
	@JsonSerialize(using = LocalDateTimeSerializer.class)
	@JsonDeserialize(using = LocalDateTimeDeserializer.class)
	@Column(name = "commit_date", nullable = false)
	private LocalDateTime commitDate;
	
	@Column(name = "commit_emp_desc", length = 200)
	private String commitEmpDesc;
	
	@Column(name = "commit_mgr_desc", length = 200)
	private String commitMgrDesc;
	
	public Assignment() {
		
	}
	
	
	
}
