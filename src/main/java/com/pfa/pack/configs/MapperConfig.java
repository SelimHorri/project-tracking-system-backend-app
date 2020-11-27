package com.selimhorri.app.pack.configs;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MapperConfig {
	
	private static final Logger logger = LoggerFactory.getLogger(MapperConfig.class);
	
	static {
		logger.info("************ entering " + MapperConfig.class.getName() + " ************");
	}
	
	@Bean
	public ModelMapper getModelMapper() {
		return new ModelMapper();
	}
	
	
	
}










