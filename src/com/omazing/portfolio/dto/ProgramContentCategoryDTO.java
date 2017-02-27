package com.omazing.portfolio.dto;

import java.io.Serializable;

public class ProgramContentCategoryDTO implements Serializable{
	private String code;
	private String contentCategory;

	public ProgramContentCategoryDTO(String code, String contentCategory) {
		super();
		this.code = code;
		this.contentCategory = contentCategory;
	}
	public ProgramContentCategoryDTO() {
		super();
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}

	public String getContentCategory() {
		return contentCategory;
	}
	public void setContentCategory(String contentCategory) {
		this.contentCategory = contentCategory;
	}
	public String[] getAll(){
		return new String[]{code, contentCategory};
	}
	@Override
	public String toString() {
		return "ProgramContentCategoryDTO [code=" + code + ", contentCategory="
				+ contentCategory + "]";
	}
}
