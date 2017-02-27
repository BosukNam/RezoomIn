package com.omazing.resume.bean;
/**
 * 장애등급 카테고리 Bean 
 * @author yeeun
 *
 */
public class UnusualCategoryBean {
	/**
	 * 장애등급 코드 
	 */
	private String disabilityCode;
	/**
	 * 장애등급 
	 */
	private String disability;
	/**
	 * 디폴트 생성자 
	 */
	public UnusualCategoryBean() {
		super();
	}
	/**
	 * 오버로디드 생성자 
	 * @param disabilityCode 장애등급 코드 
	 * @param disability 장애등급 
	 */
	public UnusualCategoryBean(String disabilityCode, String disability) {
		super();
		this.disabilityCode = disabilityCode;
		this.disability = disability;
	}
	/**
	 * 장애등급 코드 반환 
	 * @return 장애등급 
	 */
	public String getDisabilityCode() {
		return disabilityCode;
	}
	/**
	 * 장애등급 코드 설정 
	 * @param disabilityCode 장애등급 
	 */
	public void setDisabilityCode(String disabilityCode) {
		this.disabilityCode = disabilityCode;
	}
	/**
	 * 장애등급 반환 
	 * @return 장애등급 
	 */
	public String getDisability() {
		return disability;
	}
	/**
	 * 장애등급 설정 
	 * @param disability 장애등급 
	 */
	public void setDisability(String disability) {
		this.disability = disability;
	}
	@Override
	public String toString() {
		return "UnusualCategoryBean [disabilityCode=" + disabilityCode
				+ ", disability=" + disability + "]";
	}
	/**
	 * 모든 필드 반환 
	 * @return
	 */
	public String[] getAll(){
		return new String[]{ this.disabilityCode, this.disability };
	}
}
