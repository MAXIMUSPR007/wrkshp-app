package com.darthmaximus.wrkshp.data.domain;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Customers extends BaseEntity {
	private String firstName;
	private String middleInitial;
	private String lastName;
	private String email;
	private String cellPhone;
	private String homePhone;
	private String workPhone;
	private String altPhone;

	@OneToMany
	@JsonManagedReference
	private Set<Addresses> addressBook = new LinkedHashSet<>();
	
	@OneToMany
	@JsonManagedReference
	private Set<ReturnOrders> returnOrders = new LinkedHashSet<>();
	
	@OneToMany
	@JsonManagedReference
	private Set<SalesOrders> salesOrders = new LinkedHashSet<>();
	
	@OneToMany
	@JsonManagedReference
	private Set<ServiceOrders> serviceOrders = new LinkedHashSet<>();
	
	@OneToMany
	@JsonManagedReference
	private Set<WarrantyOrders> warrantyOrders = new LinkedHashSet<>();
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getMiddleInitial() {
		return middleInitial;
	}
	public void setMiddleInitial(String middleInitial) {
		this.middleInitial = middleInitial;
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
	public Set<Addresses> getAddressBook() {
		return addressBook;
	}
	public void setAddressBook(Set<Addresses> addressBook) {
		this.addressBook = addressBook;
	}
	public Set<ReturnOrders> getReturnOrders() {
		return returnOrders;
	}
	public void setReturnOrders(Set<ReturnOrders> returnOrders) {
		this.returnOrders = returnOrders;
	}
	public Set<SalesOrders> getSalesOrders() {
		return salesOrders;
	}
	public void setSalesOrders(Set<SalesOrders> salesOrders) {
		this.salesOrders = salesOrders;
	}
	public Set<ServiceOrders> getServiceOrders() {
		return serviceOrders;
	}
	public void setServiceOrders(Set<ServiceOrders> serviceOrders) {
		this.serviceOrders = serviceOrders;
	}
	public Set<WarrantyOrders> getWarrantyOrders() {
		return warrantyOrders;
	}
	public void setWarrantyOrders(Set<WarrantyOrders> warrantyOrders) {
		this.warrantyOrders = warrantyOrders;
	}
	@Override
	public String toString() {
		final int maxLen = 10;
		StringBuilder builder = new StringBuilder();
		builder.append("Customer [firstName=").append(firstName).append(", middleInitial=").append(middleInitial)
				.append(", lastName=").append(lastName).append(", email=").append(email).append(", cellPhone=")
				.append(cellPhone).append(", homePhone=").append(homePhone).append(", workPhone=").append(workPhone)
				.append(", altPhone=").append(altPhone).append(", addressBook=")
				.append(addressBook != null ? toString(addressBook, maxLen) : null).append(", returnOrders=")
				.append(returnOrders != null ? toString(returnOrders, maxLen) : null).append(", salesOrders=")
				.append(salesOrders != null ? toString(salesOrders, maxLen) : null).append(", serviceOrders=")
				.append(serviceOrders != null ? toString(serviceOrders, maxLen) : null).append(", warrantyOrders=")
				.append(warrantyOrders != null ? toString(warrantyOrders, maxLen) : null).append(", getId()=")
				.append(getId()).append(", getCreated()=").append(getCreated()).append(", getUpdated()=")
				.append(getUpdated()).append("]");
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
