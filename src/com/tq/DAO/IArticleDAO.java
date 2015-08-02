package com.tq.DAO;

import java.util.List;
import java.util.Set;

import com.tq.dto.ArticleDTO;
import com.tq.entity.Article;
import com.tq.entity.Label;

public interface IArticleDAO extends BaseDAO<Article> {

	/**
	 * 保存文章
	 * 
	 * @return
	 */
	public void saveArticle(ArticleDTO article, Set<Label> hibernatelabel);

	/**
	 * 按时间倒序获得文章列表
	 * 
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	public List<Article> getArticleByTimeList(int pageNo, int pageSize);

	/**
	 * 关键字查找文章
	 * 
	 * @param search
	 * @return
	 */
	public List<Article> searchArticle(String search);
}
