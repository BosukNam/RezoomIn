package com.omazing.portfolio.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.omazing.portfolio.bean.ProjectDateBean;
import com.omazing.portfolio.dto.ChartDTO;
import com.omazing.portfolio.dto.LibraryDTO;
import com.omazing.portfolio.dto.ProgramContentCategoryDTO;
import com.omazing.portfolio.dto.ProgramContentDTO;
import com.omazing.portfolio.dto.ProjectInfoDTO;
import com.omazing.portfolio.dto.RoleAndTaskDTO;
import com.omazing.portfolio.dto.SoftwareArchitectureDTO;
import com.omazing.portfolio.dto.SystemArchitectureDTO;
import com.omazing.portfolio.dto.UseSkillDTO;

@Repository
public class ProjectInfoDAO{
	
	@Autowired
	private SqlSession session;
	
	
	//insert
	public boolean insertProjectInfo(String memberId, String name){
		if(memberId != null){
			ProjectInfoDTO piDTO=new ProjectInfoDTO();
			piDTO.setMemberId(memberId);
			if(name!=null){
				piDTO.setName(name);
			}
			return insertProjectInfo(piDTO);
		}
		return false;
	}
	public boolean insertProjectInfo(ProjectInfoDTO piDTO){
		int num=session.insert("PortfolioProjectMapper.insertProgramContent",piDTO);
		if(num!=0)
			return true;
		return false;
	}
	public boolean insertRoleAndTask(RoleAndTaskDTO roleAndTask){
		int num = session.insert("PortfolioProjectMapper.insertRoleAndTask", roleAndTask);
		System.out.println(num);
		if(num!=0)
			return true;
		return false;
	}
	public int insertLibrary(LibraryDTO libraryDTO){
		
		return 0;
	}
	public boolean insertProgramContent(ProgramContentDTO pc, ChartDTO chartDTO){

		return false;
	}
	public boolean insertProgramContent(ProgramContentDTO pc){
		int num=session.insert("PortfolioProjectMapper.insertProgramContent", pc);
		System.out.println(num);
		if(num!=0)
			return true;
		return false;
	}
	public boolean insertChart(ChartDTO chart){
		int num=session.insert("PortfolioProjectMapper.insertChart", chart);
		System.out.println(num);
		if(num!=0)
			return true;
		return false;
	}
	public boolean insertUseSkill(UseSkillDTO dto){
		return false;
		
	}
	public boolean insertSystemArchitecture(SystemArchitectureDTO dto){
		return false;
	}
	public boolean insertSoftwareArchitecture(SoftwareArchitectureDTO dto){

		return false;
	}
	
	
	
	
	//delete
	public boolean deleteProjectInfoByRegisterNo(int registerNo){
		
		return false;
	}
	public boolean deleteProjectInfoByMemberId(String memberId){
		
		return false;
	}

	public boolean deleteProgramContentByRegisterNo(int registerNo){
		int num=session.delete("PortfolioProjectMapper.deleteProgramContentByRegisterNo",registerNo);
		System.out.println(num);
		if(num!=0)
			return true;
		return false;
	}
	public boolean deleteProgramContentByProjectNo(int projectNo){
		int num=session.delete("PortfolioProjectMapper.deleteProgramContentByProjectNo",projectNo);
		if(num!=0)
			return true;
		return false;
	}
	public boolean deleteDevelopTool(int projectNo){
		return false;
	}
	public boolean deleteDevelopTool(int projectNo, int registerNo){
		return false;
	}
	public boolean deleteRolaAndTaskByProjectNo(int projectNo){
		int num=session.delete("PortfolioProjectMapper.deleteRoleAndTaskByProjectNo",projectNo);
		if(num != 0)
			return true;
		return false;
	}
	public boolean deleteRoleAndtaskByRegisterNo(int registerNo){
		int num=session.delete("PortfolioProjectMapper.deleteRoleAndTaskByRegisterNo",registerNo);
		if(num != 0)
			return true;
		return false;
	}
	public boolean deleteLibraryByRegisterNo(int registerNo){
		int num=session.delete("PortfolioProjectMapper.deletLibraryByRegisterNo",registerNo);
		if(num!=0)
			return true;
		return false;
	}
	public boolean deleteUseTechLanguage(int projectNo){

		return false;
	}
	public boolean deleteUseTechLanguage(int projectNo, int registerNo){
	
		return false;
	}
	public boolean deleteLibrary(int projectNo){

		return false;
	}
	public boolean deleteSystemArchitecture(int projectNo){

		return false;
	}
	public boolean deleteSoftwareArchitecture(int projectNo){

		return false;
	}
	public boolean deleteUserDefineContent(int projectNo, ProgramContentCategoryDTO pcc){

		return false;
	}
	public boolean deleteUserDefineContent(int projectNo, int registerNo){

		return false;
	}
	
	
	
	
	//update - 각각의 객체 업데이트 및 projectInfo 객체 업데이트
	public boolean updateProjectInfo(ProjectInfoDTO piDTO){
		
		return false;
	}
	public boolean updateProgramContentByRegisterNo(ProgramContentDTO pc){
		int num=session.update("PortfolioProjectMapper.updateProgramContent",pc);
		if(num!=0)
	    	return true;
		return false;
	}
	public boolean updateProgramContentNo(int registerNo, int projectNo, String code){
		int num=0;
		Map<String,Integer> map=new HashMap<String, Integer>();
		map.put("register_no", projectNo);
		map.put("program_content_no", registerNo);
		if(code.equals("pc1")){
			num=session.update("PortfolioProjectMapper.updateProjectIntroNo", map);
		} else if(code.equals("pc2")){
			num=session.update("PortfolioProjectMapper.updateUserDefineContentNo",map);
		}
		if(num!=0)
			return true;
		return false;
	}
	public boolean updateProgramImageAndContent(String content, String imagePath, int registerNo){
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("registerNo", registerNo);
		map.put("content",content);
		map.put("programContentImage", imagePath);
		
		int num=session.update("PortfolioProjectMapper.updateProgramImageAndContent",map);
		if(num!=0)
	    	return true;
		return false;
	}
	public boolean updateProjectNameByRegisterNo(int registerNo, String name){
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("register_no", registerNo);
		map.put("name", name);
	    int num=session.update("PortfolioProjectMapper.updateProjectName",map);
	    if(num!=0)
	    	return true;
	    return false;
	}
/*	public boolean updateProjectIntroByRegisterNo(int registerNo, int projectNo){
		Map<String, Integer> map=new HashMap<String, Integer>();
		map.put("project_intro_no", registerNo);
		map.put("register_no", projectNo);
	    int num=session.update("PortfolioProjectMapper.updateProjectIntroNo",map);
	    if(num!=0)
	    	return true;
	    return false;
	}*/
	public boolean updateProjectDateByRegisterNo(int registerNo, String startDate, String endDate){
	    Map<String, Object> map=new HashMap<String, Object>();
	    map.put("start_date", startDate);
	    map.put("end_date", endDate);
	    map.put("register_no", registerNo);
	    int num= session.update("PortfolioProjectMapper.updateProjectDate", map);
	    if(num!=0)
	    	return true;
	    return false;
	}
	public boolean updatePeopleNoByRegisterNo(int registerNo, int peopleNo){
		Map<String, Integer> map=new HashMap<String, Integer>();
		map.put("people_no", peopleNo);
		map.put("register_no", registerNo);
	    int num=session.update("PortfolioProjectMapper.updateProjectPoepleNo",map);
	    if(num!=0)
	    	return true;
	    return false;
	}
	public boolean updateDevelopToolNo(int registerNo, int projectNo){
		return false;
	}
	public boolean updateDevelopToolByRegisterNo(int registerNo, int projectNo){
		
		return false;
	}
	public boolean updateRoleAndTaskNo(int registerNo, int projectNo){
		Map<String, Integer> map=new HashMap<String, Integer>();
		map.put("role_and_task_no", registerNo);
		map.put("register_no", projectNo);
	    int num=session.update("PortfolioProjectMapper.updateRoleAndTaskNo",map);
	    if(num!=0)
	    	return true;
	    return false;
	}
	public boolean updateRoleAndTaskByRegisterNo(RoleAndTaskDTO rat){
	    int num=session.update("PortfolioProjectMapper.updateRoleAndTaskByRegisterNo",rat);
	    if(num!=0)
	    	return true;
	    return false;
	}
/*	public boolean updateUseTechLanguageNo(int registerNo, int projectNo){

		return false;
	}
	public boolean updateUseTechLanguageByRegisterNo(UseSkillDTO useSkill, int projectNo){

		return false;
	}*/
	public boolean updateLibraryNo(int registerNo, int projectNo){
		Map<String, Integer> map=new HashMap<String, Integer>();
		map.put("register_no", registerNo);
		map.put("project_no", projectNo);
		int num=session.update("PortfolioProjectMapper.updateLibraryNo",map);
		return false;
	}
	public boolean updateLibraryByRegisterNo(LibraryDTO library, int projectNo){

		return false;
	}
/*	public boolean updateSystemArchitectureNo(int registerNo, int projectNo){
		return false;
	}
	public boolean updateSystemArchitectureByRegisterNo(SystemArchitectureDTO saDTO, int projectNo){
	   return false;
	}
	public boolean updateSoftwareArchitectureNo(int registerNo, int projectNo){

	   return false;
	}
	public boolean updateSoftwareArchitectureByRegiserNo(SoftwareArchitectureDTO saDTO, int projectNo){
	   return false;
	}
	*/
	
	
	//select
	public ProjectInfoDTO selectProjectInfo(int registerNo){
		ProjectInfoDTO projectInfo=session.selectOne("PortfolioProjectMapper.selectProjectInfoByRegisterNo", registerNo);
		return projectInfo;
	}
	public Map<Integer, ProjectInfoDTO> selectProjectInfo(String memberId){
		Map<Integer, ProjectInfoDTO> map=session.selectMap("PortfolioProjectMapper.selectProjectInfoByMemberId", memberId, "registerNo");
		return map;
	}
	public int selectPeopleNoByRegisterNo(int registerNo){
		Integer peopleNo=session.selectOne("PortfolioProjectMapper.selectProjectPeopleNo", registerNo);
/*		if(peopleNo==null){
			throw new Exception("프로젝트 정보를 가져올 수 없습니다!");
		}*/
		return peopleNo.intValue();
	}
	public String[] selectProjectDateByRegisterNo(int registerNo){
		List<ProjectDateBean> list=session.selectList("PortfolioProjectMapper.selectProjectDate",registerNo);
		if(list!=null&&!list.isEmpty()){
			ProjectDateBean date=list.get(0); 
			return new String[]{date.getStartDate(), date.getEndDate()};
		}
		return null;
	}
	
	public RoleAndTaskDTO selectRoleAndDateByProjectNo(int registerNo){
		//RoleAndTaskDTO rat=session.selectOne("PortfolioProjectMapper.selectRoleAndTaskByRegisterNo", registerNo);
		RoleAndTaskDTO rat=session.selectOne("PortfolioProjectMapper.selectRoleAndTaskByProjectNo", registerNo);
		System.out.println(rat);
		return rat;
	}
	public ProgramContentDTO selectProgramContentByRegisterNo(int registerNo){
		ProgramContentDTO pc=session.selectOne("PortfolioProjectMapper.selectProgramContentByRegisterNo",registerNo);
		System.out.println(pc);
		return pc;
	}
	public Map<Integer, ProgramContentDTO> selectProgramContentByProjectNo(int projectNo){
		Map<Integer, ProgramContentDTO> pcMap = session.selectMap("PortfolioProjectMapper.selectProgramContentByProjectNo", projectNo, "register_no");
		if(pcMap!=null){
			System.out.println("notNull");
		}
		return pcMap;
	}
	public Map<Integer, ProgramContentDTO> selectProgramContentByProjectNo(int projectNo, ProgramContentCategoryDTO pcc){
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("project_no", projectNo);
		map.put("category", pcc.getCode());
		
		Map<Integer, ProgramContentDTO> pcMap = session.selectMap("PortfolioProjectMapper.selectProgramContentByCategory", map, "registerNo");
		if(pcMap!=null){
			System.out.println("notNull!!");
			System.out.println(pcMap.get(7));
		}
		return pcMap;
	}
	public ChartDTO selectChartByProgramContentNo(int programContentNo){
		ChartDTO chart=session.selectOne("PortfolioProjectMapper.selectChartByProgramContentNo", programContentNo);
		System.out.println(chart.toString());
		return chart;
	}
	public LibraryDTO selectLibraryByProjectNo(int projectNo){
		LibraryDTO library=session.selectOne("", projectNo);
		return library;
	}
	public LibraryDTO selectLibraryByRegisterNo(int registerNo){
		LibraryDTO library=session.selectOne("", registerNo);
		return library;
	}
	public int selectLatestRegisterNoOfProgramContent(int projectNo, String category){
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("project_no", projectNo);
		map.put("category", category);
		
		List<Integer> nums=session.selectList("PortfolioProjectMapper.selectLatestRegisterNoOfProgramContent", map);
		if(nums!=null && !nums.isEmpty()){
			System.out.println(nums.get(0));
			return nums.get(0);
		}
		return 0;
	}
	public int selectLatestRegisterNoOfRoleAndTask(int projectNo){
		List<Integer> nums=session.selectList("PortfolioProjectMapper.selectLatestRegisterNoOfRoleAndTask",projectNo);		
		if(nums!=null && !nums.isEmpty()){
			System.out.println(nums.get(0));
			return nums.get(0);
		}
		return 0;
	}
	public int selectLatestRegisterNoOfChart(int programContent){
		List<Integer> nums=session.selectOne("PortfolioProjectMapper.selectLatestRegisterNoOfChart",programContent);
		if(nums!=null && !nums.isEmpty()){
			System.out.println(nums.get(0));
			return nums.get(0);
		}
		return 0;
	}
	public int selectLatestRegisterNoOfLibrary(int projectNo){
		int num=session.selectOne("PortfolioProjectMapper.selectLatestRegisterNoOfLibrary",projectNo);
		return num;
	}
	public int selectLatestRegisterNo(String memberId) {
		return 0;
	}
	
	
}
