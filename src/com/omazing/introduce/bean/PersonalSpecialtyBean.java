package com.omazing.introduce.bean;

/**
 * 성장과정의 취미,특기 Bean
 * @author nam
 */
public class PersonalSpecialtyBean {
	/**
	 * 취미특기 종류
	 */
	private String type;
	/**
	 * 등록번호
	 */
	private String registerNo;
	/**
	 * 취미특기명
	 */
	private String name;
	/**
	 * 아이콘코드
	 */
	private String iconCode;
	
	/**
	 * 기본생성자
	 */
	public PersonalSpecialtyBean() {
		super();
	}

	/**
	 * 오버로딩 생성자
	 * @param registerNo 등록번호
	 * @param type 취미특기 종류
	 * @param name 취미특기명
	 * @param iconCode 아이콘코드
	 */
	public PersonalSpecialtyBean(String registerNo, String type, String name, String iconCode) {
		super();
		this.type = type;
		this.registerNo = registerNo;
		this.name = name;
		this.iconCode = iconCode;
	}

	/**
	 * 취미특기 종류를 가져오는 메소드
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
	 * 등록번호를 가져오는 메소드
	 * @return registerNo
	 */
	public String getRegisterNo() {
		return registerNo;
	}

	/**
	 * 등록번호를 설정하는 메소드
	 * @param registerNo 등록번호
	 */
	public void setRegisterNo(String registerNo) {
		this.registerNo = registerNo;
	}

	/**
	 * 취미특기명을 가져오는 메소드
	 * @return name
	 */
	public String getName() {
		return name;
	}

	/**
	 * 취미특기명을 설정하는 메소드
	 * @param name 취미특기명
	 */
	public void setName(String name) {
		this.name = name;
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
	 * @param name 아이콘코드
	 */
	public void setIconCode(String iconCode) {
		this.iconCode = iconCode;
	}
	
	/**
	 * 저장된 모든 정보값을 가져오는 메소드
	 * @return 순서: 등록번호,취미특기 종류,취미특기명,아이콘코드 
	 */
	public String[] getAll(){
		return new String[]{registerNo,type,name,iconCode};
	}
	
	/**
	 * toString메소드 재정의
	 */
	@Override
	public String toString() {
		return "PersonalSpecialtyBean [type=" + type + ", registerNo=" + registerNo + ", name=" + name + ", iconCode="
				+ iconCode + "]";
	}
	
}
