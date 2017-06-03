package com.darthmaximus.wrkshp.data.domain;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class ReturnOrdersEntries extends OrdersEntries {
	private String reason;
	
	@OneToOne
	@JsonManagedReference
	private ProductItemsEntries itemEntry;

	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	public ProductItemsEntries getItemEntry() {
		return itemEntry;
	}
	public void setItemEntry(ProductItemsEntries itemEntry) {
		this.itemEntry = itemEntry;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ReturnOrderEntry [reason=").append(reason).append(", itemEntry=").append(itemEntry)
				.append(", getOrder()=").append(getOrder()).append(", getId()=").append(getId())
				.append(", getCreated()=").append(getCreated()).append(", getUpdated()=").append(getUpdated())
				.append("]");
		return builder.toString();
	}
}
