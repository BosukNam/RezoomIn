package com.omazing.portfolio.dto;

public class SoftwareArchitectureDTO {
	private int register_no; 
	private int project_no; 
	private String usecase_file;
	private int usecase_count;
	private String diagram_image ;
	
	
	public SoftwareArchitectureDTO() {
		super();
	}

	public SoftwareArchitectureDTO(int register_no, int project_no,
			String usecase_file, int usecase_count, String diagram_image) {
		super();
		this.register_no = register_no;
		this.project_no = project_no;
		this.usecase_file = usecase_file;
		this.usecase_count = usecase_count;
		this.diagram_image = diagram_image;
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

	public String getUsecase_file() {
		return usecase_file;
	}

	public void setUsecase_file(String usecase_file) {
		this.usecase_file = usecase_file;
	}

	public int getUsecase_count() {
		return usecase_count;
	}

	public void setUsecase_count(int usecase_count) {
		this.usecase_count = usecase_count;
	}

	public String getDiagram_image() {
		return diagram_image;
	}

	public void setDiagram_image(String diagram_image) {
		this.diagram_image = diagram_image;
	}

	
	@Override
	public String toString() {
		return "SoftwareArchitectureDTO [register_no=" + register_no
				+ ", project_no=" + project_no + ", usecase_file="
				+ usecase_file + ", usecase_count=" + usecase_count
				+ ", diagram_image=" + diagram_image + "]";
	}

	public String[] getAll(){
		return new String[]{this.register_no+"", this.project_no+"", this.usecase_file, this.usecase_count+"", this.diagram_image};
	}
	
}
