package com.omazing.resume.dto;

import java.io.Serializable;

/**
 * 보훈 장애사항 DTO
 * @author yeeun
 *
 */
public class UnusualDTO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 6345100164143776132L;
	/**
	 * 회원 아이디
	 */
	private String memberID;
	/**
	 * 보훈대상 여부 
	 */
	private boolean isRewarded;
	/**
	 * 장애대상 여부 
	 */
	private boolean isDisabled;
	/**
	 * 장애 등급
	 */
	private UnusualCategoryDTO disability;
	
	/**
	 * 디폴트 생성자
	 */
	public UnusualDTO() {
		super();
	}
	/**
	 * 오버로디드 생성자 
	 * @param memberID 회원 아이디 
	 * @param isRewarded 보훈대상 여부 
	 * @param isDisabled 장애대상 여부 
	 */
	public UnusualDTO(String memberID, boolean isRewarded, boolean isDisabled) {
		super();
		this.memberID = memberID;
		this.isRewarded = isRewarded;
		this.isDisabled = isDisabled;
	}
	/**
	 * 오버로디드 생성자 
	 * @param memberID 회원 아이디 
	 * @param isRewarded 보훈대상 여부 
	 * @param isDisabled 장애대상 여부 
	 * @param disability 장애등급 
	 */
	public UnusualDTO(String memberID, boolean isRewarded, boolean isDisabled,
			UnusualCategoryDTO disability) {
		super();
		this.memberID = memberID;
		this.isRewarded = isRewarded;
		this.isDisabled = isDisabled;
		this.disability = disability;
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
	 * 보훈대상 여부 반환 
	 * @return 보훈대상 여부 
	 */
	public boolean getIsRewarded() {
		return isRewarded;
	}
	/**
	 * 보훈대상 여부 설정 
	 * @param isRewarded 보훈대상 여부 
	 */
	public void setIsRewarded(boolean isRewarded) {
		this.isRewarded = isRewarded;
	}
	/**
	 * 장애대상 여부 반환 
	 * @return 장애대상 여부 
	 */
	public boolean getIsDisabled() {
		return isDisabled;
	}
	/**
	 * 장애대상 여부 설정 
	 * @param isDisabled 장애대상 여부 
	 */
	public void setIsDisabled(boolean isDisabled) {
		this.isDisabled = isDisabled;
	}
	/**
	 * 장애등급 반환 
	 * @return 장애등급 카테고리 
	 */
	public UnusualCategoryDTO getDisability() {
		return disability;
	}
	/**
	 * 장애등급 설정 
	 * @param disability 장애등급 카테고리 
	 */
	public void setDisabilityClass(UnusualCategoryDTO disability) {
		this.disability = disability;
	}
	@Override
	public String toString() {
		return "UnusualDTO [memberID=" + memberID + ", isRewarded="
				+ isRewarded + ", isDisabled=" + isDisabled + ", disability="
				+ disability.toString() + "]";
	}

	/**
	 * 전체 필드 반환
	 * @return 
	 */
	public String[] getAll(){
		String rewarded = "대상";
		String disabled = "대상";
		
		if(this.isRewarded == false)
			rewarded = "해당사항 없음";
		if(this.isDisabled == false)
			disabled = "해당사항 없음";
		
		return new String[]{ this.memberID, rewarded, disabled, 
				this.disability.getDisabilityCode(), this.disability.getDisability() };
	}
}
