package com.darthmaximus.wrkshp.data.domain;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
public class OrdersEntries extends BaseEntity {
	@ManyToOne
	@JsonBackReference
	private Orders order;
	
	@OneToOne
	@JsonBackReference
	private ItemsEntries itemEntry;

	public Orders getOrder() {
		return order;
	}
	public void setOrder(Orders order) {
		this.order = order;
	}
	public ItemsEntries getItemEntry() {
		return itemEntry;
	}
	public void setItemEntry(ItemsEntries itemEntry) {
		this.itemEntry = itemEntry;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("OrderEntry [order=").append(order).append(", itemEntry=").append(itemEntry).append(", getId()=")
				.append(getId()).append(", getCreated()=").append(getCreated()).append(", getUpdated()=")
				.append(getUpdated()).append("]");
		return builder.toString();
	}
}
