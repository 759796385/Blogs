package com.tq.service.impl;

import java.util.Date;
import java.util.List;

import org.hibernate.Hibernate;

import com.tq.DAO.IMessageDAO;
import com.tq.entity.Message;
import com.tq.service.IMessageService;

public class MessageServiceImpl implements IMessageService {
	private IMessageDAO dao;

	public void setDao(IMessageDAO dao) {
		this.dao = dao;
	}

	@Override
	public void saveMessage(Message message) {
		message.setDate(new Date());
		message.setStatus(Boolean.parseBoolean("false"));
		dao.save(message);
	}

	@Override
	public List<Message> findAllMessage() {
		List<Message> result = dao.findAllByTime(Message.class);
		for (Message message : result) {
			Hibernate.initialize(message.getArticle());
		}
		return result;
	}

	@Override
	public void markread() {
		List<Message> list = dao.findNoRead();
		if (list == null) {
			return;
		}
		for (Message message : list) {
			message.setStatus(true);
			dao.save(message);
		}
	}

	@Override
	public void deleteMessage(int mid) {
		Message message = dao.get(Message.class, mid);
		message.setName("-该用户已被屏蔽-");
		message.setText("**内容有问题，已被屏蔽**");
		dao.update(message);
	}

	@Override
	public int noRead() {
		return dao.findNoRead() == null ? 0 : dao.findNoRead().size();
	}

}
