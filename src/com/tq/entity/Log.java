package com.tq.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 日志
 * 
 * @author lenovo
 *
 */
public class Log implements Serializable {
	private int loid;
	// 操作账户
	private User user;
	// 操作描述
	private String description;
	// 操作结果
	private String result;
	// 操作时间
	private Date date;
	// 操作对象
	private String object;

	public Log() {
	}

	public Log(User user, String description, String result, Date date) {
		this.user = user;
		this.description = description;
		this.result = result;
		this.date = date;
	}

	public int getLoid() {
		return loid;
	}

	public void setLoid(int loid) {
		this.loid = loid;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getObject() {
		return object;
	}

	public void setObject(String object) {
		this.object = object;
	}

}
