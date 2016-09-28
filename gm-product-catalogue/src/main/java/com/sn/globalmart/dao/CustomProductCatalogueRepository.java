package com.sn.globalmart.dao;

import java.util.List;
import java.util.Map;

public interface CustomProductCatalogueRepository<T> {
	public List<T> find(Map<String, String> params);
}
