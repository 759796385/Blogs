package com.tq.action;

import java.util.HashSet;
import java.util.Set;

import com.opensymphony.xwork2.ActionSupport;
import com.tq.dto.ArticleDTO;
import com.tq.entity.Label;
import com.tq.service.IArticleService;
import com.tq.service.ILogService;

public class WriteArticleAction extends ActionSupport {
	private ArticleDTO article;
	private String labels;
	private IArticleService service;
	private ILogService logservice;

	public void setService(IArticleService service) {
		this.service = service;
	}

	public void setLogservice(ILogService logservice) {
		this.logservice = logservice;
	}

	public ArticleDTO getArticle() {
		return article;
	}

	public void setArticle(ArticleDTO article) {
		this.article = article;
	}

	public String getLabels() {
		return labels;
	}

	public void setLabels(String labels) {
		this.labels = labels;
	}

	@Override
	public String execute() throws Exception {
		// labelsת���ɱ�ǩ
		String[] l = labels.split(",");
		Set<Label> set = new HashSet<Label>();
		for (String string : l) {
			Label la = new Label(string);
			set.add(la);
		}
		article.setLabels(set);
		try {
			service.saveArticle(article);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (article.getId() != 0) {
			// �޸�����
			logservice.addDoLog("�޸�����:" + article.getTitle(), "�ɹ�", "����");
		} else {
			// д������
			logservice.addDoLog("д����:" + article.getTitle(), "�ɹ�", "����");
		}
		return SUCCESS;
	}
}
