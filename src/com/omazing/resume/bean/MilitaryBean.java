package com.omazing.resume.bean;

public class MilitaryBean {
	private String pass;
	private String startDate;
	private String endDate;
	private String categoryCode; 
	private String category; 
	private String rankCode;
	private String rank;
	
	public MilitaryBean() {
		super();
	}
	public MilitaryBean(String pass) {
		super();
		this.pass = pass;
	}
	public MilitaryBean(String pass, String startDate, String endDate,
			String categoryCode, String category, String rankCode, String rank) {
		super();
		this.pass = pass;
		this.startDate = startDate;
		this.endDate = endDate;
		this.categoryCode = categoryCode;
		this.category = category;
		this.rankCode = rankCode;
		this.rank = rank;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
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
	public String getRankCode() {
		return rankCode;
	}
	public void setRankCode(String rankCode) {
		this.rankCode = rankCode;
	}
	public String getRank() {
		return rank;
	}
	public void setRank(String rank) {
		this.rank = rank;
	}
	@Override
	public String toString() {
		return "MilitaryBean [pass=" + pass + ", startDate=" + startDate
				+ ", endDate=" + endDate + ", categoryCode=" + categoryCode
				+ ", category=" + category + ", rankCode=" + rankCode
				+ ", rank=" + rank + "]";
	}
	/**
	 * 전체 필드 반환
	 * @return 
	 */
	public String[] getAll(){
		return new String[]{ this.pass, this.startDate, this.endDate, 
				this.categoryCode, this.category, this.rankCode, this.rank };
	}
}
