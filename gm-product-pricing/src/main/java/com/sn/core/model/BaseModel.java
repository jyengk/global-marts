package com.sn.core.model;

import java.io.Serializable;

public class BaseModel implements Serializable{

	private static final long serialVersionUID = -727621339180161275L;
	
	private String createdBy;
	private String created;
	private String updatedBy;
	private String updated;
	
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
	
}
