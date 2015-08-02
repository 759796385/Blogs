package com.tq.action;

import java.util.List;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.tq.entity.Article;
import com.tq.service.IArticleService;
import com.tq.service.ILogService;

public class ArticleAction extends ActionSupport {
	// 页面要接受的article
	private List<Article> articles;
	// 总共页数
	private int pageSum;
	// 当前页数
	private int pageNo;
	// 默认一页十条
	public static final int PAGESIZE = 10;
	// 单个文章对象
	public Article article;
	private ILogService logservice;
	private IArticleService service;

	/*
	 * (non-Javadoc) 分页查询文章列表
	 */
	@Override
	public String execute() throws Exception {
		// 查询总共多少页
		int sum = service.getPageNum(PAGESIZE);
		setPageSum(sum);
		ActionContext act = ActionContext.getContext();
		Map<String, Object> params = act.getParameters();
		String[] pageno = (String[]) params.get("pageNo");
		// 设置当前页
		if (pageno == null) {
			setPageNo(1);
		} else {
			setPageNo(Integer.parseInt(pageno[0]));
		}
		// 查询结果
		List<Article> result = service.getArticleByTimeList(pageNo, PAGESIZE);

		setArticles(result);
		return SUCCESS;
	}

	private String search;

	/**
	 * 关键字查找文章
	 * 
	 * @return
	 * @throws Exception
	 */
	public String search() throws Exception {

		List<Article> ars = service.searchArticle(search);
		this.articles = ars;
		return SUCCESS;
	}

	// 修改文章
	public String modify() throws Exception {
		ActionContext act = ActionContext.getContext();
		Map<String, Object> params = act.getParameters();
		String[] id = (String[]) params.get("id");
		int aid = 0;
		// 获得id
		if (id == null) {
			return ERROR;// 没有参数
		} else {
			aid = Integer.parseInt(id[0]);
		}
		// 获得文章
		Article aa = service.getArticleById(aid);
		setArticle(aa);
		return SUCCESS;
	}

	// 删除文章
	public String delete() throws Exception {
		ActionContext act = ActionContext.getContext();
		Map<String, Object> params = act.getParameters();
		String[] id = (String[]) params.get("id");
		int aid = 0;
		// 获得id
		if (id == null) {
			return ERROR;// 没有参数
		} else {
			aid = Integer.parseInt(id[0]);
		}
		service.deleteArticleById(aid);
		logservice.addDoLog("删除文章:" + aid, "成功", "博文");
		return SUCCESS;
	}

	public Article getArticle() {
		return article;
	}

	public void setArticle(Article article) {
		this.article = article;
	}

	public List<Article> getArticles() {
		return articles;
	}

	public void setArticles(List<Article> articles) {
		this.articles = articles;
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

	public void setLogservice(ILogService logservice) {
		this.logservice = logservice;
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

	public IArticleService getService() {
		return service;
	}

	public void setService(IArticleService service) {
		this.service = service;
	}

	public void setSearch(String search) {
		this.search = search;
	}

	public String getSearch() {
		return search;
	}

}
