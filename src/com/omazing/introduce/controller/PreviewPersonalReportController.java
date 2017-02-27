package com.omazing.introduce.controller;

import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.omazing.introduce.bean.ExperienceReportBean;
import com.omazing.introduce.bean.PersonalBiographyBean;
import com.omazing.introduce.bean.PersonalReportBean;
import com.omazing.introduce.bean.PersonalSpecialtyBean;
import com.omazing.introduce.dao.ExperienceReportDAO;
import com.omazing.introduce.dao.PersonalBiographyDAO;
import com.omazing.introduce.dao.PersonalReportDAO;
import com.omazing.introduce.dto.ExperienceReportDTO;
import com.omazing.introduce.dto.PersonalBiographyDTO;
import com.omazing.introduce.dto.PersonalReportDTO;
import com.omazing.introduce.dto.PersonalSpecialtyDTO;
import com.omazing.introduce.model.PersonalBiographyVO;
import com.omazing.introduce.model.PersonalSpecialtyVO;

/**
 * 자기소개서 미리보기 컨트롤러
 * @author nam
 */
@Controller
public class PreviewPersonalReportController {
	
	/**
	 * SQL세션객체
	 */
	@Autowired
	private SqlSession sqlSession;
	/**
	 * 극복과정 DAO
	 */
	@Autowired
	private ExperienceReportDAO edao;
	/**
	 * 성장과정 DAO
	 */
	@Autowired
	private PersonalBiographyDAO bdao;
	/**
	 * 장점,준비과정,비전및목표 DAO
	 */
	@Autowired
	private PersonalReportDAO rdao;
	
	/**
	 * 페이지를 이동하는 메소드
	 * @param request 요청객체
	 * @param response 응답객체 
	 * @throws Exception 요청,응답객체에서 발생하는 익셉션
	 */
	@RequestMapping(value="/previewperson.do", method=RequestMethod.GET)
	public void gotoPreviewPage(HttpServletRequest request, HttpServletResponse response) throws Exception{
		RequestDispatcher view = request.getRequestDispatcher("/resources/views/showIntroduce2.jsp");
		view.forward(request, response);
	}

	/**
	 * 미리보기 할 자기소개서 정보를 가져오는 메소드
	 * @param response 응답객체
	 * @param memberID 회원ID
	 * @throws Exception 요청,응답객체에서 발생하는 익셉션
	 */
	@RequestMapping(value="/getpersonalreport.do", method=RequestMethod.POST)
	public void getAll(HttpServletResponse response
			,@RequestParam("id") String memberID) throws Exception{
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		
		JSONObject obj = new JSONObject();
		
		Iterator<ExperienceReportDTO> iter = edao.selectExperienceReportAll(memberID);
		ExperienceReportDTO edto = null;
		if(iter != null){
			obj.put("experience", true);
			
				JSONArray overcome = new JSONArray();
				JSONObject record = null;
				ExperienceReportBean bean = null;
				
				System.out.println("이터레이터"+iter);
				while (iter.hasNext()) {
					edto = iter.next();
					String[] all = edto.getAll();
					bean = new ExperienceReportBean(all[1], all[2], all[3]);
					record = new JSONObject();
					System.out.println("극복과정빈"+bean);
					record.put("registerNo", bean.getRegisterNo());
					record.put("title", bean.getTitle());
					record.put("content", bean.getContent());
					overcome.add(record);
				}
			obj.put("overcome", overcome);
		}
		else{
			obj.put("experience", false);
			obj.put("overcome", null);
		}
			
		PersonalBiographyDTO bdto = bdao.selectPersonalBiography(memberID);
		
		if(bdto!=null){
			obj.put("biography", true);
			
			String[] dtoAll = bdto.getAll();
			Map<Integer,PersonalSpecialtyDTO> dtomap = bdto.getSpecialtyMap();
			Map<Integer,PersonalSpecialtyVO> vomap=null;
			
			JSONArray ary = new JSONArray();
			JSONArray hobbyary=null;
			JSONArray skillary=null;
			
			if(dtomap!=null){
				hobbyary=new JSONArray();
				skillary=new JSONArray();
				
				Set<Integer> keys = dtomap.keySet();
				vomap = new HashMap<>();
				PersonalSpecialtyDTO sdto;
				PersonalSpecialtyVO svo;
				PersonalSpecialtyBean sbean;
				JSONObject sobj;
				for(Integer key : keys){
					sdto = dtomap.get(key);
					String[] all = sdto.getAll();
					svo = new PersonalSpecialtyVO(all[0], all[2], Integer.parseInt(all[1]), all[3], all[4]);
					vomap.put(svo.getRegisterNo(), svo);
					
					String[] voall = svo.getAll();
					sbean = new PersonalSpecialtyBean(voall[1], voall[2], voall[3], voall[4]);

					sobj = new JSONObject();
//					sobj.put("registerNo", sbean.getRegisterNo());
//					sobj.put("type", sbean.getType());
//					sobj.put("name", sbean.getName());
//					sobj.put("iconCode", sbean.getIconCode());
//					
					if(sbean.getType().equals("hobby")){
						hobbyary.add(sbean.getName());
					}
					else{
						skillary.add(sbean.getName());
					}
				}
				
				obj.put("specialty", true);
				obj.put("hobby", hobbyary);
				obj.put("skill", skillary);
			}
			else{
				obj.put("specialty", false);
				obj.put("hobby", null);
				obj.put("skill", null);
			}
			
			PersonalBiographyVO vo = new PersonalBiographyVO(dtoAll[0],dtoAll[1], dtoAll[2], dtoAll[3], dtoAll[4], dtoAll[5],vomap);
			String[] voAll = vo.getAll();
			PersonalBiographyBean bean = new PersonalBiographyBean(voAll[1], voAll[2], voAll[3], voAll[4], voAll[5]);
			
			if(bean.getKeyword() != null){
				StringTokenizer tok = new StringTokenizer(bean.getKeyword(),"/");
				while(tok.hasMoreTokens()){
					ary.add(tok.nextToken());
				}
				obj.put("keyword", ary);
			}
			else{
				obj.put("keyword", null);
			}
			
			obj.put("child", bean.getChildhood());
			obj.put("student", bean.getStudent());
			obj.put("company", bean.getCompany());
			obj.put("univ", bean.getUniv());
			
			/** 이전에 작성했던 코드(성장과정과 취미특기를 각자 DAO로 호출했던 방식...) */
//			String[] dtoAll = bdto.getAll();
//			PersonalBiographyVO vo = new PersonalBiographyVO(dtoAll[0],dtoAll[1], dtoAll[2], dtoAll[3], dtoAll[4], dtoAll[5],null);
//			String[] voAll = vo.getAll();
//			PersonalBiographyBean bean = new PersonalBiographyBean(voAll[1], voAll[2], voAll[3], voAll[4], voAll[5]);
//			String[] beanAll = bean.getAll();
//			
//			obj.put("biography", true);
//			obj.put("childhood", beanAll[0]);
//			obj.put("student", beanAll[1]);
//			obj.put("univ", beanAll[2]);
//			obj.put("company", beanAll[3]);
//			
//			JSONArray keywords = new JSONArray();
//			if(bean.getKeyword() != null){
//				StringTokenizer tok = new StringTokenizer(bean.getKeyword(),"/");
//				while(tok.hasMoreTokens()){
//					keywords.add(tok.nextToken());
//				}
//				obj.put("keyword", keywords);
//			}
//			else{
//				obj.put("keyword", null);
//			}
//			
//			Iterator<PersonalSpecialtyDTO> hiter = bdao.selectPersonalHobbyAll(memberID);
//			if(hiter != null){
//				JSONArray hobbies = new JSONArray();
//				while(hiter.hasNext()){
//					PersonalSpecialtyDTO sdto = hiter.next();
//					hobbies.add(sdto.getName());
//				}
//				obj.put("hobby", hobbies);
//			}
//			else{
//				obj.put("hobby", null);
//			}
//			
//			Iterator<PersonalSpecialtyDTO> siter = bdao.selectPersonalSkillAll(memberID);
//			if(siter != null){
//				JSONArray skills = new JSONArray();
//				while(siter.hasNext()){
//					PersonalSpecialtyDTO sdto = siter.next();
//					skills.add(sdto.getName());
//				}
//				obj.put("skill", skills);
//			}
//			else{
//				obj.put("skill", null);
//			}
		}
		else{
			obj.put("biography", false);
			obj.put("childhood", null);
			obj.put("student", null);
			obj.put("univ", null);
			obj.put("company", null);
			obj.put("keyword", null);
			obj.put("hobby", null);
			obj.put("skill", null);
		}
		
		PersonalReportDTO rdto = rdao.selectPersonalReport(memberID);
		if(rdto !=null){
			String[] all = rdto.getAll();
			if(all[1] != null){
				obj.put("strength", true);
				obj.put("strengthReport", all[1]);
			}
			else{
				obj.put("strength", false);
				obj.put("strengthReport", null);
			}
			if(all[2] != null){
				obj.put("ready", true);
				obj.put("readyCondition", all[2]);
			}
			else{
				obj.put("ready", false);
				obj.put("readyCondition", null);
			}
			if(all[3] != null){
				obj.put("goal", true);
				PersonalReportBean bean = new PersonalReportBean(all[1], all[2], all[3]);
				JSONArray goals = new JSONArray();
					StringTokenizer tok = new StringTokenizer(bean.getGoal(), "/");
					while(tok.hasMoreTokens()){
						goals.add(tok.nextToken());
					}
				obj.put("goalReport", goals);
			}
			else{
				obj.put("goal", false);
				obj.put("goalReport", null);
			}
		}
		else{
			obj.put("strength", false);
			obj.put("ready", false);
			obj.put("goal", false);
			obj.put("strengthReport", null);
			obj.put("readyCondition", null);
			obj.put("goalReport", null);
		}
		out.println(obj);
		out.flush();
		out.close();
	}
}
