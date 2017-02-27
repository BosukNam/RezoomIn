package com.omazing.introduce.model;

/**
 * 성장과정의 취미,특기 VO
 * @author nam
 */
public class PersonalSpecialtyVO {
	/**
	 * 회원ID
	 */
	private String memberID;
	/**
	 * 취미특기 종류
	 */
	private String type;
	/**
	 * 등록번호
	 */
	private int registerNo;
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
	public PersonalSpecialtyVO() {
		super();
	}

	/**
	 * 오버로딩 생성자
	 * @param memberID 회원ID
	 * @param type 취미특기 종류
	 * @param registerNo 등록번호
	 * @param name 취미특기명
	 * @param iconCode 아이콘코드
	 */
	public PersonalSpecialtyVO(String memberID, String type,
			int registerNo, String name, String iconCode) {
		super();
		this.memberID = memberID;
		this.type = type;
		this.registerNo = registerNo;
		this.name = name;
		this.iconCode = iconCode;
	}
	/**
	 * 오버로딩 생성자
	 * @param memberID 회원ID
	 * @param type 취미특기 종류
	 * @param name 취미특기명
	 * @param iconCode 아이콘코드
	 */
	public PersonalSpecialtyVO(String memberID, String type, String name, String iconCode) {
		this(memberID,type,0,name,iconCode);
	}

	/**
	 * 회원ID를 가져오는 메소드
	 * @return 회원ID
	 */
	public String getMemberID() {
		return memberID;
	}
	/**
	 * 회원ID를 설정하는 메소드
	 * @param memberID 회원ID
	 */
	public void setMemberID(String memberID) {
		this.memberID = memberID;
	}

	/**
	 * 취미특기 종류를 가져오는 메소드
	 * @return 취미특기 종류
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
	 * @return 등록번호
	 */
	public int getRegisterNo() {
		return registerNo;
	}

	/**
	 * 등록번호를 설정하는 메소드
	 * @param registerNo 등록번호
	 */
	public void setRegisterNo(int registerNo) {
		this.registerNo = registerNo;
	}

	/**
	 * 취미특기명을 가져오는 메소드
	 * @return 취미특기명
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
	 * @return 아이콘코드
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
	 * @return 순서: 회원ID,등록번호,취미특기 종류,취미특기명,아이콘코드 
	 */
	public String[] getAll(){
		return new String[]{memberID,new Integer(registerNo).toString(),type,name,iconCode};
	}
	
	/**
	 * toString메소드 재정의
	 */
	public String toString() {
		return "PersonalSpecialtyVO [memberID=" + memberID + ", type=" + type + ", registerNo=" + registerNo + ", name="
				+ name + ", iconCode=" + iconCode + "]";
	}
	
}
