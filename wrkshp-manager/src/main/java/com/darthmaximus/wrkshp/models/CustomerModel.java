package com.darthmaximus.wrkshp.models;

public class CustomerModel {
	private Long id;
	private String firstName;
	private String lastName;
	private String email;
	private String cellPhone;
	private String homePhone;
	private String workPhone;
	private String altPhone;
	
	public CustomerModel() {
		this.id = new Long(0);
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCellPhone() {
		return cellPhone;
	}
	public void setCellPhone(String cellPhone) {
		this.cellPhone = cellPhone;
	}
	public String getHomePhone() {
		return homePhone;
	}
	public void setHomePhone(String homePhone) {
		this.homePhone = homePhone;
	}	
	public String getWorkPhone() {
		return workPhone;
	}
	public void setWorkPhone(String workPhone) {
		this.workPhone = workPhone;
	}
	public String getAltPhone() {
		return altPhone;
	}
	public void setAltPhone(String altPhone) {
		this.altPhone = altPhone;
	}

	public String getBuildName() {
		if (id.equals(0L)) {
			return "[NEW]";
		}
		
		StringBuilder sb = new StringBuilder();
		sb
			.append("[")
			.append(id).append(": ")
			.append(firstName).append(" ")
			.append(lastName)
			.append("]");
		return sb.toString();
	}
}
