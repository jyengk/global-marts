package com.sn.globalmart.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity(name="PRODUCT_CATALOGUE")
public class ProductCatalogueEntity implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String productType;
	private String productName;
	private String productCategory;
	private Integer productCount;
	private String createdBy = "system";
	private String updatedBy = "system";
	
	@Column(name = "created", insertable = false, updatable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date created;
	
	@Column(name = "updated", insertable = false, updatable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date updated;
	
	/*@PrePersist
    protected void onCreate() {
		created = new Date();
		updated = created;
    }*/
	
	private boolean active;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
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
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = (createdBy == null ? this.createdBy : createdBy);
	}
	public Date getCreated() {
		return created;
	}
	public void setCreated(Date created) {
		this.created = created;
	}
	public String getUpdatedBy() {
		return updatedBy;
	}
	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = (updatedBy == null ? this.updatedBy : updatedBy);
	}
	public Date getUpdated() {
		return updated;
	}
	public void setUpdated(Date updated) {
		this.updated = updated;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
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
		return "ProductCatalogueEntity [id=" + id + ", productType=" + productType + ", productName=" + productName
				+ ", productCategory=" + productCategory + ", productCount=" + productCount + ", createdBy=" + createdBy
				+ ", created=" + created + ", updatedBy=" + updatedBy + ", updated=" + updated + ", active=" + active
				+ "]";
	}
}
