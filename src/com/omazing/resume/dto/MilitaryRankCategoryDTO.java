package com.omazing.resume.dto;

import java.io.Serializable;
/**
 * 군별계급 카테고리 DTO 
 * @author yeeun
 *
 */
public class MilitaryRankCategoryDTO implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -2235875055222622428L;
	/**
	 * 군별계급 코드 
	 */
	private String rankCode;
	/**
	 * 군별계급
	 */
	private String rank;
	/**
	 * 디폴트 생성자
	 */
	public MilitaryRankCategoryDTO() {
		super();
	}
	/**
	 * 오버로디드 생성자
	 * @param rankCode 군별계급 코드
	 * @param rank 군별계급
	 */
	public MilitaryRankCategoryDTO(String rankCode, String rank) {
		super();
		this.rankCode = rankCode;
		this.rank = rank;
	}
	/**
	 * 군별계급 코드 반환 
	 * @return 군별계급 코드 
	 */
	public String getRankCode() {
		return rankCode;
	}
	/**
	 * 군별계급 코드 설정 
	 * @param rankCode 군별계급 코드 
	 */
	public void setRankCode(String rankCode) {
		this.rankCode = rankCode;
	}
	/**
	 * 군별계급 반환 
	 * @return 군별계급
	 */
	public String getRank() {
		return rank;
	}
	/**
	 * 군별계급 설정 
	 * @param rank 군별계급
	 */
	public void setRank(String rank) {
		this.rank = rank;
	}
	@Override
	public String toString() {
		return "MilitaryRankCategoryDTO [rankCode=" + rankCode + ", rank="
				+ rank + "]";
	}
	/**
	 * 전체 필드 반환 
	 * @return 
	 */
	public String[] getAll(){
		return new String[]{ this.getRankCode(), this.rank };
	}
}
