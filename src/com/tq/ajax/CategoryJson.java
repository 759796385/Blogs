package com.tq.ajax;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.opensymphony.xwork2.Action;
import com.tq.entity.Category;
import com.tq.service.ICategoryService;

public class CategoryJson {
	private Map<Integer, Map> category;
	private ICategoryService service;

	public String execute() throws Exception {
		List<Category> a = service.allCategory();
		Map<Integer, Map> ss = new HashMap<Integer, Map>();
		for (Category category : a) {
			Map<String, String> map = new HashMap<String, String>();
			map.put(category.getName(), "" + category.getArticle().size());
			ss.put(category.getCid(), map);
		}
		setCategory(ss);
		return Action.SUCCESS;

	}

	public Map<Integer, Map> getCategory() {
		return category;
	}

	public void setCategory(Map<Integer, Map> category) {
		this.category = category;
	}

	public void setService(ICategoryService service) {
		this.service = service;
	}

}
