package com.omazing.resume.bean;
/**
 * 군별계급 카테고리 Bean
 * @author yeeun
 *
 */
public class MilitaryRankCategoryBean {
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
	public MilitaryRankCategoryBean() {
		super();
	}
	/**
	 * 오버로디드 생성자 
	 * @param rankCode 군별계급 코드 
	 * @param rank 군별계급
	 */
	public MilitaryRankCategoryBean(String rankCode, String rank) {
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
		return "MilitaryRankCategoryBean [rankCode=" + rankCode + ", rank="
				+ rank + "]";
	}
	/**
	 * 전체 필드 반환 
	 * @return
	 */
	public String[] getAll(){
		return new String[]{ this.rankCode, this.rank };
	}
	
}
