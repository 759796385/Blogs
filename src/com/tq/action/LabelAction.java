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
			logservice.addDoLog("��ӱ�ǩ��" + label.getName(), "�ɹ�", "��ǩ");
			return SUCCESS;
		} else {
			logservice.addDoLog("��ӱ�ǩ��" + label.getName(), "ʧ��", "��ǩ");
			addActionError("���ʧ�ܣ���ǩ�Ѵ���");
			return ERROR;
		}
	}

	/**
	 * ��ǩ����
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
	 * ���ָ����ǩ��ȫ������
	 * 
	 * @return
	 * @throws Exception
	 */
	public String findArticleByLabelId() throws Exception {
		ActionContext act = ActionContext.getContext();
		Map<String, Object> params = act.getParameters();
		String[] id = (String[]) params.get("id");
		int lid = 0;
		// ���id
		if (id == null) {
			return ERROR;// û�в���
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
	 * ����idɾ����ǩ
	 * 
	 * @return
	 * @throws Exception
	 */
	public String deleteLabel() throws Exception {
		ActionContext act = ActionContext.getContext();
		Map<String, Object> params = act.getParameters();
		String[] id = (String[]) params.get("id");
		int lid = 0;
		// ���id
		if (id == null) {
			return ERROR;// û�в���
		} else {
			lid = Integer.parseInt(id[0]);
		}
		service.deleteById(lid);
		logservice.addDoLog("ɾ����ǩ�����" + lid, "�ɹ�", "��ǩ");
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
