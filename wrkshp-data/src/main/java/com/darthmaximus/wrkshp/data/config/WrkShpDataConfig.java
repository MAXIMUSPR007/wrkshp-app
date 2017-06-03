package com.darthmaximus.wrkshp.data.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories("com.darthmaximus.wrkshp.data.repositories")
@EnableJpaAuditing
public class WrkShpDataConfig {
}
