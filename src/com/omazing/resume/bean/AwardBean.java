package com.omazing.resume.bean;

public class AwardBean {
	private String category;
	private String field;
	private String target;
	private String name;
	private String date;
	private String publication;
	private String content;
	private String registerNo;
	public AwardBean() {
		
	}
	public AwardBean(String category, String field, String target, String name,
			String date, String publication, String content, String registerNo) {
		this.category = category;
		this.field = field;
		this.target = target;
		this.name = name;
		this.date = date;
		this.publication = publication;
		this.content = content;
		this.registerNo = registerNo;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
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
	public String getRegisterNo() {
		return registerNo;
	}
	public void setRegisterNo(String registerNo) {
		this.registerNo = registerNo;
	}
	public String toString() {
		return "AwardBean [category=" + category + ", field=" + field
				+ ", target=" + target + ", name=" + name + ", date=" + date
				+ ", publication=" + publication + ", content=" + content
				+ ", registerNo=" + registerNo + "]";
	}
	public String[] getAll(){
		return new String[]{this.category,this.field,
				this.target,this.name,this.date,this.publication,
				this.content,this.registerNo};
	}
}
