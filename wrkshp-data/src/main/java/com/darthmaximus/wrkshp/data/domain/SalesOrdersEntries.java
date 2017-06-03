package com.darthmaximus.wrkshp.data.domain;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class SalesOrdersEntries extends OrdersEntries {
	@OneToOne
	@JsonManagedReference
	private ProductItemsEntries itemEntry;

	public ProductItemsEntries getItemEntry() {
		return itemEntry;
	}
	public void setItemEntry(ProductItemsEntries itemEntry) {
		this.itemEntry = itemEntry;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("SalesOrderEntry [itemEntry=").append(itemEntry).append(", getOrder()=").append(getOrder())
				.append(", getId()=").append(getId()).append(", getCreated()=").append(getCreated())
				.append(", getUpdated()=").append(getUpdated()).append("]");
		return builder.toString();
	}
}
