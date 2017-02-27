package com.omazing.resume.bean;
/**
 * 군별구분 카테고리 Bean
 * @author yeeun
 *
 */
public class MilitaryCategoryBean {
	/**
	 * 군별구분 코드 
	 */
	private String categoryCode;
	/**
	 * 군별구분
	 */
	private String category;
	/**
	 * 디폴트 생성자
	 */
	public MilitaryCategoryBean() {
		super();
	}
	/**
	 * 오버로디드 생성자
	 * @param categoryCode 군별구분 코드
	 * @param category 군별구분
	 */
	public MilitaryCategoryBean(String categoryCode, String category) {
		super();
		this.categoryCode = categoryCode;
		this.category = category;
	}
	/**
	 * 군별구분 코드 반환
	 * @return 군별구분 코드 
	 */
	public String getCategoryCode() {
		return categoryCode;
	}
	/**
	 * 군별구분 코드 설정
	 * @param categoryCode 군별구분 코드
	 */
	public void setCategoryCode(String categoryCode) {
		this.categoryCode = categoryCode;
	}
	/**
	 * 군별구분 반환 
	 * @return 군별구분
	 */
	public String getCategory() {
		return category;
	}
	/**
	 * 군별구분 설정 
	 * @param category 군별구분
	 */
	public void setCategory(String category) {
		this.category = category;
	}
	@Override
	public String toString() {
		return "MilitaryCategoryBean [categoryCode=" + categoryCode
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
