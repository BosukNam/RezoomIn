package com.omazing.portfolio.dto;

import java.io.Serializable;

public class ProgrammingSkillDTO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String memberID;
	private int register_no;
	private String name;
	private String rank;
	private String type;
	private String field;
	
	public ProgrammingSkillDTO() {
		super();
	}
	public ProgrammingSkillDTO(String memberID, int register_no, String name,
			String rank, String type, String field) {
		super();
		this.memberID = memberID;
		this.register_no = register_no;
		this.name = name;
		this.rank = rank;
		this.type = type;
		this.field = field;
	}
	public String getMemberID() {
		return memberID;
	}




	public void setMemberID(String memberID) {
		this.memberID = memberID;
	}




	public int getRegister_no() {
		return register_no;
	}




	public void setRegister_no(int register_no) {
		this.register_no = register_no;
	}




	public String getName() {
		return name;
	}




	public void setName(String name) {
		this.name = name;
	}




	public String getRank() {
		return rank;
	}




	public void setRank(String rank) {
		this.rank = rank;
	}




	public String getType() {
		return type;
	}




	public void setType(String type) {
		this.type = type;
	}




	public String getField() {
		return field;
	}




	public void setField(String field) {
		this.field = field;
	}




	public static long getSerialversionuid() {
		return serialVersionUID;
	}




	public String[] getAll(){
		return new String[]{memberID, ""+register_no, name, rank, type, field};
	}
	@Override
	public String toString() {
		return "ProgrammingSkillDTO [memberID=" + memberID + ", register_no="
				+ register_no + ", name=" + name + ", rank=" + rank + ", type="
				+ type + ", field=" + field + "]";
	}
	
	

}
