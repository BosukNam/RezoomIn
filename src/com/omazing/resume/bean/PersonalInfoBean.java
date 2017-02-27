package com.omazing.resume.bean;
/**
 * 개인 신상정보 빈
 * @author yeeun
 *
 */
public class PersonalInfoBean {
	/**
	 * 이름
	 */
	private String name;
	/**
	 * 이메일 
	 */
	private String email;
	/**
	 * 생년월일
	 */
	private String birthDate;
	/**
	 * 연락처
	 */
	private String phoneNo;
	/**
	 * 주소
	 */
	private String address;
	/**
	 * 영문이름
	 */
	private String englishName;
	/**
	 * 성별
	 */
	private String gender;
	/**
	 * 사진 url
	 */
	private String photo;
	
	/**
	 * 디폴트 생성자
	 */
	public PersonalInfoBean() {
		super();
	}
	/**
	 * 오버로디드 생성자 
	 * @param name 이름 
	 * @param email 이메일 
	 * @param birthDate 생년월일 
	 * @param phoneNo 연락처 
	 * @param address 주소 
	 * @param englishName 영문이름 
	 * @param gender 성별 
	 */
	public PersonalInfoBean(String name, String email, String birthDate,
			String phoneNo, String address, String englishName, String gender) {
		super();
		this.name = name;
		this.email = email;
		this.birthDate = birthDate;
		this.phoneNo = phoneNo;
		this.address = address;
		this.englishName = englishName;
		this.gender = gender;
	}
	/**
	 * 오버로디드 생성자 
	 * @param name 이름 
	 * @param email 이메일 
	 * @param birthDate 생년월일 
	 * @param phoneNo 연락처 
	 * @param address 주소 
	 * @param englishName 영문이름 
	 * @param gender 성별 
	 * @param photo 사진 url
	 */
	public PersonalInfoBean(String name, String email, String birthDate,
			String phoneNo, String address, String englishName, String gender,
			String photo) {
		super();
		this.name = name;
		this.email = email;
		this.birthDate = birthDate;
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
	 * @param address 주소 
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
	public String getGender() {
		return gender;
	}
	/**
	 * 성별 설정 
	 * @param gender 성별 
	 */
	public void setGender(String gender) {
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
	
	@Override
	public String toString() {
		return "PersonalInfoBean [name=" + name + ", email=" + email
				+ ", birthDate=" + birthDate + ", phoneNo=" + phoneNo
				+ ", address=" + address + ", englishName=" + englishName
				+ ", gender=" + gender + ", photo=" + photo + "]";
	}
	/**
	 * 전체 필드 반환
	 * @return 
	 */
	public String[] getAll(){
		return new String[]{ this.name, this.email, this.birthDate, this.phoneNo,
				this.address, this.englishName, this.gender, this.photo };
	}
}
