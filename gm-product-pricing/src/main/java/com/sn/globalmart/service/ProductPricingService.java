package com.sn.globalmart.service;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import com.sn.base.exception.ResourceNotFoundException;
import com.sn.globalmart.dao.ProductPricingRepository;
import com.sn.globalmart.price.entity.ProductPricingEntity;
import com.sn.globalmart.price.model.ProductCatalogueModel;
import com.sn.globalmart.price.model.ProductPricingModel;
import com.sn.globalmart.price.util.ProductPricingDataAssembler;

@Component
public class ProductPricingService {
	
	Logger log = LoggerFactory.getLogger(ProductPricingService.class);
	
	@Value("${gm.product.catalogue.base.url}")
	private String productCatalogueUrl;
	
	@Autowired
	private ProductPricingDataAssembler assembler;
	
	@Autowired
	private ProductPricingRepository repository;
	
	final RestTemplate restTemplate = new RestTemplate();
	
	public ProductPricingModel getPrice(String id) throws Exception{
		
		ProductPricingEntity entity = repository.findById(Long.valueOf(id));
		if(entity == null){
			log.error("No product price found for the product id :"+id);
			throw new ResourceNotFoundException("No product price found for the product id :"+id);
		}
		ProductCatalogueModel pdtCatalogueModel = null;
		try{
			String url = productCatalogueUrl +"/{id}";
            log.debug("productCatalogueUrl " + url);
            Map<String, Object> urlVariables = new HashMap<String, Object>();
            urlVariables.put("id", id);
            pdtCatalogueModel = restTemplate.getForObject(url, ProductCatalogueModel.class, urlVariables);
            log.debug("Product catalogie model : "+ pdtCatalogueModel);
		}
		catch(HttpClientErrorException e){
			log.error("Error encountered while fetching product catalogue. "+ e.getMessage());
			throw e;
		}
		catch(Exception e){
			e.printStackTrace();
			log.error("Error encountered while fetching product catalogue details. Service maybe down.");
			throw e;
		}
		return assembler.convertToPricingModel(entity, pdtCatalogueModel);
	}
}
