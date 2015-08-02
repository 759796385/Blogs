package com.tq.service.impl;

import com.tq.DAO.IUserDAO;
import com.tq.entity.User;
import com.tq.service.IUserService;
import com.tq.util.SendMail;

public class UserServiceImpl implements IUserService {
	private IUserDAO dao;

	public void setDao(IUserDAO dao) {
		this.dao = dao;
	}

	/*
	 * 用户登录
	 * 
	 * @see com.tq.service.IUserService#login(com.tq.entity.User)
	 */
	@Override
	public User login(User user, String ipAddr) throws Exception {
		User ruser = dao.login(user);
		if (ruser != null) {// 用户正确
			if (ruser.getIp() != null) {
				if (!ipAddr.equals(ruser.getIp())) {
					// ip地址不对，发送邮件 异地登陆
					try {
						SendMail.send("请注意，您的账号在异地登陆，ip地址为 " + ipAddr
								+ ",如果不是本人操作，请更改密码！");
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			} else {// ip地址为空
				ruser.setIp(ipAddr);
				dao.save(ruser);
			}
		}
		return ruser;
	}
}
