package com.tq.DAO.impl;

import java.util.List;

import com.tq.DAO.ILabelDAO;
import com.tq.entity.Label;

public class LabelDAOImpl extends BaseDAOHibernate4<Label> implements ILabelDAO {

	@Override
	public Label findlabelByName(Label label) {
		List<Label> labels = find("from Label l where l.name=?0",
				label.getName());
		if (labels != null && labels.size() >= 1) {
			return labels.get(0);
		}
		return null;
	}

}
