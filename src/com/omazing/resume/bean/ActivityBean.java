package com.omazing.resume.bean;

public class ActivityBean {
	private String category;
	private String startDate;
	private String endDate;
	private String content;
	private String registerNo;
	public ActivityBean() {
	}
	public ActivityBean(String category, String startDate, String endDate,
			String content, String registerNo) {
		this.category = category;
		this.startDate = startDate;
		this.endDate = endDate;
		this.content = content;
		this.registerNo = registerNo;
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
	public String getRegisterNo() {
		return registerNo;
	}
	public void setRegisterNo(String registerNo) {
		this.registerNo = registerNo;
	}
	@Override
	public String toString() {
		return "ActivityBean [category=" + category + ", startDate="
				+ startDate + ", endDate=" + endDate + ", content=" + content
				+ ", registerNo=" + registerNo + "]";
	}
	public String[] getAll(){
		return new String[]{this.category, this.startDate,
				this.endDate, this.content, this.registerNo};
	}
}
