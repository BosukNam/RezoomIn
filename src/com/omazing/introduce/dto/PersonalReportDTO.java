package com.omazing.introduce.dto;

/**
 * 장점,준비과정,비전 및 목표 DTO
 * @author nam
 */
public class PersonalReportDTO {
	/**
	 * 회원ID
	 */
	private String member_id;
	/**
	 * 장점
	 */
	private String strength;
	/**
	 * 준비과정
	 */
	private String ready;
	/**
	 * 비전 및 목표
	 */
	private String goal;
	/**
	 * 기본생성자
	 */
	public PersonalReportDTO() {
		super();
	}
	/**
	 * 오버로딩 생성자
	 * @param strength 장점
	 * @param readyCondition 준비과정
	 * @param goal 비전 및 목표
	 */
	public PersonalReportDTO(String memberID, String strength, String readyCondition, String goal) {
		super();
		this.member_id = memberID;
		this.strength = strength;
		this.ready = readyCondition;
		this.goal = goal;
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
		return ready;
	}
	/**
	 * 준비과정을 설정하는 메소드
	 * @param readyCondition 준비과정
	 */
	public void setReadyCondition(String readyCondition) {
		this.ready = readyCondition;
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
		return new String[]{member_id,strength,ready,goal};
	}
	/**
	 * toString메소드 재정의
	 */
	public String toString() {
		return "PersonalReportDTO [memberID=" + member_id + ", strength=" + strength + ", ready=" + ready + ", goal="
				+ goal + "]";
	}
}
