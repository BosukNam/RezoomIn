package com.omazing.portfolio.dto;

import java.io.Serializable;

public class ChartDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int registerNo;
	private int programContentNo;
	private ChartCategoryDTO chartType;
	private String chartPath;
	
	public ChartDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	public ChartDTO(int registerNo, int programContentNo,
			ChartCategoryDTO chartType, String chartPath) {
		super();
		this.registerNo = registerNo;
		this.programContentNo = programContentNo;
		this.chartType = chartType;
		this.chartPath = chartPath;
	}


	public int getRegisterNo() {
		return registerNo;
	}
	public void setRegisterNo(int registerNo) {
		this.registerNo = registerNo;
	}
	public int getProgramContentNo() {
		return programContentNo;
	}
	public void setProgramContentNo(int programContentNo) {
		this.programContentNo = programContentNo;
	}
	public ChartCategoryDTO getChartType() {
		return chartType;
	}
	public void setChartType(ChartCategoryDTO chartType) {
		this.chartType = chartType;
	}
	public String getChartPath() {
		return chartPath;
	}
	public void setChartPath(String chartPath) {
		this.chartPath = chartPath;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public String[] getAll(){
		String[] str=new String[]{String.valueOf(registerNo), String.valueOf(programContentNo), chartType.getCode(), chartPath};
		return str;
	}
	@Override
	public String toString() {
		return "ChartVO [registerNo=" + registerNo + ", programContentNo="
				+ programContentNo + ", chartType=" + chartType
				+ ", chartPath=" + chartPath + "]";
	}
}
