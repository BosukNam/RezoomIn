package com.omazing.resume.bean;
/**
 * 학력사항 상태 카테고리 Bean
 * @author yeeun
 *
 */
public class SchoolStateCategoryBean {
	/**
	 * 상태 코드 
	 */
	private String stateCode;
	/**
	 * 상태 
	 */
	private String state;
	
	/**
	 * 디폴트 생성자 
	 */
	public SchoolStateCategoryBean() {
		super();
	}
	/**
	 * 오버로디드 생성자 
	 * @param stateCode 상태 코드 
	 * @param state 상태 
	 */
	public SchoolStateCategoryBean(String stateCode, String state) {
		super();
		this.stateCode = stateCode;
		this.state = state;
	}
	/**
	 * 상태 코드 반환 
	 * @return 상태 코드 
	 */
	public String getStateCode() {
		return stateCode;
	}
	/**
	 * 상태 코드 설정 
	 * @param stateCode 상태 코드 
	 */
	public void setStateCode(String stateCode) {
		this.stateCode = stateCode;
	}
	/**
	 * 상태 반환 
	 * @return 상태
	 */
	public String getState() {
		return state;
	}
	/**
	 * 상태 설정 
	 * @param state 상태
	 */
	public void setState(String state) {
		this.state = state;
	}
	@Override
	public String toString() {
		return "SchoolStateCategoryBean [stateCode=" + stateCode + ", state="
				+ state + "]";
	}
	/**
	 * 전체 필드 반환
	 * @return
	 */
	public String[] getAll(){
		return new String[]{ this.stateCode, this.state };
	}
}
