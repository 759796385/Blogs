package com.tq.service;

import com.tq.entity.User;

public interface IUserService {

	/**
	 * �û���¼
	 * 
	 * @param user��ip��ַ
	 * @return
	 * @throws Exception
	 */
	public User login(User user, String ipAddr) throws Exception;

}
