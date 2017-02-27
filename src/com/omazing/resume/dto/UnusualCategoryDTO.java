package com.omazing.resume.dto;

import java.io.Serializable;

/**
 * 장애등급 카테고리 DTO
 * @author yeeun
 *
 */
public class UnusualCategoryDTO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -2199630086209814776L;
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
	public UnusualCategoryDTO() {
		super();
	}
	/**
	 * 오버로디드 생성자 
	 * @param disabilityCode 장애등급 코드 
	 * @param disability 장애등급 
	 */
	public UnusualCategoryDTO(String disabilityCode, String disability) {
		super();
		this.disabilityCode = disabilityCode;
		this.disability = disability;
	}
	/**
	 * 장애등급 코드 반환 
	 * @return 장애등급 코드 
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
		return "UnusualCategoryDTO [disabilityCode=" + disabilityCode
				+ ", disability=" + disability + "]";
	}
	/**
	 * 전체 필드 반환 
	 * @return
	 */
	public String[] getAll(){
		return new String[]{ this.disabilityCode, this.disability };
	}
}
