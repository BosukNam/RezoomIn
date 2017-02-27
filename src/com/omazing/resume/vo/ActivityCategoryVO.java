package com.omazing.resume.vo;

public class ActivityCategoryVO {
	private String categoryCode;
	private String category;
	public ActivityCategoryVO() {
	}
	public ActivityCategoryVO(String categoryCode, String category) {
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
		return "ActivitycategoryBean [categoryCode=" + categoryCode
				+ ", category=" + category + "]";
	}
	public String[] getAll(){
		return new String[]{this.categoryCode, this.category};
	}
}
