package com.tq.action;

import java.util.List;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.tq.entity.Message;
import com.tq.service.ILogService;
import com.tq.service.IMessageService;

public class MessageAction extends ActionSupport {
	private Message message;
	private IMessageService service;
	private List<Message> messages;
	private ILogService logservice;

	@Override
	public String execute() throws Exception {
		if (message.getName() == null || message.getName() == ""
				|| message.getText() == null || message.getText() == ""
				|| message.getArticle() == null) {
			return ERROR;
		}
		try {
			service.saveMessage(message);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return SUCCESS;
	}

	/**
	 * �����б�
	 * 
	 * @return
	 * @throws Exception
	 */
	public String messageList() throws Exception {
		// service��δ����Ϊ�Ѷ�
		List<Message> list = service.findAllMessage();
		// ����Ѷ�
		service.markread();
		setMessages(list);
		// �������Ϊ0
		ActionContext act = ActionContext.getContext();
		act.getSession().put("noread", 0);
		return SUCCESS;
	}

	/**
	 * ɾ������
	 * 
	 * @return
	 * @throws Exception
	 */
	public String deleteMessage() throws Exception {
		ActionContext act = ActionContext.getContext();
		Map<String, Object> params = act.getParameters();
		String[] id = (String[]) params.get("id");
		int mid = 0;
		// ���id
		if (id == null) {
			return SUCCESS;// û�в���
		} else {
			mid = Integer.parseInt(id[0]);
		}
		service.deleteMessage(mid);
		logservice.addDoLog("ɾ��������ţ�" + mid, "�ɹ�", "����");
		return SUCCESS;
	}

	public Message getMessage() {
		return message;
	}

	public void setMessage(Message message) {
		this.message = message;
	}

	public void setService(IMessageService service) {
		this.service = service;
	}

	public List<Message> getMessages() {
		return messages;
	}

	public void setMessages(List<Message> messages) {
		this.messages = messages;
	}

	public void setLogservice(ILogService logservice) {
		this.logservice = logservice;
	}

}
