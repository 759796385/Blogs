package com.tq.action;

import java.util.List;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.tq.entity.Article;
import com.tq.service.IArticleService;
import com.tq.service.ILogService;

public class ArticleAction extends ActionSupport {
	// ҳ��Ҫ���ܵ�article
	private List<Article> articles;
	// �ܹ�ҳ��
	private int pageSum;
	// ��ǰҳ��
	private int pageNo;
	// Ĭ��һҳʮ��
	public static final int PAGESIZE = 10;
	// �������¶���
	public Article article;
	private ILogService logservice;
	private IArticleService service;

	/*
	 * (non-Javadoc) ��ҳ��ѯ�����б�
	 */
	@Override
	public String execute() throws Exception {
		// ��ѯ�ܹ�����ҳ
		int sum = service.getPageNum(PAGESIZE);
		setPageSum(sum);
		ActionContext act = ActionContext.getContext();
		Map<String, Object> params = act.getParameters();
		String[] pageno = (String[]) params.get("pageNo");
		// ���õ�ǰҳ
		if (pageno == null) {
			setPageNo(1);
		} else {
			setPageNo(Integer.parseInt(pageno[0]));
		}
		// ��ѯ���
		List<Article> result = service.getArticleByTimeList(pageNo, PAGESIZE);

		setArticles(result);
		return SUCCESS;
	}

	private String search;

	/**
	 * �ؼ��ֲ�������
	 * 
	 * @return
	 * @throws Exception
	 */
	public String search() throws Exception {

		List<Article> ars = service.searchArticle(search);
		this.articles = ars;
		return SUCCESS;
	}

	// �޸�����
	public String modify() throws Exception {
		ActionContext act = ActionContext.getContext();
		Map<String, Object> params = act.getParameters();
		String[] id = (String[]) params.get("id");
		int aid = 0;
		// ���id
		if (id == null) {
			return ERROR;// û�в���
		} else {
			aid = Integer.parseInt(id[0]);
		}
		// �������
		Article aa = service.getArticleById(aid);
		setArticle(aa);
		return SUCCESS;
	}

	// ɾ������
	public String delete() throws Exception {
		ActionContext act = ActionContext.getContext();
		Map<String, Object> params = act.getParameters();
		String[] id = (String[]) params.get("id");
		int aid = 0;
		// ���id
		if (id == null) {
			return ERROR;// û�в���
		} else {
			aid = Integer.parseInt(id[0]);
		}
		service.deleteArticleById(aid);
		logservice.addDoLog("ɾ������:" + aid, "�ɹ�", "����");
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
			// ҳ�汻�۸�С��1 ����Ϊһ
			this.pageNo = 1;
		} else if (pageNo > getPageSum()) {
			// ҳ��������ҳ���� �������ֵ
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
