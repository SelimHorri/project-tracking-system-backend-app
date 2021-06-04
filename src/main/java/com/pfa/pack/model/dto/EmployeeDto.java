package com.pfa.pack.model.dto;

import java.io.Serializable;

import com.pfa.pack.model.entity.Employee;

public class EmployeeDto implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private String employeeId;
	private String firstName;
	private String lastName;
	private String email;
	private String phone;
	private String hiredate;
	private String job;
	private String salary;
	private String managerId;
	private String username;
	private String password;
	private String role;
	
	public EmployeeDto() {
		
	}
	
	public EmployeeDto(final Employee employee) {
		this.employeeId = String.valueOf(employee.getEmployeeId());
		this.firstName = employee.getFirstName();
		this.lastName = employee.getLastName();
		this.email = employee.getEmail();
		this.phone = employee.getPhone();
		this.hiredate = employee.getHiredate().toString();
		this.job = employee.getJob();
		this.salary = String.valueOf(employee.getSalary());
		this.managerId = String.valueOf(employee.getManager().getEmployeeId());
		this.username = employee.getCredential().getUsername();
		this.password = employee.getCredential().getPassword();
		this.role = employee.getCredential().getRole();
	}
	
	@Override
	public String toString() {
		return "EmployeeDto [employeeId=" + employeeId + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", email=" + email + ", phone=" + phone + ", hiredate=" + hiredate + ", job=" + job + ", salary="
				+ salary + ", managerId=" + managerId + ", username=" + username + ", password=" + password + ", role="
				+ role + "]";
	}
	
	public String getEmployeeId() {
		return employeeId;
	}
	
	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getPhone() {
		return phone;
	}
	
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	public String getHiredate() {
		return hiredate;
	}
	
	public void setHiredate(String hiredate) {
		this.hiredate = hiredate;
	}
	
	public String getJob() {
		return job;
	}
	
	public void setJob(String job) {
		this.job = job;
	}
	
	public String getSalary() {
		return salary;
	}
	
	public void setSalary(String salary) {
		this.salary = salary;
	}
	
	public String getManagerId() {
		return managerId;
	}
	
	public void setManagerId(String managerId) {
		this.managerId = managerId;
	}
	
	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getRole() {
		return role;
	}
	
	public void setRole(String role) {
		this.role = role;
	}
	
	
	
}















