package com.pfa.pack.service.impl;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pfa.pack.exception.custom.ObjectNotFoundException;
import com.pfa.pack.model.dto.EmployeeProjectData;
import com.pfa.pack.model.dto.ProjectCommit;
import com.pfa.pack.model.dto.SearchProjectsDto;
import com.pfa.pack.model.dto.collection.DtoCollection;
import com.pfa.pack.model.entity.Assignment;
import com.pfa.pack.model.id.AssignmentId;
import com.pfa.pack.repository.AssignmentRepository;
import com.pfa.pack.service.AssignmentService;

@Service
@Transactional
public class AssignmentServiceImpl implements AssignmentService {
	
	private final AssignmentRepository rep;
	private static final Logger logger = LoggerFactory.getLogger(AssignmentServiceImpl.class);
	
	static {
		logger.info("************ entering " + AssignmentServiceImpl.class.getName() + " ************");
	}
	
	@Autowired
	public AssignmentServiceImpl(final AssignmentRepository rep) {
		this.rep = rep;
	}
	
	/**
	 * @return: all assignments
	 */
	@Override
	public DtoCollection<Assignment> findAll() {
		return new DtoCollection<>(Collections.unmodifiableList(this.rep.findAll()));
	}
	
	/**
	 * retrieve a specific assignment by its composite ids
	 * @param employeeId
	 * @param projectId
	 * @param commitDate
	 * @return a specific assignment
	 */
	/*@Override
	public Assignment findById(final Integer employeeId, final Integer projectId, final LocalDateTime commitDate) {
		return this.rep.findById(employeeId, projectId, commitDate).orElseThrow(() -> new NoSuchElementException("###### NO ELEMENT FOUND !!!!! ######"));
	}*/
	
	@Override
	public Assignment findById(final Integer employeeId, final Integer projectId, final LocalDateTime commitDate) {
		return this.rep.findById(new AssignmentId(employeeId, projectId, commitDate)).orElseThrow(() -> new ObjectNotFoundException("###### NO Assignment object FOUND! ######"));
	}
	
	/**
	 * @param assignment
	 * @return the saved assignment
	 */
	@Override
	public Assignment save(final Assignment assignment) {
		return this.rep.save(assignment);
	}
	
	/**
	 * @param assignment
	 * @return the updated assignment
	 */
	@Override
	public Assignment update(final Assignment assignment) {
		return this.rep.save(assignment);
	}
	
	/**
	 * @param employeeId
	 * @param projectId
	 * @param commitDate
	 */
	@Override
	public void deleteById(final Integer employeeId, final Integer projectId, final LocalDateTime commitDate) {
		this.rep.delete(this.findById(employeeId, projectId, commitDate));
	}
	
	/**
	 * @param employeeId
	 * @return list of EmployeeProjectData
	 */
	@Override
	public List<EmployeeProjectData> findByEmployeeId(final Integer employeeId) {
		return this.rep.findByEmployeeId(employeeId);
	}
	
	/**
	 * @param projectId
	 * @return list of ProjectCommit
	 */
	@Override
	public List<ProjectCommit> findByProjectId(final Integer projectId) {
		return this.rep.findByProjectId(projectId);
	}
	
	/**
	 * @param employeeId
	 * @param projectId
	 * @return list of ProjectCommit
	 */
	@Override
	public List<ProjectCommit> findByEmployeeIdAndProjectId(final Integer employeeId, final Integer projectId) {
		return this.rep.findByEmployeeIdAndProjectId(employeeId, projectId);
	}
	
	@Override
	public void deleteByProjectId(final Integer projectId) {
		this.rep.deleteByProjectId(projectId);
	}
	
	@Override
	public ProjectCommit findByEmployeeIdAndProjectIdAndCommitDate(final Integer employeeId, final Integer projectId, final LocalDateTime commitDate) {
		return this.rep.findByEmployeeIdAndProjectIdAndCommitDate(employeeId, projectId, commitDate).orElseThrow(() -> new NoSuchElementException("###### NO ProjectCommit object FOUND! ######"));
	}
	
	@Override
	public List<ProjectCommit> findByProjectIdAndCommitDateFromAndCommitDateTo(final SearchProjectsDto searchProjectsDto) {
		
		if (searchProjectsDto.getCommitDateFrom() == null || searchProjectsDto.getCommitDateTo() == null)
			throw new IllegalArgumentException("commitDateFrom/commitDateTo is/are not designed");
		
		return new ArrayList<>(this.rep.findByProjectIdAndCommitDateFromAndCommitDateTo(Integer.parseInt(searchProjectsDto.getProjectId()), LocalDate.parse(searchProjectsDto.getCommitDateFrom()), LocalDate.parse(searchProjectsDto.getCommitDateTo())));
	}
	
	
	
}










