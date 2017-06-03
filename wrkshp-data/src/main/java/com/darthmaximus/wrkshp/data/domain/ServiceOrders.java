package com.darthmaximus.wrkshp.data.domain;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Currency;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class ServiceOrders extends Orders {
	private Currency subTotal;
	private Currency serviceTax;
	private Currency stateTax;
	private Currency taxTotal;
	private Currency serviceTotal;
	private LocalDateTime serviceRequestedDate;
	private LocalDateTime serviceEstimatedDate;
	private LocalDateTime serviceCompletedDate;
	
	@OneToMany
	@JsonManagedReference
	private Set<ServiceOrdersEntries> serviceOrderEntries = new LinkedHashSet<>();
	
	public Currency getSubTotal() {
		return subTotal;
	}
	public void setSubTotal(Currency subTotal) {
		this.subTotal = subTotal;
	}
	public Currency getServiceTax() {
		return serviceTax;
	}
	public void setServiceTax(Currency serviceTax) {
		this.serviceTax = serviceTax;
	}
	public Currency getStateTax() {
		return stateTax;
	}
	public void setStateTax(Currency stateTax) {
		this.stateTax = stateTax;
	}
	public Currency getTaxTotal() {
		return taxTotal;
	}
	public void setTaxTotal(Currency taxTotal) {
		this.taxTotal = taxTotal;
	}
	public Currency getServiceTotal() {
		return serviceTotal;
	}
	public void setServiceTotal(Currency serviceTotal) {
		this.serviceTotal = serviceTotal;
	}
	public LocalDateTime getServiceRequestedDate() {
		return serviceRequestedDate;
	}
	public void setServiceRequestedDate(LocalDateTime serviceRequestedDate) {
		this.serviceRequestedDate = serviceRequestedDate;
	}
	public LocalDateTime getServiceEstimatedDate() {
		return serviceEstimatedDate;
	}
	public void setServiceEstimatedDate(LocalDateTime serviceEstimatedDate) {
		this.serviceEstimatedDate = serviceEstimatedDate;
	}
	public LocalDateTime getServiceCompletedDate() {
		return serviceCompletedDate;
	}
	public void setServiceCompletedDate(LocalDateTime serviceCompletedDate) {
		this.serviceCompletedDate = serviceCompletedDate;
	}
	public Set<ServiceOrdersEntries> getServiceOrderEntries() {
		return serviceOrderEntries;
	}
	public void setServiceOrderEntries(Set<ServiceOrdersEntries> serviceOrderEntries) {
		this.serviceOrderEntries = serviceOrderEntries;
	}
	@Override
	public String toString() {
		final int maxLen = 10;
		StringBuilder builder = new StringBuilder();
		builder.append("ServiceOrder [subTotal=").append(subTotal).append(", serviceTax=").append(serviceTax)
				.append(", stateTax=").append(stateTax).append(", taxTotal=").append(taxTotal).append(", serviceTotal=")
				.append(serviceTotal).append(", serviceRequestedDate=").append(serviceRequestedDate)
				.append(", serviceEstimatedDate=").append(serviceEstimatedDate).append(", serviceCompletedDate=")
				.append(serviceCompletedDate).append(", serviceOrderEntries=")
				.append(serviceOrderEntries != null ? toString(serviceOrderEntries, maxLen) : null)
				.append(", getOrderNumber()=").append(getOrderNumber()).append(", getStatus()=").append(getStatus())
				.append(", getStatusHistory()=")
				.append(getStatusHistory() != null ? toString(getStatusHistory().entrySet(), maxLen) : null)
				.append(", getCustomer()=").append(getCustomer()).append(", getOrderEntries()=")
				.append(getOrderEntries() != null ? toString(getOrderEntries(), maxLen) : null)
				.append(", getAddressList()=")
				.append(getAddressList() != null ? toString(getAddressList(), maxLen) : null).append(", getId()=")
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
