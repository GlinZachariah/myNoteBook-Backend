package com.glinzac.mynotebook.models;

import java.util.List;

public class NotebookModel {
	private String section;
	private List<String> page;
	
	public NotebookModel() {
		super();
	}
	public NotebookModel(String section) {
		super();
		this.section = section;
	}

	public String getSection() {
		return section;
	}
	public void setSection(String section) {
		this.section = section;
	}
	public List<String> getPage() {
		return page;
	}
	public void setPage(List<String> page) {
		this.page = page;
	}
	
}
