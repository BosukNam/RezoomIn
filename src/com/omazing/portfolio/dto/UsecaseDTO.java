package com.omazing.portfolio.dto;

public class UsecaseDTO {
	private int register_no;
	private int project_no;
	private String actor;
	private String case1;
	private String case2;
	private String case3;
	private String case4;
	public UsecaseDTO() {
		super();
	}
	public UsecaseDTO(int register_no, int project_no, String actor,
			String case1, String case2, String case3, String case4) {
		super();
		this.register_no = register_no;
		this.project_no = project_no;
		this.actor = actor;
		this.case1 = case1;
		this.case2 = case2;
		this.case3 = case3;
		this.case4 = case4;
	}
	
	public int getRegister_no() {
		return register_no;
	}
	public void setRegister_no(int register_no) {
		this.register_no = register_no;
	}
	public int getProject_no() {
		return project_no;
	}
	public void setProject_no(int project_no) {
		this.project_no = project_no;
	}
	public String getActor() {
		return actor;
	}
	public void setActor(String actor) {
		this.actor = actor;
	}
	public String getCase1() {
		return case1;
	}
	public void setCase1(String case1) {
		this.case1 = case1;
	}
	public String getCase2() {
		return case2;
	}
	public void setCase2(String case2) {
		this.case2 = case2;
	}
	public String getCase3() {
		return case3;
	}
	public void setCase3(String case3) {
		this.case3 = case3;
	}
	public String getCase4() {
		return case4;
	}
	public void setCase4(String case4) {
		this.case4 = case4;
	}
	@Override
	public String toString() {
		return "UsecaseDTO [register_no=" + register_no + ", project_no="
				+ project_no + ", actor=" + actor + ", case1=" + case1
				+ ", case2=" + case2 + ", case3=" + case3 + ", case4=" + case4
				+ "]";
	}
	
	
	
}
