package com.omazing.introduce.bean;

/**
 * 자기소개서 미리보기 Bean
 * @author nam
 */
public class PreviewPersonalReportBean {
	/**
	 * 성장과정 Bean
	 */
	private PersonalBiographyBean personalBiographyBean;
	/**
	 * 성장과정의 취미특기 Bean
	 */
	private PersonalSpecialtyBean personalSpecialtyBean;
	/**
	 * 장점,준비과정,비전및목표 Bean
	 */
	private PersonalReportBean personalReportBean;
	/**
	 * 극복과정 Bean
	 */
	private ExperienceReportBean experienceReportBean;
	
	/**
	 * 기본 생성자
	 */
	public PreviewPersonalReportBean() {
		super();
	}
	/**
	 * 오버로딩 생성자
	 * @param personalHistoryBean 성장과정 Bean
	 * @param personalSpecialtyBean 성장과정의 취미특기 Bean
	 * @param personalReportBean 장점,준비과정,비전및목표 Bean
	 * @param experienceReportBean 극복과정 Bean
	 */
	public PreviewPersonalReportBean(PersonalBiographyBean personalHistoryBean,
			PersonalSpecialtyBean personalSpecialtyBean, PersonalReportBean personalReportBean,
			ExperienceReportBean experienceReportBean) {
		super();
		this.personalBiographyBean = personalHistoryBean;
		this.personalSpecialtyBean = personalSpecialtyBean;
		this.personalReportBean = personalReportBean;
		this.experienceReportBean = experienceReportBean;
	}
	/**
	 * 성장과정을 가져오는 메소드
	 * @return personalBiographyBean
	 */
	public PersonalBiographyBean getPersonalHistoryBean() {
		return personalBiographyBean;
	}
	/**
	 * 성장과정을 설정하는 메소드
	 * @param personalHistoryBean 성장과정
	 */
	public void setPersonalHistoryBean(PersonalBiographyBean personalHistoryBean) {
		this.personalBiographyBean = personalHistoryBean;
	}
	/**
	 * 성장과정의 취미특기를 가져오는 메소드
	 * @return personalSpecialtyBean
	 */
	public PersonalSpecialtyBean getPersonalSpecialtyBean() {
		return personalSpecialtyBean;
	}
	/**
	 * 성장과정의 취미특기를 설정하는 메소드
	 * @param personalSpecialtyBean 성장과정의 취미특기
	 */
	public void setPersonalSpecialtyBean(PersonalSpecialtyBean personalSpecialtyBean) {
		this.personalSpecialtyBean = personalSpecialtyBean;
	}
	/**
	 * 장점,준비과정,비전및목표를 가져오는 메소드
	 * @return personalReportBean
	 */
	public PersonalReportBean getSelfReportBean() {
		return personalReportBean;
	}
	/**
	 * 장점,준비과정,비전및목표를 설정하는 메소드
	 * @param personalReportBean 장점,준비과정,비전및목표를
	 */
	public void setSelfReportBean(PersonalReportBean personalReportBean) {
		this.personalReportBean = personalReportBean;
	}
	/**
	 * 극복과정을 가져오는 메소드
	 * @return experienceReportBean
	 */
	public ExperienceReportBean getExperienceReportBean() {
		return experienceReportBean;
	}
	/**
	 * 극복과정을 설정하는 메소드
	 * @param experienceReportBean 극복과정
	 */
	public void setExperienceReportBean(ExperienceReportBean experienceReportBean) {
		this.experienceReportBean = experienceReportBean;
	}
	/**
	 * toString메소드 재정의
	 */
	@Override
	public String toString() {
		return "PreviewPersonalReportBean [personalBiographyBean=" + personalBiographyBean + ", personalSpecialtyBean="
				+ personalSpecialtyBean + ", personalReportBean=" + personalReportBean + ", experienceReportBean="
				+ experienceReportBean + "]";
	}
}
