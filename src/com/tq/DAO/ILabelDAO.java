package com.tq.DAO;

import com.tq.entity.Label;

public interface ILabelDAO extends BaseDAO<Label> {
	/**
	 * ≤È—Ø±Í«©
	 * 
	 * @param label
	 * @return
	 */
	public Label findlabelByName(Label label);
}
