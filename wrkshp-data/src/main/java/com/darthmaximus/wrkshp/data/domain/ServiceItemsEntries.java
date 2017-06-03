package com.darthmaximus.wrkshp.data.domain;

import javax.persistence.Entity;

@Entity
public class ServiceItemsEntries extends ItemsEntries {
	private String productType;
	private String productMake;
	private String productModel;
	private String productSerial;
	private Integer productYear;
	private String remarks;
	
	public String getProductType() {
		return productType;
	}
	public void setProductType(String productType) {
		this.productType = productType;
	}
	public String getProductMake() {
		return productMake;
	}
	public void setProductMake(String productMake) {
		this.productMake = productMake;
	}
	public String getProductModel() {
		return productModel;
	}
	public void setProductModel(String productModel) {
		this.productModel = productModel;
	}
	public String getProductSerial() {
		return productSerial;
	}
	public void setProductSerial(String productSerial) {
		this.productSerial = productSerial;
	}
	public Integer getProductYear() {
		return productYear;
	}
	public void setProductYear(Integer productYear) {
		this.productYear = productYear;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ServiceItemEntry [productType=").append(productType).append(", productMake=")
				.append(productMake).append(", productModel=").append(productModel).append(", productSerial=")
				.append(productSerial).append(", productYear=").append(productYear).append(", remarks=").append(remarks)
				.append(", getItemNumber()=").append(getItemNumber()).append(", getItemDescription()=")
				.append(getItemDescription()).append(", getQuantity()=").append(getQuantity()).append(", getPrice()=")
				.append(getPrice()).append(", getCost()=").append(getCost()).append(", getTaxRate()=")
				.append(getTaxRate()).append(", getEnabled()=").append(getEnabled()).append(", getId()=")
				.append(getId()).append(", getCreated()=").append(getCreated()).append(", getUpdated()=")
				.append(getUpdated()).append("]");
		return builder.toString();
	}
}
