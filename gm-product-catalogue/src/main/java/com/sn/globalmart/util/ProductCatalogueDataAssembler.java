package com.sn.globalmart.util;

import java.util.Date;

import org.h2.util.StringUtils;
import org.springframework.stereotype.*;

import com.sn.globalmart.entity.ProductCatalogueEntity;
import com.sn.globalmart.model.ProductCatalogueModel;

@Component
public class ProductCatalogueDataAssembler {
	
	public ProductCatalogueModel convertEntityToModel(ProductCatalogueEntity entity){
		ProductCatalogueModel model = new ProductCatalogueModel();
		if(entity != null){
			model.setId(entity.getId().toString());
			model.setActive(entity.isActive());
			model.setCreatedBy(entity.getCreatedBy());
			model.setProductCategory(entity.getProductCategory());
			model.setProductCount(entity.getProductCount());
			model.setProductName(entity.getProductName());
			model.setUpdatedBy(entity.getUpdatedBy());
			//TODO Need to check why this is happening
			model.setCreated(entity.getCreated() == null? "" : entity.getCreated().toString());
			model.setUpdated(entity.getUpdated() == null? "":entity.getUpdated().toString());
			model.setProductType(entity.getProductType());
		}
		return model;
	}
	
	public ProductCatalogueEntity convertModelToEntity(ProductCatalogueModel model){
		ProductCatalogueEntity entity = new ProductCatalogueEntity();
		if(model != null){
			entity.setActive(model.isActive());
			//entity.setCreatedBy(StringUtils.isNullOrEmpty(model.getCreatedBy())? "system" : model.getCreatedBy());
			entity.setProductCategory(model.getProductCategory());
			entity.setProductCount(model.getProductCount());
			entity.setProductName(model.getProductName());
			//entity.setUpdatedBy(StringUtils.isNullOrEmpty(model.getUpdatedBy())? "system" : model.getUpdatedBy());
			entity.setProductType(model.getProductType());
			entity.setCreated(new Date());
			entity.setUpdated(new Date());
		}
		return entity;
	}
}
