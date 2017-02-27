package com.omazing.resume.dto;

import java.io.Serializable;

/**
 * 병역사항 DTO
 * @author yeeun
 *
 */
public class MilitaryDTO implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 300133564419646632L;
	/**
	 * 회원 아이디
	 */
	private String memberID;
	/**
	 * 병역구분
	 */
	private boolean pass;
	/**
	 * 입대일
	 */
	private String startDate;
	/**
	 * 전역일
	 */
	private String endDate;
	/**
	 * 군별구분
	 */
	private MilitaryCategoryDTO category; 
	/**
	 * 군별계급
	 */
	private MilitaryRankCategoryDTO rank;     
	
	/**
	 * 디폴트 생성자
	 */
	public MilitaryDTO() {
		super();
	}
	/**
	 * 오버로디드 생성자
	 * @param memberID 회원아이디 
	 * @param pass 병역구분
	 */
	public MilitaryDTO(String memberID, boolean pass) {
		super();
		this.memberID = memberID;
		this.pass = pass;
	}
	/**
	 * 오버로디드 생성자
	 * @param memberID 회원아이디
	 * @param pass 병역구분
	 * @param startDate 입대일
	 * @param endDate 전역일
	 */
	public MilitaryDTO(String memberID, boolean pass, String startDate, String endDate) {
		super();
		this.memberID = memberID;
		this.pass = pass;
		this.startDate = startDate;
		this.endDate = endDate;
	}
	/**
	 * 오버로디드 생성자
	 * @param memberID 회원아이디
	 * @param pass 병역구분
	 * @param startDate 입대일
	 * @param endDate 전역일 
	 * @param category 군별구분
	 * @param rank 군별계급
	 */
	public MilitaryDTO(String memberID, boolean pass, String startDate,
			String endDate, MilitaryCategoryDTO category,
			MilitaryRankCategoryDTO rank) {
		super();
		this.memberID = memberID;
		this.pass = pass;
		this.startDate = startDate;
		this.endDate = endDate;
		this.category = category;
		this.rank = rank;
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
	 * 병역구분 반환 
	 * @return 병역구분 
	 */
	public boolean isPass() {
		return pass;
	}
	/**
	 * 병역구분 설정 
	 * @param pass 병역구분
	 */
	public void setPass(boolean pass) {
		this.pass = pass;
	}
	/**
	 * 입대일 반환 
	 * @return 입대일
	 */
	public String getStartDate() {
		return startDate;
	}
	/**
	 * 입대일 설정
	 * @param startDate 입대일
	 */
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	/**
	 * 전역일 반환 
	 * @return 전역일
	 */
	public String getEndDate() {
		return endDate;
	}
	/**
	 * 전역일 설정 
	 * @param endDate 전역일
	 */
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	/**
	 * 군별구분 카테고리 반환 
	 * @return 군별구분 카테고리
	 */
	public MilitaryCategoryDTO getCategory() {
		return category;
	}
	/**
	 * 군별구분 카테고리 설정 
	 * @param category 군별구분 카테고리
	 */
	public void setCategory(MilitaryCategoryDTO category) {
		this.category = category;
	}
	/**
	 * 군별계급 카테고리 반환 
	 * @return 군별계급
	 */
	public MilitaryRankCategoryDTO getRank() {
		return rank;
	}
	/**
	 * 군별계급 카테고리 설정 
	 * @param rank 군별계급
	 */
	public void setRank(MilitaryRankCategoryDTO rank) {
		this.rank = rank;
	}

	@Override
	public String toString() {
		return "MilitaryVO [memberID=" + memberID + ", pass=" + pass
				+ ", startDate=" + startDate + ", endDate=" + endDate
				+ ", category=" + category.toString() + ", rank=" + rank.toString() + "]";
	}

	/**
	 * 전체 필드 반환
	 * @return 
	 */
	public String[] getAll(){
		String isPass = "필";
		if(this.pass == false)
			isPass = "미필";
		
		return new String[]{ this.memberID, isPass, this.startDate, this.endDate, 
				this.category.getCategoryCode(), this.category.getCategory(), 
				this.rank.getRankCode(), this.rank.getRank() };
	}
}
