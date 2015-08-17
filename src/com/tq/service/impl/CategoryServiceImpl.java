package com.tq.service.impl;

import java.util.List;
import java.util.Set;

import org.hibernate.Hibernate;

import com.tq.DAO.ICategoryDAO;
import com.tq.entity.Article;
import com.tq.entity.Category;
import com.tq.service.ICategoryService;

public class CategoryServiceImpl implements ICategoryService {
	private ICategoryDAO dao;

	public void setDao(ICategoryDAO dao) {
		this.dao = dao;
	}

	/*
	 * ��������Ȳ������������ͱ���ʧ��
	 */
	@Override
	public boolean saveCategory(Category category) {
		Category flag = dao.findCategoryByName(category);
		if (flag != null) {// ����
			return false;
		} else {
			dao.save(category);
			return true;
		}
	}

	/**
	 * ���ȫ����ǩ
	 * 
	 * @return
	 */
	@Override
	public List<Category> allCategory() {
		List<Category> ca = dao.findAll(Category.class);
		for (Category category : ca) {
			Hibernate.initialize(category.getArticle());
		}
		return ca;
	}

	/**
	 * ����idɾ��ʵ��
	 * 
	 * @return
	 */
	@Override
	public void deleteById(int cid) {
		Category c = dao.get(Category.class, cid);
		// �Ͼ��������µĹ�ϵ
		Set<Article> article = c.getArticle();
		for (Article article2 : article) {
			article2.setCategory(null);
		}
		c.setArticle(null);

		dao.delete(c);
	}

	/*
	 * �޸�����
	 */
	@Override
	public boolean updateCategory(Category category) {
		// �Ƿ�����
		Category flag = dao.findCategoryByName(category);
		if (flag != null) {
			return false;
		} else {
			// ��ֹ���Ԫ��id���޸ģ����޸ĺ�����������
			dao.saveOrUpadate(category);
			return true;
		}
	}

	@Override
	public Category findCategory(int cid) {
		Category category = dao.get(Category.class, cid);
		Set<Article> set = category.getArticle();
		Hibernate.initialize(set);
		return category;
	}

}
