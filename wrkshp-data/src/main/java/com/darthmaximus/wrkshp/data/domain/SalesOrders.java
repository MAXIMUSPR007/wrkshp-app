package com.darthmaximus.wrkshp.data.domain;

import java.util.Collection;
import java.util.Currency;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class SalesOrders extends Orders {
	private Currency subTotal;
	private Currency salesTax;
	private Currency stateTax;
	private Currency taxTotal;
	private Currency salesTotal;
	
	@OneToMany
	@JsonManagedReference
	private Set<SalesOrdersEntries> salesOrderEntries = new LinkedHashSet<>();
	
	public Currency getSubTotal() {
		return subTotal;
	}
	public void setSubTotal(Currency subTotal) {
		this.subTotal = subTotal;
	}
	public Currency getSalesTax() {
		return salesTax;
	}
	public void setSalesTax(Currency salesTax) {
		this.salesTax = salesTax;
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
	public Currency getSalesTotal() {
		return salesTotal;
	}
	public void setSalesTotal(Currency salesTotal) {
		this.salesTotal = salesTotal;
	}
	public Set<SalesOrdersEntries> getSalesOrderEntries() {
		return salesOrderEntries;
	}
	public void setSalesOrderEntries(Set<SalesOrdersEntries> salesOrderEntries) {
		this.salesOrderEntries = salesOrderEntries;
	}
	@Override
	public String toString() {
		final int maxLen = 10;
		StringBuilder builder = new StringBuilder();
		builder.append("SalesOrder [subTotal=").append(subTotal).append(", salesTax=").append(salesTax)
				.append(", stateTax=").append(stateTax).append(", taxTotal=").append(taxTotal).append(", salesTotal=")
				.append(salesTotal).append(", salesOrderEntry=")
				.append(salesOrderEntries != null ? toString(salesOrderEntries, maxLen) : null)
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
