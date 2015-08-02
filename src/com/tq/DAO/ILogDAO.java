package com.tq.DAO;

import java.util.List;

import com.tq.entity.Log;

public interface ILogDAO extends BaseDAO<Log> {

	/**
	 * 查询有多少条登陆日志
	 * 
	 * @return
	 */
	public int LoginLogSum();

	/**
	 * 分页查找登陆日志
	 * 
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	public List<Log> findLogLog(int pageNo, int pageSize);

	/**
	 * 查询有多少条操作日志
	 * 
	 * @return
	 */
	public int DoLogSum();

	/**
	 * 分页查找操作日志
	 * 
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	public List<Log> findDoLog(int pageNo, int pageSize);

}
