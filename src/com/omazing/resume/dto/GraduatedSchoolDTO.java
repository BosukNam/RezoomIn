package com.omazing.resume.dto;

import java.io.Serializable;
/**
 * 대학교, 대학원 학력사항 DTO 
 * @author yeeun
 *
 */
public class GraduatedSchoolDTO extends SchoolDTO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -4169953997478320298L;
	/**
	 * 학위 
	 */
	private SchoolDegreeCategoryDTO degree;
	/**
	 * 학점
	 */
	private double grade;
	/**
	 * 총 학점
	 */
	private SchoolTotalGradeCategoryDTO totalGrade;
	/**
	 * 지역
	 */
	private String location;
	/**
	 * 상태
	 */
	private SchoolStateCategoryDTO state; 
	
	/**
	 * 디폴트 생성자
	 */
	public GraduatedSchoolDTO() {
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
	public GraduatedSchoolDTO(String memberID, SchoolCategoryDTO category,
			String name, SchoolTrackCategoryDTO track, String major, String startDate, String endDate) {
		super(memberID, category, name, track, major, startDate, endDate);
	}
	/**
	 * 오버로디드 생성자
	 * @param degree 학위
	 * @param grade 학점 
	 * @param totalGrade 총 학점
	 * @param location 지역
	 * @param state 상태
	 */
	public GraduatedSchoolDTO(SchoolDegreeCategoryDTO degree, double grade,
			SchoolTotalGradeCategoryDTO totalGrade, String location,
			SchoolStateCategoryDTO state) {
		super();
		this.degree = degree;
		this.grade = grade;
		this.totalGrade = totalGrade;
		this.location = location;
		this.state = state;
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
	 * @param degree 학위
	 * @param grade 학점 
	 * @param totalGrade 총 학점
	 * @param location 지역
	 * @param state 상태
	 */
	public GraduatedSchoolDTO(String memberID, SchoolCategoryDTO category,
			String name, SchoolTrackCategoryDTO track, String major, String startDate, String endDate,
			SchoolDegreeCategoryDTO degree, double grade,
			SchoolTotalGradeCategoryDTO totalGrade, String location,
			SchoolStateCategoryDTO state) {
		super(memberID, category, name, track, major, startDate, endDate);
		this.degree = degree;
		this.grade = grade;
		this.totalGrade = totalGrade;
		this.location = location;
		this.state = state;
	}
	/**
	 * 오버로디드 생성자 
	 * @param memberID 회원 아이디
	 * @param registerNo 등록번호
	 * @param category 분류
	 * @param name 이름
	 * @param track 계열
	 * @param major 전공
	 * @param startDate 입학일
	 * @param endDate 졸업일
	 * @param degree 학위
	 * @param grade 학점
	 * @param totalGrade 총 학점
	 * @param location 지역
	 * @param state 상태
	 */
	public GraduatedSchoolDTO(String memberID, int registerNo, SchoolCategoryDTO category,
			String name, SchoolTrackCategoryDTO track, String major, String startDate, String endDate,
			SchoolDegreeCategoryDTO degree, double grade,
			SchoolTotalGradeCategoryDTO totalGrade, String location,
			SchoolStateCategoryDTO state) {
		super(memberID, registerNo, category, name, track, major, startDate, endDate);
		this.degree = degree;
		this.grade = grade;
		this.totalGrade = totalGrade;
		this.location = location;
		this.state = state;
	}
	/**
	 * 학위 카테고리 반환 
	 * @return 학위 카테고리
	 */
	public SchoolDegreeCategoryDTO getDegree() {
		return degree;
	}
	/**
	 * 학위 카테고리 설정 
	 * @param degree 학위 카테고리
	 */
	public void setDegree(SchoolDegreeCategoryDTO degree) {
		this.degree = degree;
	}
	/**
	 * 학점 반환 
	 * @return 학점 
	 */
	public double getGrade() {
		return grade;
	}
	/**
	 * 학점 설정 
	 * @param grade 학점
	 */
	public void setGrade(double grade) {
		this.grade = grade;
	}
	/** 
	 * 총 학점 카테고리 반환 
	 * @return 총 학점 카테고리
	 */
	public SchoolTotalGradeCategoryDTO getTotalGrade() {
		return totalGrade;
	}
	/**
	 * 총 학점 카테고리 설정 
	 * @param totalGrade
	 */
	public void setTotalGrade(SchoolTotalGradeCategoryDTO totalGrade) {
		this.totalGrade = totalGrade;
	}
	/**
	 * 지역 반환 
	 * @return 지역
	 */
	public String getLocation() {
		return location;
	}
	/**
	 * 지역 설정 
	 * @param location 지역
	 */
	public void setLocation(String location) {
		this.location = location;
	}
	/**
	 * 상태 카테고리 반환 
	 * @return 상태 카테고리 
	 */
	public SchoolStateCategoryDTO getState() {
		return state;
	}
	/**
	 * 상태 카테고리 설정 
	 * @param state 상태 카테고리 
	 */
	public void setState(SchoolStateCategoryDTO state) {
		this.state = state;
	}
	@Override
	public String toString() {
		return super.toString() + "/ GraduatedSchoolVO [degree=" + degree.toString() + ", grade=" + grade
				+ ", totalGrade=" + totalGrade.toString() + ", location=" + location
				+ ", state=" + state.toString() + "]";
	}
	
	/**
	 * 전체 필드 반환
	 * @return 
	 */
	public String[] getAll(){
		return new String[]{ this.getMemberID(), Integer.toString(this.getRegisterNo()), 
				this.getCategory().getCategoryCode(), 
				this.getCategory().getCategory(), this.getName(), 
				this.getTrack().getTrackCode(), this.getTrack().getTrack(), this.getMajor(), 
				this.getStartDate(), this.getEndDate(), 
				this.degree.getDegreeCode(), this.degree.getDegree(), Double.toString(this.grade),
				this.totalGrade.getTotalGradeCode(), Double.toString(this.totalGrade.getTotalGrade()), 
				this.location, this.state.getStateCode(), this.state.getState()
			};
	}
}
