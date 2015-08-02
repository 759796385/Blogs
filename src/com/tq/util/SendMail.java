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
		String mailserver = "smtp.sina.cn"; // 新浪邮箱主机地址
		String from = "a759796385@sina.cn"; // 发件人
		String to = "759796385@qq.com"; // 收件人
		String subject = "异地登陆提醒"; // 主题
		String message = content; // 邮件内容
		Properties pro = null;
		pro = System.getProperties();
		pro.put("mail.smtp.host", mailserver); // 设定Mail服务器
		pro.put("mail.smtp.auth", "true"); // 所使用传输协议

		// 创建用户
		MySecurity mses = new MySecurity(from, "密码");
		Session mailSession = Session.getDefaultInstance(pro, mses); // 产生新的session
		mailSession.setDebug(false); // 不需要调试
		Message msg = new MimeMessage(mailSession); // 创建新的邮件信息
		try {
			msg.setFrom(new InternetAddress(from)); // 设定发件人
			address = InternetAddress.parse(to, false); // 设定传送邮件到收信人的信箱

			msg.setRecipients(Message.RecipientType.TO, address); // 设定邮件发送方式
			msg.setSubject(subject); // 设定主题
			msg.setSentDate(new Date()); // 设定发送时间
			msg.setText(message); // 设定发送内容
			Transport.send(msg, msg.getAllRecipients());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
