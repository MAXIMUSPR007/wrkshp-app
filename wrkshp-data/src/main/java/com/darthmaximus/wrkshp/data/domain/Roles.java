package com.darthmaximus.wrkshp.data.domain;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class Roles extends BaseEntity {
	private String name;
	
	@ManyToOne
	@JsonBackReference
	private Users user;

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Users getUser() {
		return user;
	}
	public void setUser(Users user) {
		this.user = user;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Role [name=").append(name).append(", user=").append(user).append(", getId()=").append(getId())
				.append(", getCreated()=").append(getCreated()).append(", getUpdated()=").append(getUpdated())
				.append("]");
		return builder.toString();
	}
}
