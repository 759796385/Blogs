package com.tq.DAO;

import com.tq.entity.Category;

public interface ICategoryDAO extends BaseDAO<Category> {
	/**
	 * �������ֲ�ѯ���
	 * 
	 * @return
	 */
	public Category findCategoryByName(Category category);
}
