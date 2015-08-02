package com.tq.entity;

import java.io.Serializable;
import java.sql.Clob;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.tq.dto.ArticleDTO;

/**
 * ����
 * 
 * @author lenovo
 *
 */
public class Article implements Serializable {
	private int aid;
	// ����
	private String title;
	// ����
	private Date date;
	// ����
	private Clob text;
	// �������
	private Category category;
	// �������
	private int view;
	// ���Լ���
	private Set<Message> messages;
	// ��ǩ����
	private Set<Label> labels;
	// ժҪ��ʾ
	private String remark;

	public Article() {
	}

	public Article(ArticleDTO a) {
		// �������Ĳ���ת
		this.aid = a.getId();
		this.title = a.getTitle();
		this.date = a.getDate();
		this.labels = a.getLabels();
		this.view = a.getView();
		this.category = a.getCategory();
		this.remark = a.getRemark();
		List<Message> li = a.getMessages();
		Set<Message> set = new HashSet<Message>();
		if (li != null) {
			for (Message message : li) {
				set.add(message);
			}
		}
		this.messages = set;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public int getAid() {
		return aid;
	}

	public void setAid(int aid) {
		this.aid = aid;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Clob getText() {
		return text;
	}

	public void setText(Clob text) {
		this.text = text;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public int getView() {
		return view;
	}

	public void setView(int view) {
		this.view = view;
	}

	public Set<Message> getMessages() {
		return messages;
	}

	public void setMessages(Set<Message> messages) {
		this.messages = messages;
	}

	public Set<Label> getLabels() {
		return labels;
	}

	public void setLabels(Set<Label> labels) {
		this.labels = labels;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + aid;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Article other = (Article) obj;
		if (aid != other.aid)
			return false;
		return true;
	}

}
