package com.tq.DAO.impl;

import java.util.List;

import com.tq.DAO.IUserDAO;
import com.tq.entity.User;

public class UserDAOImpl extends BaseDAOHibernate4<User> implements IUserDAO {

	/*
	 * ÓÃ»§µÇÂ¼
	 * 
	 * @see com.tq.DAO.IUserDAO#login(com.tq.entity.User)
	 */
	public User login(User user) throws Exception {
		List<User> list = find("from User u where u.name=?0 and u.password=?1",
				user.getName(), user.getPassword());
		if (list != null && list.size() >= 1) {
			return list.get(0);
		}
		return null;
	}

}
