package com.tq.entity;

import java.io.Serializable;

/**
 * 用户表
 * 
 * @author lenovo
 *
 */
public class User implements Serializable {
	private int uid;
	// 账户
	private String name;
	// 密码
	private String password;
	// 身份 管理员 or 普通用户
	private String identity;
	// 上次登录ip地址
	private String ip;

	public User() {

	}

	public User(String name, String password) {
		this.name = name;
		this.password = password;
	}

	public User(String name, String password, String identity) {
		this.name = name;
		this.password = password;
		this.identity = identity;
	}

	public String getIdentity() {
		return identity;
	}

	public void setIdentity(String identity) {
		this.identity = identity;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
