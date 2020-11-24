package com.pfa.pack.models.entities;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;

@Entity
@Table(name = "employees" /*, indexes={@Index(name="employees_email_IX", columnList="email", unique=true)}*/)
public class Employee implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "employee_id", unique = true, nullable = false, precision = 10)
	private Integer employeeId;

	@Column(name = "first_name", length = 200)
	private String firstName;

	@Column(name = "last_name", length = 200)
	private String lastName;

	@Column(name = "email", unique = true, length = 200)
	private String email;

	@Column(name = "phone", length = 20)
	private String phone;
	
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@JsonFormat(shape = Shape.STRING, pattern = "dd/MM/yyyy")
	@JsonSerialize(using = LocalDateSerializer.class)
	@JsonDeserialize(using = LocalDateDeserializer.class)
	@Column(name = "hiredate")
	private LocalDate hiredate;

	@Column(name = "job", length = 200)
	private String job;

	@Column(name = "salary", precision = 7, scale = 2)
	private Double salary;

	@Column(name = "manager_id", precision = 10)
	private Integer managerId;
	
	@JsonIgnore
	@OneToMany(mappedBy = "employee")
	private Set<Assignment> assignment;

	@ManyToOne
	@JoinColumn(name = "department_id")
	private Department department;

	@OneToOne(mappedBy = "employee", fetch = FetchType.LAZY)
	private UserCredential userCredential;
	
	public Employee() {
		
	}

	
	
	
	
}













