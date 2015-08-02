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
	 * ���ָ��id��ȫ������
	 * 
	 * @return
	 */
	public String findArticleByCategoryId() {
		ActionContext act = ActionContext.getContext();
		Map<String, Object> params = act.getParameters();
		String[] id = (String[]) params.get("id");
		int cid = 0;
		// ���id
		if (id == null) {
			return ERROR;// û�в���
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
	 * ������
	 * 
	 * @see com.opensymphony.xwork2.ActionSupport#execute()
	 */
	@Override
	public String execute() throws Exception {
		boolean flag = false;
		flag = service.saveCategory(category);
		if (flag) {
			logservice.addDoLog("������:" + category.getName(), "�ɹ�", "���");
			return SUCCESS;
		} else {
			logservice.addDoLog("������:" + category.getName(), "ʧ��", "���");
			addActionError("���ʧ�ܣ���ǩ�Ѵ���");
			return ERROR;
		}
	}

	private List<Category> categorys;

	/**
	 * ���༯��
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
	 * ����idɾ������
	 * 
	 * @return
	 * @throws Exception
	 */
	public String deleteCategory() throws Exception {
		ActionContext act = ActionContext.getContext();
		Map<String, Object> params = act.getParameters();
		String[] id = (String[]) params.get("id");
		int cid = 0;
		// ���id
		if (id == null) {
			return ERROR;// û�в���
		} else {
			cid = Integer.parseInt(id[0]);
		}
		service.deleteById(cid);
		logservice.addDoLog("ɾ�����:" + cid, "�ɹ�", "���");
		return SUCCESS;
	}

	/**
	 * �޸�����
	 * 
	 * @return
	 * @throws Exception
	 */
	public String updateCategory() throws Exception {
		boolean flag = service.updateCategory(category);
		if (flag) {
			logservice.addDoLog("�޸������:" + category.getName(), "�ɹ�", "���");
			return SUCCESS;
		} else {
			logservice.addDoLog("�޸������:" + category.getName(), "ʧ��", "���");
			addActionError("�����ظ���Ŷ");
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
