package com.omazing.introduce.model;

/**
 * 극복과정 VO
 * @author nam
 */
public class ExperienceReportVO {
	/**
	 * 회원ID
	 */
	private String memberID;
	/**
	 * 등록번호
	 */
	private int registerNo;
	/**
	 * 문제 및 난관
	 */
	private String title;
	/**
	 * 극복과정
	 */
	private String content;
	/**
	 * 기본생성자
	 */
	public ExperienceReportVO() {
		super();
	}
	/**
	 * 오버로딩 생성자
	 * @param memberID 회원ID
	 * @param registerNo 등록번호
	 * @param title 문제 및 난관
	 * @param content 극복과정
	 */
	public ExperienceReportVO(String memberID, int registerNo, String title, String content) {
		super();
		this.memberID = memberID;
		this.registerNo = registerNo;
		this.title = title;
		this.content = content;
	}
	/**
	 * 오버로딩 생성자
	 * @param memberID 회원ID
	 * @param title 문제 및 난관
	 * @param content 극복과정
	 */
	public ExperienceReportVO(String memberID, String title, String content) {
		this(memberID,0,title,content);
	}
	/**
	 * 회원ID를 가져오는 메소드
	 * @return 회원ID
	 */
	public String getMemberID() {
		return memberID;
	}
	/**
	 * 회원ID를 설정하는 메소드
	 * @param memberID 회원ID
	 */
	public void setMemberID(String memberID) {
		this.memberID = memberID;
	}
	/**
	 * 등록번호를 가져오는 메소드
	 * @return 등록번호
	 */
	public int getRegisterNo() {
		return registerNo;
	}
	/**
	 * 등록번호를 설정하는 메소드
	 * @param registerNo 등록번호
	 */
	public void setRegisterNo(int registerNo) {
		this.registerNo = registerNo;
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
		return new String[]{memberID,new Integer(registerNo).toString(),title,content};
	}
	/**
	 * toString메소드 재정의
	 */
	@Override
	public String toString() {
		return "ExperienceReportVO [memberID=" + memberID + ", registerNo=" + registerNo + ", title=" + title + ", content="
				+ content + "]";
	}
}
