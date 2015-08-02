package com.tq.DAO;

import java.util.List;

import com.tq.entity.Message;

public interface IMessageDAO extends BaseDAO<Message> {

	/**
	 * 根据时间查找
	 * 
	 * @param class1
	 * @return
	 */
	List<Message> findAllByTime(Class<Message> class1);

	/**
	 * 查找未读的message
	 * 
	 * @return
	 */
	List<Message> findNoRead();

}
