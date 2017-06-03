package com.darthmaximus.wrkshp.data.domain;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
public class Orders extends BaseEntity {
	private String orderNumber;
	private String status;
	
	@ElementCollection
	private Map<String, LocalDateTime> statusHistory = new LinkedHashMap<>();
	
	@ManyToOne
	@JsonBackReference
	private Customers customer;
	
	@OneToMany
	@JsonManagedReference
	private Set<OrdersEntries> orderEntries = new LinkedHashSet<>();
	
	@OneToMany
	@JsonManagedReference
	private Set<Addresses> addressList = new LinkedHashSet<>();

	public String getOrderNumber() {
		return orderNumber;
	}
	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Map<String, LocalDateTime> getStatusHistory() {
		return statusHistory;
	}
	public void setStatusHistory(Map<String, LocalDateTime> statusHistory) {
		this.statusHistory = statusHistory;
	}
	public Customers getCustomer() {
		return customer;
	}
	public void setCustomer(Customers customer) {
		this.customer = customer;
	}
	public Set<OrdersEntries> getOrderEntries() {
		return orderEntries;
	}
	public void setOrderEntries(Set<OrdersEntries> orderEntries) {
		this.orderEntries = orderEntries;
	}
	public Set<Addresses> getAddressList() {
		return addressList;
	}
	public void setAddressList(Set<Addresses> addressList) {
		this.addressList = addressList;
	}
	@Override
	public String toString() {
		final int maxLen = 10;
		StringBuilder builder = new StringBuilder();
		builder.append("Order [orderNumber=").append(orderNumber).append(", status=").append(status)
				.append(", statusHistory=")
				.append(statusHistory != null ? toString(statusHistory.entrySet(), maxLen) : null).append(", customer=")
				.append(customer).append(", orderEntries=")
				.append(orderEntries != null ? toString(orderEntries, maxLen) : null).append(", addressList=")
				.append(addressList != null ? toString(addressList, maxLen) : null).append(", getId()=").append(getId())
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
