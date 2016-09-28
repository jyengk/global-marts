package com.sn.globalmart.price.util;

import org.springframework.stereotype.Component;

import com.sn.globalmart.price.entity.ProductPricingEntity;
import com.sn.globalmart.price.model.ProductCatalogueModel;
import com.sn.globalmart.price.model.ProductPricingModel;

@Component
public class ProductPricingDataAssembler {
	
	public ProductPricingModel convertToPricingModel(ProductPricingEntity entity, ProductCatalogueModel model){
		ProductPricingModel productPricingModel = new ProductPricingModel();
		if(entity != null){
			productPricingModel.setId(entity.getId());
			productPricingModel.setPrice(Double.valueOf(entity.getPrice()));
			productPricingModel.setProductCategory(model.getProductCategory());
			productPricingModel.setProductCount(model.getProductCount());
			productPricingModel.setProductType(model.getProductType());
		}
		return productPricingModel;
	}
}