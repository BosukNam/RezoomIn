package com.omazing.resume.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.omazing.resume.bean.SchoolBean;
import com.omazing.resume.dao.SchoolDAO;
import com.omazing.resume.dto.GraduatedSchoolDTO;
import com.omazing.resume.dto.SchoolCategoryDTO;
import com.omazing.resume.dto.SchoolDTO;
import com.omazing.resume.dto.SchoolDegreeCategoryDTO;
import com.omazing.resume.dto.SchoolStateCategoryDTO;
import com.omazing.resume.dto.SchoolTotalGradeCategoryDTO;
import com.omazing.resume.dto.SchoolTrackCategoryDTO;
/**
 * 학력사항 Controller 
 * @author yeeun
 *
 */
@Controller
public class SchoolInfoController {
	/**
	 * 학력사항 DAO 
	 */
	@Autowired
	private SchoolDAO schoolDAO;
	
	/**
	 * 디폴트 생성자 
	 */
	public SchoolInfoController(){
		System.out.println("SchoolInfoController()");
	}
	/**
	 * 학력사항 등록 
	 * @param session 세션객체 
	 * @param schoolBean 등록할 학력사항 빈 
	 * @param response 응답객체 
	 */
	@RequestMapping(value="/addSchoolInfo.do", method=RequestMethod.POST)
	public void addSchool(HttpSession session, 
			@ModelAttribute SchoolBean schoolBean, HttpServletResponse response)
	{
		System.out.println("addSchoolInfo()");
		String id = "yeeee4";
		/*
		 * Bean을 VO로 변환
		 */
		SchoolDTO schoolDTO = null; 
		Boolean res = null;
		
		if(schoolBean != null){
			String[] allBean = schoolBean.getAll();

			System.out.println("$$$" + schoolBean);
			
			String[] category = schoolBean.getCategory().split("/");
			String[] track = schoolBean.getTrack().split("/");
			
			if("고등학교".equals(category[1]))
			{
				schoolDTO = new SchoolDTO(id, 
						new SchoolCategoryDTO(category[0], category[1]), allBean[3],  
						new SchoolTrackCategoryDTO(track[0], track[1]), allBean[6], allBean[7], allBean[8]);
				System.out.println("##DTO:" + schoolDTO);
				res = schoolDAO.insertSchool(schoolDTO);
			}
			else
			{
				String[] degree = schoolBean.getDegree().split("/");
				String[] totGrade = schoolBean.getTotalGrade().split("/");
				String[] state = schoolBean.getState().split("/");
				
				schoolDTO = new GraduatedSchoolDTO(id, 
						new SchoolCategoryDTO(category[0], category[1]), allBean[3],  
						new SchoolTrackCategoryDTO(track[0], track[1]), allBean[6], allBean[7], allBean[8],
						new SchoolDegreeCategoryDTO(degree[0], degree[1]), Double.parseDouble(allBean[13]), 
						new SchoolTotalGradeCategoryDTO(totGrade[0], Double.parseDouble(totGrade[1])), allBean[14], 
						new SchoolStateCategoryDTO(state[0], state[1]));
				System.out.println("##DTO:" + schoolDTO);

				res = schoolDAO.insertGraduatedSchool(schoolDTO);
			}
		}
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = null;
		try {
			out = response.getWriter();
			if(!res)
				out.println("ADD-FAIL");

			int getRegisterNo = schoolDAO.getLastRegisterNo();
			if(getRegisterNo != -1)
				out.println("ADD-SUCCESS/" + getRegisterNo);
			else
				out.println("ADD-FAIL");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	/**
	 * 학력사항 수정 
	 * @param session 세션객체 
	 * @param schoolBean 수정할 학력사항 빈 
	 * @param response 응답객체 
	 */
	@RequestMapping(value="/modifySchoolInfo.do", method=RequestMethod.POST)
	public void modifySchoolInfo(HttpSession session, 
			@ModelAttribute SchoolBean schoolBean, HttpServletResponse response)
	{
		System.out.println("modifySchoolInfo()");
		String id = "yeeee4";
		/*
		 * Bean을 VO로 변환
		 */
		SchoolDTO schoolDTO = null; 
		Boolean res = null;
		
		if(schoolBean != null){
			String[] allBean = schoolBean.getAll();

			System.out.println("$$$" + schoolBean);
			
			String[] category = schoolBean.getCategory().split("/");
			String[] track = schoolBean.getTrack().split("/");
			
			if("고등학교".equals(category[1]))
			{
				schoolDTO = new SchoolDTO(id, Integer.parseInt(allBean[0]),
						new SchoolCategoryDTO(category[0], category[1]), allBean[3],  
						new SchoolTrackCategoryDTO(track[0], track[1]), allBean[6], allBean[7], allBean[8]);
				res = schoolDAO.updateSchool(schoolDTO);
			}
			else
			{
				String[] degree = schoolBean.getDegree().split("/");
				String[] totGrade = schoolBean.getTotalGrade().split("/");
				String[] state = schoolBean.getState().split("/");
				
				schoolDTO = new GraduatedSchoolDTO(id,  Integer.parseInt(allBean[0]),
						new SchoolCategoryDTO(category[0], category[1]), allBean[3],  
						new SchoolTrackCategoryDTO(track[0], track[1]), allBean[6], allBean[7], allBean[8],
						new SchoolDegreeCategoryDTO(degree[0], degree[1]), Double.parseDouble(allBean[13]), 
						new SchoolTotalGradeCategoryDTO(totGrade[0], Double.parseDouble(totGrade[1])), allBean[14], 
						new SchoolStateCategoryDTO(state[0], state[1]));
				 res = schoolDAO.updateGraduatedSchool(schoolDTO);
			}
		}
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = null;
		try {
			out = response.getWriter();
			if(!res)
				out.println("MODIFY-FAIL");
			else
				out.println("MODIFY-SUCCESS");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	/**
	 * 학력사항 삭제 
	 * @param session 세션객체 
	 * @param registerNo 삭제할 학력사항 등록번호 
	 * @param response 응답객체 
	 */
	@RequestMapping(value="/deleteSchoolInfo.do")
	public void deleteSchoolInfo(HttpSession session, 
			@RequestParam int registerNo, HttpServletResponse response)
	{
		boolean res = schoolDAO.deleteGraduatedSchool(registerNo);
		PrintWriter out = null;
		try {
			response.setContentType("text/html; charset=UTF-8");
			out = response.getWriter();
			
			if(res)
				out.println("DELETE-SUCCESS");
			else
				out.println("DELETE-FAIL");
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	/**
	 * 학력사항 조회 
	 * @param session 세션객체 
	 * @param registerNo 조회할 학력사항 등록번호 
	 * @param response 응답객체 
	 */
	@RequestMapping(value="/searchSchoolInfo.do")
	public void searchSchoolInfo(HttpSession session, @RequestParam int registerNo, 
			HttpServletResponse response)
	{
		System.out.println("searchSchoolInfo()");
		String id = "yeeee4";
		
		System.out.println("** registerNo: " + registerNo);
		SchoolDTO schoolDTO = schoolDAO.selectGraduatedSchoolByRegisterNo(registerNo);
		
		if(schoolDTO == null)
			schoolDTO = schoolDAO.selectSchoolByRegisterNo(registerNo);
		
		SchoolBean schoolBean = null;
		String[] all = schoolDTO.getAll();
		
		JSONObject obj = new JSONObject();
		
		String[] allBean = null;
		if("고등학교".equals(all[3])){
			schoolBean = new SchoolBean(all[1], all[2], all[3], all[4], 
					all[5], all[6], all[7], all[8], all[9]);
			allBean = schoolBean.getAll();
			
			obj.put("msg", "SEARCH-SUCCESS");
			
			obj.put("categoryCode",allBean[1]);
			obj.put("category",allBean[2]);
			obj.put("name",allBean[3]);
			obj.put("trackCode",allBean[4]);
			obj.put("track",allBean[5]);
			obj.put("major",allBean[6]);
			obj.put("startDate",allBean[7]);
			obj.put("endDate",allBean[8]);

		}
		else{
			schoolBean = new SchoolBean(all[1], all[2], all[3], all[4], 
					all[5], all[6], all[7], all[8], all[9], all[10], all[11], all[12],
				all[13], all[14], all[15], all[16], all[17]);
			allBean = schoolBean.getAll();
		
			obj.put("msg", "SEARCH-SUCCESS");
			
			obj.put("categoryCode",allBean[1]);
			obj.put("category",allBean[2]);
			obj.put("name",allBean[3]);
			obj.put("trackCode",allBean[4]);
			obj.put("track",allBean[5]);
			obj.put("major",allBean[6]);
			obj.put("startDate",allBean[7]);
			obj.put("endDate",allBean[8]);
			obj.put("degreeCode",allBean[9]);
			obj.put("degree",allBean[10]);
			obj.put("totalGradeCode",allBean[11]);
			obj.put("totalGrade",allBean[12]);
			obj.put("grade",allBean[13]);
			obj.put("location",allBean[14]);
			obj.put("stateCode",allBean[15]);
			obj.put("state",allBean[16]);
			
		}
		
		if(schoolDTO == null)
			obj.put("msg", "SEARCH-FAIL");
		
		PrintWriter out = null;
		try {
			response.setContentType("text/html; charset=UTF-8");
			out = response.getWriter();
			
			out.println(obj);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
