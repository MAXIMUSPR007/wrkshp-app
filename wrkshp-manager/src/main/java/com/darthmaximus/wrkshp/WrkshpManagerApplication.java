package com.darthmaximus.wrkshp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@EnableAutoConfiguration
@EnableConfigurationProperties
@SpringBootApplication
public class WrkshpManagerApplication {

	public static void main(String[] args) {
		SpringApplication.run(WrkshpManagerApplication.class, args);
	}
}
