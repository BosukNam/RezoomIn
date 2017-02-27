package com.omazing.resume.dto;

import java.io.Serializable;
/**
 * 기업회원 정보 DTO 
 * @author yeeun
 *
 */
public class CompanyMemberDTO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -5993803058356345195L;
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
	 * 담당자 이름
	 */
	private String name;
	/**
	 * 담당자 이메일
	 */
	private String email;
	/**
	 * 기업명
	 */
	private String companyName;
	/**
	 * 사업자 번호
	 */
	private String companyNo;
	/**
	 * 도메인 주소
	 */
	private String domain;
	/**
	 * 사업 분야
	 */
	private String field;
	/**
	 * 사원 수 
	 */
	private int employeeNum;
	/**
	 * 활성화 여부
	 */
	private boolean isActive;
	
	/**
	 * 디폴트 생성자
	 */
	public CompanyMemberDTO() {
		super();
	}
	/**
	 * 오버로디드 생성자 
	 * @param memberID 회원 아이디
	 * @param password 비밀번호 
	 * @param name 담당자 이름
	 * @param email 담당자 이메일
	 * @param companyName 기업명
	 * @param companyNo 사업자 번호
	 * @param domain 도메인 주소
	 * @param field 사업 분야
	 * @param employeeNum 사원 수
	 */
	public CompanyMemberDTO(String memberID, String password, String name,
			String email, String companyName, String companyNo, String domain,
			String field, int employeeNum) {
		super();
		this.memberID = memberID;
		this.password = password;
		this.name = name;
		this.email = email;
		this.companyName = companyName;
		this.companyNo = companyNo;
		this.domain = domain;
		this.field = field;
		this.employeeNum = employeeNum;
	}
	/**
	 * 오버로디드 생성자
	 * @param memberID 회원 아이디
	 * @param password 비밀번호
	 * @param name 담당자 이름
	 * @param email 담당자 이메일
	 * @param companyName 기업명 
	 * @param companyNo 사업자 번호
	 * @param domain 도메인 주소
	 * @param field 사업 분야
	 * @param employeeNum 사원 수 
	 * @param isActive 활성화 여부
	 */
	public CompanyMemberDTO(String memberID, String password, String name,
			String email, String companyName, String companyNo, String domain,
			String field, int employeeNum, boolean isActive) {
		super();
		this.memberID = memberID;
		this.password = password;
		this.name = name;
		this.email = email;
		this.companyName = companyName;
		this.companyNo = companyNo;
		this.domain = domain;
		this.field = field;
		this.employeeNum = employeeNum;
		this.isActive = isActive;
	}
	/**
	 * 오버로디드 생성자
	 * @param registerNo 등록번호 
	 * @param memberID 회원 아이디 
	 * @param password 비밀번호
	 * @param name 담당자 이름
	 * @param email 담당자 이메일
	 * @param companyName 기업명
	 * @param companyNo 사업자 번호
	 * @param domain 도메인 주소
	 * @param field 사업 분야 
	 * @param employeeNum 사원 수 
	 * @param isActive 활성화 여부
	 */
	public CompanyMemberDTO(int registerNo, String memberID, String password,
			String name, String email, String companyName, String companyNo,
			String domain, String field, int employeeNum, boolean isActive) {
		super();
		this.registerNo = registerNo;
		this.memberID = memberID;
		this.password = password;
		this.name = name;
		this.email = email;
		this.companyName = companyName;
		this.companyNo = companyNo;
		this.domain = domain;
		this.field = field;
		this.employeeNum = employeeNum;
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
	 * 담당자 이름 반환 
	 * @return 담당자 이름 
	 */
	public String getName() {
		return name;
	}
	/**
	 * 담당자 이름 설정 
	 * @param name 담당자 이름
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * 담당자 이메일 반환
	 * @return 담당자 이메일
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * 담당자 이메일 설정
	 * @param email 담당자 이메일
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * 기업명 반환 
	 * @return 기업명
	 */
	public String getCompanyName() {
		return companyName;
	}
	/**
	 * 기업명 설정
	 * @param companyName 기업명
	 */
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	/**
	 * 사업자 번호 반환 
	 * @return 사업자 번호
	 */
	public String getCompanyNo() {
		return companyNo;
	}
	/**
	 * 사업자 번호 설정 
	 * @param companyNo 사업자 번호
	 */
	public void setCompanyNo(String companyNo) {
		this.companyNo = companyNo;
	}
	/**
	 * 도메인 주소 반환 
	 * @return 도메인 주소
	 */
	public String getDomain() {
		return domain;
	}
	/**
	 * 도메인 주소 설정 
	 * @param domain 도메인 주소
	 */
	public void setDomain(String domain) {
		this.domain = domain;
	}
	/**
	 * 사업 분야 반환
	 * @return 사업 분야
	 */
	public String getField() {
		return field;
	}
	/**
	 * 사업 분야 설정 
	 * @param field 사업 분야
	 */
	public void setField(String field) {
		this.field = field;
	}
	/**
	 * 사원 수 반환
	 * @return 사원 수
	 */
	public int getEmployeeNum() {
		return employeeNum;
	}
	/**
	 * 사원 수 설정 
	 * @param employeeNum 사원 수
	 */
	public void setEmployeeNum(int employeeNum) {
		this.employeeNum = employeeNum;
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
		return "CompanyMemberDTO [registerNo=" + registerNo + ", memberID="
				+ memberID + ", password=" + password + ", name=" + name
				+ ", email=" + email + ", companyName=" + companyName
				+ ", companyNo=" + companyNo + ", domain=" + domain
				+ ", field=" + field + ", employeeNum=" + employeeNum
				+ ", isActive=" + isActive + "]";
	}
	/**
	 * 전체 필드 반환
	 * @return
	 */
	public String[] getAll(){
		return new String[]{ Integer.toString(this.registerNo), this.memberID, this.password, 
				this.name, this.companyNo, this.companyName, this.companyNo, this.domain, 
				this.field, Integer.toString(this.employeeNum), Boolean.toString(this.isActive) };
	}
}
