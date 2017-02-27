package com.omazing.resume.bean;
/**
 * 학력사항 학위 카테고리 Bean 
 * @author yeeun
 *
 */
public class SchoolDegreeCategoryBean {
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
	public SchoolDegreeCategoryBean() {
		super();
	}
	/**
	 * 오버로디드 생성자
	 * @param degreeCode 학위 코드
	 * @param degree 학위
	 */
	public SchoolDegreeCategoryBean(String degreeCode, String degree) {
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
		return "SchoolDegreeCategoryBean [degreeCode=" + degreeCode
				+ ", degree=" + degree + "]";
	}
	/**
	 * 전체 필드 반환
	 * @return
	 */
	public String[] getAll(){
		return new String[]{ this.degreeCode, this.degree };
	}
}
