package com.omazing.introduce.bean;

/**
 * 아이콘 카테고리 Bean
 * @author nam
 */
public class IconURLCategoryBean {
	/**
	 * 아이콘 코드
	 */
	private String iconCode;
	/**
	 * 취미특기 종류
	 */
	private String type;
	/**
	 * 아아콘 주소
	 */
	private String iconURL;
	
	/**
	 * 기본 생성자
	 */
	public IconURLCategoryBean() {
		super();
	}

	/**
	 * 오버로딩 생성자
	 * @param iconCode 아이콘 코드
	 * @param type 취미특기 종류
	 * @param iconURL 아이콘 주소
	 */
	public IconURLCategoryBean(String iconCode, String type, String iconURL) {
		super();
		this.iconCode = iconCode;
		this.type = type;
		this.iconURL = iconURL;
	}

	/**
	 * 아이콘코드를 가져오는 메소드
	 * @return iconCode
	 */
	public String getIconCode() {
		return iconCode;
	}

	/**
	 * 아이콘코드를 설정하는 메소드
	 * @param iconCode 아이콘 코드 
	 */
	public void setIconCode(String iconCode) {
		this.iconCode = iconCode;
	}

	/**
	 * 취미특기 종류를 반환하는 메소드
	 * @return type
	 */
	public String getType() {
		return type;
	}

	/**
	 * 취미특기 종류를 설정하는 메소드
	 * @param type 취미특기 종류
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * 아이콘 주소를 가져오는 메소드
	 * @return iconURL
	 */
	public String getIconURL() {
		return iconURL;
	}

	/**
	 * 아이콘 주소를 설정하는 메소드
	 * @param iconURL 아이콘 주소
	 */
	public void setIconURL(String iconURL) {
		this.iconURL = iconURL;
	}

	/**
	 * toString메소드 재정의
	 */
	@Override
	public String toString() {
		return "IconURLCategoryBean [iconCode=" + iconCode + ", type=" + type + ", iconURL=" + iconURL + "]";
	}
	
	
}
