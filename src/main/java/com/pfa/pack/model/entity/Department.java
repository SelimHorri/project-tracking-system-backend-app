package com.pfa.pack.model.entity;

import java.io.Serializable;
import java.util.Collections;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "departments")
public final class Department implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "department_id", unique = true, nullable = false, precision = 10)
	private Integer departmentId;
	
	@NotBlank(message = "*Must not blank**")
	@Column(name = "department_name", length = 200)
	private String departmentName;
	
	@NotNull(message = "*Must not NULL**")
	@ManyToOne
	@JoinColumn(name = "location_id")
	private Location location;
	
	@JsonIgnore
	@OneToMany(mappedBy = "department", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Set<Employee> employees;
	
	public Department() {
		
	}
	
	@Override
	public String toString() {
		return "Department [departmentId=" + getDepartmentId() + ", departmentName=" + departmentName + ", location="
				+ this.location + "]";
	}
	
	public Integer getDepartmentId() {
		return departmentId;
	}
	
	public void setDepartmentId(final Integer departmentId) {
		this.departmentId = departmentId;
	}
	
	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(final String departmentName) {
		this.departmentName = departmentName;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(final Location location) {
		this.location = location;
	}

	public Set<Employee> getEmployees() {
		return Collections.unmodifiableSet(this.employees);
	}

	public void setEmployees(final Set<Employee> employees) {
		this.employees = employees;
	}
	
	
	
}














