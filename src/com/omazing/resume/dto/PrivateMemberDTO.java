package com.omazing.resume.dto;

import java.io.Serializable;
/**
 * 개인회원 정보 DTO
 * @author yeeun
 *
 */
public class PrivateMemberDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5232221751203894683L;
	/**
	 * 등록번호
	 */
	private int registerNo;
	/**
	 * 회원 아이디
	 */
	private String memberID;
	/**
	 * 비밀번호
	 */
	private String password;
	/**
	 * 이름
	 */
	private String name;
	/**
	 * 이메일
	 */
	private String email;
	/**
	 * 활성화 여부
	 */
	private boolean isActive;
	
	/**
	 * 디폴트 생성자
	 */
	public PrivateMemberDTO() {
		super();
	}
	/**
	 * 오버로디드 생성자
	 * @param memberID 회원 아이디
	 * @param password 비밀번호
	 * @param name 이름
	 * @param email 이메일
	 */
	public PrivateMemberDTO(String memberID, String password,
			String name, String email) {
		super();
		this.memberID = memberID;
		this.password = password;
		this.name = name;
		this.email = email;
	}
	/**
	 * 오버로디드 생성자
	 * @param memberID 회원 아이디
	 * @param password 비밀번호
	 * @param name 이름
	 * @param email 이메일
	 * @param isActive 활성화 여부
	 */
	public PrivateMemberDTO(String memberID, String password, String name,
			String email, boolean isActive) {
		super();
		this.memberID = memberID;
		this.password = password;
		this.name = name;
		this.email = email;
		this.isActive = isActive;
	}
	/**
	 * 오버로디드 생성자
	 * @param registerNo 등록번호
	 * @param memberID 회원 아이디
	 * @param password 비밀번호
	 * @param name 이름
	 * @param email 이메일 
	 * @param isActive 활성화 여부
	 */
	public PrivateMemberDTO(int registerNo, String memberID, String password,
			String name, String email, boolean isActive) {
		super();
		this.registerNo = registerNo;
		this.memberID = memberID;
		this.password = password;
		this.name = name;
		this.email = email;
		this.isActive = isActive;
	}
	/**
	 * 등록번호 반환
	 * @return 등록번호
	 */
	public int getRegisterNo() {
		return registerNo;
	}
	/**
	 * 등록번호 설정
	 * @param registerNo 등록번호
	 */
	public void setRegisterNo(int registerNo) {
		this.registerNo = registerNo;
	}
	/**
	 * 회원 아이디 반환
	 * @return 회원 아이디
	 */
	public String getMemberID() {
		return memberID;
	}
	/**
	 * 회원 아이디 설정 
	 * @param memberID 회원 아이디
	 */
	public void setMemberID(String memberID) {
		this.memberID = memberID;
	}
	/**
	 * 비밀번호 반환 
	 * @return 비밀번호 
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * 비밀번호 설정 
	 * @param password 비밀번호
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	/**
	 * 이름 반환 
	 * @return 이름 
	 */
	public String getName() {
		return name;
	}
	/**
	 * 이름 설정 
	 * @param name 이름
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * 이메일 반환 
	 * @return 이메일
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * 이메일 설정 
	 * @param email 이메일
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * 활성화 여부 반환 
	 * @return 활성화 여부 
	 */
	public boolean isActive() {
		return isActive;
	}
	/**
	 * 활성화 여부 설정 
	 * @param isActive 활성화 여부 
	 */
	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	@Override
	public String toString() {
		return "PrivateMemberDTO [registerNo=" + registerNo + ", memberID="
				+ memberID + ", password=" + password + ", name=" + name
				+ ", email=" + email + ", isActive=" + isActive + "]";
	}
	/**
	 * 전체 필드 반환 
	 * @return
	 */
	public String[] getAll(){
		return new String[]{ Integer.toString(this.registerNo), this.memberID, this.password,
				this.name, this.email, Boolean.toString(this.isActive) };
	}
}
