package com.omazing.portfolio.dto;

import java.io.Serializable;

public class ChartCategoryDTO implements Serializable{
	private String code;
	private String category;
	public ChartCategoryDTO(String code, String category) {
		super();
		this.code = code;
		this.category = category;
	}
	public ChartCategoryDTO() {
		super();
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String[] getAll(){
		return new String[]{code, category};
	}
	@Override
	public String toString() {
		return "ChartCategoryDTO [code=" + code + ", category=" + category
				+ "]";
	}
}
