package com.tq.service;

import java.util.List;

import com.tq.entity.Log;
import com.tq.entity.User;

public interface ILogService {

	/**
	 * ��ӵ�½��־
	 */
	public void addLoginLog(User user, String result);

	/**
	 * ��ѯ���ж�������½��־
	 * 
	 * @param pageSize
	 * 
	 * @return
	 */
	public int LoginLogSum(int pageSize);

	/**
	 * ��ѯ���е�½��־
	 * 
	 * @param pageNo
	 * @param pageSize
	 */
	public List<Log> findLoginLog(int pageNo, int pageSize);

	public void addDoLog(String description, String result, String object);

	/**
	 * ��ѯ���ж�����������־
	 * 
	 * @param pageSize
	 * 
	 * @return
	 */
	public int DoLogSum(int pageSize);

	public List<Log> findDoLog(int pageNo, int pageSize);
}
