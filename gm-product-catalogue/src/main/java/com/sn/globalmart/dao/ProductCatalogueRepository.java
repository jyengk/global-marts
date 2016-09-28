package com.sn.globalmart.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.sn.globalmart.entity.ProductCatalogueEntity;

@Repository
public interface ProductCatalogueRepository extends JpaRepository<ProductCatalogueEntity, Long>, 
													JpaSpecificationExecutor<ProductCatalogueEntity>{
	
	ProductCatalogueEntity findById(Long id);
	ProductCatalogueEntity findByIdAndActive(Long id, boolean active);
	List<ProductCatalogueEntity> findByProductTypeAndActive(String productType, boolean active);
}
