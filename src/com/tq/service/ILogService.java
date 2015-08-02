package com.tq.service;

import java.util.List;

import com.tq.entity.Log;
import com.tq.entity.User;

public interface ILogService {

	/**
	 * 添加登陆日志
	 */
	public void addLoginLog(User user, String result);

	/**
	 * 查询共有多少条登陆日志
	 * 
	 * @param pageSize
	 * 
	 * @return
	 */
	public int LoginLogSum(int pageSize);

	/**
	 * 查询所有登陆日志
	 * 
	 * @param pageNo
	 * @param pageSize
	 */
	public List<Log> findLoginLog(int pageNo, int pageSize);

	public void addDoLog(String description, String result, String object);

	/**
	 * 查询共有多少条操作日志
	 * 
	 * @param pageSize
	 * 
	 * @return
	 */
	public int DoLogSum(int pageSize);

	public List<Log> findDoLog(int pageNo, int pageSize);
}
