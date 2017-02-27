package com.omazing.portfolio.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.omazing.portfolio.dao.ProgrammingSkillDAO;
import com.omazing.portfolio.dao.ProjectInfoDAO;
import com.omazing.portfolio.dao.SoftwareArchitectureDAO;
import com.omazing.portfolio.dao.SystemArchitectureDAO;
import com.omazing.portfolio.dao.UseSkillDAO;
import com.omazing.portfolio.dto.PortfolioDTO;
import com.omazing.portfolio.dto.ProgramContentCategoryDTO;
import com.omazing.portfolio.dto.ProgramContentDTO;
import com.omazing.portfolio.dto.SoftwareArchitectureDTO;
import com.omazing.portfolio.dto.UseSkillDTO;
import com.omazing.portfolio.dto.UsecaseDTO;
import com.omazing.resume.bean.AwardBean;
import com.omazing.resume.bean.PersonalInfoBean;
import com.omazing.resume.dao.AwardDAO;
import com.omazing.resume.dao.PersonalInfoDAO;
import com.omazing.resume.dto.AwardDTO;
import com.omazing.resume.dto.PersonalInfoDTO;
import com.omazing.resume.vo.AwardVO;

@Controller
public class PortfolioPreviewController {
	
	@Autowired
	private AwardDAO awardDAO;
	
	@Autowired
	private PersonalInfoDAO personalInfoDAO;
	
	@Autowired
	private ProjectInfoDAO projectInfoDAO;
	
	@Autowired
	private ProgrammingSkillDAO proDAO;
	
	@Autowired
	private SystemArchitectureDAO sysDAO;
	
	@Autowired
	private SoftwareArchitectureDAO softDAO;
	
	@Autowired
	private UseSkillDAO useDAO;
	
	@RequestMapping("/previewPortfolio.do")
	public ModelAndView portFolioPreview() throws Exception{
  		  
		ModelAndView mav = new ModelAndView();
  		//수상경력 불러오기
		AwardDTO[] awardDTOs = awardDAO.selectAwardAll("yeeee4");
		ArrayList<AwardVO> awardVOs = new ArrayList<AwardVO>();
		for(int i = 0 ; i < awardDTOs.length; ++i){
			awardVOs.add(new AwardVO(awardDTOs[i].getCategory().getCategoryCode(),
					awardDTOs[i].getCategory().getCategory(), awardDTOs[i].getField().getFieldCode(), 
					awardDTOs[i].getField().getField(), awardDTOs[i].getTarget(), 
					awardDTOs[i].getName(), awardDTOs[i].getDate(), awardDTOs[i].getPublication(),
					awardDTOs[i].getContent(), awardDTOs[i].getRegisterNo(), awardDTOs[i].getMemberID()));
		}
		AwardBean[] awardBeans = null;
		if(awardVOs.size() != 0)
		{
			int len = awardVOs.size();
			awardBeans = new AwardBean[len];
				
			for(int i = 0; i < len; ++i)
			{
				String[] all=  awardVOs.get(i).getAll();
			/**
			 * VO를 Bean으로 바꿔준다 
			 */
				awardBeans[i] = new AwardBean(all[1], all[3], all[4], 
						all[5], all[6], all[7], all[8], all[9]);
			}
		}
		mav.addObject("Award", awardBeans);
	  //사용자 개인정보 불러오기
		PersonalInfoDTO personalInfoVO = personalInfoDAO.selectPersonalInfoByID("yeeee4");
			
		String[] all = personalInfoVO.getAll();
		PersonalInfoBean personalBean = new PersonalInfoBean(all[1], all[2],
				all[3], all[4],  all[5], all[6], all[7]);
			
		mav.addObject("profile", personalBean);
			
	  //프로그램 소개
		Map<Integer,ProgramContentDTO> pc=projectInfoDAO.selectProgramContentByProjectNo(1, new ProgramContentCategoryDTO("pc1", null));
		mav.addObject("projectIntro", pc);   
	  //개발 환경         
		mav.addObject(projectInfoDAO.selectPeopleNoByRegisterNo(1));
		//라이브러리
			   
        //프로그래밍 기술
		  Map<Integer,PortfolioDTO> list = proDAO.selectProgrammingSkillByID("yeeee4");
		   if(list.size()!=0)
			   mav.addObject("programmingSkill", list);            
	   //UML 설계문서            	
		mav.addObject("systemArchitecture",sysDAO.searchSystemArchitecture(1));   
		UsecaseDTO usecaseDTO = new UsecaseDTO();
		
		SoftwareArchitectureDTO dto= softDAO.searchSoftwareArchitecture(1);
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
		System.out.println(usecaseDTO);
		mav.addObject("usecaseValue", usecaseDTO);
		mav.addObject("softwareArchitecture", softDAO.searchSoftwareArchitecture(1));
		 
		//차트
		 /*  ChartDAO chartDAO=new ChartDAO();
		   ChartDTO chartVO=chartDAO.selectChartVOByRegitserNO(2);
		   if(chartVO!=null){
	       		 String[] items=new String[]{"","","","",""};
	       		 String[] datas=new String[]{"","","","",""};
	          
	//	           		 StringTokenizer token_items=new StringTokenizer(chartVO.getItem(),"$");
	//	           		 StringTokenizer token_datas=new StringTokenizer(chartVO.getData(),"/");
	       		 int i=0;
	       		 while(token_items.hasMoreTokens()&&token_datas.hasMoreTokens()&&i<5){
	       			 items[i]=token_items.nextToken();
	       			 datas[i]=token_datas.nextToken();
	       			 System.out.println("item : "+items[i]);
	       			 System.out.println("data : "+datas[i]);
	       		 }
	       		 request.setAttribute("chartItem", items);
	       		 request.setAttribute("chartData", datas);
	       		 
		    } */

	          //주요 역할 및 담당
			  mav.addObject("MRAT",  projectInfoDAO.selectRoleAndDateByProjectNo(1));           
             
             mav.setViewName("/resources/views/showPortfolio.jsp");
             
             
             // 사용 기술
             
             List<UseSkillDTO> useSkill = useDAO.selectUseSkillName(1);
             System.out.println(useSkill.get(0).getName());
             mav.addObject("useSkill", useSkill);
             
             return mav;
  	  }

}

