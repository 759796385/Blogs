package com.tq.service.impl;

import java.util.Date;
import java.util.List;

import org.hibernate.Hibernate;

import com.opensymphony.xwork2.ActionContext;
import com.tq.DAO.ILogDAO;
import com.tq.entity.Log;
import com.tq.entity.User;
import com.tq.service.ILogService;

public class LogServiceImpl implements ILogService {
	private ILogDAO dao;

	public void setDao(ILogDAO dao) {
		this.dao = dao;
	}

	@Override
	public void addLoginLog(User user, String result) {
		Log log = new Log();
		log.setDate(new Date());
		log.setDescription("ÕË»§:" + user.getName());
		log.setObject("µÇÂ½");
		log.setResult(result);
		dao.save(log);
	}

	@Override
	public int LoginLogSum(int PageSize) {
		int sum = dao.LoginLogSum();
		return sum % PageSize == 0 ? sum / PageSize : sum / PageSize + 1;
	}

	@Override
	public List<Log> findLoginLog(int pageNo, int pageSize) {
		return dao.findLogLog(pageNo, pageSize);
	}

	@Override
	public void addDoLog(String description, String result, String object) {
		ActionContext act = ActionContext.getContext();
		User user = (User) act.getSession().get("user");
		Log log = new Log();
		log.setDate(new Date());
		log.setDescription(description);
		log.setObject(object);
		log.setResult(result);
		log.setUser(user);
		dao.save(log);
	}

	@Override
	public int DoLogSum(int pageSize) {
		int sum = dao.DoLogSum();
		return sum % pageSize == 0 ? sum / pageSize : sum / pageSize + 1;
	}

	@Override
	public List<Log> findDoLog(int pageNo, int pageSize) {
		List<Log> dos = dao.findDoLog(pageNo, pageSize);
		for (Log log : dos) {
			Hibernate.initialize(log.getUser());
		}
		return dos;
	}
}
