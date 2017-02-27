package com.omazing.resume.bean;
/**
 * 학력사항 총 학점 카테고리 Bean
 * @author yeeun
 *
 */
public class SchoolTotalGradeCategoryBean {
	/**
	 * 총 학점 코드 
	 */
	private String totalGradeCode;
	/**
	 * 총 학점 
	 */
	private String totalGrade;
	
	/**
	 * 디폴트 생성자
	 */
	public SchoolTotalGradeCategoryBean() {
		super();
	}
	/**
	 * 오버로디드 생성자 
	 * @param totalGradeCode 총 학점 코드 
	 * @param totalGrade 총 학점 
	 */
	public SchoolTotalGradeCategoryBean(String totalGradeCode, String totalGrade) {
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
	 * 총 학점 코드 설정 
	 * @param totalGradeCode 총 학점 코드 
	 */
	public void setTotalGradeCode(String totalGradeCode) {
		this.totalGradeCode = totalGradeCode;
	}
	/**
	 * 총 학점 반환  
	 * @return 총 학점 
	 */
	public String getTotalGrade() {
		return totalGrade;
	}
	/**
	 * 총 학점 설정 
	 * @param totalGrade 총 학점 
	 */
	public void setTotalGrade(String totalGrade) {
		this.totalGrade = totalGrade;
	}
	@Override
	public String toString() {
		return "SchoolTotalGradeCategoryBean [totalGradeCode=" + totalGradeCode
				+ ", totalGrade=" + totalGrade + "]";
	}
	/**
	 * 전체 필드 반환 
	 * @return
	 */
	public String[] getAll(){
		return new String[]{ this.totalGradeCode, this.totalGrade };
	}
	
}
