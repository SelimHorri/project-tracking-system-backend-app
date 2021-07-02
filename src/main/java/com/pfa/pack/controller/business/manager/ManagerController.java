package com.pfa.pack.controller.business.manager;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.pfa.pack.constant.StatusEnum;
import com.pfa.pack.model.dto.AssignEmployeesDto;
import com.pfa.pack.model.dto.EmployeeAssignedProjectDto;
import com.pfa.pack.model.dto.ManagerProjectData;
import com.pfa.pack.model.dto.ProjectCommit;
import com.pfa.pack.model.dto.ProjectDTO;
import com.pfa.pack.model.dto.SearchProjectsDto;
import com.pfa.pack.model.entity.Assignment;
import com.pfa.pack.model.entity.Credential;
import com.pfa.pack.model.entity.Employee;
import com.pfa.pack.model.entity.Project;
import com.pfa.pack.service.AssignmentService;
import com.pfa.pack.service.CredentialService;
import com.pfa.pack.service.EmployeeService;
import com.pfa.pack.service.ProjectService;
import com.pfa.pack.util.email.EmailUtil;
import com.pfa.pack.util.sms.Sms;
import com.pfa.pack.util.sms.SmsUtil;

@Controller
@RequestMapping(value = {"/app/managers"})
public class ManagerController {
	
	private final EmployeeService employeeService;
	private final CredentialService credentialService;
	private final AssignmentService assignmentService;
	private final ProjectService projectService;
	private final EmailUtil emailUtil;
	private final SmsUtil smsUtil;
	private static final Logger logger = LoggerFactory.getLogger(ManagerController.class);
	
	static {
		logger.info("************ entering " + ManagerController.class.getName() + " ************");
	}
	
	/**
	 * Inject dependencies
	 * @param employeeService
	 * @param credentialService
	 * @param assignmentService
	 * @param projectService
	 */
	@Autowired
	public ManagerController(final EmployeeService employeeService, final CredentialService credentialService, final AssignmentService assignmentService, final ProjectService projectService, final EmailUtil emailUtil, final SmsUtil smsUtil) {
		this.employeeService = employeeService;
		this.credentialService = credentialService;
		this.assignmentService = assignmentService;
		this.projectService = projectService;
		this.emailUtil = emailUtil;
		this.smsUtil = smsUtil;
	}
	
	/**
	 * display manager-index view
	 * @param authentication
	 * @param model
	 * @return manager-index view (using default view resolver)
	 */
	@GetMapping(value = {"", "/", "/manager-index"})
	public String displayManagerIndex(final Authentication authentication, final Model model) {
		
		final Credential credential = this.credentialService.findByUsername(authentication.getName());
		final List<ManagerProjectData> managerProjectDatas = this.projectService.findByEmployeeId(credential.getEmployee().getEmployeeId());
		
		model.addAttribute("fname", credential.getEmployee().getFirstName().toUpperCase().charAt(0) + credential.getEmployee().getFirstName().toLowerCase().substring(1));
		model.addAttribute("lname", credential.getEmployee().getLastName().toUpperCase().charAt(0) + credential.getEmployee().getLastName().toLowerCase().substring(1));
		model.addAttribute("managerProjectDatas", managerProjectDatas);
		
		return "managers/manager-index";
	}
	
	/**
	 * display manager-info view
	 * @param authentication
	 * @param model
	 * @return manager-info view (using default view resolver)
	 */
	@GetMapping(value = {"/manager-info"})
	public String displayManagerInfo(final Authentication authentication, final Model model) {
		
		final Employee manager = this.employeeService.findById(this.credentialService.findByUsername(authentication.getName()).getEmployee().getEmployeeId());
		model.addAttribute("m", manager);
		
		return "managers/manager-info";
	}
	
	/**
	 * display manager-team view
	 * @param authentication
	 * @param model
	 * @return manager-team view (using default view resolver)
	 */
	@GetMapping(value = {"/manager-team"})
	public String displayManagerTeam(final Authentication authentication, final Model model) {
		
		final Credential credential = this.credentialService.findByUsername(authentication.getName());
		final List<Employee> team = this.employeeService.findByDepartmentId(credential.getEmployee().getDepartment().getDepartmentId());
		
		model.addAttribute("team", team);
		
		return "managers/manager-team";
	}
	
	@GetMapping(value = {"/manager-assigned-projects"})
	public String displayManagerAssignedProjects(@RequestParam("employeeId") final String employeeId, final Model model) {
		
		
		
		return "managers/manager-assigned-projects";
	}
	
	/**
	 * display manager-add-project view
	 * @param authentication
	 * @param model
	 * @return manager-add-project view (using default view resolver)
	 */
	@GetMapping(value = {"/manager-add-project"})
	public String displayManagerAddProject(final Authentication authentication, final Model model) {
		
		final List<Employee> managerSubEmployees = this.employeeService.findByManagerId(this.credentialService.findByUsername(authentication.getName()).getEmployee().getEmployeeId());
		
		model.addAttribute("listStatus", StatusEnum.values());
		model.addAttribute("managerSubEmployees", managerSubEmployees);
		model.addAttribute("username", authentication.getName());
		model.addAttribute("project", new Project());
		
		return "managers/manager-add-project";
	}
	
	/**
	 * handle manager-add-project view:
	 * by adding new project with assigning at least one employee 
	 * @param projectDTO
	 * @param error
	 * @param authentication
	 * @param model
	 * @return manager-add-project view (using default view resolver)
	 */
	@PostMapping(value = {"/manager-add-project"})
	public String handleManagerAddProject(@ModelAttribute("project") @Valid final ProjectDTO projectDTO, final BindingResult error, final Authentication authentication, final Model model) {
		
		final List<Employee> managerSubEmployees = this.employeeService.findByManagerId(this.credentialService.findByUsername(authentication.getName()).getEmployee().getEmployeeId());
		
		// to check of binding variables
		if (error.hasErrors()) {
			logger.error("----------ERROR Binding object----------");
			System.err.println(error);
			model.addAttribute("username", authentication.getName());
			model.addAttribute("listStatus", StatusEnum.values());
			model.addAttribute("managerSubEmployees", managerSubEmployees);
			model.addAttribute("msg", "Something went wrong !! ");
			model.addAttribute("msgColour", "danger");
			return "managers/manager-add-project";
		}
		
		// to check the selection of one employee at least
		if (projectDTO.getAssignedEmployees() == null) {
			model.addAttribute("username", authentication.getName());
			model.addAttribute("listStatus", StatusEnum.values());
			model.addAttribute("managerSubEmployees", managerSubEmployees);
			model.addAttribute("msg", "Please you have to assign one employee at least to create the project");
			model.addAttribute("msgColour", "danger");
			return "managers/manager-add-project"; 
		}
		
		final LocalDate startDate = LocalDate.parse(projectDTO.getStartDate());
		final LocalDate endDate = LocalDate.parse(projectDTO.getEndDate());
		
		// to check if the end date is after the start date
		if (startDate.isAfter(endDate)) {
			model.addAttribute("username", authentication.getName());
			model.addAttribute("listStatus", StatusEnum.values());
			model.addAttribute("managerSubEmployees", managerSubEmployees);
			model.addAttribute("msg", "EndDate is before StartDate! please check again...");
			model.addAttribute("msgColour", "danger");
			return "managers/manager-add-project";
		}
		
		// successful output msg
		final String msg = "Username : " + authentication.getName() + " \n project [" + projectDTO.getTitle() + "] created successfully";
		final String msgUtil = " : You've been assigned to a new project called => ";
		
		// persist a new project in DB
		final Project project = this.projectService.save(projectDTO);
		logger.info(msg);
		
		// print the list of the assigned employees' ids
		System.err.println(projectDTO.getAssignedEmployees());
		
		// assign checked employees to the already created project
		final Assignment assignment = new Assignment();
		projectDTO.getAssignedEmployees().forEach((employeeId) -> {
			assignment.setEmployeeId(Integer.parseInt(employeeId));
			assignment.setProjectId(project.getProjectId());
			// assignment.setCommitDate(LocalDateTime.now());
			assignment.setCommitMgrDesc("init"); // 'init' to tell this is the assignment
			final Employee employee = this.employeeService.findById(Integer.parseInt(employeeId));
			assignment.setEmployee(employee);
			assignment.setProject(project);
			
			this.assignmentService.save(assignment);
			logger.info("employeeId : {} is assigned to this project with projectId : {}", employeeId, project.getProjectId());
			
			this.emailUtil.sendEmail(employee.getEmail(), "Project-Tracker-Sys", employee.getFirstName() + " " + employee.getLastName() + msgUtil + project.getTitle());
			logger.info("MAIL successfully sent to {}", employee.getEmail());
			
			this.smsUtil.sendSms(new Sms(employee.getPhone(), employee.getFirstName() + " " + employee.getLastName() + msgUtil + project.getTitle()));
			logger.info("SMS successfully sent to {}", employee.getPhone());
		});
		
		model.addAttribute("username", authentication.getName());
		model.addAttribute("listStatus", StatusEnum.values());
		model.addAttribute("msg", msg);
		model.addAttribute("assignMsg", "employees assigned successfully to this project");
		model.addAttribute("msgColour", "success");
		
		return "managers/manager-add-project";
	}
	
	/**
	 * display manager-show-commits view
	 * @param projectId
	 * @param model
	 * @return manager-show-commits view (using default view resolver)
	 */
	@GetMapping(value = {"/manager-show-commits"})
	public String displayManagerShowCommits(@RequestParam("projectId") final String projectId, final Model model) {
		
		final List<ProjectCommit> allProjectCommits = this.assignmentService.findByProjectId(Integer.parseInt(projectId));
		final Project project = this.projectService.findById(Integer.parseInt(projectId));
		
		model.addAttribute("commits", allProjectCommits);
		model.addAttribute("project", project);
		
		return "managers/manager-show-commits";
	}
	
	@GetMapping(value = {"/manager-search-commits"})
	public String displayManagerSearchCommits(final Authentication authentication, final Model model) {
		
		final SearchProjectsDto searchProjectsDto = new SearchProjectsDto();
		searchProjectsDto.setDataProjects(this.projectService.findByEmployeeId(this.credentialService.findByUsername(authentication.getName()).getEmployee().getEmployeeId()));
		
		model.addAttribute("searchProjectsDto", searchProjectsDto);
		
		return "managers/manager-search-commits";
	}
	
	@PostMapping(value = {"/manager-search-commits"})
	public String handleManagerSearchCommits(@ModelAttribute("searchProjectsDto") @Valid final SearchProjectsDto searchProjectsDto, final BindingResult error, final Authentication authentication, final Model model) {
		
		if (error.hasErrors()) {
			searchProjectsDto.setDataProjects(this.projectService.findByEmployeeId(this.credentialService.findByUsername(authentication.getName()).getEmployee().getEmployeeId()));
			model.addAttribute("searchProjectsDto", searchProjectsDto);
			model.addAttribute("msg", "Problem happened here, please check again...");
			model.addAttribute("msgColour", "danger");
			return "managers/manager-search-commits";
		}
		
		final LocalDate commitDateFrom = LocalDate.parse(searchProjectsDto.getCommitDateFrom());
		final LocalDate commitDateTo = LocalDate.parse(searchProjectsDto.getCommitDateTo());
		
		if (commitDateFrom.isAfter(commitDateTo)) {
			searchProjectsDto.setDataProjects(this.projectService.findByEmployeeId(this.credentialService.findByUsername(authentication.getName()).getEmployee().getEmployeeId()));
			model.addAttribute("searchProjectsDto", searchProjectsDto);
			model.addAttribute("msg", "commitDateFrom must be before commitDateTo...");
			model.addAttribute("msgColour", "danger");
			return "managers/manager-search-commits";
		}
		
		System.err.println(searchProjectsDto);
		
		final List<ProjectCommit> commits = this.assignmentService.findByProjectIdAndCommitDateFromAndCommitDateTo(searchProjectsDto);
		
		model.addAttribute("project", this.projectService.findById(Integer.parseInt(searchProjectsDto.getProjectId())));
		model.addAttribute("commits", commits);
		
		return "managers/manager-show-commits";
	}
	
	/**
	 * display manager-describe-commit view
	 * a specific commit by its composite ids
	 * @param employeeId
	 * @param projectId
	 * @param commitDate
	 * @param authentication
	 * @param model
	 * @return manager-describe-commit view (using default view resolver)
	 */
	@GetMapping(value = {"/manager-describe-commit"})
	public String displayManagerDescribeCommit(@RequestParam("employeeId") final String employeeId, @RequestParam("projectId") final String projectId, @RequestParam("commitDate") @DateTimeFormat(pattern = "yyyy-MM-ddTHH:mm:ss") final String commitDate, final Authentication authentication, final Model model) {
		
		final ProjectCommit projectCommit = this.assignmentService.findByEmployeeIdAndProjectIdAndCommitDate(Integer.parseInt(employeeId), Integer.parseInt(projectId), LocalDateTime.parse(commitDate));
		final Project project = this.projectService.findById(Integer.parseInt(projectId));
		
		model.addAttribute("c", projectCommit);
		model.addAttribute("project", project);
		
		return "managers/manager-describe-commit";
	}
	
	/**
	 * handle manager-describe-commit:
	 * adding new comment by current manager to the existing commit created by employee
	 * @param employeeId
	 * @param projectId
	 * @param commitDate
	 * @param commitEmpDesc
	 * @param commitMgrDesc
	 * @param model
	 * @return manager-describe-commit view (using default view resolver)
	 */
	@PostMapping(value = {"/manager-describe-commit"})
	public String handleManagerDescribeCommit(@RequestParam("employeeId") final String employeeId, @RequestParam("projectId") final String projectId, @RequestParam("commitDate") final String commitDate, @RequestParam("commitEmpDesc") final String commitEmpDesc, @RequestParam("commitMgrDesc") final String commitMgrDesc, final Model model) {
		
		if (commitMgrDesc.isBlank()) {
			
			final ProjectCommit projectCommit = this.assignmentService.findByEmployeeIdAndProjectIdAndCommitDate(Integer.parseInt(employeeId), Integer.parseInt(projectId), LocalDateTime.parse(commitDate));
			final Project project = this.projectService.findById(Integer.parseInt(projectId));
			
			model.addAttribute("c", projectCommit);
			model.addAttribute("project", project);
			model.addAttribute("msg", "Fill up the Manager description field !!");
			model.addAttribute("msgColour", "warning");
			
			return "managers/manager-describe-commit";
		}
		
		final Assignment assignment = new Assignment();
		assignment.setEmployeeId(Integer.parseInt(employeeId));
		assignment.setProjectId(Integer.parseInt(projectId));
		assignment.setCommitDate(LocalDateTime.parse(commitDate));
		assignment.setCommitEmpDesc(commitEmpDesc);
		assignment.setCommitMgrDesc(commitMgrDesc);
		assignment.setEmployee(this.employeeService.findById(Integer.parseInt(employeeId)));
		assignment.setProject(this.projectService.findById(Integer.parseInt(projectId)));
		
		System.err.println(assignment);
		
		this.assignmentService.update(assignment);
		logger.info("Manager Description has been added successfully to commit with employeeId : {} | projectId : {} | commitDate : {}", employeeId, projectId, commitDate);
		
		final ProjectCommit projectCommit = this.assignmentService.findByEmployeeIdAndProjectIdAndCommitDate(Integer.parseInt(employeeId), Integer.parseInt(projectId), LocalDateTime.parse(commitDate));
		final Project project = this.projectService.findById(Integer.parseInt(projectId));
		
		model.addAttribute("c", projectCommit);
		model.addAttribute("project", project);
		model.addAttribute("msg", "Description added successfully");
		model.addAttribute("msgColour", "success");
		
		return "managers/manager-describe-commit";
	}
	
	/**
	 * display manager-assign view
	 * get data and display them by a new instance of AssignEmployeesDto
	 * @param projectId
	 * @param authentication
	 * @param model
	 * @return manager-assign view (using default view resolver)
	 */
	@GetMapping(value = {"/manager-assign"})
	public String displayManagerAssign(@RequestParam("projectId") final String projectId, final Authentication authentication, final Model model) {
		
		final List<EmployeeAssignedProjectDto> managerSubEmployees = this.employeeService.findByManagerIdAndProjectId(this.credentialService.findByUsername(authentication.getName()).getEmployee().getEmployeeId(), Integer.parseInt(projectId));
		
		model.addAttribute("username", authentication.getName());
		model.addAttribute("managerSubEmployees", managerSubEmployees);
		model.addAttribute("assignEmployeesDto", new AssignEmployeesDto(projectId, this.projectService.findById(Integer.parseInt(projectId)).getTitle(), null));
		
		return "managers/manager-assign";
	}
	
	/**
	 * handle manager-assign view
	 * get checked employees and assign them to the specified project
	 * and persist every Assignment instance for each employee to DB 
	 * @param assignEmployeesDto used to bind variables
	 * @param error
	 * @param authentication
	 * @param model
	 * @return manager-assign view (using default view resolver)
	 */
	@PostMapping(value = {"/manager-assign"})
	public String handleManagerAssign(@ModelAttribute("assignEmployeesDto") final AssignEmployeesDto assignEmployeesDto, final BindingResult error, final Authentication authentication, final Model model) {
		
		if (error.hasErrors()) {
			
			final List<EmployeeAssignedProjectDto> managerSubEmployees = this.employeeService.findByManagerIdAndProjectId(this.credentialService.findByUsername(authentication.getName()).getEmployee().getEmployeeId(), Integer.parseInt(assignEmployeesDto.getProjectId()));
			
			model.addAttribute("username", authentication.getName());
			model.addAttribute("managerSubEmployees", managerSubEmployees);
			model.addAttribute("project", this.projectService.findById(Integer.parseInt(assignEmployeesDto.getProjectId())));
			model.addAttribute("msg", "Fill up the Manager description field !!");
			model.addAttribute("msgColour", "danger");
			
			return "managers/manager-assign";
		}
		if (assignEmployeesDto.getAssignedEmployees() == null) {
			final List<EmployeeAssignedProjectDto> managerSubEmployees = this.employeeService.findByManagerIdAndProjectId(this.credentialService.findByUsername(authentication.getName()).getEmployee().getEmployeeId(), Integer.parseInt(assignEmployeesDto.getProjectId()));
			
			model.addAttribute("username", authentication.getName());
			model.addAttribute("managerSubEmployees", managerSubEmployees);
			model.addAttribute("project", this.projectService.findById(Integer.parseInt(assignEmployeesDto.getProjectId())));
			model.addAttribute("msg", "Assign employees...");
			model.addAttribute("msgColour", "danger");
			
			return "managers/manager-assign";
		}
		
		System.err.println(assignEmployeesDto);
		// assignEmployeesDto.setTitle(this.projectService.findById(Integer.parseInt(assignEmployeesDto.getProjectId())).getTitle());
		
		final Assignment assignment = new Assignment();
		assignEmployeesDto.getAssignedEmployees().forEach((employeeId) -> {
			assignment.setEmployeeId(Integer.parseInt(employeeId));
			assignment.setProjectId(Integer.parseInt(assignEmployeesDto.getProjectId()));
			// assignment.setCommitDate(LocalDateTime.now());
			assignment.setCommitMgrDesc("init");
			assignment.setEmployee(this.employeeService.findById(Integer.parseInt(employeeId)));
			assignment.setProject(this.projectService.findById(Integer.parseInt(assignEmployeesDto.getProjectId())));
			System.err.println(assignment);
			
			this.assignmentService.save(assignment);
			logger.info("employeeId : {} is assigned to this project with projectId : {}", employeeId, assignEmployeesDto.getProjectId());
		});
		
		final List<EmployeeAssignedProjectDto> managerSubEmployees = this.employeeService.findByManagerIdAndProjectId(this.credentialService.findByUsername(authentication.getName()).getEmployee().getEmployeeId(), Integer.parseInt(assignEmployeesDto.getProjectId()));
		
		model.addAttribute("username", authentication.getName());
		model.addAttribute("managerSubEmployees", managerSubEmployees);
		model.addAttribute("assignEmployeesDto", assignEmployeesDto);
		model.addAttribute("msg", "Employees assigned successfully");
		model.addAttribute("msgColour", "success");
		
		return "managers/manager-assign";
	}
	
	/**
	 * display manager-edit-project view
	 * get the specified project by its projectId & display data in view
	 * @param projectId
	 * @param authentication
	 * @param model
	 * @return manager-edit-project view (using default view resolver)
	 */
	@GetMapping(value = {"/manager-edit-project"})
	public String displayManagerEditProject(@RequestParam("projectId") final String projectId, final Authentication authentication, final Model model) {
		
		model.addAttribute("username", authentication.getName());
		model.addAttribute("projectId", projectId);
		model.addAttribute("project", this.projectService.findProjectDtoById(this.projectService.findById(Integer.parseInt(projectId))));
		model.addAttribute("listStatus", StatusEnum.values());
		
		return "managers/manager-edit-project";
	}
	
	/**
	 * handle manager-edit-project view
	 * bind all parameters & update the specific commit by adding a new manager comment
	 * @param projectId
	 * @param projectDTO
	 * @param error
	 * @param authentication
	 * @param model
	 * @return manager-edit-project (using default view resolver)
	 */
	@PostMapping(value = {"/manager-edit-project"})
	public String handleManagerEditProject(@RequestParam("projectId") final String projectId, @ModelAttribute("project") @Valid final ProjectDTO projectDTO, final BindingResult error, final Authentication authentication, final Model model) {
		
		if (error.hasErrors()) {
			logger.error("----------ERROR Binding object----------");
			System.err.println(error);
			model.addAttribute("username", authentication.getName());
			model.addAttribute("projectId", projectId);
			model.addAttribute("listStatus", StatusEnum.values());
			model.addAttribute("msg", "Something went wrong !! ");
			model.addAttribute("msgColour", "danger");
			return "managers/manager-edit-project";
		}
		
		final LocalDate startDate = LocalDate.parse(projectDTO.getStartDate());
		final LocalDate endDate = LocalDate.parse(projectDTO.getEndDate());
		
		if (startDate.isAfter(endDate)) {
			model.addAttribute("username", authentication.getName());
			model.addAttribute("projectId", projectId);
			model.addAttribute("listStatus", StatusEnum.values());
			model.addAttribute("msg", "EndDate is before StartDate! please check again...");
			model.addAttribute("msgColour", "danger");
			return "managers/manager-add-project";
		}
		
		final String msg = "project " + projectDTO.getTitle() + " updated successfully";
		
		this.projectService.update(Integer.parseInt(projectId), projectDTO);
		logger.info(msg);
		
		model.addAttribute("username", authentication.getName());
		model.addAttribute("projectId", projectId);
		model.addAttribute("listStatus", StatusEnum.values());
		model.addAttribute("msg", msg);
		model.addAttribute("msgColour", "success");
		
		return "managers/manager-edit-project";
	}
	
	/**
	 * handle deletion of a specific project
	 * Please NOTE that by deleting a project, you will delete all assignments related to this project
	 * @param projectId
	 * @param model
	 * @return redirection to manager-index view (using default view resolver)
	 */
	@GetMapping(value = {"/manager-delete-project"})
	public String handleManagerDeleteProject(@RequestParam("projectId") final String projectId, final Model model) {
		
		this.projectService.deleteById(Integer.parseInt(projectId));
		logger.warn("project with its projectId = {} is deleted with all its assignments", projectId);
		
		return "redirect:/app/managers/manager-index";
	}
	
	
	
}










