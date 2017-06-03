package com.darthmaximus.wrkshp.data.domain;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class Addresses extends BaseEntity {
	private String addressLine1;
	private String addressLine2;
	private String city;
	private String state;
	private String country;
	private String zipCode;
	private String addressType;
	
	@ManyToOne
	@JsonBackReference
	private Customers customer;
	
	@ManyToOne
	@JsonBackReference
	private Orders order;

	public String getAddressLine1() {
		return addressLine1;
	}
	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}
	public String getAddressLine2() {
		return addressLine2;
	}
	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getZipCode() {
		return zipCode;
	}
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
	public String getAddressType() {
		return addressType;
	}
	public void setAddressType(String addressType) {
		this.addressType = addressType;
	}
	public Customers getCustomer() {
		return customer;
	}
	public void setCustomer(Customers customer) {
		this.customer = customer;
	}
	public Orders getOrder() {
		return order;
	}
	public void setOrder(Orders order) {
		this.order = order;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Address [addressLine1=").append(addressLine1).append(", addressLine2=").append(addressLine2)
				.append(", city=").append(city).append(", state=").append(state).append(", country=").append(country)
				.append(", zipCode=").append(zipCode).append(", addressType=").append(addressType).append(", customer=")
				.append(customer).append(", order=").append(order).append(", getId()=").append(getId())
				.append(", getCreated()=").append(getCreated()).append(", getUpdated()=").append(getUpdated())
				.append("]");
		return builder.toString();
	}
}
