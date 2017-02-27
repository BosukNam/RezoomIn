package com.omazing.portfolio.dto;

public class SkillRankDTO {
	private String skill_rank_code;
	private String skill_rank_name;
	public SkillRankDTO(String skill_rank_code, String skill_rank_name) {
		super();
		this.skill_rank_code = skill_rank_code;
		this.skill_rank_name = skill_rank_name;
	}
	public String getSkill_rank_code() {
		return skill_rank_code;
	}
	public void setSkill_rank_code(String skill_rank_code) {
		this.skill_rank_code = skill_rank_code;
	}
	public String getSkill_rank_name() {
		return skill_rank_name;
	}
	public void setSkill_rank_name(String skill_rank_name) {
		this.skill_rank_name = skill_rank_name;
	}
	@Override
	public String toString() {
		return "SkillRankDTO [skill_rank_code=" + skill_rank_code
				+ ", skill_rank_name=" + skill_rank_name + "]";
	}
	
	public String[] getAll(){
		return new String[]{this.skill_rank_code, this.skill_rank_name};
	}
}
