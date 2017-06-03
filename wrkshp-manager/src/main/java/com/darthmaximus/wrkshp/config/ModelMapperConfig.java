package com.darthmaximus.wrkshp.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMapperConfig {
	@Bean
	public ModelMapper defaultModelMapper() {
		return configure(new ModelMapper());
	}
	
	private ModelMapper configure(ModelMapper modelMapper) {
		modelMapper.getConfiguration().setFieldMatchingEnabled(true);
		modelMapper.getConfiguration().setAmbiguityIgnored(true);
		return modelMapper;
	}
}
