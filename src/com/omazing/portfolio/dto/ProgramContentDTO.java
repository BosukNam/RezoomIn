package com.omazing.portfolio.dto;

import java.io.Serializable;

public class ProgramContentDTO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int registerNo;
	private int projectNo;
	private String programContentImage;
	private String content;
	private int chartNo;
	private ProgramContentCategoryDTO category;
	
	public ProgramContentDTO() {
		super();
	}

	public ProgramContentDTO(int registerNo, int projectNo,
			String programContentImage, String content, int chartNo,
			ProgramContentCategoryDTO category) {
		super();
		this.registerNo = registerNo;
		this.projectNo = projectNo;
		this.programContentImage = programContentImage;
		this.content = content;
		this.chartNo = chartNo;
		this.category = category;
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
	public String getProgramContentImage() {
		return programContentImage;
	}
	public void setProgramContentImage(String programContentImage) {
		this.programContentImage = programContentImage;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}

	public int getChartNo() {
		return chartNo;
	}

	public void setChartNo(int chartNo) {
		this.chartNo = chartNo;
	}

	public ProgramContentCategoryDTO getCategory() {
		return category;
	}
	public void setCategory(ProgramContentCategoryDTO category) {
		this.category = category;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public String[] getAll(){
		return new String[]{String.valueOf(registerNo),String.valueOf(projectNo),programContentImage , content, String.valueOf(chartNo), category.getCode(), category.getContentCategory()};
	}
	@Override
	public String toString() {
		return "ProgramContentDTO [registerNo=" + registerNo + ", projectNo="
				+ projectNo + ", programContentImage=" + programContentImage
				+ ", content=" + content + ", chartNo=" + chartNo
				+ ", category=" + category + "]";
	}
	
}
