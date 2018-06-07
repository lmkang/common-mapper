package org.wandaima.service;

import org.wandaima.model.Criteria;
import org.wandaima.model.Pagination;

public interface BaseService<T> {

	int addModel(T model);

	int editModel(T model, Criteria criteria);

	int deleteModel(T model);

	T getModel(Criteria criteria, String... fieldList);
	
	Pagination<T> getPagination(Integer pageNum, Integer pageSize, Criteria criteria, String... fieldList);
}
