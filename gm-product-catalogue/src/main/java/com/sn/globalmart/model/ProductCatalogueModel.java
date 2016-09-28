package com.sn.globalmart.model;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

public class ProductCatalogueModel implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private String id;
	
	@NotEmpty
	private String productType;
	
	@NotEmpty
	private String productName;
	
	@NotEmpty
	private String productCategory;
	
	@NotNull
	private Integer productCount;
	
	private String createdBy;
	
	private String created;
	
	private String updatedBy;
	
	private String updated;
	
	private boolean active;
	
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	public String getCreated() {
		return created;
	}
	public void setCreated(String created) {
		this.created = created;
	}
	public String getUpdatedBy() {
		return updatedBy;
	}
	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}
	public String getUpdated() {
		return updated;
	}
	public void setUpdated(String updated) {
		this.updated = updated;
	}

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
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
		return "ProductCatalogueModel [id=" + id + ", productType=" + productType + ", productName=" + productName
				+ ", productCategory=" + productCategory + ", productCount=" + productCount + ", active=" + active
				+ "]";
	}
	
}
