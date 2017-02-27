package com.omazing.portfolio.controller;



import java.io.File;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.omazing.portfolio.dao.ChartCategoryDAO;
import com.omazing.portfolio.dao.ChartDAO;
import com.omazing.portfolio.dao.ProgramContentCategoryDAO;
import com.omazing.portfolio.dao.ProgramContentDAO;
import com.omazing.portfolio.dao.ProgrammingSkillDAO;
import com.omazing.portfolio.dao.ProjectInfoDAO;
import com.omazing.portfolio.dao.RoleAndTaskDAO;
import com.omazing.portfolio.dao.SoftwareArchitectureDAO;
import com.omazing.portfolio.dao.SystemArchitectureDAO;
import com.omazing.portfolio.dao.UseSkillDAO;
import com.omazing.portfolio.dto.ChartDTO;
import com.omazing.portfolio.dto.LibraryDTO;
import com.omazing.portfolio.dto.ProgramContentCategoryDTO;
import com.omazing.portfolio.dto.ProgramContentDTO;
import com.omazing.portfolio.dto.ProgrammingSkillDTO;
import com.omazing.portfolio.dto.ProjectInfoDTO;
import com.omazing.portfolio.dto.RoleAndTaskDTO;
import com.omazing.portfolio.dto.SoftwareArchitectureDTO;
import com.omazing.portfolio.dto.SystemArchitectureDTO;
import com.omazing.portfolio.dto.UseSkillDTO;
import com.omazing.portfolio.dto.UsecaseDTO;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.MyFileRenamePolicy;


/**
 * 
 * @author USER
 * 포트폴리오 프로젝트 controller
 */
@Controller
public class PortfolioProjectController {
	@Autowired
	private UseSkillDAO useDAO;
	
	@Autowired
	private SystemArchitectureDAO sysDAO;
	
	@Autowired
	private SoftwareArchitectureDAO softDAO;
	
	@Autowired
	private ProjectInfoDAO dao;
	
/*	@Autowired
	private ChartDAO chartDAO;
	
	@Autowired
	private ProgramContentDAO pcDAO;
	
	@Autowired
	private RoleAndTaskDAO ratDAO;
	
	@Autowired
	private ProgramContentCategoryDAO pccDAO;
	
	@Autowired
	private ChartCategoryDAO ccDAO;*/
	
	@Autowired
	private ProgrammingSkillDAO proDAO;
	
	/**
	 * registerNo에 해당하는 programContent 삭제, registerNo를 관리하고 있는 projectInfo 수정
	 * @param registerNo 삭제할 programContent(프로젝트 내용) 등록번호
	 * @param projectNo 삭제할 registerNo를 관리하고 있는 projectInfo 등록번호
	 * @param category programContent에 해당하는 code값
	 * @return 삭제 성공 실패 여부
	 */
	@RequestMapping("/deleteProgramContent.do")
	@ResponseBody
	public String deleteProgramContentByRegisterNo(@RequestParam int registerNo, @RequestParam int projectNo, @RequestParam String category){
		boolean check=dao.deleteProgramContentByRegisterNo(registerNo);
		//projectInfo update
		return String.valueOf(check);
	}
	/**
	 * registerNo에 해당하는 roleAndTask 삭제, registerNo를 관리하고 있는 projectInfo 수정
	 * @param registerNo 삭제할 roleAndTask(주요역할 및 담당) 등록번호
	 * @param projectNo 삭제할 registerNo를 관리하고 있는 projectInfo 등록번호
	 * @return 삭제 성공 실패 여부
	 */
	@RequestMapping("/deleteRoleAndTask.do")
	@ResponseBody
	public String deleteRoleAndTaskByRegisterNo(@RequestParam int registerNo, @RequestParam int projectNo){
		boolean check=dao.deleteRoleAndtaskByRegisterNo(registerNo);
		return String.valueOf(check);
	}
	/**
	 * programcontentNo에 해당하는 chart 삭제, 삭제한 chart의 등록번호를 가지고 있는 programContent 수정
	 * @param programContentNo 삭제할 차트 등록번호를 가지고 있는 programContent(프로그램 내용)등록번호
	 * @return 삭제 성공 실패 여부
	 */
	@RequestMapping("/deleteChart.do")
	@ResponseBody
	public String deleteChartByProgramContentNo(@RequestParam int programContentNo){
		return "";
	}
	/**
	 * registerNo에 해당하는 library삭제, registerNo를 관리하고 있는 projectInfo 수정
	 * @param registerNo 삭제할 library(라이브러리) 등록번호
	 * @param projectNo 삭제할 regisgerNo를 관리하고 있는 projectInfo 등록번호
	 * @return 삭제 성공 실패 여부
	 */
	@RequestMapping("/deleteLibrary.do")
	@ResponseBody
	public String deleteLibraryByRegisterNo(@RequestParam int registerNo, @RequestParam int projectNo){
		boolean check=dao.deleteLibraryByRegisterNo(registerNo);
		return String.valueOf(check);
	}
	/**
	 * registerNo에 해당하는 프로젝트 기간 수정
	 * @param registerNo 수정할 프로젝트 기간을 관리하고 있는 projectInfo 등록번호
	 * @param startDate 수정될 시작날짜
	 * @param endDate 수정될 종료날짜
	 * @return 수정 성공- 수정된 projectInfo 등록번호, 실패 - 0
	 */
	@RequestMapping("/updateDate.do")
	@ResponseBody
	public String updateDateByProjectNo(@RequestParam int registerNo, @RequestParam String startDate, @RequestParam String endDate){
		registerNo=1;
		boolean check=dao.updateProjectDateByRegisterNo(registerNo, startDate, endDate);
		return String.valueOf(check);
	}
	/**
	 * registerNo에 해당하는 프로젝트 참여인원 수정
	 * @param registerNo 수정할 프로젝트 참여 인원을 관리하고 있는 projectInfo 등록번호
	 * @param peopleNo 수정될 참여인원
	 * @return 수정 성공- 수정된 projectInfo 등록번호, 실패 - 0
	 */
	@RequestMapping("/updatePeopleNo.do")
	@ResponseBody
	public String updatePeopleNoByProjectNo(@RequestParam int registerNo, @RequestParam int peopleNo){
		
		boolean check=dao.updatePeopleNoByRegisterNo(registerNo, peopleNo);
		return String.valueOf(check);
		
	}

/*	@RequestMapping("/updateProgramContent.do")
	@ResponseBody
	public String updateProgramContentByRegisterNo(@RequestParam String content, @RequestParam String imagePath,
													@RequestParam int projectNo, @RequestParam int registerNo){


		ProgramContentDTO pc=new ProgramContentDTO(registerNo, projectNo, imagePath, content, chartNo, category);
		boolean check=dao.updateProgramImageAndContent(content, imagePath, registerNo);
		if(check)
			return String.valueOf(registerNo);
		return "0";
		
	}*/
	/**
	 * programContentNo에 해당하는 차트 수정
	 * @param items 수정할 차트 항목
	 * @param datas 수정할 차트 데이턴
	 * @param programContentNo 수정할 차트의 등록번호를 가지고 있는 programContent(프로그램 내용)의 등록번호
	 * @return 수정 성공-수정된 chart를 관리하고 있는 programContent의 등록번호, 실패 - 0
	 */
	@RequestMapping("/updateChart.do")
	@ResponseBody
	public String updateChartByRegisterNo(@RequestParam(value="item") List<String> items,
											@RequestParam(value="data") List<String> datas,
											@RequestParam int programContentNo){
		return "0";
	}
	/**
	 * registerNo에 해당하는 programContent 수정
	 * @param content 수정할 programContent의 내용
	 * @param imagePath 수정할 programContent의 이미지 경로
	 * @param projectNo 수정할 registerNo를 관리하고 있는 projectInfo 등록번호
	 * @param registerNo 수정할 programContent(프로그램 내용) 등록번호
	 * @return 수정 성공- 수정된 projectContent 등록번호, 실패 - 0
	 */
	@RequestMapping("/updateProgramImageAndContent.do")
	@ResponseBody
	public String updateProgramImageAndContent(@RequestParam String content, @RequestParam String imagePath,
												@RequestParam int projectNo, @RequestParam int registerNo){
		boolean check=dao.updateProgramImageAndContent(content, imagePath, registerNo);
		if(check)
			return String.valueOf(registerNo);
		return "0";
	}
	/**
	 * registerNo에 해당하는 roleAndTask 수정
	 * @param role 수정할 주요역할 내용
	 * @param task 수정할 담당업무 내용
	 * @param registerNo 수정할 roleAndTask(주요역할 및 담당) 등록번호
	 * @param projectNo 수정할 registerNo를 관리하고 있는 projectInfo 등록번호
	 * @return 수정 성공- 수정된 programContent 등록번호, 실패 - 0
	 */
	@RequestMapping("/updateRoleAndTask.do")
	@ResponseBody
	public String updateRoleAndTaskByRegisterNo(@RequestParam String role, @RequestParam String task,
												@RequestParam int registerNo, @RequestParam int projectNo){
		boolean check=dao.updateRoleAndTaskByRegisterNo(new RoleAndTaskDTO(registerNo, projectNo, role, task));
		System.out.println(check);
		if(check)
			return String.valueOf(registerNo);
		return "0";
	}
	/**
	 * regsterNo에 해당하는 library 수정
	 * @param content 수정할 library의 내용
	 * @param imagePath 수정할 library의 이미지 경로
	 * @param projectNo 수정할 registerNo를 관리하고 있는 projectInfo 등록번호
	 * @param registerNo 수정할 library(라이브러리) 등록번호
	 * @return 수정 성공- 수정된 library 등록번호, 실패 - 0
	 */
	@RequestMapping("/updateLibrary.do")
	@ResponseBody
	public String updateLibraryByRegisterNo(@RequestParam String content, @RequestParam String imagePath,
											@RequestParam int projectNo, @RequestParam int registerNo){
		boolean check=dao.updateLibraryByRegisterNo(new LibraryDTO(registerNo, projectNo, imagePath, content), projectNo);
		if(check)
			return String.valueOf(registerNo);
		return "0";
	}
	
	/**
	 * programContent 등록
	 * @param category 등록할 programContent의 code
	 * @param content 등록할 programContent의 내용
	 * @param imagePath 등록할 programContent의 이미지 경로
	 * @param registerNo 등록할 programContent의 임의의 등록번호(0번)
	 * @param projectNo programContent를 등록할 project의 등록번호 
	 * @return 등록 성공- 등록한 programContent의 등록번호, 실패- 0
	 */
	@RequestMapping("/insertProgramContent.do")
	@ResponseBody
	public String insertProgramContent(@RequestParam String category, @RequestParam String content,
										@RequestParam String imagePath, @RequestParam int registerNo,
										@RequestParam int projectNo){
		int num=0;
		ProgramContentDTO pc=new ProgramContentDTO(0, projectNo, imagePath, content, 0,new ProgramContentCategoryDTO(category,null));
		boolean check=dao.insertProgramContent(pc);
		if(check){
			num=dao.selectLatestRegisterNoOfProgramContent(projectNo, category);
			if(num!=0){
				dao.updateProgramContentNo(num, projectNo, category);
			}
		}
		return String.valueOf(num);
	}
	/**
	 * roleAndTask 등록
	 * @param projectNo roleAndTask를 등록할 project의 등록번호
	 * @param role 등록할 roleAndTask의 주요역할 내용
	 * @param task 등록할 roleAndTask의 담당업무 내용
	 * @return 등록 성공- 등록한 roleAndTask의 등록번호, 실패- 0
	 */
	@RequestMapping("/insertRoleAndTask.do")
	@ResponseBody
	public String insertRoleAndTask(@RequestParam int projectNo,
									@RequestParam String role,
									@RequestParam String task){
	
		int num=0;
		System.out.println("role:"+role+"   task:" + task);
		boolean check=dao.insertRoleAndTask(new RoleAndTaskDTO(0, projectNo, role, task));
		System.out.println(check);
		if(check){
			num=dao.selectLatestRegisterNoOfRoleAndTask(projectNo);
			if(num!=0){
				dao.updateRoleAndTaskNo(num, projectNo);
			}
		}
		return String.valueOf(num);
	}
	/**
	 * chart 등록
	 * @param items 등록할 chart의 항목들
	 * @param datas 등록할 chart의 데이터들
	 * @param programContentNo chart를 등록할 programContent의 등록번호
	 * @return 등록  성공-등록된 chart의 등록번호를 가지고있는 programContent의 등록번호, 실패- 0
	 */
	@RequestMapping("/insertChart.do")
	@ResponseBody
	public String insertChart(@RequestParam(value="item") List<String> items,
							@RequestParam(value="data") List<String> datas,
							@RequestParam int programContentNo){
		System.out.println(items.toString());
		System.out.println(datas.toString());
		
		return "0";
	}
	/**
	 * library 등록
	 * @param content 등록할 library의 내용
	 * @param imagePath 등록할 library의 이미지 경로
	 * @param registerNo 등록할 library의 임의의 등록번호(0번)
	 * @param projectNo library를 등록할 project의 등록번호
	 * @return 등록 성공-등록된 library의 등록번호, 실패-0
	 */
	@RequestMapping("/insertLibrary.do")
	@ResponseBody
	public String insertLibrary(@RequestParam String content, @RequestParam String imagePath,
								@RequestParam int registerNo, @RequestParam int projectNo){
		
		
		
		return "0";
	}
	/**
	 * registerNo에 해당하는 프로젝트 참여인원 조회
	 * @param registerNo 조회할 project의 등록번호
	 * @return 조회 성공-프로젝트 참여인원, 실패-"ERROR"
	 */
	@RequestMapping("/selectPeopleNo.do")
	@ResponseBody
	public String selectPeopleNo(@RequestParam int registerNo){
		int peopleNo=dao.selectPeopleNoByRegisterNo(registerNo);
		JSONObject obj=new JSONObject();
		obj.put("projectNo", registerNo);
		obj.put("peopleNo", peopleNo);
		
		return obj.toString();
		
	}
	/**
	 * registerNo에 해당하는 프로젝트 기간 조회
	 * @param registerNo 조회할 project의 등록번호
	 * @return 조회 성공-프로젝트 기간을 JSONObject로, 실패-"ERROR"
	 */
	@RequestMapping("/selectProjectDate.do")
	@ResponseBody
	public String selectProjectDate(@RequestParam int registerNo){
		String[] pi=dao.selectProjectDateByRegisterNo(registerNo);
		JSONObject ary=new JSONObject();
		String startDate=pi[0].substring(0, 4)+"년"+pi[0].substring(4,6)+"월"+pi[0].substring(6,8)+"일";
		String endDate=pi[1].substring(0, 4)+"년"+pi[1].substring(4,6)+"월"+pi[1].substring(6,8)+"일";
		ary.put("startDate", startDate);
		ary.put("endDate", endDate);
		System.out.println(ary.toString());
		return ary.toString();
	}
	/**
	 * projectNo에 해당하는 주요 역할 및 담당 조회
	 * @param projectNo 조회할 project의 등록번호
	 * @return 조회 성공-주요 역할 및 담당을 JSONObject로, 실패-"ERROR"
	 */
	@RequestMapping("/selectRoleAndTask.do")
	@ResponseBody
	public String selectRoleAndTask(@RequestParam int projectNo){
		RoleAndTaskDTO pi=dao.selectRoleAndDateByProjectNo(projectNo);
		if(pi!=null){
			JSONObject obj=new JSONObject();
			obj.put("role", pi.getRole());
			obj.put("task", pi.getTask());
			obj.put("registerNo", pi.getRegisterNo());
			return obj.toString();
		}
		return "ERROR";
	}
	/**
	 * projectNo에 해당하는 프로그램 내용중 category와 일치하는 프로그램 내용 조회
	 * @param projectNo 조회할 project의 등록번호
	 * @param category 조회할 category의 code
	 * @return 조회 성공-프로그램 내용을 JSONObject로, 실패-"ERROR"
	 */
	@RequestMapping("/selectProgramContent.do")
	@ResponseBody
	public String selectProgramContentByProjectNo(@RequestParam int projectNo, @RequestParam String category){
		Map<Integer,ProgramContentDTO> pc=dao.selectProgramContentByProjectNo(projectNo, new ProgramContentCategoryDTO(category, null));
		
		int num=0;
		Set<Integer> set=pc.keySet();
		Iterator<Integer> iterator=set.iterator();
		
		while(iterator.hasNext()){
			int temp=iterator.next();
			if(num<temp)
				num=temp;
		}
		if(pc!=null){
			JSONObject obj = new JSONObject();
			ProgramContentDTO pcDTO=pc.get(num);
			System.out.println(pcDTO);
			obj.put("registerNo", pcDTO.getRegisterNo());
			obj.put("content", pcDTO.getContent());
			obj.put("image_path", pcDTO.getProgramContentImage());
			obj.put("chartNo", pcDTO.getChartNo());

			return obj.toString();
		}
		return "ERROR";
	}
	
	/**
	 * projectNo에 해당하는 라이브러리 조회
	 * @param projectNo 조회할 project의 등록번호
	 * @return 성공-라이브러리를 JSONArray로, 실패-"ERROR"
	 */
	@RequestMapping(value="/selectLibrary.do")
	@ResponseBody
	public String selectLibraryByProjectNo(@RequestParam int projectNo){
		LibraryDTO library=dao.selectLibraryByProjectNo(projectNo);
		
		
		return "ERROR";
	}
	/**
	 * programContentNo에 해당하는 차트 조회
	 * @param programContentNo 조회할 projectContent의 등록번호
	 * @return 조회 성공-차트를 JSONArray로, 실패-"ERROR"
	 */
	@RequestMapping("/selectChart.do")
	@ResponseBody
	public String selectChartByProgramContentNo(@RequestParam(value="registerNo") int programContentNo){
		ChartDTO chart=dao.selectChartByProgramContentNo(programContentNo);
		if(chart!=null){
			JSONObject obj=new JSONObject();
			JSONArray ary=new JSONArray();
			obj.put("type",chart.getChartType().getCategory());
			ary.add(obj);
			obj=new JSONObject();
			obj.put("registerNo", chart.getRegisterNo());
			ary.add(obj);
      		//String[] items=new String[]{"","","","",""};
      		//String[] datas=new String[]{"","","","",""};
			//System.out.println(obj);
			String table=chart.getChartPath();
			StringTokenizer token=new StringTokenizer(table,"@^", true);
			while(token.hasMoreTokens()){
				String str=token.nextToken();
				if(str.equals("@")){
					obj=new JSONObject();
					obj.put("item", token.nextToken());
				}else if(str.equals("^")){
					obj.put("data", token.nextToken());
					ary.add(obj);
				}
			}
			System.out.println(ary.toString());
			return ary.toString();
		}
		return "chart";
	}
	/**
	 * memberid에 해당하는 프로젝트 정보 조회
	 * @param session memberid를 포함하고 있는 session 객체
	 * @return 조회 성공-프로젝트 정보를 JSONOject로, 실패-"ERROR"
	 */
	@RequestMapping("/selectProjectInfo.do")
	public String selectProjectInfoByMemberId(HttpSession session){
		String memberId="yeeee4";
		Map<Integer,ProjectInfoDTO> map=dao.selectProjectInfo(memberId);
		
		if(map!=null){
			String name=map.get(1).getName();
			System.out.println(name);
		}
		return "ERROR";

	}

	@RequestMapping(value = "/insertUseSkill.do", method=RequestMethod.GET)
	@ResponseBody
	public String useSkillInsert(@ModelAttribute UseSkillDTO dto, @RequestParam String registerArray) throws Exception{
		StringTokenizer token = new StringTokenizer(registerArray);
		int register_no;
		useDAO.deleteUseSkillByProjectNo(dto.getProject_no());
		while(token.hasMoreTokens()){
			register_no = Integer.parseInt(token.nextToken("/"));
			dto.setRegister_no(register_no);
			useDAO.insertUseSkill(dto);
			
		}
		
		return "success";
	}
	@RequestMapping(value = "/deleteUseSkill.do", method=RequestMethod.POST)
	@ResponseBody
	public String useSkillDelete(@ModelAttribute int projectNo) throws Exception{
		useDAO.deleteUseSkillByProjectNo(projectNo);
		return "success";
	}
	
	
	@RequestMapping(value = "/insertSystemArchitecture.do", method=RequestMethod.POST)
	@ResponseBody
	public String systemArchitectureInsert(@ModelAttribute SystemArchitectureDTO dto) throws Exception{
		System.out.println(dto.getClient());
		sysDAO.insertSystemArchitecture(dto);
		return "success";
	}
	
	@RequestMapping(value = "/updateSystemArchitecture.do", method=RequestMethod.POST)
	@ResponseBody
	public String systemArchitectureUpdate(@ModelAttribute SystemArchitectureDTO dto) throws Exception{
		sysDAO.updateSystemArchitecture(dto);
		return "success";
	}
	@RequestMapping(value = "/deleteSystemArchitecture.do", method=RequestMethod.POST)
	@ResponseBody
	public String systemArchitectureDelete(@RequestParam int project_no) throws Exception{
		sysDAO.deleteSystemArchitecture(project_no);
		return "success";
	}
	@RequestMapping(value = "/searchSystemArchitecture.do", method=RequestMethod.POST)
	@ResponseBody
	public String systemArchitectureSearch(@RequestParam int project_no ) throws Exception{
		
		System.out.println(project_no+"프로젝트");
		SystemArchitectureDTO dto = sysDAO.searchSystemArchitecture(project_no);
		
		if(dto==null){
			return "no";
		}
		JSONObject obj = new JSONObject();	
		System.out.println(dto.getRegister_no());
		obj.put("register_no", dto.getRegister_no());
		obj.put("project_no", dto.getProject_no());
		obj.put("client", dto.getClient());
		obj.put("server", dto.getServer());
		obj.put("middle_ware", dto.getMiddle_ware());
		obj.put("tier_category", dto.getTier_category());
		return obj.toString();
	}
	
	@RequestMapping(value = "/insertSoftwareArchitecture.do", method=RequestMethod.POST)
	@ResponseBody
	public String SoftwareArchitectureInsert(HttpServletRequest request) throws Exception{
		
		SoftwareArchitectureDTO dto = null;
		int maxSize = 5 * 1024 * 1024;
		String path = request.getServletContext().getRealPath("/");
		String diagram_image=null;
		int register_no =0; 
		int project_no = 0;
		String usecase_file = null;
		int usecase_count = 0;
		StringTokenizer token = new StringTokenizer(request.getContentType());

		System.out.println(request.getContentType());

		if (token.nextToken(";").equals("multipart/form-data")) {
			MultipartRequest mRequest = new MultipartRequest(request, path,
					maxSize, "UTF-8", new MyFileRenamePolicy("yeeee4"));
			if(mRequest.getFile("diagram_image") != null)
	        {
	        	Enumeration  e = mRequest.getFileNames();
	        	
	        	if(e.hasMoreElements()) {
	                String strName = (String) e.nextElement();
	                diagram_image = mRequest.getFilesystemName(strName);
	        	}
			}
			register_no = Integer.parseInt(mRequest.getParameter("register_no"));
			project_no = Integer.parseInt(mRequest.getParameter("project_no"));
			usecase_file = mRequest.getParameter("usecase_file");
			usecase_count = Integer.parseInt(mRequest.getParameter("usecase_count"));
		}
		dto = new SoftwareArchitectureDTO(register_no,project_no,usecase_file,usecase_count,diagram_image);
		System.out.println(dto);
		softDAO.insertSoftwareArchitecture(dto);
		return "success";
	}
	
	@RequestMapping(value = "/searchSoftwareArchitecture.do", method=RequestMethod.POST)
	@ResponseBody
	public String softwareArchitectureSearch(@RequestParam int project_no ) throws Exception{
		
		SoftwareArchitectureDTO dto = softDAO.searchSoftwareArchitecture(project_no);
		UsecaseDTO usecaseDTO = new UsecaseDTO();
		if(dto==null){
			return "no";
		}
		
		if(dto.getUsecase_count()!=0){
			StringTokenizer token = new StringTokenizer(dto.getUsecase_file());
			usecaseDTO.setActor(token.nextToken("/"));
			for(int i=0; i<dto.getUsecase_count()-1; i++){
				if(token.hasMoreTokens()){
					if(i==0){
						usecaseDTO.setCase1(token.nextToken("/"));
					}else if(i==1){
						usecaseDTO.setCase2(token.nextToken("/"));
					}else if(i==2){
						usecaseDTO.setCase3(token.nextToken("/"));
					}else if(i==3){
						usecaseDTO.setCase4(token.nextToken("/"));
					}
				}
			}
			usecaseDTO.setProject_no(dto.getProject_no());
			usecaseDTO.setRegister_no(dto.getRegister_no());
		}
		
		JSONObject obj = new JSONObject();	
		System.out.println(dto.getRegister_no());
		obj.put("register_no", usecaseDTO.getRegister_no());
		obj.put("project_no", usecaseDTO.getProject_no());
		obj.put("case1", usecaseDTO.getCase1());
		obj.put("case2", usecaseDTO.getCase2());
		obj.put("case3", usecaseDTO.getCase3());
		obj.put("case4", usecaseDTO.getCase4());
		obj.put("actor", usecaseDTO.getActor());
		obj.put("usecase_count", dto.getUsecase_count());
		System.out.println(obj.toString());
		return obj.toString();
	}
	
	
	@RequestMapping(value = "/deleteSoftwareArchitecture.do", method=RequestMethod.POST)
	@ResponseBody
	public String softwareArchitectureDelete(HttpSession session, @RequestParam int register_no) throws Exception{
		
		 File file = new File(softDAO.searchSoftwareArchitectureAtDiagram(register_no));
			try{
				file.delete();
			}catch(Exception e){
				e.printStackTrace();
			}
		 return softDAO.deleteSoftwareArchitectureAtDiagram(register_no)+"";
	}
	
	@RequestMapping(value = "/updateSoftwareArchitecture.do", method=RequestMethod.POST)
	@ResponseBody
	public String SoftwareArchitectureUpdate(HttpServletRequest request, HttpSession session) throws Exception{
		
		SoftwareArchitectureDTO dto = null;
		int maxSize = 5 * 1024 * 1024;
		String path = request.getServletContext().getRealPath("/");
		String diagram_image="";
		int register_no =0; 
		int project_no = 0;
		String usecase_file = null;
		int usecase_count = 0;
		StringTokenizer token = new StringTokenizer(request.getContentType());
		System.out.println(request.getContentType());

		if (token.nextToken(";").equals("multipart/form-data")) {
			MultipartRequest mRequest = new MultipartRequest(request, path,
					maxSize, "UTF-8", new MyFileRenamePolicy("yeeee4"));
			if(mRequest.getFile("diagram_image") != null)
	        {
	        	Enumeration  e = mRequest.getFileNames();
	        	
	        	if(e.hasMoreElements()) {
	                String strName = (String) e.nextElement();
	                diagram_image = mRequest.getFilesystemName(strName);
	        	}
			}
			
			register_no = Integer.parseInt(mRequest.getParameter("register_no"));
			project_no = Integer.parseInt(mRequest.getParameter("project_no"));
			usecase_file = mRequest.getParameter("usecase_file");
			usecase_count = Integer.parseInt(mRequest.getParameter("usecase_count"));
		}
		dto = new SoftwareArchitectureDTO(register_no,project_no,usecase_file,usecase_count,diagram_image);
		System.out.println(dto.toString());
		if (!diagram_image.equals("")) {
			String fname = softDAO
					.searchSoftwareArchitectureAtDiagram(register_no);
			if (fname!=null) {
				File file = new File(
						softDAO.searchSoftwareArchitectureAtDiagram(register_no));

				try {
					softDAO.searchSoftwareArchitectureAtDiagram(register_no);
					file.delete();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		} 
		softDAO.updateSoftwareArchitectureAtDiagram(dto);
		return "success";
	}

	/* 사용 기술  검색*/
	@RequestMapping(value = "/searchUseSkillByField.do", method=RequestMethod.POST)
	@ResponseBody
	public String programmingSkillSearchByField(HttpSession session, @ModelAttribute ProgrammingSkillDTO dto, @RequestParam int project_no) throws Exception{
		dto.setMemberID("yeeee4");
		List<ProgrammingSkillDTO> list = proDAO.selectProgrammingSkillByField(dto);
		List<UseSkillDTO> useList = useDAO.selectUseSkill(1);
		
		System.out.println(useList.size());
		JSONObject obj;
		JSONArray jArray = new JSONArray();
		for(int i=0; i<list.size(); i++){
			obj = new JSONObject();
			obj.put("register_no", list.get(i).getRegister_no());
			obj.put("name", list.get(i).getName());
			obj.put("isUse", false);
			for(int j=0; j<useList.size(); j++){		
				if(list.get(i).getRegister_no()== useList.get(j).getRegister_no()){
					obj.put("isUse", true);
					break;
				}
			}
			jArray.add(obj);
		}
		return jArray.toString();
	}
}
