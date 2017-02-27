package com.omazing.introduce.dto;

/**
 * 극복과정 DTO
 * @author nam
 */
public class ExperienceReportDTO {
	/**
	 * 회원ID
	 */
	private String member_id;
	/**
	 * 등록번호
	 */
	private int register_no;
	/**
	 * 문제및난관
	 */
	private String title;
	/**
	 * 극복과정
	 */
	private String content;
	/**
	 * 기본생성자
	 */
	public ExperienceReportDTO() {
		super();
	}
	/**
	 * 오버로딩 생성자
	 * @param memberID 회원ID
	 * @param registerNo 등록번호
	 * @param title 문제및난관
	 * @param content 극복과정
	 */
	public ExperienceReportDTO(String memberID, int registerNo, String title, String content) {
		super();
		this.member_id = memberID;
		this.register_no = registerNo;
		this.title = title;
		this.content = content;
	}
	/**
	 * 오버로딩 생성자
	 * @param memberID 회원ID
	 * @param title 문제및난관
	 * @param content 극복과정
	 */
	public ExperienceReportDTO(String memberID, String title, String content) {
		this(memberID,0,title,content);
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
	 * 등록번호를 가져오는 메소드
	 * @return 등록번호
	 */
	public int getRegisterNo() {
		return register_no;
	}
	/**
	 * 등록번호를 설정하는 메소드
	 * @param registerNo 등록번호
	 */
	public void setRegisterNo(int registerNo) {
		this.register_no = registerNo;
	}
	/**
	 * 문제및난관을 가져오는 메소드
	 * @return 문제및난관
	 */
	public String getTitle() {
		return title;
	}
	/**
	 * 문제및난관을 설정하는 메소드
	 * @param title 문제및난관
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	/**
	 * 극복과정을 가져오는 메소드
	 * @return 극복과정
	 */
	public String getContent() {
		return content;
	}
	/**
	 * 극복과정을 설정하는 메소드
	 * @param content 극복과정
	 */
	public void setContent(String content) {
		this.content = content;
	}
	/**
	 * 저장된 모든 정보값을 가져오는 메소드
	 * @return 순서: 회원ID,등록번호,문제및난관,극복과정
	 */
	public String[] getAll(){
		return new String[]{member_id,new Integer(register_no).toString(),title,content};
	}
	/**
	 * toString메소드 재정의
	 */
	@Override
	public String toString() {
		return "ExperienceReportDTO [memberID=" + member_id + ", registerNo=" + register_no + ", title=" + title + ", content="
				+ content + "]";
	}
}
