package com.tq.interceptor;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import com.tq.entity.User;

/**
 * �ǹ���ԱȨ�޹���
 * 
 * @author lenovo
 *
 */
public class ManagerInterceptor extends AbstractInterceptor {

	@Override
	public String intercept(ActionInvocation arg0) throws Exception {
		ActionContext act = ActionContext.getContext();
		User user = (User) act.getSession().get("user");
		if (user.getIdentity().equals("����Ա")) {
			// �ǹ���Ա
			return arg0.invoke();
		} else {
			// ������Ա
			return "menu";
		}
	}
}
