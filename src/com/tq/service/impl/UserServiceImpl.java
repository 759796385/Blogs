package com.tq.service.impl;

import com.tq.DAO.IUserDAO;
import com.tq.entity.User;
import com.tq.service.IUserService;

public class UserServiceImpl implements IUserService {
	private IUserDAO dao;

	public void setDao(IUserDAO dao) {
		this.dao = dao;
	}

	/*
	 * �û���¼
	 * 
	 * @see com.tq.service.IUserService#login(com.tq.entity.User)
	 */
	@Override
	public User login(User user, String ipAddr) throws Exception {
		User ruser = dao.login(user);
		if (ruser != null) {// �û���ȷ
			if (ruser.getIp() != null) {
				if (!ipAddr.equals(ruser.getIp())) {
					// ip��ַ���ԣ������ʼ� ��ص�½
				}
			} else {// ip��ַΪ��
				ruser.setIp(ipAddr);
				dao.save(ruser);
			}
		}
		return ruser;
	}
}
