package com.entity;

import java.util.List;

public class Conference {

	private String theme;
	
	private List<Boss> lists;

	public Conference() {
		super();
	}

	public Conference(String theme, List<Boss> lists) {
		super();
		this.theme = theme;
		this.lists = lists;
	}

	public String getTheme() {
		return theme;
	}

	public void setTheme(String theme) {
		this.theme = theme;
	}

	public List<Boss> getLists() {
		return lists;
	}

	public void setLists(List<Boss> lists) {
		this.lists = lists;
	}

	@Override
	public String toString() {
		return "Conference [theme=" + theme + ", lists=" + lists + "]";
	}
	
}
