package org.wandaima.web.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.wandaima.model.Criteria;
import org.wandaima.web.model.EnterpriseInfo;
import org.wandaima.web.model.NewsInfo;
import org.wandaima.web.service.NewsInfoService;

@RestController
@RequestMapping("/news")
public class NewsInfoController {

	@Autowired
	private NewsInfoService newsInfoService;
	
	@GetMapping("/list")
	public Object listNewsInfo() {
		return newsInfoService.listNewsInfo();
	}
	
	@GetMapping("/add")
	public Object addNewsfInfo() {
		NewsInfo newsInfo = new NewsInfo();
		newsInfo.setTitle("测试");
		newsInfo.setAuthor("测试作者");
		newsInfo.setContent("测试内容");
		newsInfo.setType("1");
		newsInfo.setPublishTime(new Date());
		EnterpriseInfo enterpriseInfo = new EnterpriseInfo();
		enterpriseInfo.setId(1L);
		newsInfo.setEnterpriseInfo(enterpriseInfo);
		int result = newsInfoService.addNewsInfo(newsInfo);
		System.out.println(result);
		if(result == 0) {
			return "error";
		}
		return "success";
	}
	
	@GetMapping("/edit")
	public Object editNewsINfo() {
		NewsInfo newsInfo = new NewsInfo();
//		newsInfo.setType("3");
		newsInfo.setContent("test");
		Criteria criteria = new Criteria();
//		criteria.like("enterpriseInfo.enterpriseName", "网易");
//		criteria.eq("enterpriseInfo.id", 1L);
		criteria.eq("id", 10L);
		int result = newsInfoService.editNewsInfo(newsInfo, criteria);
		System.out.println(result);
		if(result == 0) {
			return "error";
		}
		return "success";
	}
	
	@GetMapping("/delete")
	public Object deleteNewsInfo() {
		Criteria criteria = new Criteria();
//		criteria.like("enterpriseInfo.enterpriseName", "test");
//		criteria.like("title", "aa");
		criteria.eq("type", "5");
		criteria.eq("enterpriseInfo.id", 1L);
		int result = newsInfoService.deleteNewsInfo(criteria);
		if(result == 0) {
			return "error";
		}
		return "success";
	}
	
	@GetMapping("/get")
	public Object getNewsInfo() {
		Criteria criteria = new Criteria();
//		String str = "100' or title like %aa% or '1=1";
//		str = str.replaceAll("\\'", "\\\\'");
//		criteria.eq("id", str);
//		String str = "%aa";
//		criteria.like("author", str);
//		criteria.like("enterprise.enterpriseName", "网易");
//		criteria.like("author", "%aa%");
		criteria.eq("enterpriseInfo.id", 1L);
		criteria.eq("departmentInfo.id", 1L);
		String[] fieldList = {"id", "title", "type", "author", "content"};
		NewsInfo newsInfo = newsInfoService.getNewsInfo(criteria, fieldList);
		return newsInfo;
	}
	
	@GetMapping("/all")
	public Object listAllNewsInfo() {
		Criteria criteria = new Criteria();
//		criteria.like("enterprise.enterpriseName", "网易");
//		criteria.like("author", "aa");
		criteria.eq("enterpriseInfo.id", 1L);
//		criteria.eq("departmentInfo.id", 1L);
		criteria.orderBy("publishTime", "ASC");
		String[] fieldList = {"id", "title", "type", "author", "publishTime", "content", "enterpriseInfo.enterpriseName"};
		List<NewsInfo> list = newsInfoService.listAllNewsInfo(criteria, fieldList);
		return list;
	}
	
	@GetMapping("/paging")
	public Object getNewsInfoPagination() {
		Integer pageNum = 2;
		Integer pageSize = 5;
		Criteria criteria = new Criteria();
		criteria.like("enterpriseInfo.enterpriseName", "网易");
		String[] fieldList = {"id", "title", "author", "publishTime", "content", "enterpriseInfo.enterpriseName"};
		return newsInfoService.getNewsInfoPagination(pageNum, pageSize, criteria, fieldList);
	}
	
}
