package com.omazing.resume.dto;

import java.io.Serializable;

public class ActivityDTO implements Serializable {
	private ActivityCategoryDTO category;
	private String startDate;
	private String endDate;
	private String content;
	private int registerNo;
	private String memberID;
	public ActivityDTO() {
		super();
	}
	public ActivityDTO(ActivityCategoryDTO category, String startDate,
			String endDate, String content, int registerNo, String memberID) {
		this.category = category;
		this.startDate = startDate;
		this.endDate = endDate;
		this.content = content;
		this.registerNo = registerNo;
		this.memberID = memberID;
	}
	public ActivityCategoryDTO getCategory() {
		return category;
	}
	public void setCategory(ActivityCategoryDTO category) {
		this.category = category;
	}
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
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
		return "ActivityDTO [category=" + category + ", startDate=" + startDate
				+ ", endDate=" + endDate + ", content=" + content
				+ ", registerNo=" + registerNo + ", memberID=" + memberID + "]";
	}
	public String[] getAll(){
		return new String[]{this.category.getCategoryCode(), this.category.getCategory(), 
				this.startDate,	this.endDate, this.content, Integer.toString(this.registerNo), 
				this.memberID};
	}
	
	
}
