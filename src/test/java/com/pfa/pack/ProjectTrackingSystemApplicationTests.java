package com.pfa.pack;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.pfa.pack.models.dto.EmployeeProjectData;
import com.pfa.pack.services.AssignmentService;

@SpringBootTest
public class ProjectTrackingSystemApplicationTests {
	
	@Autowired
	private AssignmentService assignmentService;
	
	@Test
	void contextLoads() {
		
	}
	
	@Test
	public void testAssignmentServiceImpl() {
		final List<EmployeeProjectData> data = this.assignmentService.findByEmployeeId(1);
		data.forEach((d) -> { 
			System.err.println(d.getFirstName());
			System.err.println(d.getLastName());
			System.err.println(d.getTitle());
			System.err.println(d.getStatus());
			assertEquals("selim", d.getFirstName().toLowerCase());
			assertEquals("horri", d.getFirstName().toLowerCase());
		});
	}
	
	
	
}







