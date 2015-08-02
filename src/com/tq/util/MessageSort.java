package com.tq.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Set;

import com.tq.entity.Message;

public class MessageSort {
	/**
	 * 将留言进行排序
	 * 
	 * @param messages
	 * @return
	 */
	public static List<List<Message>> sort(Set<Message> messages) {
		List<Message> list = new ArrayList<Message>(messages);
		Collections.sort(list, new Comparator<Message>() {
			@Override
			public int compare(Message m1, Message m2) {
				// 由于list的message是按id从小到大排列的
				return m1.getMid() - m2.getMid();
			}
		});
		// 现在list是按id从小到大拍好序的了
		List<List<Message>> result = new ArrayList<List<Message>>();
		List<Message> flag = new ArrayList<Message>();
		for (Message message : list) {
			if (message.getParentmsg() == null) {
				// 根节点
				flag = new ArrayList<Message>();
				// 保证根节点是逆序，即最新留言
				flag.add(message);
				result.add(0, flag);
			} else {
				// 这个信息有父节点
				Message ms = message.getParentmsg();
				// 遍历父节点
				for (List<Message> message2 : result) {
					if (message2.contains(ms)) {
						// 将子节点放入对应的父节点列表
						message2.add(message);
					}
				}
			}
		}
		return result;
	}
}
