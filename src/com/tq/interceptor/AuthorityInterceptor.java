package com.tq.interceptor;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import com.tq.entity.User;

/**
 * 登录过滤管理器
 * 
 * @author lenovo
 *
 */
public class AuthorityInterceptor extends AbstractInterceptor {

	@Override
	public String intercept(ActionInvocation arg0) throws Exception {
		// 查看是否登录
		ActionContext act = ActionContext.getContext();
		User user = (User) act.getSession().get("user");
		if (user == null) {
			// 没有登录
			return Action.LOGIN;
		} else {
			return arg0.invoke();
		}
	}

}
