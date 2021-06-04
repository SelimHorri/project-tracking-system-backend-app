package com.pfa.pack.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.pfa.pack.converter.EmployeeAssignedProjectConverter;
import com.pfa.pack.exception.custom.ObjectNotFoundException;
import com.pfa.pack.model.dto.EmployeeAssignedProjectDto;
import com.pfa.pack.model.dto.collection.DtoCollection;
import com.pfa.pack.model.entity.Employee;
import com.pfa.pack.repository.EmployeeRepository;
import com.pfa.pack.service.EmployeeService;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {
	
	private final EmployeeRepository rep;
	private final EmployeeAssignedProjectConverter employeeAssignedProjectConverter;
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	private static final Logger logger = LoggerFactory.getLogger(EmployeeServiceImpl.class);
	
	static {
		logger.info("************ entering " + EmployeeServiceImpl.class.getName() + " ************");
	}
	
	@Autowired
	public EmployeeServiceImpl(final EmployeeRepository rep, final BCryptPasswordEncoder bCryptPasswordEncoder, final EmployeeAssignedProjectConverter employeeAssignedProjectConverter) {
		this.rep = rep;
		this.employeeAssignedProjectConverter = employeeAssignedProjectConverter;
		this.bCryptPasswordEncoder = bCryptPasswordEncoder;
	}
	
	@Override
	public DtoCollection<Employee> findAll() {
		return new DtoCollection<>(Collections.unmodifiableList(this.rep.findAll()));
	}
	
	@Override
	public Employee findById(final Integer employeeId) {
		return this.rep.findById(employeeId).orElseThrow(() -> new ObjectNotFoundException("\\n------------ NO Employee object FOUND! ------------\\n"));
	}
	
	@Override
	public Employee save(final Employee employee) {
		
		employee.setDepartment(employee.getManager().getDepartment());
		employee.getUserCredential().setPassword(this.bCryptPasswordEncoder.encode(employee.getUserCredential().getPassword()));
		employee.getUserCredential().setEnabled(true);
		employee.getUserCredential().setRole("ROLE_" + employee.getUserCredential().getRole().toUpperCase());
		employee.getUserCredential().setEmployee(employee);
		
		return this.rep.save(employee);
	}
	
	@Override
	public Employee update(final Employee employee) {
		
		employee.setDepartment(employee.getManager().getDepartment());
		employee.getUserCredential().setPassword(this.bCryptPasswordEncoder.encode(employee.getUserCredential().getPassword()));
		// employee.getUserCredential().setEnabled(employee.getUserCredential().getEnabled());
		employee.getUserCredential().setEnabled(true); // TODO this is baaaaaaaaaaaaddd
		employee.getUserCredential().setRole("ROLE_" + employee.getUserCredential().getRole());
		employee.getUserCredential().setEmployee(employee);
		
		return this.rep.save(employee);
	}
	
	@Override
	public void delete(final Integer employeeId) {
		this.rep.delete(this.findById(employeeId));
	}
	
	/**
	 * @param departmentId
	 * @return a list of employees
	 */
	@Override
	public List<Employee> findByDepartmentId(final Integer departmentId) {
		return this.rep.findByDepartmentId(departmentId);
	}
	
	@Override
	public List<Employee> findByManagerId(final Integer managerId) {
		return this.rep.findByManagerId(managerId);
	}
	
	@Override
	public List<EmployeeAssignedProjectDto> findByManagerIdAndProjectId(final Integer managerId, final Integer projectId) {
		Set<Integer> byManagerIdAndProjectId = this.rep.findByManagerIdAndProjectId(managerId, projectId);
		List<Employee> allByEmployeeIdIn = this.rep.getAllByEmployeeIdIn(byManagerIdAndProjectId);
		return this.employeeAssignedProjectConverter.convert(allByEmployeeIdIn);
	}
	
	@Override
	public List<Employee> findAllManagers() {
		return new ArrayList<>(this.rep.findAllManagers());
	}
	
	
	
}










