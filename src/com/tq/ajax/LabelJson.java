package com.tq.ajax;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.opensymphony.xwork2.Action;
import com.tq.entity.Label;
import com.tq.service.ILabelService;

public class LabelJson {
	// Json labels
	private Map<Integer, String> labels;

	private ILabelService service;

	public String execute() throws Exception {
		List<Label> la = service.allLabels();
		Map<Integer, String> map = new HashMap<Integer, String>();
		for (Label label : la) {
			map.put(label.getLid(), label.getName());
		}
		setLabels(map);
		return Action.SUCCESS;
	}

	public Map<Integer, String> getLabels() {
		return labels;
	}

	public void setLabels(Map<Integer, String> labels) {
		this.labels = labels;
	}

	public void setService(ILabelService service) {
		this.service = service;
	}

}
