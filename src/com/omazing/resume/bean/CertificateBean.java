package com.omazing.resume.bean;

public class CertificateBean {
	private String name;
	private String date;
	private String publication;
	private String registerNo;
	public CertificateBean() {		
	}
	
	public CertificateBean(String name, String date, String publication,
			String registerNo) {
		this.name = name;
		this.date = date;
		this.publication = publication;
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
	public String getPublication() {
		return publication;
	}
	public void setPublication(String publication) {
		this.publication = publication;
	}
	public String getRegisterNo() {
		return registerNo;
	}
	public void setRegisterNo(String registerNo) {
		this.registerNo = registerNo;
	}
	public String toString() {
		return "CertificateVO [name=" + name + ", date=" + date
				+ ", publication=" + publication + ", registerNo=" + registerNo
				+ "]";
	}
	public String[] getAll(){
		return new String[]{this.name, this.date, 
				this.publication, this.registerNo};
	}
}
