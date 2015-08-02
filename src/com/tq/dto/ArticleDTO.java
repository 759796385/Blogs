package com.tq.dto;

import java.util.Date;
import java.util.List;
import java.util.Set;

import com.tq.entity.Category;
import com.tq.entity.Label;
import com.tq.entity.Message;

/**
 * 文章
 * 
 * @author lenovo
 *
 */
public class ArticleDTO {
	private int id;
	// 标题
	private String title;
	// 日期
	private Date date;
	// 内容
	private String text;
	// 文章类别
	private Category category;
	// 浏览次数
	private int view;
	// 留言集合
	private List<Message> messages;
	// 标签集合
	private Set<Label> labels;
	// 摘要显示
	private String remark;

	public ArticleDTO() {
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public String getText() {
		return text;
	}

	public void setText(String text) {
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

	public List<Message> getMessages() {
		return messages;
	}

	public void setMessages(List<Message> messages) {
		this.messages = messages;
	}

	public Set<Label> getLabels() {
		return labels;
	}

	public void setLabels(Set<Label> labels) {
		this.labels = labels;
	}

}
