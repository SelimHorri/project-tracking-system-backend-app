package com.pfa.pack;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.pfa.pack.service.AssignmentService;

@SpringBootTest
public class ProjectTrackingSystemApplicationTests {
	
	@Autowired
	private AssignmentService assignmentService;
	
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







