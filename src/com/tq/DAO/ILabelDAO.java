package com.tq.DAO;

import com.tq.entity.Label;

public interface ILabelDAO extends BaseDAO<Label> {
	/**
	 * ��ѯ��ǩ
	 * 
	 * @param label
	 * @return
	 */
	public Label findlabelByName(Label label);
}
