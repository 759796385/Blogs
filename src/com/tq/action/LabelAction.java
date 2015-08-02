package com.tq.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.tq.entity.Article;
import com.tq.entity.Label;
import com.tq.service.ILabelService;
import com.tq.service.ILogService;

public class LabelAction extends ActionSupport {
	private Label label;
	private ILabelService service;
	private ILogService logservice;
	private List<Label> labels;

	public void setLogservice(ILogService logservice) {
		this.logservice = logservice;
	}

	public void setService(ILabelService service) {
		this.service = service;
	}

	public void setLabel(Label label) {
		this.label = label;
	}

	@Override
	public String execute() throws Exception {
		boolean flag = false;
		try {
			flag = service.saveLabel(label);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (flag) {
			logservice.addDoLog("添加标签：" + label.getName(), "成功", "标签");
			return SUCCESS;
		} else {
			logservice.addDoLog("添加标签：" + label.getName(), "失败", "标签");
			addActionError("添加失败，标签已存在");
			return ERROR;
		}
	}

	/**
	 * 标签集合
	 * 
	 * @return
	 * @throws Exception
	 */
	public String labelList() throws Exception {
		List<Label> la = service.allLabels();
		setLabels(la);
		return SUCCESS;
	}

	private List<Article> articles;

	/**
	 * 获得指定标签的全部文章
	 * 
	 * @return
	 * @throws Exception
	 */
	public String findArticleByLabelId() throws Exception {
		ActionContext act = ActionContext.getContext();
		Map<String, Object> params = act.getParameters();
		String[] id = (String[]) params.get("id");
		int lid = 0;
		// 获得id
		if (id == null) {
			return ERROR;// 没有参数
		} else {
			lid = Integer.parseInt(id[0]);
		}
		Label label = service.findLabel(lid);
		Set<Article> a = label.getArticles();
		List<Article> ar = new ArrayList<Article>();
		for (Article article : a) {
			ar.add(article);
		}
		this.articles = ar;
		return SUCCESS;
	}

	/**
	 * 根据id删除标签
	 * 
	 * @return
	 * @throws Exception
	 */
	public String deleteLabel() throws Exception {
		ActionContext act = ActionContext.getContext();
		Map<String, Object> params = act.getParameters();
		String[] id = (String[]) params.get("id");
		int lid = 0;
		// 获得id
		if (id == null) {
			return ERROR;// 没有参数
		} else {
			lid = Integer.parseInt(id[0]);
		}
		service.deleteById(lid);
		logservice.addDoLog("删除标签：序号" + lid, "成功", "标签");
		return SUCCESS;
	}

	public List<Label> getLabels() {
		return labels;
	}

	public void setLabels(List<Label> labels) {
		this.labels = labels;
	}

	public List<Article> getArticles() {
		return articles;
	}

	public void setArticles(List<Article> articles) {
		this.articles = articles;
	}

}
