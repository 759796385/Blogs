package com.tq.DAO;

import com.tq.entity.Category;

public interface ICategoryDAO extends BaseDAO<Category> {
	/**
	 * 根据名字查询类别
	 * 
	 * @return
	 */
	public Category findCategoryByName(Category category);
}
