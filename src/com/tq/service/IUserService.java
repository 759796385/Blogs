package com.tq.service;

import com.tq.entity.User;

public interface IUserService {

	/**
	 * 用户登录
	 * 
	 * @param user和ip地址
	 * @return
	 * @throws Exception
	 */
	public User login(User user, String ipAddr) throws Exception;

}
