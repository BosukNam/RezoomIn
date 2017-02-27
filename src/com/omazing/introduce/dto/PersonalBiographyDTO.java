package com.omazing.introduce.dto;

import java.util.Map;

/**
 * 성장과정 DTO
 * @author nam
 */
public class PersonalBiographyDTO {
	/**
	 * 회원ID
	 */
	private String member_id;
	/**
	 * 유년기
	 */
	private String childhood;
	/**
	 * 청소년기
	 */
	private String student;
	/**
	 * 대학생활
	 */
	private String univ;
	/**
	 * 회사생활
	 */
	private String company;
	/**
	 * 대표키워드
	 */
	private String keyword;
	/**
	 * 취미특기를 저장할 맵
	 */
	private Map<Integer, PersonalSpecialtyDTO> specialtyMap;
	
	/**
	 * 기본생성자
	 */
	public PersonalBiographyDTO() {
		super();
	}

	/**
	 * 오버로딩 생성자
	 * @param memberID 회원ID
	 * @param childhood 유년기
	 * @param student 청소년기
	 * @param univ 대학생활
	 * @param company 회사생활
	 * @param keyword 대표키워드
	 * @param specialtyMap 취미특기 맵
	 */
	public PersonalBiographyDTO(String memberID, String childhood, String student, String univ, String company,
			String keyword, Map<Integer, PersonalSpecialtyDTO> specialtyMap) {
		super();
		this.member_id = memberID;
		this.childhood = childhood;
		this.student = student;
		this.univ = univ;
		this.company = company;
		this.keyword = keyword;
		this.setSpecialtyMap(specialtyMap);
	}

	/**
	 * 회원ID를 가져오는 메소드
	 * @return 회원ID
	 */
	public String getMemberID() {
		return member_id;
	}

	/**
	 * 회원ID를 설정하는 메소드
	 * @param memberID 회원ID
	 */
	public void setMemberID(String memberID) {
		this.member_id = memberID;
	}

	/**
	 * 유년기를 가져오는 메소드
	 * @return 유년기
	 */
	public String getChildhood() {
		return childhood;
	}

	/**
	 * 유년기를 설정하는 메소드
	 * @param childhood 유년기
	 */
	public void setChildhood(String childhood) {
		this.childhood = childhood;
	}

	/**
	 * 청소년기를 가져오는 메소드
	 * @return 청소년기
	 */
	public String getStudent() {
		return student;
	}

	/**
	 * 청소년기를 설정하는 메소드
	 * @param student 청소년기
	 */
	public void setStudent(String student) {
		this.student = student;
	}

	/**
	 * 대학생활을 가져오는 메소드
	 * @return 대학생활
	 */
	public String getUniv() {
		return univ;
	}

	/**
	 * 대학생활을 설정하는 메소드
	 * @param univ 대학생활
	 */
	public void setUniv(String univ) {
		this.univ = univ;
	}

	/**
	 * 회사생활을 가져오는 메소드
	 * @return 회사생활
	 */
	public String getCompany() {
		return company;
	}

	/**
	 * 회사생활을 설정하는 메소드
	 * @param company 회사생활
	 */
	public void setCompany(String company) {
		this.company = company;
	}

	/**
	 * 대표키워드를 가져오는 메소드
	 * @return 대표키워드
	 */
	public String getKeyword() {
		return keyword;
	}

	/**
	 * 대표키워드를 설정하는 메소드
	 * @param keyword 대표키워드
	 */
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	
	/**
	 * 취미특기 맵을 가져오는 메소드
	 * @return 취미특기 맵
	 */
	public Map<Integer, PersonalSpecialtyDTO> getSpecialtyMap() {
		return specialtyMap;
	}

	/**
	 * 취미특기 맵을 설정하는 메소드
	 * @param specialtyMap
	 */
	public void setSpecialtyMap(Map<Integer, PersonalSpecialtyDTO> specialtyMap) {
		this.specialtyMap = specialtyMap;
	}
	
	/**
	 * 저장된 모든 정보값을 가져오는 메소드
	 * @return 순서: 회원ID,유년기,청소년기,대학생활,회사생활,대표키워드
	 */
	public String[] getAll(){
		return new String[]{member_id,childhood,student,univ,company,keyword};
	}
	
	/**
	 * toString메소드 재정의
	 */
	public String toString() {
		return "PersonalBiographyDTO [memberID=" + member_id 
				+ ", childhood=" + childhood + ", student=" + student
				+ ", univ=" + univ + ", company=" + company +
				", keyword=" + keyword + ", specialtyMap=" + specialtyMap + "]";
	}

	
	
}
