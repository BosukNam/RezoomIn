package com.omazing.resume.vo;

public class ActivityVO {
	private String categoryCode;
	private String category;
	private String startDate;
	private String endDate;
	private String content;
	private int registerNo;
	private String memberID;
	public ActivityVO() {
	}
	public ActivityVO(String categoryCode, String category, String startDate,
			String endDate, String content, int registerNo, String memberID) {
		this.categoryCode = categoryCode;
		this.category = category;
		this.startDate = startDate;
		this.endDate = endDate;
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
		return "ActivityVO [categoryCode=" + categoryCode + ", category="
				+ category + ", startDate=" + startDate + ", endDate="
				+ endDate + ", Content=" + content + ", registerNo="
				+ registerNo + ", memberID=" + memberID + "]";
	}
	public String[] getAll(){
		return new String[]{this.categoryCode, this.category, this.startDate,
				this.endDate, this.content, Integer.toString(this.registerNo), 
				this.memberID};
	}
	
	
}
