package com.sn.globalmart.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.sn.core.rest.BaseRest;
import com.sn.globalmart.price.model.ProductPricingModel;
import com.sn.globalmart.service.ProductPricingService;

@RestController
@ControllerAdvice
@RequestMapping(value="/product-price", produces=MediaType.APPLICATION_JSON_VALUE) 
public class ProductPricingRest extends BaseRest{
	
	private Logger log = LoggerFactory.getLogger(ProductPricingRest.class);
	
	@Autowired
	ProductPricingService service; 
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public @ResponseBody ProductPricingModel find(@PathVariable String id) throws Exception{
		log.debug("Inside the POST method to create a product");
		return service.getPrice(id);
	}

}
