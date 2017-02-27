package com.omazing.portfolio.dto;

public class UseSkillDTO {
	private int register_no;
	private int project_no;
	private String name;
	
	
	public UseSkillDTO() {
		super();
	}
	public UseSkillDTO(int register_no, int project_no, String name) {
		super();
		this.register_no = register_no;
		this.project_no = project_no;
		this.name = name;
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
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String[] getAll(){
		return new String[]{this.register_no+"", this.project_no+"", this.name};
	}
}
