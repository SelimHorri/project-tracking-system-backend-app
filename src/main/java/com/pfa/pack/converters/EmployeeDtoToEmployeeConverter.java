package com.pfa.pack.converters;

import java.time.LocalDate;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.pfa.pack.models.dto.EmployeeDto;
import com.pfa.pack.models.entities.Employee;
import com.pfa.pack.models.entities.UserCredential;

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
		
		final UserCredential userCredential = new UserCredential();
		userCredential.setUsername(source.getUsername());
		userCredential.setPassword(source.getPassword());
		userCredential.setEnabled(true); // TODO hardcoded
		userCredential.setRole(source.getRole());
		
		employee.setUserCredential(userCredential);
		
		
		return employee;
	}
	
	
	
}












