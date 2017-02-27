package com.omazing.resume.bean;

public class LanguageExamBean {
	private String name;
	private String date;
	private String grade;
	private String registerNo;
	public LanguageExamBean() {
	}
	
	public LanguageExamBean(String name, String date, String grade, String registerNo){
		this.name = name;
		this.date = date;
		this.grade = grade;
		this.registerNo = registerNo;
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
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	
	public String getRegisterNo() {
		return registerNo;
	}

	public void setRegisterNo(String registerNo) {
		this.registerNo = registerNo;
	}

	public String toString() {
		return "LanguageExamVO [name=" + name + ", date=" + date + ", grade="
				+ grade + ", registerNo=" + registerNo + "]";
	}
	public String[] getAll(){
		return new String[]{this.name,this.date, this.grade, 
				this.registerNo}; 
	}
}
