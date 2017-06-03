package com.darthmaximus.wrkshp.data.domain;

import javax.persistence.Entity;

@Entity
public class ProductItemsEntries extends ItemsEntries {
	private Long available;
	private Long onHold;
	private Long onBackOrder;
	private String terms;

	public Long getAvailable() {
		return available;
	}
	public void setAvailable(Long available) {
		this.available = available;
	}
	public Long getOnHold() {
		return onHold;
	}
	public void setOnHold(Long onHold) {
		this.onHold = onHold;
	}
	public Long getOnBackOrder() {
		return onBackOrder;
	}
	public void setOnBackOrder(Long onBackOrder) {
		this.onBackOrder = onBackOrder;
	}
	public String getTerms() {
		return terms;
	}
	public void setTerms(String terms) {
		this.terms = terms;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ProductItemEntry [available=").append(available).append(", onHold=").append(onHold)
				.append(", onBackOrder=").append(onBackOrder).append(", terms=").append(terms)
				.append(", getItemNumber()=").append(getItemNumber()).append(", getItemDescription()=")
				.append(getItemDescription()).append(", getQuantity()=").append(getQuantity()).append(", getPrice()=")
				.append(getPrice()).append(", getCost()=").append(getCost()).append(", getTaxRate()=")
				.append(getTaxRate()).append(", getEnabled()=").append(getEnabled()).append(", getId()=")
				.append(getId()).append(", getCreated()=").append(getCreated()).append(", getUpdated()=")
				.append(getUpdated()).append("]");
		return builder.toString();
	}
}
