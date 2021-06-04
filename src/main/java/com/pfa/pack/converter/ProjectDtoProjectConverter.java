package com.pfa.pack.converter;

import java.time.LocalDate;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.pfa.pack.model.dto.ProjectDTO;
import com.pfa.pack.model.entity.Project;

@Component
public class ProjectDtoProjectConverter implements Converter<ProjectDTO, Project> {
	
	@Override
	public Project convert(final ProjectDTO source) {
		
		final Project project = new Project();
		project.setTitle(source.getTitle());
		project.setStartDate(LocalDate.parse(source.getStartDate()));
		project.setEndDate(LocalDate.parse(source.getEndDate()));
		project.setStatus(source.getStatus());
		
		return project;
	}
	
	
	
}







