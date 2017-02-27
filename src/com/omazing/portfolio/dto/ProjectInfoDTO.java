package com.omazing.portfolio.dto;

import java.io.Serializable;

public class ProjectInfoDTO implements Serializable{
	private int registerNo;
	private String memberId;
	private String name;
	private String projectIntroNo;
	private String startDate;
	private String endDate;
	private int peopleNo;
	private String developToolNo;
	private int roleAndTaskNo;
	private String useTechLanguageNo;
	private int libraryNo;
	private int systemArchitectureNo;
	private int softwareArchitectureNo;
	private String userDefineContentNo;
	
	
	
	public ProjectInfoDTO() {
		super();
/*		registerNo=0;
		memberId="none";
		name="none";
		projectIntroNo="none";
		startDate="none";
		endDate="none";
		peopleNo=1;
		developToolNo="none";
		roleAndTaskNo=0;
		useTechLanguageNo="none";
		libraryNo=0;
		systemArchitectureNo=0;
		softwareArchitectureNo=0;
		userDefineContentNo="none";*/
	}

	public ProjectInfoDTO(int registerNo, String memberId, String name,
			String projectIntroNo, String startDate, String endDate,
			int peopleNo, String developToolNo, int roleAndTaskNo,
			String useTechLanguageNo, int libraryNo, int systemArchitectureNo,
			int softwareArchitectureNo, String userDefineContentNo) {
		super();
		this.registerNo = registerNo;
		this.memberId = memberId;
		this.name = name;
		this.projectIntroNo = projectIntroNo;
		this.startDate = startDate;
		this.endDate = endDate;
		this.peopleNo = peopleNo;
		this.developToolNo = developToolNo;
		this.roleAndTaskNo = roleAndTaskNo;
		this.useTechLanguageNo = useTechLanguageNo;
		this.libraryNo = libraryNo;
		this.systemArchitectureNo = systemArchitectureNo;
		this.softwareArchitectureNo = softwareArchitectureNo;
		this.userDefineContentNo = userDefineContentNo;
	}
	
	public int getRegisterNo() {
		return registerNo;
	}

	public void setRegisterNo(int registerNo) {
		this.registerNo = registerNo;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getProjectIntroNo() {
		return projectIntroNo;
	}


	public void setProjectIntroNo(String projectIntroNo) {
		this.projectIntroNo = projectIntroNo;
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

	public int getPeopleNo() {
		return peopleNo;
	}

	public void setPeopleNo(int peopleNo) {
		this.peopleNo = peopleNo;
	}
	public String getDevelopToolNo() {
		return developToolNo;
	}

	public void setDevelopToolNo(String developToolNo) {
		this.developToolNo = developToolNo;
	}

	public int getRoleAndTaskNo() {
		return roleAndTaskNo;
	}

	public void setRoleAndTaskNo(int roleAndTaskNo) {
		this.roleAndTaskNo = roleAndTaskNo;
	}

	public String getUseTechLanguageNo() {
		return useTechLanguageNo;
	}

	public void setUseTechLanguageNo(String useTechLanguageNo) {
		this.useTechLanguageNo = useTechLanguageNo;
	}
	
	public int getLibraryNo() {
		return libraryNo;
	}

	public void setLibraryNo(int libraryNo) {
		this.libraryNo = libraryNo;
	}

	public int getSystemArchitectureNo() {
		return systemArchitectureNo;
	}

	public void setSystemArchitectureNo(int systemArchitectureNo) {
		this.systemArchitectureNo = systemArchitectureNo;
	}

	public int getSoftwareArchitectureNo() {
		return softwareArchitectureNo;
	}


	public void setSoftwareArchitectureNo(int softwareArchitectureNo) {
		this.softwareArchitectureNo = softwareArchitectureNo;
	}


	public String getUserDefineContentNo() {
		return userDefineContentNo;
	}

	public void setUserDefineContentNo(String userDefineContentNo) {
		this.userDefineContentNo = userDefineContentNo;
	}

	public String[] getAll(){
		String[] str=new String[]{String.valueOf(registerNo), memberId, name,
								  projectIntroNo, startDate, endDate, String.valueOf(peopleNo),
								  developToolNo, roleAndTaskNo+"", useTechLanguageNo,libraryNo+"",
								  systemArchitectureNo+"",softwareArchitectureNo+"",userDefineContentNo
								  };
		return str;
	}

	@Override
	public String toString() {
		return "ProjectInfoDTO [registerNo=" + registerNo + ", memberId="
				+ memberId + ", name=" + name + ", projectIntroNo="
				+ projectIntroNo + ", startDate=" + startDate + ", endDate="
				+ endDate + ", peopleNo=" + peopleNo + ", developToolNo="
				+ developToolNo + ", roleAndTaskNo=" + roleAndTaskNo
				+ ", useTechLanguageNo=" + useTechLanguageNo + ", libraryNo="
				+ libraryNo + ", systemArchitectureNo=" + systemArchitectureNo
				+ ", softwareArchitectureNo=" + softwareArchitectureNo
				+ ", userDefineContentNo=" + userDefineContentNo + "]";
	}
	
}
