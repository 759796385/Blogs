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
	 * 默认检查用户名重复
	 * 
	 * 用户登录
	 */
	@Override
	public String execute() throws Exception {
		ActionContext act = ActionContext.getContext();
		// 登录过 直接进入
		if (act.getSession().get("user") != null) {
			return SUCCESS;
		}
		if (jcaptcha == null) {// 即从博客页面跳转过来
			return ERROR;
		}
		boolean flag = SimpleImageCaptchaServlet.validateResponse(request,
				jcaptcha);
		if (!flag) {
			addActionMessage("验证码输入错误");
			return ERROR;
		}
		// 执行用户登录
		// 修复反向客户端代理127.0.0.1问题
		String ip = request.getHeader("x-forwarded-for") == null ? request
				.getRemoteAddr() : request.getHeader("x-forwarded-for");

		User ruser = null;
		try {
			ruser = service.login(user, ip);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (ruser != null) {// 登陆成功
			int num = messageservice.noRead();
			logservice.addLoginLog(ruser, "成功");
			// 将user放入session中
			act.getSession().put("user", ruser);
			act.getSession().put("noread", num);
			return SUCCESS;
		} else {
			addActionMessage("用户名或密码错误");
			try {
				logservice.addLoginLog(user, "失败");
			} catch (Exception e) {
				e.printStackTrace();
			}
			return ERROR;
		}
	}

	/*
	 * 获得验证码需要的request参数
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
