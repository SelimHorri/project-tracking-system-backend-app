package com.pfa.pack.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.pfa.pack.model.entity.Employee;

import java.util.List;
import java.util.Set;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
	
	@Query(name = "List.findByDepartmentId", nativeQuery = true)
	public abstract List<Employee> findByDepartmentId(@Param("departmentId") final int departmentId);
	
	@Query(name = "List<Employee>.findByManagerId", nativeQuery = true)
	public abstract List<Employee> findByManagerId(@Param("managerId") final int managerId);
	
	@Query(name = "Set<EmployeeAssignedProject>.findByManagerIdAndProjectId", nativeQuery = true)
	Set<Integer> findByManagerIdAndProjectId(@Param("managerId") final int managerId, @Param("projectId") final int projectId);
	
	@Query(name = "Set<Employee>.findAllManagers", nativeQuery = true)
	public abstract Set<Employee> findAllManagers();

	List<Employee> getAllByEmployeeIdIn(Set<Integer> employeeIds);

}







