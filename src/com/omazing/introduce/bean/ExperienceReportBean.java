package com.omazing.introduce.bean;

/**
 * 극복과정 Bean
 * @author nam
 */
public class ExperienceReportBean {
	/**
	 * 등록번호
	 */
	private String registerNo;
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
	public ExperienceReportBean() {
		super();
	}
	/**
	 * 오버로딩 생성자
	 * @param registerNo 등록번호
	 * @param title 문제 및 난관
	 * @param content 극복과정
	 */
	public ExperienceReportBean(String registerNo, String title, String content) {
		super();
		this.registerNo = registerNo;
		this.title = title;
		this.content = content;
	}
	/**
	 * 등록번호를 가져오는 메소드
	 * @return registerNo
	 */
	public String getRegisterNo() {
		return registerNo;
	}
	/**
	 * 등록번호를 설정하는 메소드
	 * @param registerNo 등록번호
	 */
	public void setRegisterNo(String registerNo) {
		this.registerNo = registerNo;
	}
	/**
	 * 문제 및 난관을 가져오는 메소드
	 * @return title
	 */
	public String getTitle() {
		return title;
	}
	/**
	 * 문제 및 난관을 설정하는 메소드
	 * @param title 문제 및 난관
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	/**
	 * 극복과정을 가져오는 메소드
	 * @return content
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
	 * @return 순서: 등록번호,문제및난관,극복과정
	 */
	public String[] getAll(){
		return new String[]{registerNo,title,content};
	}
	/**
	 * toString메소드 재정의
	 */
	@Override
	public String toString() {
		return "ExperienceReportBean [registerNo=" + registerNo + ", title=" + title + ", content=" + content + "]";
	}
	
}
