package com.darthmaximus.wrkshp.data.domain;

import java.util.Currency;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
public class ItemsEntries extends BaseEntity {
	private String itemNumber;
	private String itemDescription;
	private Long quantity;
	private Currency price;
	private Currency cost;
	private Currency taxRate;
	private Boolean enabled;
	
	public String getItemNumber() {
		return itemNumber;
	}
	public void setItemNumber(String itemNumber) {
		this.itemNumber = itemNumber;
	}
	public String getItemDescription() {
		return itemDescription;
	}
	public void setItemDescription(String itemDescription) {
		this.itemDescription = itemDescription;
	}
	public Long getQuantity() {
		return quantity;
	}
	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}
	public Currency getPrice() {
		return price;
	}
	public void setPrice(Currency price) {
		this.price = price;
	}
	public Currency getCost() {
		return cost;
	}
	public void setCost(Currency cost) {
		this.cost = cost;
	}
	public Currency getTaxRate() {
		return taxRate;
	}
	public void setTaxRate(Currency taxRate) {
		this.taxRate = taxRate;
	}
	public Boolean getEnabled() {
		return enabled;
	}
	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ItemEntry [itemNumber=").append(itemNumber).append(", itemDescription=").append(itemDescription)
				.append(", quantity=").append(quantity).append(", price=").append(price).append(", cost=").append(cost)
				.append(", taxRate=").append(taxRate).append(", enabled=").append(enabled).append(", getId()=")
				.append(getId()).append(", getCreated()=").append(getCreated()).append(", getUpdated()=")
				.append(getUpdated()).append("]");
		return builder.toString();
	}
}
