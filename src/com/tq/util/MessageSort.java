package com.tq.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Set;

import com.tq.entity.Message;

public class MessageSort {
	/**
	 * �����Խ�������
	 * 
	 * @param messages
	 * @return
	 */
	public static List<List<Message>> sort(Set<Message> messages) {
		List<Message> list = new ArrayList<Message>(messages);
		Collections.sort(list, new Comparator<Message>() {
			@Override
			public int compare(Message m1, Message m2) {
				// ����list��message�ǰ�id��С�������е�
				return m1.getMid() - m2.getMid();
			}
		});
		// ����list�ǰ�id��С�����ĺ������
		List<List<Message>> result = new ArrayList<List<Message>>();
		List<Message> flag = new ArrayList<Message>();
		for (Message message : list) {
			if (message.getParentmsg() == null) {
				// ���ڵ�
				flag = new ArrayList<Message>();
				// ��֤���ڵ������򣬼���������
				flag.add(message);
				result.add(0, flag);
			} else {
				// �����Ϣ�и��ڵ�
				Message ms = message.getParentmsg();
				// �������ڵ�
				for (List<Message> message2 : result) {
					if (message2.contains(ms)) {
						// ���ӽڵ�����Ӧ�ĸ��ڵ��б�
						message2.add(message);
					}
				}
			}
		}
		return result;
	}
}
