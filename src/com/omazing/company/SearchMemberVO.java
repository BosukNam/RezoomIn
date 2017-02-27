package com.omazing.company;
/**
 * 기업회원의 개인회원 조회 VO 
 * @author yeeun
 *
 */
public class SearchMemberVO {
	/**
	 * 개인회원 아이디 
	 */
	private String member_id;
	/**
	 * 개인회원 이름 
	 */
	private String name;
	/**
	 * 개인회원 이메일 
	 */
	private String email;
	/**
	 * 보유기술명 
	 */
	private String skillName;
	/**
	 * 보유기술 숙련도 
	 */
	private String rank;
	
	/**
	 * 디폴트 생성자 
	 */
	public SearchMemberVO() {
		super();
	}
	/**
	 * 오버로디드 생성자 
	 * @param member_id 개인회원 아이디 
	 * @param name 개인회원 이름 
	 * @param email 개인회원 이메일 
	 */
	public SearchMemberVO(String member_id, String name, String email) {
		super();
		this.member_id = member_id;
		this.name = name;
		this.email = email;
	}
	/**
	 * 오버로디드 생성자 
	 * @param member_id 개인회원 아이디 
	 * @param name 개인회원 이름 
	 * @param email 개인회원 이메일 
	 * @param skillName 보유기술 명 
	 * @param rank 보유기술 숙련도 
	 */
	public SearchMemberVO(String member_id, String name, String email,
			String skillName, String rank) {
		super();
		this.member_id = member_id;
		this.name = name;
		this.email = email;
		this.skillName = skillName;
		this.rank = rank;
	}
	/**
	 * 개인회원 아이디 반환 
	 * @return 개인회원 아이디 
	 */
	public String getMember_id() {
		return member_id;
	}
	/**
	 * 개인회원 아이디 설정 
	 * @param member_id 개인회원 아이디 
	 */
	public void setMember_id(String member_id) {
		this.member_id = member_id;
	}
	/**
	 * 보유기술 명 반환 
	 * @return 보유기술 명 
	 */
	public String getSkillName() {
		return skillName;
	}
	/**
	 * 보유기술 명 설정 
	 * @param skillName 보유기술 명 
	 */
	public void setSkillName(String skillName) {
		this.skillName = skillName;
	}
	/**
	 * 회원 이름 반환 
	 * @return 회원 이름 
	 */
	public String getName() {
		return name;
	}
	/**
	 * 회원 이름 설정 
	 * @param name 회원 이름 
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * 보유기술 숙련도 반환 
	 * @return 보유기술 숙련도 
	 */
	public String getRank() {
		return rank;
	}
	/**
	 * 보유기술 숙련도 설정 
	 * @param rank 보유기술 숙련도 
	 */
	public void setRank(String rank) {
		this.rank = rank;
	}
	/**
	 * 개인회원 이메일 반환 
	 * @return 개인회원 이메일 
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * 개인회원 이메일 설정 
	 * @param email 개인회원 이메일 
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "SearchMemberVO [member_id=" + member_id + ", name=" + name
				+ ", email=" + email + ", skillName=" + skillName + ", rank="
				+ rank + "]";
	}
	
}
