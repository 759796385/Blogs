package com.tq.service;

import java.util.List;

import com.tq.entity.Message;

public interface IMessageService {

	/**
	 * ����ظ�
	 * 
	 * @param message
	 */
	public void saveMessage(Message message);

	/**
	 * 
	 */
	public List<Message> findAllMessage();

	/**
	 * ������δ������Ѷ�
	 */
	public void markread();

	/**
	 * ������
	 * 
	 * @return
	 */
	public int noRead();

	/**
	 * ��������
	 * 
	 * @param mid
	 */
	public void deleteMessage(int mid);

}
