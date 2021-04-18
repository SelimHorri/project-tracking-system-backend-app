package com.pfa.pack.converters;

import com.pfa.pack.models.dto.EmployeeAssignedProjectDto;
import com.pfa.pack.models.entities.Employee;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class EmployeeAssignedProjectConverter implements Converter<List<Employee>, List<EmployeeAssignedProjectDto>> {
	
	@Override
	public List<EmployeeAssignedProjectDto> convert(final List<Employee> source) {
		final List<EmployeeAssignedProjectDto> emps = new ArrayList<>();
		source.forEach(c -> emps.add(new EmployeeAssignedProjectDto(c.getEmployeeId(), c.getFirstName() + " " + c.getLastName(), false )));
		return emps;
	}

}










