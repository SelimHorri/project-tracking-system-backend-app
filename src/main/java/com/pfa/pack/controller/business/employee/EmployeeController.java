package com.pfa.pack.controller.business.employee;

import java.time.LocalDateTime;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.pfa.pack.model.dto.EmployeeProjectData;
import com.pfa.pack.model.dto.ProjectCommit;
import com.pfa.pack.model.dto.ProjectCommitInfoDTO;
import com.pfa.pack.model.entity.Assignment;
import com.pfa.pack.model.entity.Employee;
import com.pfa.pack.model.entity.Project;
import com.pfa.pack.model.entity.Credential;
import com.pfa.pack.service.AssignmentService;
import com.pfa.pack.service.EmployeeService;
import com.pfa.pack.service.ProjectService;
import com.pfa.pack.service.CredentialService;
import com.pfa.pack.util.email.EmailUtil;
import com.pfa.pack.util.sms.Sms;
import com.pfa.pack.util.sms.SmsUtil;

@Controller
@RequestMapping(value = {"/app/employees"})
public class EmployeeController {
	
	private final EmployeeService employeeService;
	private final CredentialService credentialService;
	private final AssignmentService assignmentService;
	private final ProjectService projectService;
	private final EmailUtil emailUtil;
	private final SmsUtil smsUtil;
	private static final Logger logger = LoggerFactory.getLogger(EmployeeController.class);
	
	static {
		logger.info("************ entering " + EmployeeController.class.getName() + " ************");
	}
	
	/**
	 * Injected dependencies
	 * @param employeeService
	 * @param credentialService
	 * @param projectService
	 * @param assignmentService
	 * @param emailUtil
	 * @param smsUtil
	 */
	@Autowired
	public EmployeeController(final EmployeeService employeeService, final CredentialService credentialService, final ProjectService projectService, final AssignmentService assignmentService, final EmailUtil emailUtil, final SmsUtil smsUtil) {
		this.employeeService = employeeService;
		this.credentialService = credentialService;
		this.assignmentService = assignmentService;
		this.projectService = projectService;
		this.emailUtil = emailUtil;
		this.smsUtil = smsUtil;
	}
	
	/**
	 * display employee-info view
	 * @param authentication
	 * @param model
	 * @return employee-info
	 */
	@GetMapping(value = {"/employee-info"})
	public String displayEmployeeInfo(final Authentication authentication, final Model model) {
		
		final Employee employee = this.employeeService.findById(this.credentialService.findByUsername(authentication.getName()).getEmployee().getEmployeeId());
		model.addAttribute("e", employee);
		
		return "employees/employee-info";
	}
	
	/**
	 * display employee-team view
	 * @param authentication
	 * @param model
	 * @return employee-team
	 */
	@GetMapping(value = {"/employee-team"})
	public String displayEmployeeTeam(final Authentication authentication, final Model model) {
		
		final Credential credential = this.credentialService.findByUsername(authentication.getName());
		final List<Employee> team = this.employeeService.findByDepartmentId(credential.getEmployee().getDepartment().getDepartmentId());
		
		model.addAttribute("team", team);
		
		return "employees/employee-team";
	}
	
	/**
	 * display employee-index view
	 * @param authentication
	 * @param model
	 * @return employee-index
	 */
	@GetMapping(value = {"", "/", "/employee-index"})
	public String displayEmployeeIndex(final Authentication authentication, final Model model) {
		
		final Credential credential = this.credentialService.findByUsername(authentication.getName());
		final List<EmployeeProjectData> employeeProjectData = this.assignmentService.findByEmployeeId(credential.getEmployee().getEmployeeId());
		
		model.addAttribute("fnameAndLname", credential.getEmployee().getFirstName().toUpperCase() + " " + credential.getEmployee().getLastName().toUpperCase());
		model.addAttribute("employeeProjectData", employeeProjectData);
		
		return "employees/employee-index";
	}
	
	/**
	 * display employee-show-commits view to show all users' commits on a specific project by this url : /employee-show-all-commits
	 * @param projectId
	 * @param authentication
	 * @param model
	 * @return employee-show-commits
	 */
	@GetMapping(value = {"/employee-show-all-commits"})
	public String displayEmployeeShowAllCommits(@RequestParam("projectId") final String projectId, final Authentication authentication, final Model model) {
		
		final List<ProjectCommit> allProjectCommits = this.assignmentService.findByProjectId(Integer.parseInt(projectId));
		final Project project = this.projectService.findById(Integer.parseInt(projectId));
		
		model.addAttribute("commits", allProjectCommits);
		model.addAttribute("project", project);
		
		return "employees/employee-show-commits";
	}
	
	/**
	 * display employee-show-commits view to show current user commits on a specific project by this url : /employee-show-my-commits
	 * @param projectId
	 * @param authentication
	 * @param model
	 * @return employee-show-commits
	 */
	@GetMapping(value = {"/employee-show-my-commits"})
	public String displayEmployeeShowMyCommits(@RequestParam("projectId") final String projectId, final Authentication authentication, final Model model) {
		
		final List<ProjectCommit> myProjectCommits = this.assignmentService.findByEmployeeIdAndProjectId(this.credentialService.findByUsername(authentication.getName()).getEmployee().getEmployeeId(), Integer.parseInt(projectId));
		final Project project = this.projectService.findById(Integer.parseInt(projectId));
		
		model.addAttribute("commits", myProjectCommits);
		model.addAttribute("project", project);
		
		return "employees/employee-show-commits";
	}
	/**
	 * display employee-add-commit with the current username and specific project
	 * @param projectId
	 * @param authentication
	 * @param model
	 * @return employee-add-commit view
	 */
	@GetMapping(value = {"/employee-add-commit"})
	public String displayEmployeeAddCommit(@RequestParam("projectId") String projectId, final Authentication authentication, final Model model) {
		
		projectId = projectId.trim();
		
		// final Credential userCredential = this.userCredentialService.findByUsername(authentication.getName());
		final ProjectCommitInfoDTO projectCommitInfoDTO = this.projectService.findByUsernameAndProjectId(authentication.getName(), Integer.parseInt(projectId));
		
		model.addAttribute("projectId", projectId);
		model.addAttribute("c", projectCommitInfoDTO);
		return "employees/employee-add-commit";
	}
	
	/**
	 * handle employee-add-commit view to make new commit on this specific project
	 * @param projectId
	 * @param commitEmpDesc
	 * @param authentication
	 * @param model
	 * @return employee-add-commit view
	 */
	@PostMapping(value = {"/employee-add-commit"})
	public String handleEmployeeAddCommit(@RequestParam(value = "projectId", required = true) String projectId, @RequestParam("commitEmpDesc") final String commitEmpDesc, final Authentication authentication, final Model model) {
		
		projectId = projectId.trim();
		
		final ProjectCommitInfoDTO projectCommitInfoDTO = this.projectService.findByUsernameAndProjectId(authentication.getName(), Integer.parseInt(projectId));
		
		// to get employeeId from userCredential
		final Credential credential = this.credentialService.findByUsername(authentication.getName());
		
		final Assignment assignment = new Assignment();
		assignment.setEmployeeId(credential.getEmployee().getEmployeeId());
		assignment.setProjectId(Integer.parseInt(projectId));
		// assignment.setCommitDate(LocalDateTime.now());
		assignment.setEmployee(credential.getEmployee());
		assignment.setProject(this.projectService.findById(Integer.parseInt(projectId)));
		assignment.setCommitEmpDesc(commitEmpDesc);
		
		final String msg = "\nUsername : " + authentication.getName() + " \n" + this.projectService.findById(Integer.parseInt(projectId)).getTitle() + "\nYou've created a new COMMIT at : " + LocalDateTime.now();
		
		this.assignmentService.save(assignment);
		logger.info("COMMIT created successfully at : " + LocalDateTime.now());
		
		this.emailUtil.sendEmail(credential.getEmployee().getEmail(), "Project-Tracker-Sys", msg + "\n it says : \n" + commitEmpDesc);
		logger.info("MAIL successfully sent to {}", credential.getEmployee().getEmail());
		
		this.smsUtil.sendSms(new Sms(credential.getEmployee().getPhone(), msg));
		logger.info("SMS successfully sent to {}", credential.getEmployee().getPhone());
		
		model.addAttribute("msg", msg);
		model.addAttribute("c", projectCommitInfoDTO);
		model.addAttribute("msgColour", "success");
		
		return "employees/employee-add-commit";
	}
	
	
	
}










