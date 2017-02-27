package com.omazing.resume.dto;

import java.io.Serializable;
/**
 * 수상 분야 DTO
 * @author Jun Seop
 *
 */
public class AwardFieldDTO implements Serializable {
	/**
	 * 수상 분야 코드
	 */
	private String fieldCode;
	/**
	 * 수상 분야
	 */
	private String field;
	/**
	 * 수상 분류 코드
	 */
	private String categoryCode;
	/**
	 * 기본 생성자
	 */
	public AwardFieldDTO() {
		super();
	}
	/**
	 * 오버로딩 생성자
	 * @param fieldCode (수상 분야 코드)
	 * @param field(수상 분야)
	 * @param categoryCode(수상 분류 코드)
	 */
	public AwardFieldDTO(String fieldCode, String field, String categoryCode) {
		super();
		this.fieldCode = fieldCode;
		this.field = field;
		this.categoryCode = categoryCode;
	}
	/**
	 * 수상 분야 코드 get메서드
	 * @return fieldCode(수상 분야 코드)
	 */
	public String getFieldCode() {
		return fieldCode;
	}
	/**
	 * 수상 분야 코드 set메서드
	 * @param fieldCode(수상 분야 코드)
	 */
	public void setFieldCode(String fieldCode) {
		this.fieldCode = fieldCode;
	}
	/**
	 * 수상 분야 get메서드
	 * @return field(수상 분야)
	 */
	public String getField() {
		return field;
	}
	/**
	 * 수상 분야 set메서드
	 * @param field(수상 분야)
	 */
	public void setField(String field) {
		this.field = field;
	}
	/**
	 * 수상 분류 코드 get메서드
	 * @return categoryCode(수상 분류)
	 */
	public String getCategoryCode() {
		return categoryCode;
	}
	/**
	 * 수상 분류 코드 set메서드
	 * @param categoryCode(수상 분류)
	 */
	public void setCategoryCode(String categoryCode) {
		this.categoryCode = categoryCode;
	}
	/**
	 * AwardFieldDTO toString 메서드
	 */
	@Override
	public String toString() {
		return "AwardFieldBean [fieldCode=" + fieldCode + ", field=" + field
				+ ", categoryCode=" + categoryCode + "]";
	}
	/**
	 * AwardFieldDTO 필드 String[] 형태로 리턴하는 메서드
	 * @return String[] 형태로 필드 내용 리턴
	 */
	public String[] getAll(){
		return new String[]{this.fieldCode, this.field, this.categoryCode};
	}
}
