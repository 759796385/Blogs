package com.tq.DAO.impl;

import java.util.List;

import com.tq.DAO.IMessageDAO;
import com.tq.entity.Message;

public class MessageDAOImpl extends BaseDAOHibernate4<Message> implements
		IMessageDAO {

	@Override
	public List<Message> findAllByTime(Class<Message> class1) {
		return find("from " + class1.getSimpleName() + " m order by m.mid desc");
	}

	/*
	 * 查找所有未读信息
	 */
	@Override
	public List<Message> findNoRead() {
		return find("from Message m where m.status=?0", false);
	}

}
