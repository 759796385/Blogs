package com.tq.service.impl;

import java.util.List;

import org.hibernate.Hibernate;

import com.tq.DAO.ILabelDAO;
import com.tq.entity.Label;
import com.tq.service.ILabelService;

public class LabelServiceImpl implements ILabelService {
	private ILabelDAO dao;

	public void setDao(ILabelDAO dao) {
		this.dao = dao;
	}

	@Override
	public boolean saveLabel(Label label) {
		Label la = dao.findlabelByName(label);
		if (la != null) {// ����
			return false;
		} else {// û������
			dao.save(label);
			return true;
		}
	}

	@Override
	public List<Label> allLabels() {
		return dao.findAll(Label.class);
	}

	@Override
	public void deleteById(int lid) {
		Label label = dao.get(Label.class, lid);
		if (label == null)
			return;
		dao.delete(label);
	}

	@Override
	public Label findLabel(int lid) {
		Label label = dao.get(Label.class, lid);
		Hibernate.initialize(label.getArticles());
		return label;
	}
}
