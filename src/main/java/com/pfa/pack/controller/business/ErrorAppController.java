package com.pfa.pack.controller.business;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@Lazy
public class ErrorAppController implements ErrorController {
	
	private static final Logger logger = LoggerFactory.getLogger(ErrorAppController.class);
	
	static {
		logger.info("************ entering " + ErrorAppController.class.getName() + " ************");
	}
	
	/**
	 * Handle errors produced by the app based upon the returned status code
	 * @param request
	 * @return error view according to statusCode
	 */
	@GetMapping(value = { "/error" })
	public String handleError(final HttpServletRequest request) {
		
		final Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);
		final int statusCode = Integer.valueOf(status.toString());
		
		logger.error(">>>>>>>>>>>>> Status Code: " + statusCode + " <<<<<<<<<<<<<");
		logger.error(">>>>>>>>>>>>> Error encountred: " + status + " <<<<<<<<<<<<<");
		
		if (status != null) {
			if (statusCode == HttpStatus.NOT_FOUND.value())
				return "errors/error-404";
			else {
				if (statusCode == HttpStatus.INTERNAL_SERVER_ERROR.value())
					return "errors/error-500";
				else {
					if (statusCode == HttpStatus.FORBIDDEN.value())
						return "errors/error-403";
				}
			}
		}
		
		return "errorpages/error";
	}
	
	/**
	 * getErrorPath() overridden from org.springframework.boot.web.servlet.error.ErrorController
	 * @return "/error" route and handle it in handleError(request)
	 */
	@Override
	public String getErrorPath() {
		return "/error";
	}
	
	
	
}








