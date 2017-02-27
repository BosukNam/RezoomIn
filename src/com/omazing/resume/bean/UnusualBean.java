package com.omazing.resume.bean;
/**
 * 보훈장애사항 Bean 
 * @author yeeun
 *
 */
public class UnusualBean {
	/**
	 * 보훈대상 여부 
	 */
	private String isRewarded;
	/**
	 * 장애대상 여부 
	 */
	private String isDisabled;
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
	public UnusualBean() {
		super();
	}
	/**
	 * 오버로디드 생성자 
	 * @param isRewarded 보훈대상 여부 
	 * @param isDisabled 장애대상 여부 
	 */
	public UnusualBean(String isRewarded, String isDisabled) {
		super();
		this.isRewarded = isRewarded;
		this.isDisabled = isDisabled;
	}
	/**
	 * 오버로디드 생성자 
	 * @param isRewarded 보훈대상 여부 
	 * @param isDisabled 장애대상 여부 
	 * @param disabilityCode 장애등급 코드 
	 * @param disability 장애등급 
	 */
	public UnusualBean(String isRewarded, String isDisabled,
			String disabilityCode, String disability) {
		super();
		this.isRewarded = isRewarded;
		this.isDisabled = isDisabled;
		this.disabilityCode = disabilityCode;
		this.disability = disability;
	}
	/**
	 * 보훈대상 여부 반환 
	 * @return 보훈대상 여부 
	 */
	public String getIsRewarded() {
		return isRewarded;
	}
	/**
	 * 보훈대상 여부 설정 
	 * @param isRewarded 보훈대상 여부 
	 */
	public void setIsRewarded(String isRewarded) {
		this.isRewarded = isRewarded;
	}
	/**
	 * 장애대상 여부 반환 
	 * @return 장애대상 여부 
	 */
	public String getIsDisabled() {
		return isDisabled;
	}
	/**
	 * 장애대상 여부 설정 
	 * @param isDisabled 장애대상 여부 
	 */
	public void setIsDisabled(String isDisabled) {
		this.isDisabled = isDisabled;
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
	 * @param disabilityCode 장애등급 코드
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
		return "UnusualBean [isRewarded=" + isRewarded + ", isDisabled="
				+ isDisabled + ", disabilityCode=" + disabilityCode
				+ ", disability=" + disability + "]";
	}
	/**
	 * 전체 필드 반환
	 * @return 
	 */
	public String[] getAll(){
		return new String[]{ this.isRewarded, this.isDisabled, this.disabilityCode, this.disability };
	}
}
