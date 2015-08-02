package com.tq.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * ����
 * 
 * @author lenovo
 *
 */
public class Message implements Serializable {
	private int mid;
	// �ǳ�
	private String name;
	// ����ʱ��
	private Date date;
	// ����
	private String text;
	// ����
	private Article article;
	// �ظ�����Ϣ
	private Message parentmsg;
	// �Ķ�״̬
	private Boolean status;

	public Message() {
	}

	public Message(String name, Date date, Article article, Message parentmsg) {
		this.name = name;
		this.date = date;
		this.article = article;
		this.parentmsg = parentmsg;
	}

	public int getMid() {
		return mid;
	}

	public void setMid(int mid) {
		this.mid = mid;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Article getArticle() {
		return article;
	}

	public void setArticle(Article article) {
		this.article = article;
	}

	public Message getParentmsg() {
		return parentmsg;
	}

	public void setParentmsg(Message parentmsg) {
		this.parentmsg = parentmsg;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + mid;
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
		Message other = (Message) obj;
		if (mid != other.mid)
			return false;
		return true;
	}

}
