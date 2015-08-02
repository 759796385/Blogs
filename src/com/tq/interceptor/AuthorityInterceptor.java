package com.tq.interceptor;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import com.tq.entity.User;

/**
 * ��¼���˹�����
 * 
 * @author lenovo
 *
 */
public class AuthorityInterceptor extends AbstractInterceptor {

	@Override
	public String intercept(ActionInvocation arg0) throws Exception {
		// �鿴�Ƿ��¼
		ActionContext act = ActionContext.getContext();
		User user = (User) act.getSession().get("user");
		if (user == null) {
			// û�е�¼
			return Action.LOGIN;
		} else {
			return arg0.invoke();
		}
	}

}
