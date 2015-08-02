package com.tq.action;

import java.util.List;

import com.opensymphony.xwork2.ActionSupport;
import com.tq.entity.Article;
import com.tq.service.IArticleService;

public class IndexAction extends ActionSupport {
	private int pageNo;
	private int pageSum;
	private int pageSize;
	private IArticleService service;
	private List<Article> articles;

	@Override
	public String execute() throws Exception {
		setPageNo(pageNo);
		if (pageSize == 0) {
			setPageSize(10);
		}
		int sum = service.getPageNum(pageSize);
		setPageSum(sum);
		List<Article> result = service.getArticleByTimeList(pageNo, pageSize);
		setArticles(result);
		return SUCCESS;
	}

	public void setPageNo(int pageNo) {
		if (pageNo <= 0) {
			// 页面被篡改小于1 便置为一
			this.pageNo = 1;
		} else if (pageNo > getPageSum()) {
			// 页面大于最大页面数 ，置最大值
			this.pageNo = getPageSum();
		} else {
			this.pageNo = pageNo;
		}
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getPageSum() {
		return pageSum;
	}

	public void setPageSum(int pageSum) {
		this.pageSum = pageSum;
	}

	public int getPageNo() {
		return pageNo;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setService(IArticleService service) {
		this.service = service;
	}

	public List<Article> getArticles() {
		return articles;
	}

	public void setArticles(List<Article> articles) {
		this.articles = articles;
	}

}
