package com.omazing.resume.vo;

public class AwardVO {
	private String categoryCode;
	private String category;
	private String fieldCode;
	private String field;
	private String target;
	private String name;
	private String date;
	private String publication;
	private String content;
	private int registerNo;
	private String memberID;	
	public AwardVO() {
		super();
	}
	public AwardVO(String categoryCode, String category, String fieldCode,
			String field, String target, String name, String date,
			String publication, String content, int registerNo, String memberID) {
		super();
		this.categoryCode = categoryCode;
		this.category = category;
		this.fieldCode = fieldCode;
		this.field = field;
		this.target = target;
		this.name = name;
		this.date = date;
		this.publication = publication;
		this.content = content;
		this.registerNo = registerNo;
		this.memberID = memberID;
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
	public String getTarget() {
		return target;
	}
	public void setTarget(String target) {
		this.target = target;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getPublication() {
		return publication;
	}
	public void setPublication(String publication) {
		this.publication = publication;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getRegisterNo() {
		return registerNo;
	}
	public void setRegisterNo(int registerNo) {
		this.registerNo = registerNo;
	}
	public String getMemberID() {
		return memberID;
	}
	public void setMemberID(String memberID) {
		this.memberID = memberID;
	}
	@Override
	public String toString() {
		return "AwardVO [categoryCode=" + categoryCode + ", category="
				+ category + ", fieldCode=" + fieldCode + ", field=" + field
				+ ", target=" + target + ", name=" + name + ", date=" + date
				+ ", publication=" + publication + ", content=" + content
				+ ", registerNo=" + registerNo + ", memberID=" + memberID + "]";
	}
	public String[] getAll(){
		String[] res = null;
		res = new String[]{ this.categoryCode, this.category, 
				this.fieldCode, this.field, this.target,
				this.name,this.date,this.publication,this.content,
				Integer.toString(this.registerNo), this.memberID};
		return res;
	}
}
