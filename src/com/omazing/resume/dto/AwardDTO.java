package com.omazing.resume.dto;

import java.io.Serializable;

public class AwardDTO implements Serializable {
	private AwardCategoryDTO category;
	private AwardFieldDTO field;
	private String target;
	private String name;
	private String date;
	private String publication;
	private String content;
	private int registerNo;
	private String memberID;

	public AwardDTO() {
		super();
	}
	public AwardDTO(AwardCategoryDTO category, AwardFieldDTO field,
			String target, String name, String date, String publication,
			String content, int registerNo, String memberID) {
		super();
		this.category = category;
		this.field = field;
		this.target = target;
		this.name = name;
		this.date = date;
		this.publication = publication;
		this.content = content;
		this.registerNo = registerNo;
		this.memberID = memberID;
	}
	public AwardCategoryDTO getCategory() {
		return category;
	}
	public void setCategory(AwardCategoryDTO category) {
		this.category = category;
	}
	public AwardFieldDTO getField() {
		return field;
	}
	public void setField(AwardFieldDTO field) {
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
		return "AwardDTO [category=" + category + ", field=" + field
				+ ", target=" + target + ", name=" + name + ", date=" + date
				+ ", publication=" + publication + ", content=" + content
				+ ", registerNo=" + registerNo + ", memberID=" + memberID + "]";
	}
	public String[] getAll(){
		String[] res = null;
		res = new String[]{this.category.getCategory(), this.category.getCategoryCode(),
				this.field.getField(),this.field.getFieldCode(),this.target,
				this.name,this.date,this.publication,this.content, Integer.toString(this.registerNo),
				this.memberID};
		return res;
	}
	
}
