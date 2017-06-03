package com.darthmaximus.wrkshp.data.domain;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class ServiceOrdersEntries extends OrdersEntries {
	@OneToOne
	@JsonManagedReference
	private ServiceItemsEntries serviceItemEntry;

	public ServiceItemsEntries getServiceItemEntry() {
		return serviceItemEntry;
	}
	public void setServiceItemEntry(ServiceItemsEntries serviceItemEntry) {
		this.serviceItemEntry = serviceItemEntry;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ServiceOrderEntry [serviceItemEntry=").append(serviceItemEntry).append(", getOrder()=")
				.append(getOrder()).append(", getItemEntry()=").append(getItemEntry()).append(", getId()=")
				.append(getId()).append(", getCreated()=").append(getCreated()).append(", getUpdated()=")
				.append(getUpdated()).append("]");
		return builder.toString();
	}
}
