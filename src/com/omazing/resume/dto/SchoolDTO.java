package com.omazing.resume.dto;

import java.io.Serializable;
/**
 * 고등학교 학력사항 DTO 
 * @author yeeun
 *
 */
public class SchoolDTO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -1935320118929222731L;
	/**
	 * 회원 아이디 
	 */
	private String memberID;
	/**
	 * 등록 번호 
	 */
	private int registerNo;
	/**
	 * 분류 
	 */
	private SchoolCategoryDTO category; 
	/**
	 * 학교명
	 */
	private String name;
	/**
	 * 계열
	 */
	private SchoolTrackCategoryDTO track; 
	/**
	 * 전공
	 */
	private String major;
	/**
	 * 입학일
	 */
	private String startDate;
	/**
	 * 졸업일
	 */
	private String endDate;
	
	/**
	 * 디폴트 생성자
	 */
	public SchoolDTO() {
		super();
	}
	/**
	 * 오버로디드 생성자 
	 * @param memberID 회원 아이디 
	 * @param category 분류 
	 * @param name 학교명 
	 * @param track 계열 
	 * @param major 전공 
	 * @param startDate 입학일 
	 * @param endDate 졸업일 
	 */
	public SchoolDTO(String memberID, SchoolCategoryDTO category, String name,
			SchoolTrackCategoryDTO track, String major, String startDate,
			String endDate) {
		super();
		this.memberID = memberID;
		this.category = category;
		this.name = name;
		this.track = track;
		this.major = major;
		this.startDate = startDate;
		this.endDate = endDate;
	}
	/**
	 * 오버로디드 생성자 
	 * @param memberID 회원 아이디 
	 * @param registerNo 등록 번호 
	 * @param category 분류 
	 * @param name 학교명 
	 * @param track 계열 
	 * @param major 전공 
	 * @param startDate 입학일 
	 * @param endDate 졸업일 
	 */
	public SchoolDTO(String memberID, int registerNo,
			SchoolCategoryDTO category, String name,
			SchoolTrackCategoryDTO track, String major, String startDate,
			String endDate) {
		super();
		this.memberID = memberID;
		this.registerNo = registerNo;
		this.category = category;
		this.name = name;
		this.track = track;
		this.major = major;
		this.startDate = startDate;
		this.endDate = endDate;
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
	 * 학교명 반환 
	 * @return 학교명 
	 */
	public String getName() {
		return name;
	}
	/**
	 * 학교명 설정 
	 * @param name 학교명 
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * 분류 카테고리 반환 
	 * @return 분류 카테고리 
	 */
	public SchoolCategoryDTO getCategory() {
		return category;
	}
	/**
	 * 분류 카테고리 설정 
	 * @param category 분류 카테고리 
	 */
	public void setCategory(SchoolCategoryDTO category) {
		this.category = category;
	}
	/**
	 * 계열 카테고리 반환 
	 * @return 계열 카테고리 
	 */
	public SchoolTrackCategoryDTO getTrack() {
		return track;
	}
	/**
	 * 계열 카테고리 설정 
	 * @param track 계열 카테고리 
	 */
	public void setTrack(SchoolTrackCategoryDTO track) {
		this.track = track;
	}
	/**
	 * 전공 반환 
	 * @return 전공 
	 */
	public String getMajor() {
		return major;
	}
	/**
	 * 전공 설정 
	 * @param major 전공 
	 */
	public void setMajor(String major) {
		this.major = major;
	}
	/**
	 * 입학일 반환 
	 * @return 입학일 
	 */
	public String getStartDate() {
		return startDate;
	}
	/**
	 * 입학일 설정 
	 * @param startDate 입학일 
	 */
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	/**
	 * 졸업일 반환
	 * @return 졸업일
	 */
	public String getEndDate() {
		return endDate;
	}
	/**
	 * 졸업일 설정
	 * @param endDate 졸업일
	 */
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	@Override
	public String toString() {
		return "SchoolVO [memberID=" + memberID + ", registerNo=" + registerNo
				+ ", category=" + category.toString() + ", name=" + name + ", track="
				+ track.toString() + ", major=" + major + ", startDate=" + startDate
				+ ", endDate=" + endDate + "]";
	}
	
	/**
	 * 전체 필드 반환
	 * @return 
	 */
	public String[] getAll(){
		return new String[]{ this.memberID, Integer.toString(this.registerNo), 
				this.category.getCategoryCode(), this.category.getCategory(),
				this.name, this.track.getTrackCode(), this.track.getTrack(), 
				this.major, this.startDate, this.endDate };
	}
}
