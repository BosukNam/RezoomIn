package com.omazing.resume.bean;

public class AwardFieldBean {
	private String fieldCode;
	private String field;
	private String categoryCode;
	public AwardFieldBean() {
		super();
	}
	public AwardFieldBean(String fieldCode, String field, String categoryCode) {
		super();
		this.fieldCode = fieldCode;
		this.field = field;
		this.categoryCode = categoryCode;
	}
	public String getFieldCode() {
		return fieldCode;
	}
	public void setFieldCode(String fieldCode) {
		this.fieldCode = fieldCode;
	}
	public String getField() {
		return field;
	}
	public void setField(String field) {
		this.field = field;
	}
	public String getCategoryCode() {
		return categoryCode;
	}
	public void setCategoryCode(String categoryCode) {
		this.categoryCode = categoryCode;
	}
	@Override
	public String toString() {
		return "AwardFieldBean [fieldCode=" + fieldCode + ", field=" + field
				+ ", categoryCode=" + categoryCode + "]";
	}
	public String[] getAll(){
		return new String[]{this.fieldCode, this.field, this.categoryCode};
	}
}
