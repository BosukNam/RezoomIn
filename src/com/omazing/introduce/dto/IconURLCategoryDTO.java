package com.omazing.introduce.dto;
/**
 * 아이콘 카테고리 DTO
 * @author nam
 */
public class IconURLCategoryDTO {
	/**
	 * 아이콘 코드
	 */
	private String icon_code;
	/**
	 * 취미특기 종류
	 */
	private String type;
	/**
	 * 아아콘 주소
	 */
	private String icon_url;
	
	/**
	 * 기본생성자
	 */
	public IconURLCategoryDTO() {
		super();
	}

	/**
	 * 오버로딩 생성자
	 * @param iconCode 아이콘 코드
	 * @param type 취미특기 종류
	 * @param iconURL 아이콘 주소
	 */
	public IconURLCategoryDTO(String iconCode, String type, String iconURL) {
		super();
		this.icon_code = iconCode;
		this.type = type;
		this.icon_url = iconURL;
	}

	/**
	 * 아이콘 코드를 가져오는 메소드
	 * @return 아이콘 코드
	 */
	public String getIconCode() {
		return icon_code;
	}

	/**
	 * 아이콘 코드를 설정하는 메소드
	 * @param iconCode 아이콘 코드 
	 */
	public void setIconCode(String iconCode) {
		this.icon_code = iconCode;
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
		return icon_url;
	}

	/**
	 * 아이콘 주소를 설정하는 메소드
	 * @param iconURL 아이콘 주소
	 */
	public void setIconURL(String iconURL) {
		this.icon_url = iconURL;
	}
	
	/**
	 * 저장된 모든 정보값을 가져오는 메소드
	 * @return 순서: 아이콘 코드,취미특기종류,아이콘 주소
	 */
	public String[] getAll(){
		return new String[]{icon_code,type,icon_url};
	}

	/**
	 * toString메소드 재정의
	 */
	@Override
	public String toString() {
		return "IconURLCategoryDTO [iconCode=" + icon_code + ", type=" + type + ", iconURL=" + icon_url + "]";
	}
	
	
}
