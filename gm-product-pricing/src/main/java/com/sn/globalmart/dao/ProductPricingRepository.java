package com.sn.globalmart.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sn.globalmart.price.entity.ProductPricingEntity;

@Repository
public interface ProductPricingRepository extends JpaRepository<ProductPricingEntity, Long>{
	
	ProductPricingEntity findById(Long id);
}
