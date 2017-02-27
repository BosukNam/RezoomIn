package com.omazing.introduce.model;

/**
 * 아이콘 카테고리 VO
 * @author nam
 */
public class IconURLCategoryVO {
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
	 * 기본생성자
	 */
	public IconURLCategoryVO() {
		super();
	}

	/**
	 * 오버로딩 생성자
	 * @param iconCode 아이콘 코드
	 * @param type 취미특기 종류
	 * @param iconURL 아이콘 주소
	 */
	public IconURLCategoryVO(String iconCode, String type, String iconURL) {
		super();
		this.iconCode = iconCode;
		this.type = type;
		this.iconURL = iconURL;
	}

	/**
	 * 아이콘 코드를 가져오는 메소드
	 * @return 아이콘 코드
	 */
	public String getIconCode() {
		return iconCode;
	}

	/**
	 * 아이콘 코드를 설정하는 메소드
	 * @param iconCode 아이콘 코드 
	 */
	public void setIconCode(String iconCode) {
		this.iconCode = iconCode;
	}

	/**
	 * 취미특기종류를 가져오는 메소드
	 * @return 취미특기종류
	 */
	public String getType() {
		return type;
	}

	/**
	 * 취미특기종류를 설정하는 메소드
	 * @param type 취미특기종류
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * 아이콘 주소를 가져오는 메소드
	 * @return 아이콘 주소
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
	 * 저장된 모든 정보값을 가져오는 메소드
	 * @return 순서: 아이콘 코드,취미특기종류,아이콘 주소
	 */
	public String[] getAll(){
		return new String[]{iconCode,type,iconURL};
	}
	
	/**
	 * toString메소드 재정의
	 */
	@Override
	public String toString() {
		return "IconURLCategoryVO [iconCode=" + iconCode + ", type=" + type + ", iconURL=" + iconURL + "]";
	}
	
	
}
