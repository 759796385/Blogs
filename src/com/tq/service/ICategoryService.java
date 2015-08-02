package com.tq.service;

import java.util.List;

import com.tq.entity.Category;

public interface ICategoryService {
	/**
	 * 保存类别
	 * 
	 * @param gategory
	 * @return
	 */
	public boolean saveCategory(Category category);

	/**
	 * 获得全部类别
	 * 
	 * @return
	 */
	public List<Category> allCategory();

	/**
	 * 根据id删除类型
	 * 
	 * @param cid
	 */
	public void deleteById(int cid);

	/**
	 * 修改类别名
	 * 
	 * @param category
	 * @return
	 */
	public boolean updateCategory(Category category);

	/**
	 * 获得指定类别
	 * 
	 * @param cid
	 * @return
	 */
	public Category findCategory(int cid);
}
