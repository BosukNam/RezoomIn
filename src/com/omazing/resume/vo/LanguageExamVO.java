package com.omazing.resume.vo;

import java.io.Serializable;

public class LanguageExamVO implements Serializable {
	private String name;
	private String date;
	private String grade;
	private int registerNo;
	private String memberID;
	public LanguageExamVO() {
		super();
	}
	
	public LanguageExamVO(String name, String date, String grade, int registerNo,
			String memberID) {
		this.name = name;
		this.date = date;
		this.grade = grade;
		this.registerNo = registerNo;
		this.memberID = memberID;
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
	public String toString() {
		return "LanguageExamVO [name=" + name + ", date=" + date + ", grade="
				+ grade + ", registerNo=" + registerNo + ", memberID="
				+ memberID + "]";
	}
	public String[] getAll(){
		return new String[]{this.name,this.date,this.grade, 
				Integer.toString(this.registerNo), this.memberID}; 
	}
	
}
