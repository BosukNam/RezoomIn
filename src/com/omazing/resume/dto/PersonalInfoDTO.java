package com.omazing.resume.dto;

import java.io.Serializable;

/**
 * 인적사항 DTO
 * @author yeeun
 *
 */
public class PersonalInfoDTO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 374310641565218971L;
	/**
	 * 회원 아이디 
	 */
	private String memberID;
	/**
	 * 이름
	 */
	private String name;
	/**
	 * 생년월일
	 */
	private String birthDate;
	/**
	 * 이메일
	 */
	private String email;
	/**
	 * 연락처
	 */
	private String phoneNo;
	/**
	 * 주소
	 */
	private String address;
	/**
	 * 영문 이름
	 */
	private String englishName;
	/**
	 * 성별
	 */
	private Boolean gender;
	/**
	 * 사진 url
	 */
	private String photo;
	
	/**
	 * 디폴트생성자
	 */
	public PersonalInfoDTO() {
		super();
	}
	/**
	 * 오버로디드 생성자
	 * @param memberID 회원 아이디
	 * @param name 이름 
	 * @param birthDate 생년월일
	 * @param email 이메일
	 * @param phoneNo 연락처 
	 * @param address 주소
	 * @param englishName 영문이름
	 */
	public PersonalInfoDTO(String memberID, String name, String birthDate,
			String email, String phoneNo, String address, String englishName) {
		super();
		this.memberID = memberID;
		this.name = name;
		this.birthDate = birthDate;
		this.email = email;
		this.phoneNo = phoneNo;
		this.address = address;
		this.englishName = englishName;
	}
	/**
	 * 오버로디드 생성자
	 * @param memberID 회원 아이디
	 * @param name 이름 
	 * @param birthDate 생년월일
	 * @param email 이메일
	 * @param phoneNo 연락처
	 * @param address 주소
	 * @param englishName 영문이름
	 * @param photo 사진 url
	 */
	public PersonalInfoDTO(String memberID, String name, String birthDate,
			String email, String phoneNo, String address, String englishName,
			String photo) {
		super();
		this.memberID = memberID;
		this.name = name;
		this.birthDate = birthDate;
		this.email = email;
		this.phoneNo = phoneNo;
		this.address = address;
		this.englishName = englishName;
		this.photo = photo;
	}
	/**
	 * 오버로디드 생성자
	 * @param memberID 회원 아이디 
	 * @param name 이름
	 * @param birthDate 생년월일
	 * @param email 이메일
	 * @param phoneNo 연락처
	 * @param address 주소
	 * @param englishName 영문이름
	 * @param gender 성별
	 */
	public PersonalInfoDTO(String memberID, String name, String birthDate,
			String email, String phoneNo, String address,
			String englishName, Boolean gender) {
		super();
		this.memberID = memberID;
		this.name = name;
		this.birthDate = birthDate;
		this.email = email;
		this.phoneNo = phoneNo;
		this.address = address;
		this.englishName = englishName;
		this.gender = gender;
	}
	/**
	 * 오버로디드 생성자
	 * @param memberID 회원아이디
	 * @param name 이름
	 * @param birthDate 생년월일
	 * @param email 이메일
	 * @param phoneNo 연락처
	 * @param address 주소
	 * @param englishName 영문이름
	 * @param gender 성별
	 * @param photo 사진 url
	 */
	public PersonalInfoDTO(String memberID, String name, String birthDate,
			String email, String phoneNo, String address,
			String englishName, Boolean gender, String photo) {
		super();
		this.memberID = memberID;
		this.name = name;
		this.birthDate = birthDate;
		this.email = email;
		this.phoneNo = phoneNo;
		this.address = address;
		this.englishName = englishName;
		this.gender = gender;
		this.photo = photo;
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
	 * 생년월일 반환
	 * @return 생년월일
	 */
	public String getBirthDate() {
		return birthDate;
	}
	/**
	 * 생년월일 설정 
	 * @param birthDate 생년월일
	 */
	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}
	/**
	 * 연락처 반환 
	 * @return 연락처
	 */
	public String getPhoneNo() {
		return phoneNo;
	}
	/**
	 * 연락처 설정 
	 * @param phoneNo 연락처
	 */
	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}
	/**
	 * 주소 반환
	 * @return 주소
	 */
	public String getAddress() {
		return address;
	}
	/**
	 * 주소 설정
	 * @param address
	 */
	public void setAddress(String address) {
		this.address = address;
	}
	/**
	 * 영문이름 반환
	 * @return 영문이름
	 */
	public String getEnglishName() {
		return englishName;
	}
	/**
	 * 영문이름 설정 
	 * @param englishName 영문이름
	 */
	public void setEnglishName(String englishName) {
		this.englishName = englishName;
	}
	/**
	 * 성별 반환
	 * @return 성별 
	 */
	public boolean isGender() {
		return gender;
	}
	/**
	 * 성별 설정 
	 * @param gender 성별
	 */
	public void setGender(boolean gender) {
		this.gender = gender;
	}
	/**
	 * 사진 url 반환 
	 * @return 사진 url
	 */
	public String getPhoto() {
		return photo;
	}
	/**
	 * 사진 url 설정 
	 * @param photo 사진 url
	 */
	public void setPhoto(String photo) {
		this.photo = photo;
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
	@Override
	public String toString() {
		return "PersonalInfoVO [memberID=" + memberID + ", name=" + name
				+ ", birthDate=" + birthDate + ", email=" + email
				+ ", phoneNo=" + phoneNo + ", address=" + address
				+ ", englishName=" + englishName + ", gender=" + gender
				+ ", photo=" + photo + "]";
	}
	/**
	 * 전체 필드 반환
	 * @return 
	 */
	public String[] getAll(){
		String isMale = null;
		if(!this.gender)
			isMale = "여성";
		else if(this.gender)
			isMale = "남성";
		
		return new String[]{ this.memberID, this.name, this.birthDate, this.email, this.phoneNo,
				this.address, this.englishName, isMale, this.photo };
	}
}
