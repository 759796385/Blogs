package com.tq.interceptor;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import com.tq.entity.User;

/**
 * 非管理员权限管理
 * 
 * @author lenovo
 *
 */
public class ManagerInterceptor extends AbstractInterceptor {

	@Override
	public String intercept(ActionInvocation arg0) throws Exception {
		ActionContext act = ActionContext.getContext();
		User user = (User) act.getSession().get("user");
		if (user.getIdentity().equals("管理员")) {
			// 是管理员
			return arg0.invoke();
		} else {
			// 测试人员
			return "menu";
		}
	}
}
