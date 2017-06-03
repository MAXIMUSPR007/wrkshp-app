package com.darthmaximus.wrkshp.data.domain;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Users extends BaseEntity {
	@Column(unique=true)
	private String username;
	private String password;
	private String email;
	private boolean enabled;
	
	@OneToMany(fetch=FetchType.EAGER)
	@JsonManagedReference
	private Set<Roles> userRoles = new LinkedHashSet<>();
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public boolean isEnabled() {
		return enabled;
	}
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	public Set<Roles> getUserRoles() {
		return userRoles;
	}
	public void setUserRoles(Set<Roles> userRoles) {
		this.userRoles = userRoles;
	}
	@Override
	public String toString() {
		final int maxLen = 10;
		StringBuilder builder = new StringBuilder();
		builder.append("User [username=").append(username).append(", password=").append(password).append(", email=")
				.append(email).append(", enabled=").append(enabled).append(", userRoles=")
				.append(userRoles != null ? toString(userRoles, maxLen) : null).append(", getId()=").append(getId())
				.append(", getCreated()=").append(getCreated()).append(", getUpdated()=").append(getUpdated())
				.append("]");
		return builder.toString();
	}
	private String toString(Collection<?> collection, int maxLen) {
		StringBuilder builder = new StringBuilder();
		builder.append("[");
		int i = 0;
		for (Iterator<?> iterator = collection.iterator(); iterator.hasNext() && i < maxLen; i++) {
			if (i > 0)
				builder.append(", ");
			builder.append(iterator.next());
		}
		builder.append("]");
		return builder.toString();
	}
}
