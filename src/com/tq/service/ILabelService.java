package com.tq.service;

import java.util.List;

import com.tq.entity.Label;

public interface ILabelService {
	/**
	 * �����ǩ
	 * 
	 * @param label
	 * @return
	 */
	public boolean saveLabel(Label label);

	/**
	 * ���ȫ����ǩ
	 * 
	 * @return
	 */
	public List<Label> allLabels();

	/**
	 * ����idɾ����ǩ
	 * 
	 * @param lid
	 */
	public void deleteById(int lid);

	/**
	 * ����id��ñ�ǩ
	 * 
	 * @param cid
	 * @return
	 */
	public Label findLabel(int lid);
}
