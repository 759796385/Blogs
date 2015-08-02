package com.tq.service;

import java.util.List;

import com.tq.dto.ArticleDTO;
import com.tq.entity.Article;

public interface IArticleService {
	/**
	 * 保存文章
	 * 
	 * @param article
	 * @return
	 */
	public void saveArticle(ArticleDTO article);

	/**
	 * 根据时间顺序获得文章列表
	 * 
	 * @return
	 */
	public List<Article> getArticleByTimeList(int pageNo, int pageSize);

	/**
	 * 获得总共页数
	 * 
	 * @param pageSize
	 * @return
	 */
	public int getPageNum(int pageSize);

	/**
	 * 根据id获得文章
	 * 
	 * @param id
	 * @return
	 */
	public Article getArticleById(int id);

	/**
	 * 根据id删除文章
	 * 
	 * @param aid
	 */
	public void deleteArticleById(int aid);

	/**
	 * 读取文章
	 * 
	 * @param id
	 */
	public Article readArticleById(int id);

	/**
	 * 查找文章
	 * 
	 * @param search
	 * @return
	 */
	public List<Article> searchArticle(String search);
}
