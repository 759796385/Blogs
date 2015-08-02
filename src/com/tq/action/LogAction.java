package com.tq.action;

import java.util.List;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.tq.entity.Log;
import com.tq.service.ILogService;

public class LogAction extends ActionSupport {
	private List<Log> logs;
	private int pageNo;
	private int pageSum;
	private int pageSize;
	private ILogService service;

	/*
	 * ��ѯ���е�½��־
	 */
	@Override
	public String execute() throws Exception {
		if (pageSize == 0) {
			setPageSize(30);
		}
		// ���������
		setPageSum(service.LoginLogSum(pageSize));
		// ��ȡpage��
		ActionContext act = ActionContext.getContext();
		Map<String, Object> params = act.getParameters();
		String[] pages = (String[]) params.get("page");
		// ���id
		if (pages == null) {
			setPageNo(1);
		} else {
			// �淶��ǰҳ
			setPageNo(Integer.parseInt(pages[0]));
		}
		List<Log> result = service.findLoginLog(pageNo, pageSize);
		this.logs = result;
		return SUCCESS;
	}

	public String doLogList() throws Exception {
		if (pageSize == 0) {
			setPageSize(30);
		}
		// ���������
		setPageSum(service.DoLogSum(pageSize));
		// ��ȡpage��
		ActionContext act = ActionContext.getContext();
		Map<String, Object> params = act.getParameters();
		String[] pages = (String[]) params.get("page");
		// ���id
		if (pages == null) {
			setPageNo(1);
		} else {
			// �淶��ǰҳ
			setPageNo(Integer.parseInt(pages[0]));
		}
		List<Log> result = service.findDoLog(pageNo, pageSize);
		this.logs = result;
		return SUCCESS;
	}

	public List<Log> getLogs() {
		return logs;
	}

	public void setLogs(List<Log> logs) {
		this.logs = logs;
	}

	public int getPageNo() {
		return pageNo;
	}

	public void setPageNo(int pageNo) {
		if (pageNo <= 0) {
			// ҳ�汻�۸�С��1 ����Ϊһ
			this.pageNo = 1;
		} else if (pageNo > getPageSum()) {
			// ҳ��������ҳ���� �������ֵ
			this.pageNo = getPageSum();
		} else {
			this.pageNo = pageNo;
		}
	}

	public int getPageSum() {
		return pageSum;
	}

	public void setPageSum(int pageSum) {
		this.pageSum = pageSum;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public void setService(ILogService service) {
		this.service = service;
	}

}
