package com.tq.action;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.ServletRequestAware;

import com.octo.captcha.module.servlet.image.SimpleImageCaptchaServlet;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.tq.entity.User;
import com.tq.service.ILogService;
import com.tq.service.IMessageService;
import com.tq.service.IUserService;

public class LoginAction extends ActionSupport implements ServletRequestAware {
	private User user;
	private IUserService service;
	private String jcaptcha;
	private HttpServletRequest request;
	private IMessageService messageservice;
	private ILogService logservice;

	public String getJcaptcha() {
		return jcaptcha;
	}

	public void setJcaptcha(String jcaptcha) {
		this.jcaptcha = jcaptcha;
	}

	public void setService(IUserService service) {
		this.service = service;
	}

	public IUserService getService() {
		return service;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String logout() throws Exception {
		ActionContext act = ActionContext.getContext();
		if (act.getSession().get("user") != null) {
			act.getSession().remove("user");
		}
		return SUCCESS;
	}

	/*
	 * Ĭ�ϼ���û����ظ�
	 * 
	 * �û���¼
	 */
	@Override
	public String execute() throws Exception {
		ActionContext act = ActionContext.getContext();
		// ��¼�� ֱ�ӽ���
		if (act.getSession().get("user") != null) {
			return SUCCESS;
		}
		if (jcaptcha == null) {// ���Ӳ���ҳ����ת����
			return ERROR;
		}
		boolean flag = SimpleImageCaptchaServlet.validateResponse(request,
				jcaptcha);
		if (!flag) {
			addActionMessage("��֤���������");
			return ERROR;
		}
		// ִ���û���¼
		// �޸�����ͻ��˴���127.0.0.1����
		String ip = request.getHeader("x-forwarded-for") == null ? request
				.getRemoteAddr() : request.getHeader("x-forwarded-for");

		User ruser = null;
		try {
			ruser = service.login(user, ip);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (ruser != null) {// ��½�ɹ�
			int num = messageservice.noRead();
			logservice.addLoginLog(ruser, "�ɹ�");
			// ��user����session��
			act.getSession().put("user", ruser);
			act.getSession().put("noread", num);
			return SUCCESS;
		} else {
			addActionMessage("�û������������");
			try {
				logservice.addLoginLog(user, "ʧ��");
			} catch (Exception e) {
				e.printStackTrace();
			}
			return ERROR;
		}
	}

	/*
	 * �����֤����Ҫ��request����
	 */
	@Override
	public void setServletRequest(HttpServletRequest arg0) {
		this.request = arg0;
	}

	public void setMessageservice(IMessageService messageservice) {
		this.messageservice = messageservice;
	}

	public void setLogservice(ILogService logservice) {
		this.logservice = logservice;
	}

}
