package com.tq.service;

import java.util.List;

import com.tq.entity.Message;

public interface IMessageService {

	/**
	 * 保存回复
	 * 
	 * @param message
	 */
	public void saveMessage(Message message);

	/**
	 * 
	 */
	public List<Message> findAllMessage();

	/**
	 * 将所有未读标记已读
	 */
	public void markread();

	/**
	 * 新留言
	 * 
	 * @return
	 */
	public int noRead();

	/**
	 * 屏蔽留言
	 * 
	 * @param mid
	 */
	public void deleteMessage(int mid);

}
