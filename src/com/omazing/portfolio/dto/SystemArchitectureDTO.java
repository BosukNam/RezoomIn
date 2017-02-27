package com.omazing.portfolio.dto;

public class SystemArchitectureDTO {
	private int register_no; 
	private int project_no; 
	private String tier_category;
	private String client;
	private String server;
	private String middle_ware;
	
	public SystemArchitectureDTO() {
		super();
	}
	public SystemArchitectureDTO(int register_no, int project_no,
			String tier_category, String client, String server,
			String middle_ware) {
		super();
		this.register_no = register_no;
		this.project_no = project_no;
		this.tier_category = tier_category;
		this.client = client;
		this.server = server;
		this.middle_ware = middle_ware;
	}
	
	public int getRegister_no() {
		return register_no;
	}
	public void setRegister_no(int register_no) {
		this.register_no = register_no;
	}
	public int getProject_no() {
		return project_no;
	}
	public void setProject_no(int project_no) {
		this.project_no = project_no;
	}
	public String getTier_category() {
		return tier_category;
	}
	public void setTier_category(String tier_category) {
		this.tier_category = tier_category;
	}
	public String getClient() {
		return client;
	}
	public void setClient(String client) {
		this.client = client;
	}
	public String getServer() {
		return server;
	}
	public void setServer(String server) {
		this.server = server;
	}
	public String getMiddle_ware() {
		return middle_ware;
	}
	public void setMiddle_ware(String middle_ware) {
		this.middle_ware = middle_ware;
	}
	
	public String[] getAll(){
		return new String[]{this.register_no+"", this.project_no+"", this.client, this.server, this.middle_ware};
	}
}
