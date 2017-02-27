package com.omazing.introduce.bean;

/**
 * 성장과정 Bean
 * @author nam
 */
public class PersonalBiographyBean {
	/**
	 * 유년기
	 */
	private String childhood;
	/**
	 * 청소년기
	 */
	private String student;
	/**
	 * 대학생활
	 */
	private String univ;
	/**
	 * 회사생활
	 */
	private String company;
	/**
	 * 대표키워드
	 */
	private String keyword;
	
	/**
	 * 기본생성자
	 */
	public PersonalBiographyBean() {
		super();
	}

	/**
	 * 오버로딩 생성자
	 * @param childhood 유년기
	 * @param student 청소년기
	 * @param univ 대학생활
	 * @param company 회사생활
	 * @param keyword 대표키워드
	 */
	public PersonalBiographyBean(String childhood, String student, String univ, String company,
			String keyword) {
		super();
		this.childhood = childhood;
		this.student = student;
		this.univ = univ;
		this.company = company;
		this.keyword = keyword;
	}

	/**
	 * 유년기를 가져오는 메소드
	 * @return childhood
	 */
	public String getChildhood() {
		return childhood;
	}

	/**
	 * 유년기를 설정하는 메소드
	 * @param childhood 유년기
	 */
	public void setChildhood(String childhood) {
		this.childhood = childhood;
	}

	/**
	 * 청소년기를 가져오는 메소드
	 * @return student
	 */
	public String getStudent() {
		return student;
	}

	/**
	 * 청소년기를 설정하는 메소드
	 * @param student 청소년기
	 */
	public void setStudent(String student) {
		this.student = student;
	}

	/**
	 * 대학생활을 가져오는 메소드
	 * @return univ
	 */
	public String getUniv() {
		return univ;
	}

	/**
	 * 대학생활을 설정하는 메소드
	 * @param univ 대학생활
	 */
	public void setUniv(String univ) {
		this.univ = univ;
	}

	/**
	 * 회사생활을 가져오는 메소드
	 * @return company
	 */
	public String getCompany() {
		return company;
	}

	/**
	 * 회사생활을 설정하는 메소드
	 * @param company 회사생활
	 */
	public void setCompany(String company) {
		this.company = company;
	}

	/**
	 * 대표키워드를 가져오는 메소드
	 * @return keyword
	 */
	public String getKeyword() {
		return keyword;
	}

	/**
	 * 대표키워드를 설정하는 메소드
	 * @param keyword 대표키워드
	 */
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	
	/**
	 * 저장된 모든 정보값을 가져오는 메소드
	 * @return 순서: 유년기,청소년기,대학생활,회사생활,대표키워드
	 */
	public String[] getAll(){
		return new String[]{childhood,student,univ,company,keyword};
	}
	/**
	 * toString메소드 재정의
	 */
	@Override
	public String toString() {
		return "PersonalHistoryBean [childhood=" + childhood + ", student=" + student + ", univ=" + univ + ", company="
				+ company + ", keyword=" + keyword + "]";
	}

	
}
