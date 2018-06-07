package org.wandaima.core;

import java.util.List;

import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.UpdateProvider;
import org.wandaima.model.Criteria;

public interface BaseMapper<T> {

	@InsertProvider(type = BaseSqlProvider.class, method = "insert")
	int insert(T model);

	@UpdateProvider(type = BaseSqlProvider.class, method = "update")
	int update(@Param("model") T model, @Param("criteria") Criteria criteria);

	@DeleteProvider(type = BaseSqlProvider.class, method = "delete")
	int delete(Criteria criteria);
	
	@ResultMap("BaseResultMap")
	@SelectProvider(type = BaseSqlProvider.class, method = "selectOne")
	T selectOne(@Param("criteria") Criteria criteria, @Param("fieldList") String... fieldList);
	
	@ResultMap("BaseResultMap")
	@SelectProvider(type = BaseSqlProvider.class, method = "selectAll")
	List<T> selectAll(@Param("criteria") Criteria criteria, @Param("fieldList") String... fieldList);
	
	@ResultMap("BaseResultMap")
	@SelectProvider(type = BaseSqlProvider.class, method = "selectPagination")
	List<T> selectPagination(@Param("pageNum") Integer pageNum, @Param("pageSize") Integer pageSize, @Param("criteria") Criteria criteria, @Param("fieldList") String... fieldList);

	@ResultType(long.class)
	@SelectProvider(type = BaseSqlProvider.class, method = "countPagination")
	long countPagination(Criteria criteria);
}
