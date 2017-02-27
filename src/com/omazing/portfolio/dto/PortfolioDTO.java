package com.omazing.portfolio.dto;

public class PortfolioDTO {
	private int register_no;
	private String member_id;
	private String name;
	private String skill_rank_name;
	private String programming_type_name;
	private String field;
	private String skill_name_image;
	
	 
	
	public PortfolioDTO() {
		super();
	}

	public PortfolioDTO(int register_no, String member_id, String name,
			String skill_rank_name, String programming_type_name, String field,
			String skill_name_image) {
		super();
		this.register_no = register_no;
		this.member_id = member_id;
		this.name = name;
		this.skill_rank_name = skill_rank_name;
		this.programming_type_name = programming_type_name;
		this.field = field;
		this.skill_name_image = skill_name_image;
	}
	
	public int getRegister_no() {
		return register_no;
	}
	public void setRegister_no(int register_no) {
		this.register_no = register_no;
	}
	public String getMember_id() {
		return member_id;
	}
	public void setMember_id(String member_id) {
		this.member_id = member_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSkill_rank_name() {
		return skill_rank_name;
	}
	public void setSkill_rank_name(String skill_rank_name) {
		this.skill_rank_name = skill_rank_name;
	}
	public String getProgramming_type_name() {
		return programming_type_name;
	}
	public void setProgramming_type_name(String programming_type_name) {
		this.programming_type_name = programming_type_name;
	}
	public String getField() {
		return field;
	}
	public void setField(String field) {
		this.field = field;
	}
	public String getSkill_name_image() {
		return skill_name_image;
	}
	public void setSkill_name_image(String skill_name_image) {
		this.skill_name_image = skill_name_image;
	}

	public String[] getAll(){
		return new String[]{String.valueOf(register_no),member_id, name, skill_rank_name, programming_type_name, field, skill_name_image};
	}
}
