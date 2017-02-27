package com.omazing.introduce.model;

/**
 * 장점,준비과정,비전 및 목표 VO
 * @author nam
 */
public class PersonalReportVO {
	/**
	 * 회원ID
	 */
	private String memberID;
	/**
	 * 장점
	 */
	private String strength;
	/**
	 * 준비과정
	 */
	private String readyCondition;
	/**
	 * 비전 및 목표
	 */
	private String goal;
	/**
	 * 기본생성자
	 */
	public PersonalReportVO() {
		super();
	}
	/**
	 * 오버로딩 생성자
	 * @param strength 장점
	 * @param readyCondition 준비과정
	 * @param goal 비전 및 목표
	 */
	public PersonalReportVO(String memberID, String strength, String readyCondition, String goal) {
		super();
		this.memberID = memberID;
		this.strength = strength;
		this.readyCondition = readyCondition;
		this.goal = goal;
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
	 * 장점을 가져오는 메소드
	 * @return strength
	 */
	public String getStrength() {
		return strength;
	}
	/**
	 * 장점을 설정하는 메소드
	 * @param strength 장점
	 */
	public void setStrength(String strength) {
		this.strength = strength;
	}
	/**
	 * 준비과정을 가져오는 메소드
	 * @return 준비과정
	 */
	public String getReadyCondition() {
		return readyCondition;
	}
	/**
	 * 준비과정을 설정하는 메소드
	 * @param readyCondition 준비과정
	 */
	public void setReadyCondition(String readyCondition) {
		this.readyCondition = readyCondition;
	}
	/**
	 * 비전 및 목표를 가져오는 메소드
	 * @return goal
	 */
	public String getGoal() {
		return goal;
	}
	/**
	 * 비전 및 목표를 설정하는 메소드
	 * @param goal 비전 및 목표
	 */
	public void setGoal(String goal) {
		this.goal = goal;
	}
	/**
	 * 저장된 모든 정보값을 가져오는 메소드
	 * @return 순서: 회원ID,장점,준비과정,비전 및 목표
	 */
	public String[] getAll(){
		return new String[]{memberID,strength,readyCondition,goal};
	}
	/**
	 * toString메소드 재정의
	 */
	public String toString() {
		return "PersonalReportVO [memberID=" + memberID + ", strength=" + strength + ", ready=" + readyCondition + ", goal="
				+ goal + "]";
	}
}
