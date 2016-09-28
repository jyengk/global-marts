package com.sn.globalmart.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import com.sn.core.exception.ResourceNotFoundException;
import com.sn.globalmart.dao.ProductCatalogueRepository;
import com.sn.globalmart.entity.ProductCatalogueEntity;
import com.sn.globalmart.model.ProductCatalogueModel;
import com.sn.globalmart.util.ProductCatalogueDataAssembler;

@Component
public class ProductCatalogueService {
	
	Logger log = LoggerFactory.getLogger(ProductCatalogueService.class);
	
	@Autowired
	public ProductCatalogueDataAssembler assembler;
	
	@Resource
	public ProductCatalogueRepository repository;
	
	/**
	 * Persist the catalogue entity.
	 * @param model
	 * @return
	 * @throws Exception
	 */
	public ProductCatalogueModel create(ProductCatalogueModel model) throws Exception{
		log.debug("Creating model with the details >>> "+model.toString());
		model.setActive(true);
		ProductCatalogueEntity entity = repository.save(assembler.convertModelToEntity(model));
		if(entity == null){
			throw new ResourceNotFoundException("Entity is NULL");
		}
		log.debug("Successfully created model with the details >>> "+entity.toString());
		return (assembler.convertEntityToModel(entity));
	}
	
	/**
	 * Find the catalogue entity as per the request params
	 * @param model
	 * @return
	 * @throws Exception
	 */
	public List<ProductCatalogueModel> retrieve(String productType) throws Exception{
		
		//TODO - Why is this still returning the records with false
		List<ProductCatalogueEntity> entities = repository.findByProductTypeAndActive(productType, true);
		List<ProductCatalogueModel> models = new ArrayList<ProductCatalogueModel>();
		if(!(CollectionUtils.isEmpty(entities))){
			 for(ProductCatalogueEntity entity : entities){
				 models.add(assembler.convertEntityToModel(entity));
			 }
		}
		return models;
	}
	
	public ProductCatalogueModel delete(Long id) throws Exception{
		
		ProductCatalogueEntity entity = repository.findById(id);
		if(entity == null){
			log.error("No entity found for the id " + id);
			throw new ResourceNotFoundException("No entity found for the id " + id);
		}
		entity.setActive(false);
		repository.save(entity);
		return assembler.convertEntityToModel(entity);
	}
	
	public ProductCatalogueModel retrieveById(String id) throws Exception{
		ProductCatalogueEntity entity = repository.findByIdAndActive(Long.valueOf(id), true);
		if(entity == null){
			throw new ResourceNotFoundException("No entity found for the id " + id);
		}
		return (assembler.convertEntityToModel(entity));
	}

}
