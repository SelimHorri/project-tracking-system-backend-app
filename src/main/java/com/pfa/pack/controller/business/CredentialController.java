package com.pfa.pack.controller.business;

import java.time.LocalDateTime;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.pfa.pack.constant.AccountEnum;
import com.pfa.pack.model.entity.Credential;
import com.pfa.pack.service.CredentialService;
import com.pfa.pack.util.email.EmailUtil;
import com.pfa.pack.util.sms.Sms;
import com.pfa.pack.util.sms.SmsUtil;

@Controller
@Lazy
@RequestMapping(value = {"/app/credentials"})
public class CredentialController {
	
	private final CredentialService credentialService;
	private final EmailUtil emailUtil;
	private final SmsUtil smsUtil;
	private static final Logger logger = LoggerFactory.getLogger(CredentialController.class);
	
	static {
		logger.info("************ entering " + CredentialController.class.getName() + " ************");
	}
	
	/**
	 * Inject dependencies
	 * @param credentialService
	 * @param employeeService
	 * @param bCryptPasswordEncoder
	 * @param emailUtil
	 * @param smsUtil
	 */
	@Autowired
	public CredentialController(final CredentialService credentialService, final EmailUtil emailUtil, final SmsUtil smsUtil) {
		this.credentialService = credentialService;
		this.emailUtil = emailUtil;
		this.smsUtil = smsUtil;
	}
	
	/**
	 * display credential-edit view
	 * @param authentication
	 * @param model
	 * @return credential-edit
	 */
	@GetMapping(value = {"/credential-edit"})
	public String displayCredentialEdit(final Authentication authentication, final Model model) {
		
		final Credential credential = this.credentialService.findByUsername(authentication.getName());
		
		if (credential.getRole().equalsIgnoreCase("ROLE_EMP")) {
			model.addAttribute("account", AccountEnum.EMPLOYEE.toString());
		}
		else {
			if (credential.getRole().equalsIgnoreCase("ROLE_MGR")) {
				model.addAttribute("account", AccountEnum.MANAGER.toString());
			}
			else {
				model.addAttribute("account", AccountEnum.ADMIN.toString());
			}
		}
		
		model.addAttribute("username", authentication.getName());
		return "credentials/credential-edit";
	}
	
	/**
	 * handle credential-edit business logic in order to change credentials
	 * @param pwd1
	 * @param pwd2
	 * @param authentication
	 * @param model
	 * @return credential-edit
	 */
	@PostMapping(value = {"/credential-edit"})
	public String handleCredentialEdit(@RequestParam("pwd1") final String pwd1, @RequestParam("pwd2") final String pwd2, final Authentication authentication, final Model model) {
		
		final Credential credential = this.credentialService.findByUsername(authentication.getName());
		
		if (credential.getRole().equalsIgnoreCase("ROLE_EMP"))
			model.addAttribute("account", AccountEnum.EMPLOYEE.toString());
		else {
			if (credential.getRole().equalsIgnoreCase("ROLE_MGR"))
				model.addAttribute("account", AccountEnum.MANAGER.toString());
			else 
				model.addAttribute("account", AccountEnum.ADMIN.toString());
		}
		
		final boolean isBlank = pwd1.isEmpty() || pwd2.isEmpty();
		
		if (isBlank) {
			model.addAttribute("username", authentication.getName());
			model.addAttribute("msg", "Field(s) is/are empty");
			model.addAttribute("msgColour", "danger");
			return "credentials/credential-edit";
		}
		else {
			
			if (!pwd1.equals(pwd2)) {
				model.addAttribute("username", authentication.getName());
				model.addAttribute("msg", "Passwords not matching, try again!");
				model.addAttribute("msgColour", "danger");
				return "credentials/credential-edit";
			}
			
		}
		
		credential.setPassword(pwd1);
		
		final String msg = "You've changed some credentials : " + LocalDateTime.now() + "\n" + "Username : " + authentication.getName() + "\n" + "Password : " + pwd1;
		
		this.credentialService.update(credential);
		logger.info("Credentials updated successfully");
		
		this.emailUtil.sendEmail(credential.getEmployee().getEmail(), "Project-Tracker-Sys", msg);
		logger.info("MAIL successfully sent to {}", credential.getEmployee().getEmail());
		
		this.smsUtil.sendSms(new Sms(credential.getEmployee().getPhone(), msg));
		logger.info("SMS successfully sent to {}", credential.getEmployee().getPhone());
		
		model.addAttribute("username", authentication.getName());
		model.addAttribute("msg", "Credentials updated successfully");
		model.addAttribute("msgColour", "success");
		
		return "credentials/credential-edit";
	}
	
	
	
}









