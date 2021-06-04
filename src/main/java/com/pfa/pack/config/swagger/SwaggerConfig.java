package com.pfa.pack.config.swagger;

import static springfox.documentation.builders.PathSelectors.regex;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@Configuration
@Profile(value = {"dev", "qa"})
public class SwaggerConfig {
	
	private static final String BASE_PACKAGE = "com.pfa.pack.controller.api";
	private static final Logger logger = LoggerFactory.getLogger(SwaggerConfig.class);
	
	static {
		logger.info("************ entering " + SwaggerConfig.class.getName() + " ************");
	}
	
	@Bean
	public Docket productApi() {
		
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.basePackage(BASE_PACKAGE))
				.paths(regex("/app/api/.*"))
				.build()
		.apiInfo(this.metaData());
	}

	private ApiInfo metaData() {
		
		final String title = "Project-Tracker-System";
		final String description = "Manage and track commits transactions by Employees and their Managers on a specific project.\n"
				+ "- Employees can be assigned to projects created and managed by their managers, can add a new commits to a specific project so manager can track its progression\n"
				+ "- Managers can create, edit & delete projects, also assign them to their employees and track them efficiently & easily\n"
				+ "- Admin manages all Employees as well as their credentials & departments\n"
				+ "For more, you can check more on our GitHub repositories : \n"
				+ "- Selim Horri : https://github.com/SelimHorri?tab=repositories \n"
				+ "- Imen Toukebri : https://github.com/imen1012?tab=repositories \n"
				+ "- Bader Idoudi : https://github.com/Bader1996?tab=repositories \n";
		final String version = "1.0";
		final String termsOfServiceUrl = "Terms of service";
		final String name = "Selim Horri, Imen Touk, Badr Idoudi";
		final String url = "https://github.com/SelimHorri/Project-Tracking-System";
		final String email = "springabcxyz@gmail.com";
		final Contact contact = new Contact(name, url, email);
		final String license = "Apache Licence version 2.0";
		final String licenseUrl = "https://apache.org/license.html";
		
		return new ApiInfoBuilder()
								.title(title)
								.description(description)
								.version(version)
								.termsOfServiceUrl(termsOfServiceUrl)
								.contact(contact)
								.license(license)
								.licenseUrl(licenseUrl)
		.build();
	}
	
	
	
}









