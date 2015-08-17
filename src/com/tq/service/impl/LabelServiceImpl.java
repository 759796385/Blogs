package com.tq.service.impl;

import java.util.List;
import java.util.Set;

import org.hibernate.Hibernate;

import com.tq.DAO.ILabelDAO;
import com.tq.entity.Article;
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
		if (la != null) {// 重名
			return false;
		} else {// 没有重名
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
		// 断绝标签和文章的关系
		Set<Article> set = label.getArticles();
		for (Article article : set) {
			article.getLabels().remove(label);
		}

		label.setArticles(null);
		dao.delete(label);
	}

	@Override
	public Label findLabel(int lid) {
		Label label = dao.get(Label.class, lid);
		Hibernate.initialize(label.getArticles());
		return label;
	}
}
