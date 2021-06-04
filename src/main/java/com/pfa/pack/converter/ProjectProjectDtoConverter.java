package com.pfa.pack.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.pfa.pack.model.dto.ProjectDTO;
import com.pfa.pack.model.entity.Project;

@Component
public class ProjectProjectDtoConverter implements Converter<Project, ProjectDTO> {
	
	@Override
	public ProjectDTO convert(final Project source) {
		
		final ProjectDTO projectDTO = new ProjectDTO();
		projectDTO.setTitle(source.getTitle());
		projectDTO.setStartDate(source.getStartDate().toString());
		projectDTO.setEndDate(source.getEndDate().toString());
		projectDTO.setStatus(source.getStatus());
		
		return projectDTO;
	}
	
	
	
}








