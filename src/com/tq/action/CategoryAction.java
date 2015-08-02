package com.tq.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.tq.entity.Article;
import com.tq.entity.Category;
import com.tq.service.ICategoryService;
import com.tq.service.ILogService;

public class CategoryAction extends ActionSupport {
	private Category category;
	private ICategoryService service;
	private ILogService logservice;
	private List<Article> articles;

	/**
	 * 获得指定id的全部文章
	 * 
	 * @return
	 */
	public String findArticleByCategoryId() {
		ActionContext act = ActionContext.getContext();
		Map<String, Object> params = act.getParameters();
		String[] id = (String[]) params.get("id");
		int cid = 0;
		// 获得id
		if (id == null) {
			return ERROR;// 没有参数
		} else {
			cid = Integer.parseInt(id[0]);
		}
		Category ca = service.findCategory(cid);
		Set<Article> a = ca.getArticle();
		List<Article> ar = new ArrayList<Article>();
		for (Article article : a) {
			ar.add(article);
		}
		this.articles = ar;
		return SUCCESS;
	}

	/*
	 * 添加类别
	 * 
	 * @see com.opensymphony.xwork2.ActionSupport#execute()
	 */
	@Override
	public String execute() throws Exception {
		boolean flag = false;
		flag = service.saveCategory(category);
		if (flag) {
			logservice.addDoLog("添加类别:" + category.getName(), "成功", "类别");
			return SUCCESS;
		} else {
			logservice.addDoLog("添加类别:" + category.getName(), "失败", "类别");
			addActionError("添加失败，标签已存在");
			return ERROR;
		}
	}

	private List<Category> categorys;

	/**
	 * 分类集合
	 * 
	 * @return
	 * @throws Exception
	 */
	public String categoryList() throws Exception {
		try {
			List<Category> ca = service.allCategory();
			setCategorys(ca);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return SUCCESS;
	}

	/**
	 * 根据id删除类型
	 * 
	 * @return
	 * @throws Exception
	 */
	public String deleteCategory() throws Exception {
		ActionContext act = ActionContext.getContext();
		Map<String, Object> params = act.getParameters();
		String[] id = (String[]) params.get("id");
		int cid = 0;
		// 获得id
		if (id == null) {
			return ERROR;// 没有参数
		} else {
			cid = Integer.parseInt(id[0]);
		}
		service.deleteById(cid);
		logservice.addDoLog("删除类别:" + cid, "成功", "类别");
		return SUCCESS;
	}

	/**
	 * 修改名字
	 * 
	 * @return
	 * @throws Exception
	 */
	public String updateCategory() throws Exception {
		boolean flag = service.updateCategory(category);
		if (flag) {
			logservice.addDoLog("修改类别名:" + category.getName(), "成功", "类别");
			return SUCCESS;
		} else {
			logservice.addDoLog("修改类别名:" + category.getName(), "失败", "类别");
			addActionError("类名重复了哦");
			return ERROR;
		}
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Category getCategory() {
		return category;
	}

	public void setService(ICategoryService service) {
		this.service = service;
	}

	public List<Category> getCategorys() {
		return categorys;
	}

	public void setCategorys(List<Category> categorys) {
		this.categorys = categorys;
	}

	public List<Article> getArticles() {
		return articles;
	}

	public void setArticles(List<Article> articles) {
		this.articles = articles;
	}

	public void setLogservice(ILogService logservice) {
		this.logservice = logservice;
	}

}
