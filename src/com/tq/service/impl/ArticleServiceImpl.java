package com.tq.service.impl;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Hibernate;

import com.tq.DAO.IArticleDAO;
import com.tq.DAO.ICategoryDAO;
import com.tq.DAO.ILabelDAO;
import com.tq.dto.ArticleDTO;
import com.tq.entity.Article;
import com.tq.entity.Label;
import com.tq.service.IArticleService;

public class ArticleServiceImpl implements IArticleService {
	private IArticleDAO dao;
	private ILabelDAO labeldao;
	private ICategoryDAO categorydao;

	public void setCategorydao(ICategoryDAO categorydao) {
		this.categorydao = categorydao;
	}

	public void setDao(IArticleDAO dao) {
		this.dao = dao;
	}

	public void setLabeldao(ILabelDAO labeldao) {
		this.labeldao = labeldao;
	}

	@Override
	public void saveArticle(ArticleDTO article) {
		// 查询label是否存在。对之进行持久态
		Set<Label> labes = article.getLabels();
		Set<Label> hibernatelabel = new HashSet<Label>();
		for (Label label2 : labes) {
			// 获得持久化标签
			Label label = labeldao.findlabelByName(label2);
			if (label == null) {// 标签不存在
				// 保存标签，进入持久态
				labeldao.save(label2);
				hibernatelabel.add(label2);
			} else {
				hibernatelabel.add(label);
			}
		}
		// 保存文章
		dao.saveArticle(article, hibernatelabel);
	}

	@Override
	public List<Article> getArticleByTimeList(int pageNo, int pageSize) {
		List<Article> li = dao.getArticleByTimeList(pageNo, pageSize);
		for (Article article : li) {
			Set<Label> labels = article.getLabels();
			for (Label label : labels) {
				Hibernate.initialize(label);
			}
		}
		return li;
	}

	@Override
	public int getPageNum(int pageSize) {
		int sum = (int) dao.findCount(Article.class);
		return sum % pageSize == 0 ? sum / pageSize : sum / pageSize + 1;
	}

	@Override
	public Article getArticleById(int id) {
		return dao.get(Article.class, id);
	}

	@Override
	public void deleteArticleById(int aid) {
		Article article = dao.get(Article.class, aid);
		if (article == null) {
			return;
		}
		dao.delete(article);
	}

	// 和getArticleById方法一样，只不过阅读次数加一
	@Override
	public Article readArticleById(int id) {
		Article article = dao.get(Article.class, id);
		// 阅读次数加一
		article.setView(article.getView() + 1);
		dao.save(article);
		Hibernate.initialize(article.getMessages());
		return article;
	}

	@Override
	public List<Article> searchArticle(String search) {
		return dao.searchArticle(search);
	}
}
