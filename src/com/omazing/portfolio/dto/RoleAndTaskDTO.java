package com.omazing.portfolio.dto;

import java.io.Serializable;

public class RoleAndTaskDTO implements Serializable{
	private int registerNo;
	private int projectNo;
	private String role;
	private String task;
	public RoleAndTaskDTO(int registerNo, int projectNo, String role, String task) {
		super();
		this.registerNo = registerNo;
		this.projectNo = projectNo;
		this.role = role;
		this.task = task;
	}
	public RoleAndTaskDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getRegisterNo() {
		return registerNo;
	}
	public void setRegisterNo(int registerNo) {
		this.registerNo = registerNo;
	}
	public int getProjectNo() {
		return projectNo;
	}
	public void setProjectNo(int projectNo) {
		this.projectNo = projectNo;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getTask() {
		return task;
	}
	public void setTask(String task) {
		this.task = task;
	}
	@Override
	public String toString() {
		return "RoleAndTaskDTO [registerNo=" + registerNo + ", projectNo="
				+ projectNo + ", role=" + role + ", task=" + task + "]";
	}
	
	public String[] getAll(){
		String[] str=new String[]{String.valueOf(registerNo),String.valueOf(projectNo),role,task};
		return str;
	}
}
