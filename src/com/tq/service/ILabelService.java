package com.tq.service;

import java.util.List;

import com.tq.entity.Label;

public interface ILabelService {
	/**
	 * 保存标签
	 * 
	 * @param label
	 * @return
	 */
	public boolean saveLabel(Label label);

	/**
	 * 获得全部标签
	 * 
	 * @return
	 */
	public List<Label> allLabels();

	/**
	 * 根据id删除标签
	 * 
	 * @param lid
	 */
	public void deleteById(int lid);

	/**
	 * 根据id获得标签
	 * 
	 * @param cid
	 * @return
	 */
	public Label findLabel(int lid);
}
