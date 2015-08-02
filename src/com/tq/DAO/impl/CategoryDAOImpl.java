package com.tq.DAO.impl;

import java.util.List;

import com.tq.DAO.ICategoryDAO;
import com.tq.entity.Category;

public class CategoryDAOImpl extends BaseDAOHibernate4<Category> implements
		ICategoryDAO {

	@Override
	public Category findCategoryByName(Category category) {
		List<Category> ca = find("from Category c where c.name=?0",
				category.getName());
		if (ca != null && ca.size() >= 1) {
			return ca.get(0);
		}
		return null;
	}

}
