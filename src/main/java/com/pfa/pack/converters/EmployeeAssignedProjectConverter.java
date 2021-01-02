package com.pfa.pack.converters;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.pfa.pack.models.dto.EmployeeAssignedProject;
import com.pfa.pack.models.dto.EmployeeAssignedProjectDto;

@Component
public class EmployeeAssignedProjectConverter implements Converter<Set<EmployeeAssignedProject>, List<EmployeeAssignedProjectDto>> {
	
	@Override
	public List<EmployeeAssignedProjectDto> convert(final Set<EmployeeAssignedProject> source) {
		
		final List<EmployeeAssignedProjectDto> emps = new ArrayList<>();
		source.forEach((c) -> {
			emps.add(new EmployeeAssignedProjectDto(c.getEmployeeId(), c.getProjectId(), c.getFirstName() + " " + c.getLastName(), (c.getVerif() == 1) ? true : false ));
		});
		
		return emps;
	}
	
	
	
}










