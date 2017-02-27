package com.omazing.resume.vo;

public class AwardCategoryVO {
	private String categoryCode;
	private String category;
	public AwardCategoryVO() {
		super();
	}
	public AwardCategoryVO(String categoryCode, String category) {
		super();
		this.categoryCode = categoryCode;
		this.category = category;
	}
	public String getCategoryCode() {
		return categoryCode;
	}
	public void setCategoryCode(String categoryCode) {
		this.categoryCode = categoryCode;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	@Override
	public String toString() {
		return "AwardCategoryBean [categoryCode=" + categoryCode
				+ ", category=" + category + "]";
	}
	public String[] getAll(){
		return new String[]{this.categoryCode, this.category};
	}
}
