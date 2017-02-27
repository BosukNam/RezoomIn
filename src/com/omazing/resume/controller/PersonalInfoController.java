package com.omazing.resume.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.StringTokenizer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.omazing.resume.bean.MilitaryBean;
import com.omazing.resume.bean.PersonalInfoBean;
import com.omazing.resume.bean.UnusualBean;
import com.omazing.resume.dao.MilitaryDAO;
import com.omazing.resume.dao.PersonalInfoDAO;
import com.omazing.resume.dao.UnusualDAO;
import com.omazing.resume.dto.MilitaryCategoryDTO;
import com.omazing.resume.dto.MilitaryDTO;
import com.omazing.resume.dto.MilitaryRankCategoryDTO;
import com.omazing.resume.dto.PersonalInfoDTO;
import com.omazing.resume.dto.UnusualCategoryDTO;
import com.omazing.resume.dto.UnusualDTO;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.MyFileRenamePolicy;
/**
 * 개인 인적 사항 Controller
 * @author yeeun
 *
 */
@Controller
public class PersonalInfoController {
	/**
	 * 개인 신상 정보 DAO
	 */
	@Autowired
	PersonalInfoDAO personalInfoDAO;
	/**
	 * 병역사항 DAO 
	 */
	@Autowired
	MilitaryDAO militaryDAO;
	/**
	 * 보훈 장애사항 DAO 
	 */
	@Autowired
	UnusualDAO unusualDAO;
	/**
	 * 디폴트 생성자
	 */
	public PersonalInfoController(){
		System.out.println("PersonalInfoController()");
	}
	/**
	 * 개인신상 정보 등록 
	 * @param session 세션객체 
	 * @param personalInfo 등록할 개인신상정보 빈 
	 * @param response 응답객체 
	 */
	@RequestMapping(value = "/addPersonalInfo.do", method = RequestMethod.POST)
	public void addPersonalInfo(HttpSession session, 
			@ModelAttribute PersonalInfoBean personalInfo, HttpServletResponse response){
		System.out.println("addPersonalInfo() 호출");
		
		String id = "yeeee4";
		System.out.println("personalInfo:" + personalInfo);

		String[] all = personalInfo.getAll();
		
		PersonalInfoDTO personalInfoDTO = null;
		if(all[6] == null){
			personalInfoDTO = new PersonalInfoDTO(
					id, all[0], all[1], all[2], all[3], all[4], all[5]);
			System.out.println("personalInfoDTO1:" + personalInfoDTO);
		}
		else{
			boolean isMale = false;
			if("male".equals(all[6]))
				isMale = true;
			personalInfoDTO = new PersonalInfoDTO(
					id, all[0], all[1], all[2], all[3], all[4], all[5], isMale);
			System.out.println("personalInfoDTO2:" + personalInfoDTO);
		}
		boolean res = personalInfoDAO.insertPersonalInfo(personalInfoDTO);

		try {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter writer = response.getWriter();
			
			if(!res)
				writer.println("ADD-FAIL");
			else
				writer.println("ADD-SUCCESS");
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	/**
	 * 병역사항 등록 
	 * @param session 세션객체 
	 * @param militaryBean 등록할 병역사항 빈 
	 * @param response 응답객체 
	 */
	@RequestMapping(value = "/addMilitary.do", method = RequestMethod.POST)
	public void addMilitary(HttpSession session, 
			@ModelAttribute MilitaryBean militaryBean, HttpServletResponse response){
		System.out.println("addMilitary() 호출");
		
		String id = "yeeee4";
		System.out.println("militaryBean:" + militaryBean);
		
		
		String[] all = militaryBean.getAll();
		MilitaryDTO militaryDTO = null;
		
		if("필".equals(all[0]))
		{
			String[] category = militaryBean.getCategory().split("/");
			String[] rank = militaryBean.getRank().split("/");
			
			militaryDTO = new MilitaryDTO(id, true, all[1], all[2], 
				new MilitaryCategoryDTO(category[0], category[1]), new MilitaryRankCategoryDTO(rank[0], rank[1]));
		}
		else
			militaryDTO = new MilitaryDTO(id, false);	
		
		boolean res = militaryDAO.insertMilitary(militaryDTO);
		try {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter writer = response.getWriter();
			
			if(!res)
				writer.println("ADD-FAIL");
			else
				writer.println("ADD-SUCCESS");
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	/**
	 * 보훈 장애사항 등록 
	 * @param session 세션객체 
	 * @param unusualBean 등록할 보훈 장애사항 빈 
	 * @param response 응답객체 
	 */
	@RequestMapping(value = "/addUnusual.do", method = RequestMethod.POST)
	public void addUnusual(HttpSession session, 
			@ModelAttribute UnusualBean unusualBean, HttpServletResponse response){
		System.out.println("addUnusual() 호출");
		
		String id = "yeeee4";
		System.out.println("unusualBean:" + unusualBean);
		
		UnusualDTO unusualDTO = null;
		
		String[] all = unusualBean.getAll();

		boolean isRewarded = false;
		if("대상".equals(all[0]))
			isRewarded = true;
		
		if("대상".equals(all[1]))
		{
			String[] category = unusualBean.getDisability().split("/");
			
			unusualDTO = new UnusualDTO(id, isRewarded, true,  
					new UnusualCategoryDTO(category[0], category[1]));
			
		}
		else
			unusualDTO = new UnusualDTO(id, isRewarded, false);  
		
		boolean res = unusualDAO.insertUnusual(unusualDTO);
		try {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter writer = response.getWriter();
			
			if(!res)
				writer.println("ADD-FAIL");
			else
				writer.println("ADD-SUCCESS");
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	/**
	 * 개인 신상 정보 수정 
	 * @param session 세션객체 
	 * @param personalInfo 등록할 개인신상정보 빈 
	 * @param response 응답객체 
	 */
	@RequestMapping(value = "/modifyPersonalInfo.do", method = RequestMethod.POST)
	public void modifyPersonalInfo(HttpSession session, 
			@ModelAttribute PersonalInfoBean personalInfo, HttpServletResponse response){
		System.out.println("addPersonalInfo() 호출");
		
		String id = "yeeee4";
		System.out.println("personalInfo:" + personalInfo);

		String[] all = personalInfo.getAll();
		
		PersonalInfoDTO personalInfoDTO = null;
		if(all[6] == null){
			personalInfoDTO = new PersonalInfoDTO(
					id, all[0], all[1], all[2], all[3], all[4], all[5]);
			System.out.println("personalInfoDTO1:" + personalInfoDTO);
			
		}
		else{
			boolean isMale = false;
			if("male".equals(all[6]))
				isMale = true;
			personalInfoDTO = new PersonalInfoDTO(
					id, all[0], all[1], all[2], all[3], all[4], all[5], isMale);
			System.out.println("personalInfoDTO2:" + personalInfoDTO);
		}
		boolean res = personalInfoDAO.updatePersonalInfo(personalInfoDTO);

		try {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter writer = response.getWriter();
			
			if(!res)
				writer.println("MODIFY-FAIL");
			else
				writer.println("MODIFY-SUCCESS");
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	/**
	 * 병역사항 수정 
	 * @param session 세션객체 
	 * @param militaryBean 수정할 병역사항 빈 
	 * @param response 응답객체 
	 */
	@RequestMapping(value = "/modifyMilitary.do", method = RequestMethod.POST)
	public void modifyMilitary(HttpSession session, 
			@ModelAttribute MilitaryBean militaryBean, HttpServletResponse response){
		System.out.println("modifyMilitary() 호출");
		
		String id = "yeeee4";
		System.out.println("militaryBean:" + militaryBean);
		
		
		String[] all = militaryBean.getAll();
		MilitaryDTO militaryDTO = null;
		
		if("필".equals(all[0]))
		{
			String[] category = militaryBean.getCategory().split("/");
			String[] rank = militaryBean.getRank().split("/");
			
			militaryDTO = new MilitaryDTO(id, true, all[1], all[2], 
				new MilitaryCategoryDTO(category[0], category[1]), new MilitaryRankCategoryDTO(rank[0], rank[1]));
		}
		else
			militaryDTO = new MilitaryDTO(id, false);	
		
		boolean res = militaryDAO.updateMilitary(militaryDTO);
		try {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter writer = response.getWriter();
			
			if(!res)
				writer.println("MODIFY-FAIL");
			else
				writer.println("MODIFY-SUCCESS");
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	/**
	 * 보훈 장애사항 수정 
	 * @param session 세션객체 
	 * @param unusualBean 수정할 보훈 장애사항 빈 
	 * @param response 응답객체 
	 */
	@RequestMapping(value = "/modifyUnusual.do", method = RequestMethod.POST)
	public void modifyUnusual(HttpSession session, 
			@ModelAttribute UnusualBean unusualBean, HttpServletResponse response){
		System.out.println("modifyUnusual() 호출");
		
		String id = "yeeee4";
		System.out.println("unusualBean:" + unusualBean);
		
		UnusualDTO unusualDTO = null;
		
		String[] all = unusualBean.getAll();
		
		boolean isRewarded = false;
		if("대상".equals(all[0]))
			isRewarded = true;
		
		if("대상".equals(all[1]))
		{
			String[] category = unusualBean.getDisability().split("/");
			System.out.println(category[0]);
			System.out.println(category[1]);
			unusualDTO = new UnusualDTO(id, isRewarded, true,  
					new UnusualCategoryDTO(category[0], category[1]));
			
		}
		else
			unusualDTO = new UnusualDTO(id, isRewarded, false);  
		
		boolean res = unusualDAO.updateUnusual(unusualDTO);
		try {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter writer = response.getWriter();
			
			if(!res)
				writer.println("MODIFY-FAIL");
			else
				writer.println("MODIFY-SUCCESS");
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	/**
	 * 개인 신상 정보 삭제 
	 * @param session 세션객체 
	 * @param response 응답객체 
	 */
	@RequestMapping(value = "/deletePersonalInfo.do")
	public void deletePersonalInfo(HttpSession session, HttpServletResponse response){
		System.out.println("deletePersonalInfo() 호출");
		
		String id = "yeeee4";
		boolean res = personalInfoDAO.deletePersonalInfo(id);

		try {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter writer = response.getWriter();
			
			if(res)
				writer.println("DELETE-SUCCESS");
			else
				writer.println("DELETE-FAIL");
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	/**
	 * 병역사항 삭제 
	 * @param session 세션객체 
	 * @param response 응답객체 
	 */
	@RequestMapping(value = "/deleteMilitary.do")
	public void deleteMilitary(HttpSession session, HttpServletResponse response){
		System.out.println("deleteMilitary() 호출");
		
		String id = "yeeee4";
		boolean res = militaryDAO.deleteMilitary(id);
		
		try {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter writer = response.getWriter();
			
			if(res)
				writer.println("DELETE-SUCCESS");
			else
				writer.println("DELETE-FAIL");
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	/**
	 * 보훈 장애사항 삭제 
	 * @param session 세션객체 
	 * @param response 응답객체 
	 */
	@RequestMapping(value = "/deleteUnusual.do")
	public void deleteUnusual(HttpSession session, HttpServletResponse response){
		System.out.println("deleteUnusual() 호출");
		
		String id = "yeeee4";
		boolean res = unusualDAO.deleteUnusual(id);
		
		try {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter writer = response.getWriter();
			
			if(res)
				writer.println("DELETE-SUCCESS");
			else
				writer.println("DELETE-FAIL");
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	/**
	 * 개인 신상 정보 조회 
	 * @param session 세션객체 
	 * @param response 응답객체 
	 */
	@RequestMapping(value = "/searchPersonalInfo.do")
	public void searchPersonalInfo(HttpSession session, HttpServletResponse response){
		System.out.println("searchPersonalInfo() 호출");
		
		String id = "yeeee4";
		PersonalInfoDTO personalInfoDTO = personalInfoDAO.selectPersonalInfoByID(id);
		
		String[] all = personalInfoDTO.getAll();
		PersonalInfoBean personalBean = new PersonalInfoBean(all[1], all[2],
				all[3], all[4],  all[5], all[6], all[7]);
		
		String[] allBean = personalBean.getAll();
		JSONObject obj = new JSONObject();

		response.setContentType("text/html; charset=UTF-8");
		
		
		if(personalInfoDTO != null)
		{
			obj.put("msg", "SEARCH-SUCCESS");
			
			obj.put("name",allBean[0]);
			obj.put("email",allBean[1]);
			obj.put("birthDate",allBean[2]);
			obj.put("phone",allBean[3]);
			obj.put("address",allBean[4]);
			obj.put("englishName",allBean[5]);
			obj.put("gender",allBean[6]);
		}
		else
		{
			obj.put("msg", "SEARCH-FAIL");
		}
		
		PrintWriter writer = null;
		try {
			writer = response.getWriter();
			writer.println(obj);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	/**
	 * 병역사항 조회 
	 * @param session 세션객체 
	 * @param response 응답객체 
	 */
	@RequestMapping(value = "/searchMilitary.do")
	public void searchMilitary(HttpSession session, HttpServletResponse response){
		System.out.println("searchMilitary() 호출");
		
		String id = "yeeee4";
		MilitaryDTO militaryDTO = militaryDAO.selectMilitaryByID(id);
		
		/*
		 * VO를 Bean을 변환 
		 */
		String[] all = militaryDTO.getAll();
		MilitaryBean militaryBean 
			= new MilitaryBean(all[1], all[2], all[3], all[4], all[5], all[6], all[7]);
		
		String[] allBean = militaryBean.getAll();
		JSONObject obj = new JSONObject();
		
		if(militaryDTO != null)
		{
			obj.put("msg", "SEARCH-SUCCESS");
			
			obj.put("military_select",allBean[0]);
			obj.put("startDate",allBean[1]);
			obj.put("endDate",allBean[2]);
			obj.put("militaryCategoryCode",allBean[3]);
			obj.put("militaryCategory",allBean[4]);
			obj.put("militaryRankCode",allBean[5]);
			obj.put("militaryRank",allBean[6]);
		}
		else
		{
			obj.put("msg", "SEARCH-FAIL");
		}
		PrintWriter writer = null;
		try {
			response.setContentType("text/html; charset=UTF-8");
			writer = response.getWriter();
			writer.println(obj);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	/**
	 * 보훈 장애사항 조회 
	 * @param session 세션객체 
	 * @param response 응답객체 
	 */
	@RequestMapping(value = "/searchUnusual.do")
	public void searchUnusual(HttpSession session, HttpServletResponse response){
		System.out.println("searchUnusual() 호출");
		
		String id = "yeeee4";
		UnusualDTO unusualDTO = unusualDAO.selectUnusualByID(id);
		
		/*
		 * VO를 Bean을 변환 
		 */
		String[] all = unusualDTO.getAll();
		UnusualBean unusualBean = new UnusualBean(all[1], all[2], all[3], all[4]);
		
		String[] allBean = unusualBean.getAll();
		JSONObject obj = new JSONObject();

		if(unusualDTO != null)
		{
			obj.put("msg", "SEARCH-SUCCESS");
			
			obj.put("isRewarded",allBean[0]);
			obj.put("isDisabled",allBean[1]);
			obj.put("disabilityCode",allBean[2]);
			obj.put("disability",allBean[3]);
		}
		else
		{
			obj.put("msg", "SEARCH-FAIL");
		}
		PrintWriter writer = null;
		try {
			response.setContentType("text/html; charset=UTF-8");
			writer = response.getWriter();
			writer.println(obj);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	/**
	 * 사진 업로드 
	 * @param session 세션객체 
	 * @param request 요청객체 
	 * @param response 응답객체 
	 */
	@RequestMapping(value = "/uploadPhoto.do", method=RequestMethod.POST)
	public void uploadPhoto(HttpSession session, HttpServletRequest request, HttpServletResponse response){
		String id = "yeeee4";
		
		int maxSize = 5 * 1024 * 1024;
	    String path = request.getServletContext().getRealPath("/");
	    System.out.println("request: " + request.getContentType());
	    
	    StringTokenizer token = new StringTokenizer(request.getContentType());

	    String photoPath = null;
	     if(token.nextToken(";").equals("multipart/form-data"))
	     {
	        MultipartRequest mRequest = null;
			try {
				mRequest = new MultipartRequest(request, path, maxSize, "UTF-8", new MyFileRenamePolicy(id));
				System.out.println("mRequest : " + mRequest);
			} catch (IOException e) {
				e.printStackTrace();
			}
			boolean res = false;
	        if(mRequest.getFile("uploadfile") != null)
	        {
	        	Enumeration  e = mRequest.getFileNames();
	        	
	        	if(e.hasMoreElements()) {
	                String strName = (String) e.nextElement();
	                photoPath= mRequest.getFilesystemName(strName);
	        	}
	           System.out.println("photoPath:" + photoPath);
	        	res = personalInfoDAO.updatePersonalInfo(id, photoPath);
	        }
	        PrintWriter writer = null;
			try {
				response.setContentType("text/html; charset=UTF-8");
				writer = response.getWriter();
				
				if(res)
					writer.println("UPLOAD-SUCCESS");
				else
					writer.println("UPLOAD-FAIL");

			} catch (IOException e) {
				e.printStackTrace();
			}
	     }
	}
	/**
	 * 사진 삭제 
	 * @param session 세션객체 
	 * @param request 요청객체 
	 * @param response 응답객체 
	 */
	@RequestMapping(value = "/deletePhoto.do")
	public void deletePhoto(HttpSession session, HttpServletRequest request, HttpServletResponse response){
		System.out.println("deletePhoto");
		String id = "yeeee4";
		boolean res = personalInfoDAO.updatePersonalInfo(id, null);
			PrintWriter writer = null;
			try {
				response.setContentType("text/html; charset=UTF-8");
				writer = response.getWriter();
				
				if(res)
					writer.println("DELETE-SUCCESS");
				else
					writer.println("DELETE-FAIL");
				
			} catch (IOException e) {
				e.printStackTrace();
			}
	}
}
