package com.omazing.resume.bean;
/**
 * 학력사항 계열 카테고리 Bean 
 * @author yeeun
 *
 */
public class SchoolTrackCategoryBean {
	/**
	 * 계열 코드
	 */
	private String trackCode;
	/**
	 * 계열
	 */
	private String track;
	
	/**
	 * 디폴트 생성자
	 */
	public SchoolTrackCategoryBean() {
		super();
	}
	/**
	 * 오버로디드 생성자
	 * @param trackCode 계열 코드
	 * @param track 계열
	 */
	public SchoolTrackCategoryBean(String trackCode, String track) {
		super();
		this.trackCode = trackCode;
		this.track = track;
	}
	/**
	 * 계열 코드 반환
	 * @return 계열 코드
	 */
	public String getTrackCode() {
		return trackCode;
	}
	/**
	 * 계열 코드 설정
	 * @param trackCode 계열 코드
	 */
	public void setTrackCode(String trackCode) {
		this.trackCode = trackCode;
	}
	/**
	 * 계열 반환
	 * @return
	 */
	public String getTrack() {
		return track;
	}
	/**
	 * 계열 설정
	 * @param track
	 */
	public void setTrack(String track) {
		this.track = track;
	}
	@Override
	public String toString() {
		return "SchoolTrackCategoryBean [trackCode=" + trackCode + ", track="
				+ track + "]";
	}
	/**
	 * 전체 필드 반환
	 * @return
	 */
	public String[] getAll(){
		return new String[]{ this.trackCode, this.track };
	}
}
