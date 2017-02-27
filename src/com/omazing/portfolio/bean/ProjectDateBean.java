package com.omazing.portfolio.bean;

public class ProjectDateBean {
	private String startDate;
	private String endDate;
	public ProjectDateBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ProjectDateBean(String startDate, String endDate) {
		super();
		this.startDate = startDate;
		this.endDate = endDate;
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
	@Override
	public String toString() {
		return "ProjectDateBean [startDate=" + startDate + ", endDate="
				+ endDate + "]";
	}
	
	
}
