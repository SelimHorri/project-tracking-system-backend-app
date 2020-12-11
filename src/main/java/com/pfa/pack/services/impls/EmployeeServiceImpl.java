package com.pfa.pack.services.impls;

import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pfa.pack.models.collectionwrappers.EmployeesCollection;
import com.pfa.pack.models.entities.Employee;
import com.pfa.pack.repositories.EmployeeRepository;
import com.pfa.pack.services.EmployeeService;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {
	
	private final EmployeeRepository rep;
	private static final Logger logger = LoggerFactory.getLogger(EmployeeServiceImpl.class);
	
	static {
		logger.info("************ entering " + EmployeeServiceImpl.class.getName() + " ************");
	}
	
	@Autowired
	public EmployeeServiceImpl(final EmployeeRepository rep) {
		this.rep = rep;
	}
	
	@Override
	public EmployeesCollection findAll() {
		return new EmployeesCollection(Collections.unmodifiableList(this.rep.findAll()));
	}
	
	@Override
	public Employee findById(final Integer employeeId) {
		return this.rep.findById(employeeId).orElseThrow(() -> new NoSuchElementException("\\n------------ NO ELEMENT FOUND !!!!! ------------\\n"));
	}
	
	@Override
	public Employee save(final Employee employee) {
		return this.rep.save(employee);
	}
	
	@Override
	public Employee update(final Employee employee) {
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
	
	
	
}










