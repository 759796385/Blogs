package com.tq.service;

import java.util.List;

import com.tq.dto.ArticleDTO;
import com.tq.entity.Article;

public interface IArticleService {
	/**
	 * ��������
	 * 
	 * @param article
	 * @return
	 */
	public void saveArticle(ArticleDTO article);

	/**
	 * ����ʱ��˳���������б�
	 * 
	 * @return
	 */
	public List<Article> getArticleByTimeList(int pageNo, int pageSize);

	/**
	 * ����ܹ�ҳ��
	 * 
	 * @param pageSize
	 * @return
	 */
	public int getPageNum(int pageSize);

	/**
	 * ����id�������
	 * 
	 * @param id
	 * @return
	 */
	public Article getArticleById(int id);

	/**
	 * ����idɾ������
	 * 
	 * @param aid
	 */
	public void deleteArticleById(int aid);

	/**
	 * ��ȡ����
	 * 
	 * @param id
	 */
	public Article readArticleById(int id);

	/**
	 * ��������
	 * 
	 * @param search
	 * @return
	 */
	public List<Article> searchArticle(String search);
}
