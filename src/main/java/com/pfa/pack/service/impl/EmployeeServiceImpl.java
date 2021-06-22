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
import com.pfa.pack.service.CredentialService;
import com.pfa.pack.service.EmployeeService;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {
	
	private final EmployeeRepository rep;
	private final CredentialService credentialService;
	private final EmployeeAssignedProjectConverter employeeAssignedProjectConverter;
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	private static final Logger logger = LoggerFactory.getLogger(EmployeeServiceImpl.class);
	
	static {
		logger.info("************ entering " + EmployeeServiceImpl.class.getName() + " ************");
	}
	
	@Autowired
	public EmployeeServiceImpl(final EmployeeRepository rep, final CredentialService credentialService, final BCryptPasswordEncoder bCryptPasswordEncoder, final EmployeeAssignedProjectConverter employeeAssignedProjectConverter) {
		this.rep = rep;
		this.credentialService = credentialService;
		this.employeeAssignedProjectConverter = employeeAssignedProjectConverter;
		this.bCryptPasswordEncoder = bCryptPasswordEncoder;
	}
	
	@Override
	public DtoCollection<Employee> findAll() {
		return new DtoCollection<>(Collections.unmodifiableList(this.rep.findAll()));
	}
	
	@Override
	public Employee findById(final Integer employeeId) {
		return this.rep.findById(employeeId).orElseThrow(() -> new ObjectNotFoundException("###### NO Employee object FOUND! ######"));
	}
	
	@Override
	public Employee save(final Employee employee) {
		
		employee.setDepartment(employee.getManager().getDepartment());
		employee.getCredential().setPassword(this.bCryptPasswordEncoder.encode(employee.getCredential().getPassword()));
		employee.getCredential().setEnabled(true);
		if (employee.getCredential().getRole().startsWith("ROLE_"))
			employee.getCredential().setRole(employee.getCredential().getRole().toUpperCase());
		else
			employee.getCredential().setRole("ROLE_" + employee.getCredential().getRole().toUpperCase());
		employee.getCredential().setEmployee(employee);
		
		return this.rep.save(employee);
	}
	
	@Override
	public Employee update(final Employee employee) {
		
		employee.setDepartment(employee.getManager().getDepartment());
		employee.getCredential().setPassword(this.bCryptPasswordEncoder.encode(employee.getCredential().getPassword()));
		// employee.getUserCredential().setEnabled(employee.getUserCredential().getEnabled());
		employee.getCredential().setEnabled(true); // TODO this is baaaaaaaaaaaaddd
		if (employee.getCredential().getRole().startsWith("ROLE_"))
			employee.getCredential().setRole(employee.getCredential().getRole());
		else
			employee.getCredential().setRole("ROLE_" + employee.getCredential().getRole());
		employee.getCredential().setEmployee(employee);
		
		return this.rep.save(employee);
	}
	
	@Override
	public void deleteById(final Integer employeeId) {
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
	
	@Override
	public Employee findByUsername(final String username) {
		return this.credentialService.findByUsername(username).getEmployee();
	}
	
	@Override
	public void deleteByUsername(final String username) {
		this.rep.delete(this.credentialService.findByUsername(username).getEmployee());
	}
	
	
	
}










