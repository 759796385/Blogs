package com.tq.DAO;

import java.util.List;

import com.tq.entity.Log;

public interface ILogDAO extends BaseDAO<Log> {

	/**
	 * ��ѯ�ж�������½��־
	 * 
	 * @return
	 */
	public int LoginLogSum();

	/**
	 * ��ҳ���ҵ�½��־
	 * 
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	public List<Log> findLogLog(int pageNo, int pageSize);

	/**
	 * ��ѯ�ж�����������־
	 * 
	 * @return
	 */
	public int DoLogSum();

	/**
	 * ��ҳ���Ҳ�����־
	 * 
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	public List<Log> findDoLog(int pageNo, int pageSize);

}
