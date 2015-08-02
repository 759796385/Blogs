package com.tq.entity;

import java.io.Serializable;
import java.util.Set;

/**
 * ���
 * 
 * @author lenovo
 *
 */
public class Category implements Serializable {
	private int cid;
	// �������
	private String name;

	// ����������
	private Set<Article> article;

	public Category() {
	}

	public Category(String name) {
		this.name = name;
	}

	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<Article> getArticle() {
		return article;
	}

	public void setArticle(Set<Article> article) {
		this.article = article;
	}

}
