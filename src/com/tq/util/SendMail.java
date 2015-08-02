package com.tq.util;

import java.util.Date;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.tq.dto.MySecurity;

public class SendMail {
	public static void send(String content) throws Exception {
		InternetAddress[] address = null;
		String mailserver = "smtp.sina.cn"; // ��������������ַ
		String from = "a759796385@sina.cn"; // ������
		String to = "759796385@qq.com"; // �ռ���
		String subject = "��ص�½����"; // ����
		String message = content; // �ʼ�����
		Properties pro = null;
		pro = System.getProperties();
		pro.put("mail.smtp.host", mailserver); // �趨Mail������
		pro.put("mail.smtp.auth", "true"); // ��ʹ�ô���Э��

		// �����û�
		MySecurity mses = new MySecurity(from, "����");
		Session mailSession = Session.getDefaultInstance(pro, mses); // �����µ�session
		mailSession.setDebug(false); // ����Ҫ����
		Message msg = new MimeMessage(mailSession); // �����µ��ʼ���Ϣ
		try {
			msg.setFrom(new InternetAddress(from)); // �趨������
			address = InternetAddress.parse(to, false); // �趨�����ʼ��������˵�����

			msg.setRecipients(Message.RecipientType.TO, address); // �趨�ʼ����ͷ�ʽ
			msg.setSubject(subject); // �趨����
			msg.setSentDate(new Date()); // �趨����ʱ��
			msg.setText(message); // �趨��������
			Transport.send(msg, msg.getAllRecipients());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
