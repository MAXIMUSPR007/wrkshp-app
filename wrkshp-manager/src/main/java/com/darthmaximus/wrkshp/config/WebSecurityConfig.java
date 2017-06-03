package com.darthmaximus.wrkshp.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.session.HttpSessionEventPublisher;

@Configuration
@ConfigurationProperties(prefix="security")
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	private String sessionsPolicy;
	private int maximumSessions;
	
	public String getSessionsPolicy() {
		return sessionsPolicy;
	}

	public void setSessionsPolicy(String sessionsPolicy) {
		this.sessionsPolicy = sessionsPolicy;
	}

	public int getMaximumSessions() {
		return maximumSessions;
	}

	public void setMaximumSessions(int maximumSessions) {
		this.maximumSessions = maximumSessions;
	}

	@Override
	public void configure(HttpSecurity http) throws Exception {
		http
			.authorizeRequests()
				.antMatchers("/web**").permitAll()
				.antMatchers("/web/customers**").access("hasRole('ADMIN')")
				.antMatchers("/web/admin**").access("hasRole('ADMIN')")
				.anyRequest().authenticated()
			.and()
				.formLogin()
				.loginPage("/login").permitAll()
				.defaultSuccessUrl("/web")
				.failureUrl("/login?m=login")
			.and()
				.logout()
				.logoutUrl("/logout")
				.logoutSuccessUrl("/login?m=logout")
				.permitAll()
			.and()
				.exceptionHandling()
				.accessDeniedPage("/accessDenied");
		http.sessionManagement()
			.sessionCreationPolicy(SessionCreationPolicy.valueOf(sessionsPolicy))
			.sessionFixation().migrateSession()
			.maximumSessions(maximumSessions)
			.expiredUrl("/login?m=expired");
	}
	
	@Bean
	public HttpSessionEventPublisher httpSessionEventPublisher() {
		return new HttpSessionEventPublisher();
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication().withUser("maximus").password("maximus").roles("ADMIN");
	}
}
