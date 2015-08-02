package com.tq.DAO;

import java.util.List;
import java.util.Set;

import com.tq.dto.ArticleDTO;
import com.tq.entity.Article;
import com.tq.entity.Label;

public interface IArticleDAO extends BaseDAO<Article> {

	/**
	 * ��������
	 * 
	 * @return
	 */
	public void saveArticle(ArticleDTO article, Set<Label> hibernatelabel);

	/**
	 * ��ʱ�䵹���������б�
	 * 
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	public List<Article> getArticleByTimeList(int pageNo, int pageSize);

	/**
	 * �ؼ��ֲ�������
	 * 
	 * @param search
	 * @return
	 */
	public List<Article> searchArticle(String search);
}
