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
	 * 保存类别，先查重名，重名就保存失败
	 */
	@Override
	public boolean saveCategory(Category category) {
		Category flag = dao.findCategoryByName(category);
		if (flag != null) {// 重名
			return false;
		} else {
			dao.save(category);
			return true;
		}
	}

	/**
	 * 获得全部标签
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
	 * 根据id删除实体
	 * 
	 * @return
	 */
	@Override
	public void deleteById(int cid) {
		Category c = dao.get(Category.class, cid);
		// 断绝类别和文章的关系
		Set<Article> article = c.getArticle();
		for (Article article2 : article) {
			article2.setCategory(null);
		}
		c.setArticle(null);

		dao.delete(c);
	}

	/*
	 * 修改类名
	 */
	@Override
	public boolean updateCategory(Category category) {
		// 是否重名
		Category flag = dao.findCategoryByName(category);
		if (flag != null) {
			return false;
		} else {
			// 防止审查元素id被修改，被修改后就添加新名字
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
