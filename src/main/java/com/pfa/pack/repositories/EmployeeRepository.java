package com.pfa.pack.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.pfa.pack.models.entities.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
	
	@Query(name = "List.findByDepartmentId", nativeQuery = true)
	public abstract List<Employee> findByDepartmentId(@Param("departmentId") final int departmentId);
	
}







