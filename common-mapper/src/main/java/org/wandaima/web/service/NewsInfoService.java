package org.wandaima.web.service;

import java.util.List;

import org.wandaima.model.Criteria;
import org.wandaima.model.Pagination;
import org.wandaima.web.model.NewsInfo;

public interface NewsInfoService {

	List<NewsInfo> listNewsInfo();
	
	int addNewsInfo(NewsInfo newsInfo);
	
	int editNewsInfo(NewsInfo newsInfo, Criteria criteria);
	
	int deleteNewsInfo(Criteria criteria);
	
	NewsInfo getNewsInfo(Criteria criteria, String... fieldList);
	
	List<NewsInfo> listAllNewsInfo(Criteria criteria, String... fieldList);
	
	Pagination<NewsInfo> getNewsInfoPagination(Integer pageNum, Integer pageSize, Criteria criteria, String... fieldList);
}
