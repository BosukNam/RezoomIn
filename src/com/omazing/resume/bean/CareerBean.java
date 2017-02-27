package com.omazing.resume.bean;

public class CareerBean {
	private String name;
	private String startDate;
	private String endDate;
	private String position;
	private String department;
	private String task;
	private String retirementReason;
	private String registerNo;
	public CareerBean() {
		
	}
	public CareerBean(String name, String startDate, String endDate,
			String position, String department, String task, String retirementReason,
			String registerNo) {
		this.name = name;
		this.startDate = startDate;
		this.endDate = endDate;
		this.position = position;
		this.department = department;
		this.task = task;
		this.retirementReason = retirementReason;
		this.registerNo = registerNo;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getTask() {
		return task;
	}
	public void setTask(String task) {
		this.task = task;
	}
	public String getRetirementReason() {
		return retirementReason;
	}
	public void setRetirementReason(String retirementReason) {
		this.retirementReason = retirementReason;
	}
	public String getRegisterNo() {
		return registerNo;
	}
	public void setRegisterNo(String registerNo) {
		this.registerNo = registerNo;
	}
	public String toString() {
		return "CareerBean [name=" + name + ", startDate=" + startDate
				+ ", endDate=" + endDate + ", position=" + position
				+ ", department=" + department + ", task="
				+ task + ", retirementReason="
				+ retirementReason + ", registerNo=" + registerNo + "]";
	}
	public String[] getAll(){
		return new String[]{this.name,this.startDate,this.endDate,this.position,
				this.department, this.task, this.retirementReason,this.registerNo};
	}
	
}
