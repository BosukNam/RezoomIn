package com.omazing.resume.vo;

public class CertificateVO {
	private String name;
	private String date;
	private String publication;
	private int registerNo;
	private String memberID;
	public CertificateVO() {		
	}
	
	public CertificateVO(String name, String date, String publication,
			int registerNo, String memberID) {
		this.name = name;
		this.date = date;
		this.publication = publication;
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
	public String getPublication() {
		return publication;
	}
	public void setPublication(String publication) {
		this.publication = publication;
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
		return "CertificateDTO [name=" + name + ", date=" + date
				+ ", publication=" + publication + ", registerNo=" + registerNo
				+ ", memberID=" + memberID + "]";
	}
	public String[] getAll(){
		return new String[]{this.name, this.date, 
				this.publication, Integer.toString(this.registerNo), this.memberID};
	}
}
