package com.tq.service;

import java.util.List;

import com.tq.entity.Category;

public interface ICategoryService {
	/**
	 * �������
	 * 
	 * @param gategory
	 * @return
	 */
	public boolean saveCategory(Category category);

	/**
	 * ���ȫ�����
	 * 
	 * @return
	 */
	public List<Category> allCategory();

	/**
	 * ����idɾ������
	 * 
	 * @param cid
	 */
	public void deleteById(int cid);

	/**
	 * �޸������
	 * 
	 * @param category
	 * @return
	 */
	public boolean updateCategory(Category category);

	/**
	 * ���ָ�����
	 * 
	 * @param cid
	 * @return
	 */
	public Category findCategory(int cid);
}
