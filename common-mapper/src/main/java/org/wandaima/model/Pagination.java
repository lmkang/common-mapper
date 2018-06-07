package org.wandaima.model;

import java.util.List;

/**
 * 分页Model
 * @author lmkang25@163.com
 *
 * @param <T>
 */
public class Pagination<T> {

	private Integer currentPage;// 当前分页页码
	private Integer pageSize;// 每页的记录数
	private List<T> recordList;// 分页记录
	private long recordCount;// 总记录数
	private Integer pageCount;// 总页数
	
	/**
	 * 构造方法
	 * @param recordList 分页记录
	 * @param recordCount 总记录数
	 * @param currentPage 当前页码
	 * @param pageSize 每页的记录数
	 */
	public Pagination(List<T> recordList, long recordCount, Integer currentPage, Integer pageSize) {
		this.recordList = recordList;
		this.recordCount = recordCount;
		this.currentPage = currentPage;
		this.pageSize = pageSize;
		this.pageCount = (int) ((recordCount + pageSize - 1) / pageSize);
	}
	
	public Integer getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}
	public Integer getPageSize() {
		return pageSize;
	}
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
	public List<T> getRecordList() {
		return recordList;
	}
	public void setRecordList(List<T> recordList) {
		this.recordList = recordList;
	}
	public long getRecordCount() {
		return recordCount;
	}
	public void setRecordCount(long recordCount) {
		this.recordCount = recordCount;
	}
	public Integer getPageCount() {
		return pageCount;
	}
	public void setPageCount(Integer pageCount) {
		this.pageCount = pageCount;
	}
	
}
