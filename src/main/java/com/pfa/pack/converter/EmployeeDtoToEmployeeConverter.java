package com.pfa.pack.converter;

import java.time.LocalDate;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.pfa.pack.model.dto.EmployeeDto;
import com.pfa.pack.model.entity.Employee;
import com.pfa.pack.model.entity.Credential;

@Component
public class EmployeeDtoToEmployeeConverter implements Converter<EmployeeDto, Employee> {
	
	@Override
	public Employee convert(final EmployeeDto source) {
		
		final Employee employee = new Employee();
		employee.setEmployeeId(Integer.parseInt(source.getEmployeeId()));
		employee.setFirstName(source.getFirstName());
		employee.setLastName(source.getLastName());
		employee.setEmail(source.getEmail());
		employee.setPhone(source.getPhone());
		employee.setHiredate(LocalDate.parse(source.getHiredate()));
		employee.setJob(source.getJob());
		employee.setSalary(Double.parseDouble(source.getSalary()));
		
		final Credential credential = new Credential();
		credential.setUsername(source.getUsername());
		credential.setPassword(source.getPassword());
		credential.setEnabled(true); // TODO hardcoded
		credential.setRole(source.getRole());
		
		employee.setCredential(credential);
		
		
		return employee;
	}
	
	
	
}












