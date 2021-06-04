package com.pfa.pack.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.pfa.pack.model.dto.EmployeeAssignedProjectDto;
import com.pfa.pack.model.entity.Employee;

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










