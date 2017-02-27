package com.omazing.resume.bean;
/**
 * 학력사항 Bean
 * @author yeeun
 *
 */
public class SchoolBean {
	/**
	 * 등록번호 
	 */
	private String registerNo;
	/**
	 * 분류코드
	 */
	private String categoryCode; 
	/**
	 * 분류
	 */
	private String category; 
	/**
	 * 학교명
	 */
	private String name;
	/**
	 * 계열 코드
	 */
	private String trackCode; 
	/**
	 * 계열
	 */
	private String track; 
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
	 * 학위 코드
	 */
	private String degreeCode; 
	/**
	 * 학위
	 */
	private String degree; 
	/**
	 * 학점
	 */
	private String grade;
	/**
	 * 총 학점 코드 
	 */
	private String totalGradeCode;
	/**
	 * 총 학점
	 */
	private String totalGrade;
	/**
	 * 지역
	 */
	private String location;
	/**
	 * 상태 코드
	 */
	private String stateCode; 
	/**
	 * 상태
	 */
	private String state; 
	
	public SchoolBean() {
		super();
	}
	public SchoolBean(String registerNo, String categoryCode, String category,
			String name, String trackCode, String track, String major, 
			String startDate, String endDate) {
		super();
		this.registerNo = registerNo;
		this.categoryCode = categoryCode;
		this.category = category;
		this.name = name;
		this.trackCode = trackCode;
		this.track = track;
		this.major = major;
		this.startDate = startDate;
		this.endDate = endDate;
	}
	public SchoolBean(String registerNo, String categoryCode, String category,
			String name,  String trackCode, String track, String major,
			String startDate, String endDate, String degreeCode, String degree,
			String grade, String totalGradeCode, String totalGrade,
			String location, String stateCode, String state) {
		super();
		this.registerNo = registerNo;
		this.categoryCode = categoryCode;
		this.category = category;
		this.name = name;
		this.trackCode = trackCode;
		this.track = track;
		this.major = major;
		this.startDate = startDate;
		this.endDate = endDate;
		this.degreeCode = degreeCode;
		this.degree = degree;
		this.grade = grade;
		this.totalGradeCode = totalGradeCode;
		this.totalGrade = totalGrade;
		this.location = location;
		this.stateCode = stateCode;
		this.state = state;
	}
	public String getRegisterNo() {
		return registerNo;
	}
	public void setRegisterNo(String registerNo) {
		this.registerNo = registerNo;
	}
	public String getCategoryCode() {
		return categoryCode;
	}
	public void setCategoryCode(String categoryCode) {
		this.categoryCode = categoryCode;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMajor() {
		return major;
	}
	public void setMajor(String major) {
		this.major = major;
	}
	public String getTrackCode() {
		return trackCode;
	}
	public void setTrackCode(String trackCode) {
		this.trackCode = trackCode;
	}
	public String getTrack() {
		return track;
	}
	public void setTrack(String track) {
		this.track = track;
	}
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	public String getDegreeCode() {
		return degreeCode;
	}
	public void setDegreeCode(String degreeCode) {
		this.degreeCode = degreeCode;
	}
	public String getDegree() {
		return degree;
	}
	public void setDegree(String degree) {
		this.degree = degree;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	public String getTotalGradeCode() {
		return totalGradeCode;
	}
	public void setTotalGradeCode(String totalGradeCode) {
		this.totalGradeCode = totalGradeCode;
	}
	public String getTotalGrade() {
		return totalGrade;
	}
	public void setTotalGrade(String totalGrade) {
		this.totalGrade = totalGrade;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getStateCode() {
		return stateCode;
	}
	public void setStateCode(String stateCode) {
		this.stateCode = stateCode;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	@Override
	public String toString() {
		return "SchoolBean [registerNo=" + registerNo + ", categoryCode="
				+ categoryCode + ", category=" + category + ", name=" + name
				+ ", major=" + major + ", trackCode=" + trackCode + ", track="
				+ track + ", startDate=" + startDate + ", endDate=" + endDate
				+ ", degreeCode=" + degreeCode + ", degree=" + degree
				+ ", grade=" + grade + ", totalGradeCode=" + totalGradeCode
				+ ", totalGrade=" + totalGrade + ", location=" + location
				+ ", stateCode=" + stateCode + ", state=" + state + "]";
	}
	/**
	 * 전체 필드 반환
	 * @return 
	 */
	public String[] getAll(){
		return new String[]{ this.registerNo, this.categoryCode, this.category, this.name,
				this.trackCode, this.track, this.major, this.startDate, this.endDate, 
				this.degreeCode, this.degree, this.totalGradeCode, this.totalGrade, 
				this.grade, this.location, this.stateCode, this.state };
	}
	
}
