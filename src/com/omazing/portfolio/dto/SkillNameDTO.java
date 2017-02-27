package com.omazing.portfolio.dto;

public class SkillNameDTO {
	private String skill_name_code;
	private String skill_name;
	private String skill_name_image;
	public SkillNameDTO(String skill_name_code, String skill_name,
			String skill_name_image) {
		super();
		this.skill_name_code = skill_name_code;
		this.skill_name = skill_name;
		this.skill_name_image = skill_name_image;
	}
	public String getSkill_name_code() {
		return skill_name_code;
	}
	public void setSkill_name_code(String skill_name_code) {
		this.skill_name_code = skill_name_code;
	}
	public String getSkill_name() {
		return skill_name;
	}
	public void setSkill_name(String skill_name) {
		this.skill_name = skill_name;
	}
	public String getSkill_name_image() {
		return skill_name_image;
	}
	public void setSkill_name_image(String skill_name_image) {
		this.skill_name_image = skill_name_image;
	}
	
	@Override
	public String toString() {
		return "SkillNameDTO [skill_name_code=" + skill_name_code
				+ ", skill_name=" + skill_name + ", skill_name_image="
				+ skill_name_image + "]";
	}
	public String[] getAll(){
		return new String[]{skill_name_code, skill_name, skill_name_image};
	}
}
