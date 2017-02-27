package com.omazing.resume.dto;

import java.io.Serializable;
/**
 * 학력사항 총 학점 카테고리 DTO 
 * @author yeeun
 *
 */
public class SchoolTotalGradeCategoryDTO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 8991892429388329802L;
	/**
	 * 총 학점 코드 
	 */
	private String totalGradeCode;
	/**
	 * 총 학점 
	 */
	private double totalGrade;
	
	/**
	 * 디폴트 생성자 
	 */
	public SchoolTotalGradeCategoryDTO() {
		super();
	}
	/**
	 * 오버로디드 생성자 
	 * @param totalGradeCode 총 학점 코드 
	 * @param totalGrade 총 학점 
	 */
	public SchoolTotalGradeCategoryDTO(String totalGradeCode, double totalGrade) {
		super();
		this.totalGradeCode = totalGradeCode;
		this.totalGrade = totalGrade;
	}
	/**
	 * 총 학점 코드 반환 
	 * @return 총 학점 코드
	 */
	public String getTotalGradeCode() {
		return totalGradeCode;
	}
	/**
	 * 총 학점 코드
	 * @param totalGradeCode 총 학점 코드
	 */
	public void setTotalGradeCode(String totalGradeCode) {
		this.totalGradeCode = totalGradeCode;
	}
	/**
	 * 총 학점 반환 
	 * @return 총 학점  
	 */
	public double getTotalGrade() {
		return totalGrade;
	}
	/**
	 * 총 학점 설정  
	 * @param totalGrade 총 학점 
	 */
	public void setTotalGrade(double totalGrade) {
		this.totalGrade = totalGrade;
	}
	@Override
	public String toString() {
		return "SchoolTotalGradeCategoryDTO [totalGradeCode=" + totalGradeCode
				+ ", totalGrade=" + totalGrade + "]";
	}
	/**
	 * 전체 필드 반환 
	 * @return
	 */
	public String[] getAll(){
		return new String[]{ this.totalGradeCode, Double.toString(this.totalGrade) };
	}
}
