package com.tq.DAO;

import java.util.List;

import com.tq.entity.Message;

public interface IMessageDAO extends BaseDAO<Message> {

	/**
	 * ����ʱ�����
	 * 
	 * @param class1
	 * @return
	 */
	List<Message> findAllByTime(Class<Message> class1);

	/**
	 * ����δ����message
	 * 
	 * @return
	 */
	List<Message> findNoRead();

}
