package com.omazing.resume.dto;

import java.io.Serializable;
/**
 * 수상 분류 DTO
 * @author Jun Seop
 *
 */
public class AwardCategoryDTO implements Serializable {
	/**
	 * 수상 분류 코드 
	 */
	private String categoryCode;
	/**
	 * 수상 분류
	 */
	private String category;
	/**
	 * 기본 생성자
	 */
	public AwardCategoryDTO() {
		super();
	}
	/**
	 * 오버로딩 생성자
	 * @param categoryCode(수상 분류 코드)
	 * @param category(수상 분류)
	 */
	public AwardCategoryDTO(String categoryCode, String category) {
		super();
		this.categoryCode = categoryCode;
		this.category = category;
	}
	/**
	 * 수상 분류 코드 get메서드
	 * @return categoryCode(수상 분류 코드)
	 */
	public String getCategoryCode() {
		return categoryCode;
	}
	/**
	 * 수상 분류 코드 set메서드
	 * @param categoryCode(수상 분류 코드)
	 */
	public void setCategoryCode(String categoryCode) {
		this.categoryCode = categoryCode;
	}
	/**
	 * 수상 분류 get메서드
	 * @return category(수상 분류)
	 */
	public String getCategory() {
		return category;
	}
	/**
	 * 수상 분류 set메서드
	 * @param category(수상 분류)
	 */
	public void setCategory(String category) {
		this.category = category;
	}
	/**
	 * AwardCategoryDTO toString 메서드
	 */
	@Override
	public String toString() {
		return "AwardCategoryBean [categoryCode=" + categoryCode
				+ ", category=" + category + "]";
	}
	/**
	 * AwardCategory 필드 String 배열로 리턴하는 메서드
	 * @return String[] 형태로 필드 내용 리턴
	 */
	public String[] getAll(){
		return new String[]{this.categoryCode, this.category};
	}
}
