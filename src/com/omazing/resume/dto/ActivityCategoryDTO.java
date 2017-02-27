package com.omazing.resume.dto;

import java.io.Serializable;
/**
 * 대외활동 분류 DTO
 * @author Jun Seop
 *
 */
public class ActivityCategoryDTO implements Serializable{
	/**
	 * 대외활동 분류 코드
	 */
	private String categoryCode;
	/**
	 * 대외 활동 분류
	 */
	private String category;
	/**
	 * 기본 생성자
	 */
	public ActivityCategoryDTO() {
	}
	/**
	 * 오버로딩 생성자
	 * @param categoryCode(대외 활동 분류 코드)
	 * @param category(대외 활동 분류)
	 */
	public ActivityCategoryDTO(String categoryCode, String category) {
		super();
		this.categoryCode = categoryCode;
		this.category = category;
	}
	/**
	 * 대외활동 분류 코드 get메서드
	 * @return String(대외활동 분류 코드)
	 */
	public String getCategoryCode() {
		return categoryCode;
	}
	/**
	 * 대외 활동 분류 코드 set메서드
	 * @param categoryCode(대외활동 분류 코드)
	 */
	public void setCategoryCode(String categoryCode) {
		this.categoryCode = categoryCode;
	}
	/**
	 * 대외 활동 분류 get메서드
	 * @return String(대외 활동 분류)
	 */
	public String getCategory() {
		return category;
	}
	/**
	 * 대외 활동 분류 set메서드
	 * @param category(대외 활동 분류)
	 */
	public void setCategory(String category) {
		this.category = category;
	}
	/**
	 * toString 메서드(ActivityCategoryDTO)
	 */
	@Override
	public String toString() {
		return "ActivitycategoryBean [categoryCode=" + categoryCode
				+ ", category=" + category + "]";
	}
	/**
	 * ActivityCategoryDTO 객체 필드 String배열로 리턴
	 * @return String[](필드 String 배열로 리턴)
	 */
	public String[] getAll(){
		return new String[]{this.categoryCode, this.category};
	}
}
