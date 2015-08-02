package com.tq.DAO.impl;

import java.sql.Clob;
import java.util.Date;
import java.util.List;
import java.util.Set;

import org.hibernate.Hibernate;

import com.tq.DAO.IArticleDAO;
import com.tq.dto.ArticleDTO;
import com.tq.entity.Article;
import com.tq.entity.Label;

public class ArticleDAOImpl extends BaseDAOHibernate4<Article> implements
		IArticleDAO {

	@Override
	public void saveArticle(ArticleDTO article, Set<Label> hibernatelabel) {
		// ��dtoת����entity
		Article obj = new Article(article);
		// ��String ת����Clob
		Clob text = Hibernate.getLobCreator(
				getSessionFactory().getCurrentSession()).createClob(
				article.getText());
		obj.setText(text);
		obj.setLabels(hibernatelabel);
		obj.setDate(new Date());
		// ����new�˸����󣬺�session�еĶ����ַ��һ��
		merge(obj);
	}

	/*
	 * ����ʱ�䵹���ҳ����
	 * 
	 * @see com.tq.DAO.IArticleDAO#getArticleByTimeList(int, int)
	 */
	@Override
	public List<Article> getArticleByTimeList(int pageNo, int pageSize) {
		List<Article> art = null;
		try {
			art = findByPage("from Article a order by a.date desc", pageNo,
					pageSize, null);
		} catch (Exception e) {
			e.printStackTrace();
		}
		for (Article article : art) {
			// ʵ����
			Hibernate.initialize(article.getCategory());
		}
		return art;
	}

	@Override
	public List<Article> searchArticle(String search) {
		// ��String ת����Clob
		return find("from Article a where a.title like ?0 or a.remark like ?1",
				"%" + search + "%", "%" + search + "%");
	}
}