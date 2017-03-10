package com.omazing.portfolio.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServlet;
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
import org.springframework.web.servlet.ModelAndView;

import com.omazing.portfolio.dao.ProgrammingSkillDAO;
import com.omazing.portfolio.dao.SkillNameDAO;
import com.omazing.portfolio.dao.SkillRankDAO;
import com.omazing.portfolio.dao.UseSkillDAO;
import com.omazing.portfolio.dto.PortfolioDTO;
import com.omazing.portfolio.dto.ProgrammingSkillDTO;
import com.omazing.portfolio.dto.SkillNameDTO;
import com.omazing.portfolio.dto.SkillRankDTO;
import com.omazing.portfolio.dto.UseSkillDTO;
import com.omazing.resume.bean.AwardBean;
import com.omazing.resume.dao.AwardDAO;
import com.omazing.resume.dto.AwardDTO;
import com.omazing.resume.vo.AwardVO;



/*
 * Servlet implementation class ProfileAddServlet
 */
@Controller
/**
 * 
 * @author YJ
 *
 */
public class PortfolioProfileController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Autowired
	private ProgrammingSkillDAO proDAO;
	/*@Autowired
	AwardDAO awardDAO ;*/
	
	@Autowired
	private SkillRankDAO rankDAO;
	
	@Autowired
	private SkillNameDAO nameDAO;
	
	
	@Autowired
	private AwardDAO awardDAO; 
	
	@RequestMapping(value = "/initProgrammingSkill.do", method=RequestMethod.GET)
	public ModelAndView portfolioProfileInit(HttpSession session) throws Exception{
		
		ModelAndView mav = new ModelAndView();
		
		/*session.getAttribute("memberID")*/
		if(!proDAO.selectProgrammingSkillByID("yeeee4").isEmpty()){
			ArrayList<PortfolioDTO> array = new ArrayList<PortfolioDTO>(proDAO.selectProgrammingSkillByID("yeeee4").values());
			mav.addObject("ProgrammingSKill", array);
		}
		 
		List<SkillRankDTO> list = rankDAO.selectSkillRankCategory();
		mav.addObject("rankcategory", list);
		/*AwardVO[] vo= awardDAO.selectAwardAll(id);
		if(vo.length!=0){
			ArrayList<AwardVO> volist = new ArrayList<AwardVO>(Arrays.asList(vo));
			request.setAttribute("Award", volist);
		}*/
		
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
		mav.addObject("awards", awardBeans);
//		System.out.println("프로필에서" + awardBeans[0].toString());
		mav.setViewName("/resources/views/profile.jsp");
		return mav;
	}
	
	@RequestMapping(value = "/addProgrammingSkill.do", method=RequestMethod.POST)
	@ResponseBody
	public String programmingSkillInsert(HttpSession session, @ModelAttribute ProgrammingSkillDTO dto) throws Exception{
		dto.setMemberID("yeeee4");
		if("Etc".equals(dto.getType())){
			nameDAO.insertSkillNameCategoryETC(dto.getName());
		}
		proDAO.insertProgrammingSkill(dto);
		int register_no = proDAO.selectProgrammingSkillByName("yeeee4", dto.getName()).getRegister_no();
		List<SkillNameDTO> nameList = nameDAO.selectSkillNameCategory();
		JSONObject obj;
		JSONArray jArray = new JSONArray();
		String[] all;
		for(int i=0; i<nameList.size(); i++){
			obj = new JSONObject();	
			all = nameList.get(i).getAll();
			obj.put("skill_name_code", all[0]);
			obj.put("skill_name", all[1]);
			obj.put("skill_name_image", all[2]);
			obj.put("register_no", register_no);
			jArray.add(obj);
			
		}
		return jArray.toString();
	
	}
	
	@RequestMapping(value = "/modifyProgrammingSkill.do", method=RequestMethod.POST)
	@ResponseBody
	public String programmingSkillModify(HttpSession session, @ModelAttribute ProgrammingSkillDTO dto) throws Exception{
		dto.setMemberID("yeeee4");
		proDAO.updateProgrammingSkillUnit(dto);
		
		JSONObject obj = new JSONObject();	
		SkillNameDTO nameDTO = nameDAO.selectSkillNameByName(dto.getName());
		obj.put("skill_name_code", nameDTO.getSkill_name_code());
		obj.put("skill_name", nameDTO.getSkill_name());
		obj.put("skill_name_image", nameDTO.getSkill_name_image());
		
		return obj.toString();
	}
	
	@RequestMapping(value = "/searchProgrammingSkill.do", method=RequestMethod.POST)
	@ResponseBody
	public String programmingSkillSearch(HttpSession session, @RequestParam String name) throws Exception{
		ProgrammingSkillDTO dto = proDAO.selectProgrammingSkillByName("yeeee4", name);
		JSONObject obj = new JSONObject();	
		
		obj.put("name", dto.getName());
		obj.put("register_no", dto.getRegister_no());
		obj.put("rank", dto.getRank());
		obj.put("type", dto.getType());
		
		return obj.toString();
	}
	
	@RequestMapping(value = "/deleteProgrammingSkill.do", method=RequestMethod.POST)
	@ResponseBody
	public String programmingSkillDelete(HttpSession session, @RequestParam int register_no) throws Exception{
		PortfolioDTO dto = proDAO.selectProgrammingSkillByRegisterNo(register_no);
		if(dto.getProgramming_type_name().equals("Etc")){
			nameDAO.deleteSkillNameByName(dto.getName());
		};
		proDAO.deleteProgrammingSkill(register_no);
		return "success";
	}
}
