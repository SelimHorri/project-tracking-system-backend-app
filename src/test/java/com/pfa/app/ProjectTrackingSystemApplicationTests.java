package com.pfa.app;

import com.pfa.app.exception.custom.ObjectNotFoundException;
import com.pfa.app.model.entity.Location;
import com.pfa.app.service.LocationService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.pfa.app.service.AssignmentService;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class ProjectTrackingSystemApplicationTests {
	
	@Autowired
	private AssignmentService assignmentService;
	@Autowired
	private LocationService locationService;

	@Test
	void contextLoads() {
		
	}
	
	@Test
	public void testAssignmentServiceImpl() {
		/*
		final List<EmployeeProjectData> data = this.assignmentService.findByEmployeeId(1);
		data.forEach((d) -> { 
			System.err.println(d.getTitle());
			System.err.println(d.getStartDate());
			System.err.println(d.getEndDate());
			System.err.println(d.getStatus());
		});
		*/
	}

}







