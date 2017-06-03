package com.darthmaximus.wrkshp.data.domain;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class ReturnOrders extends Orders {
	private String reason;
	
	@OneToMany
	@JsonManagedReference
	private Set<ReturnOrdersEntries> returnOrderEntries = new LinkedHashSet<>();

	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	public Set<ReturnOrdersEntries> getReturnOrderEntries() {
		return returnOrderEntries;
	}
	public void setReturnOrderEntries(Set<ReturnOrdersEntries> returnOrderEntries) {
		this.returnOrderEntries = returnOrderEntries;
	}
	@Override
	public String toString() {
		final int maxLen = 10;
		StringBuilder builder = new StringBuilder();
		builder.append("ReturnOrder [reason=").append(reason).append(", returnOrderEntries=")
				.append(returnOrderEntries != null ? toString(returnOrderEntries, maxLen) : null)
				.append(", getOrderNumber()=").append(getOrderNumber()).append(", getCustomer()=").append(getCustomer())
				.append(", getOrderEntries()=")
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
