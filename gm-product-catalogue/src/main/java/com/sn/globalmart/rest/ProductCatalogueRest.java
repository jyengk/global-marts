package com.sn.globalmart.rest;

import java.util.List;

import javax.annotation.security.RolesAllowed;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.sn.core.authorization.Authorize;
import com.sn.core.rest.BaseRest;
import com.sn.globalmart.model.ProductCatalogueModel;
import com.sn.globalmart.service.ProductCatalogueService;

@RestController
@ControllerAdvice
@RequestMapping(value="/product-catalogue", produces=MediaType.APPLICATION_JSON_VALUE) 
public class ProductCatalogueRest extends BaseRest{
	
	private Logger log = LoggerFactory.getLogger(ProductCatalogueRest.class);
	
	@Autowired
	private ProductCatalogueService service;
	
	@RequestMapping(value="/alive", method=RequestMethod.GET)
	public @ResponseBody String alive(){
		return "Service is alive";
	}
	
	/**
	 * Creates a product resource
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RolesAllowed("ADMIN")
	@Authorize
	@RequestMapping(value="/product.json",method=RequestMethod.POST,
					consumes={MediaType.APPLICATION_JSON_VALUE})
	public @ResponseBody ProductCatalogueModel create(@RequestBody @Valid ProductCatalogueModel model) throws Exception{
		log.debug("Inside the POST method to create a product");
		ProductCatalogueModel persistedModel = service.create(model);
		return persistedModel;
	}
	
	/**
	 * Get the products by the product type in the url param
	 * http://localhost:9200/product-catalogue?productType=POTATO
	 * @param productType
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(method=RequestMethod.GET)
	public @ResponseBody List<ProductCatalogueModel> find(@RequestParam("productType") String productType) throws Exception{
		log.debug("Inside the POST method to create a product");
		return service.retrieve(productType);
	}
	
	/**
	 * Get object by product id
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/product/{id}", method=RequestMethod.GET)
	public @ResponseBody ProductCatalogueModel findById(@PathVariable String id) throws Exception{
		log.debug("Inside the POST method to create a product");
		return service.retrieveById(id);
	}
	
	/**
	 * Delete a product by ID
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@RolesAllowed("ADMIN")
	@Authorize
	@RequestMapping(value="/product/{id}", method=RequestMethod.DELETE)
	public @ResponseBody ProductCatalogueModel delete(@PathVariable Long id) throws Exception{
		log.debug("Inside the POST method to create a product");
		return service.delete(id);
	}

}
