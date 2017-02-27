package com.omazing.portfolio.dto;

public class TierCategoryDTO {
	private String tier_code;
	private String tier_name;
	public TierCategoryDTO() {
		super();
	}
	public TierCategoryDTO(String tier_code, String tier_name) {
		super();
		this.tier_code = tier_code;
		this.tier_name = tier_name;
	}
	public String getTier_code() {
		return tier_code;
	}
	public void setTier_code(String tier_code) {
		this.tier_code = tier_code;
	}
	public String getTier_name() {
		return tier_name;
	}
	public void setTier_name(String tier_name) {
		this.tier_name = tier_name;
	}
	@Override
	public String toString() {
		return "TierCategoryDTO [tier_code=" + tier_code + ", tier_name="
				+ tier_name + "]";
	}
	public String[] getAll(){
		return new String[]{this.tier_code, this.tier_name};
	}
	
}
