package com.omazing.resume.dto;

import java.io.Serializable;
/**
 * 학력사항 학위 카테고리 DTO 
 * @author yeeun
 *
 */
public class SchoolDegreeCategoryDTO implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -6874804773280258528L;
	/**
	 * 학위 코드
	 */
	private String degreeCode;
	/**
	 * 학위
	 */
	private String degree;
	/**
	 * 디폴트 생성자
	 */
	public SchoolDegreeCategoryDTO() {
		super();
	}
	/**
	 * 오버로디드 생성자
	 * @param degreeCode
	 * @param degree
	 */
	public SchoolDegreeCategoryDTO(String degreeCode, String degree) {
		super();
		this.degreeCode = degreeCode;
		this.degree = degree;
	}
	/**
	 * 학위 코드 반환 
	 * @return 학위 코드
	 */
	public String getDegreeCode() {
		return degreeCode;
	}
	/**
	 * 학위 코드 설정 
	 * @param degreeCode 학위 코드
	 */
	public void setDegreeCode(String degreeCode) {
		this.degreeCode = degreeCode;
	}
	/**
	 * 학위 반환
	 * @return 학위
	 */
	public String getDegree() {
		return degree;
	}
	/**
	 * 학위 설정
	 * @param degree 학위
	 */
	public void setDegree(String degree) {
		this.degree = degree;
	}
	@Override
	public String toString() {
		return "SchoolDegreeCategoryDTO [degreeCode=" + degreeCode
				+ ", degree=" + degree + "]";
	}
	/**
	 * 전체 필드 반환
	 * @return
	 */
	public String[] getAll(){
		return new String[]{ this.getDegreeCode(), this.getDegree() };
	}
}
