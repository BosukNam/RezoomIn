package com.omazing.resume.bean;

/**
 * 학력사항 분류 카테고리 Bean 
 * @author yeeun
 *
 */
public class SchoolCategoryBean {
	/**
	 * 분류 코드
	 */
	private String categoryCode;
	/**
	 * 분류
	 */
	private String category;
	/**
	 * 디폴트 생성자
	 */
	public SchoolCategoryBean() {
		super();
	}
	/**
	 * 오버로디드 생성자
	 * @param categoryCode 분류 코드
	 * @param category 분류
	 */
	public SchoolCategoryBean(String categoryCode, String category) {
		super();
		this.categoryCode = categoryCode;
		this.category = category;
	}
	/**
	 * 분류 코드 반환 
	 * @return 분류 코드
	 */
	public String getCategoryCode() {
		return categoryCode;
	}
	/**
	 * 분류 코드 설정
	 * @param categoryCode 분류 코드
	 */
	public void setCategoryCode(String categoryCode) {
		this.categoryCode = categoryCode;
	}
	/**
	 * 분류 반환 
	 * @return 분류 
	 */
	public String getCategory() {
		return category;
	}
	/**
	 * 분류 설정 
	 * @param category 분류 
	 */
	public void setCategory(String category) {
		this.category = category;
	}
	@Override
	public String toString() {
		return "SchoolCategoryBean [categoryCode=" + categoryCode
				+ ", category=" + category + "]";
	}
	/**
	 * 전체 필드 반환
	 * @return
	 */
	public String[] getAll(){
		return new String[]{ this.categoryCode, this.category };
	}
}
