package com.omazing.portfolio.dto;

import java.io.Serializable;

/**
 * 라이브러리 DTO 객체
 * @author YJ
 *
 */
public class LibraryDTO implements Serializable{
	/**
	 * 라이브러리 등록 번호
	 */
	private int registerNo;
/*	private String memberID;*/
	/**
	 * 라이브러리를 등록할 프로젝트 번호
	 */
	private int projectNo;
	/**
	 * 라이브러리에 등록할 이미지 파일 경로
	 */
	private String libraryImage;
	/**
	 * 라이브러리 내용 
	 */
	private String content;
	/**
	 * Spring mybatis의 DI를 위한 default 생성자
	 */
	public LibraryDTO() {
	}
	
	
	public LibraryDTO(int registerNo, int projectNo, String libraryImage,
			String content) {
		super();
		this.registerNo = registerNo;
		/*this.memberID = memberID;*/
		this.projectNo=projectNo;
		this.libraryImage = libraryImage;
		this.content = content;
	}

	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getLibraryImage() {
		return libraryImage;
	}

	public void setLibraryImage(String libraryImage) {
		this.libraryImage = libraryImage;
	}

	public int getProjectNo() {
		return projectNo;
	}

	public void setProjectNo(int projectNo) {
		this.projectNo = projectNo;
	}
	public int getRegisterNo() {
		return registerNo;
	}
	public void setRegisterNo(int registerNo) {
		this.registerNo = registerNo;
	}
	public String[] getAll(){
		return new String[]{String.valueOf(registerNo), String.valueOf(projectNo), libraryImage, content};
	}
	@Override
	public String toString() {
		return "LibraryDTO [registerNo=" + registerNo + ", projectNo="
				+ projectNo + ", picture=" + libraryImage + ", content=" + content
				+ "]";
	}
}
