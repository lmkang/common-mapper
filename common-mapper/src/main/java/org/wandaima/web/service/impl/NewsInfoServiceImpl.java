package org.wandaima.web.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.wandaima.model.Criteria;
import org.wandaima.model.Pagination;
import org.wandaima.web.mapper.NewsInfoMapper;
import org.wandaima.web.model.NewsInfo;
import org.wandaima.web.service.NewsInfoService;

@Service
public class NewsInfoServiceImpl implements NewsInfoService {

	@Autowired
	private NewsInfoMapper newsInfoMapper;
	
	public List<NewsInfo> listNewsInfo() {
		return newsInfoMapper.selectNewsInfo();
	}

	@Transactional
	public int addNewsInfo(NewsInfo newsInfo) {
		if(newsInfo != null) {
			return newsInfoMapper.insert(newsInfo);
		}
		return 0;
	}

	@Transactional
	public int editNewsInfo(NewsInfo newsInfo, Criteria criteria) {
		if(newsInfo != null) {
			return newsInfoMapper.update(newsInfo, criteria);
		}
		return 0;
	}

	@Transactional
	public int deleteNewsInfo(Criteria criteria) {
		if(criteria != null) {
			return newsInfoMapper.delete(criteria);
		}
		return 0;
	}

	public NewsInfo getNewsInfo(Criteria criteria, String... fieldList) {
		return newsInfoMapper.selectOne(criteria, fieldList);
	}

	public List<NewsInfo> listAllNewsInfo(Criteria criteria, String... fieldList) {
		return newsInfoMapper.selectAll(criteria, fieldList);
	}

	public Pagination<NewsInfo> getNewsInfoPagination(Integer pageNum, Integer pageSize, Criteria criteria,
			String... fieldList) {
		if(pageNum < 1) {
			pageNum = 1;
		}
		if(pageSize < 1) {
			pageSize = 1;
		}
		long recordCount = newsInfoMapper.countPagination(criteria);
		List<NewsInfo> list = newsInfoMapper.selectPagination((pageNum - 1) * pageSize, pageSize, criteria, fieldList);
		return new Pagination<NewsInfo>(list, recordCount, pageNum, pageSize);
	}

}
