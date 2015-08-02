package com.tq.action;

import java.util.List;
import java.util.Map;
import java.util.Set;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.tq.entity.Article;
import com.tq.entity.Message;
import com.tq.service.IArticleService;
import com.tq.util.MessageSort;

public class ContentAction extends ActionSupport {
	private Article article;
	private IArticleService service;
	private List<List<Message>> messagesList;

	@Override
	public String execute() throws Exception {
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
		this.article = service.readArticleById(aid);
		// 读取一次阅读数还要加一
		Set<Message> messages = article.getMessages();
		this.messagesList = MessageSort.sort(messages);
		return SUCCESS;
	}

	public Article getArticle() {
		return article;
	}

	public void setArticle(Article article) {
		this.article = article;
	}

	public void setService(IArticleService service) {
		this.service = service;
	}

	public List<List<Message>> getMessagesList() {
		return messagesList;
	}

	public void setMessagesList(List<List<Message>> messagesList) {
		this.messagesList = messagesList;
	}

}
