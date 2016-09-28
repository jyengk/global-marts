package com.sn.globalmart.price.model;

import java.io.Serializable;

public class ProductCatalogueModel implements Serializable{

	private static final long serialVersionUID = -6989983181449326505L;
	
	private String productType;
	private String productName;
	private String productCategory;
	private Integer productCount;
	private boolean active;
	
	public String getProductType() {
		return productType;
	}
	public void setProductType(String productType) {
		this.productType = productType;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getProductCategory() {
		return productCategory;
	}
	public void setProductCategory(String productCategory) {
		this.productCategory = productCategory;
	}
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	public Integer getProductCount() {
		return productCount;
	}
	public void setProductCount(Integer productCount) {
		this.productCount = productCount;
	}
	@Override
	public String toString() {
		return "ProductCatalogueModel [productType=" + productType + ", productName=" + productName
				+ ", productCategory=" + productCategory + ", productCount=" + productCount + ", active=" + active
				+ "]";
	}
	
}
