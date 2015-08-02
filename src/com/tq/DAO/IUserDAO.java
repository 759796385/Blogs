package com.tq.DAO;

import com.tq.entity.User;

public interface IUserDAO extends BaseDAO<User> {

	/**
	 * ÓÃ»§µÇÂ¼¼ì²é
	 * 
	 * @param user
	 * @return User
	 * @throws Exception
	 */
	public User login(User user) throws Exception;

}
