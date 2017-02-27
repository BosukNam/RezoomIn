package com.omazing.resume.controller;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.omazing.resume.bean.ActivityBean;
import com.omazing.resume.bean.AwardBean;
import com.omazing.resume.dao.ActivityDAO;
import com.omazing.resume.dto.ActivityCategoryDTO;
import com.omazing.resume.dto.ActivityDTO;
import com.omazing.resume.dto.AwardCategoryDTO;
import com.omazing.resume.dto.AwardDTO;
import com.omazing.resume.dto.AwardFieldDTO;
import com.omazing.resume.vo.ActivityVO;
import com.omazing.resume.vo.AwardVO;

@Controller
public class CommunityExperienceController {
	@Autowired
	private ActivityDAO activityDAO;
	@RequestMapping(value ="/addForeignStudy.do", method=RequestMethod.POST)
	public void insertForeignStudy(@ModelAttribute ActivityBean formData,
			@RequestParam String categoryCode, HttpServletResponse response){
		String id = "yeeee4";
		JSONObject json = new JSONObject();
		int registerNo = 0;
		System.out.println(formData);
		String category = formData.getCategory();
		String startDate = formData.getStartDate();
		String endDate = formData.getEndDate();
		String content = formData.getContent();
		
		ActivityVO tmpVO = new ActivityVO(categoryCode, category, startDate,
				endDate, content, registerNo, id);
		ActivityDTO dto = null;
		dto = new ActivityDTO(new ActivityCategoryDTO(tmpVO.getCategoryCode(), tmpVO.getCategory()), 
				tmpVO.getStartDate(), tmpVO.getEndDate(), 
				tmpVO.getContent(), tmpVO.getRegisterNo(), tmpVO.getMemberID());
		activityDAO.insertActivity(dto);
		
		registerNo = activityDAO.getNewRegisterNo();
		
		ActivityVO resVO = tmpVO;
		ActivityBean inBean = new ActivityBean(resVO.getCategory(),
				resVO.getStartDate(), resVO.getEndDate(), 
				resVO.getContent(), Integer.toString(registerNo));

		String[] display = inBean.getAll();
		json.put("category", display[0]);
		json.put("startDate",display[1]);
		json.put("endDate", display[2]);
		json.put("content", display[3]);
		json.put("registerNo", display[4]);
		System.out.println(json);
		try {
			response.setCharacterEncoding("UTF-8");
			PrintWriter out = response.getWriter();
			out.println(json);
			out.flush();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@RequestMapping(value ="/editForeignStudy.do", method=RequestMethod.POST)
	public void updateForeignStudy(@ModelAttribute ActivityBean formData,
			@RequestParam String categoryCode, HttpServletResponse response){
		String id = "yeeee4";
		JSONObject json = new JSONObject();
		System.out.println(formData);
		String category = formData.getCategory();
		String startDate = formData.getStartDate();
		String endDate = formData.getEndDate();
		String content = formData.getContent();
		String registerNo = formData.getRegisterNo();
		
		ActivityVO tmpVO = new ActivityVO(categoryCode, category, startDate,
				endDate, content, Integer.parseInt(registerNo), id);
		ActivityDTO dto = null;
		dto = new ActivityDTO(new ActivityCategoryDTO(tmpVO.getCategoryCode(), tmpVO.getCategory()), 
				tmpVO.getStartDate(), tmpVO.getEndDate(), 
				tmpVO.getContent(), tmpVO.getRegisterNo(), tmpVO.getMemberID());
		activityDAO.updateActivity(dto);
		
		ActivityVO resVO = tmpVO;
		ActivityBean inBean = new ActivityBean(resVO.getCategory(),
				resVO.getStartDate(), resVO.getEndDate(), 
				resVO.getContent(), Integer.toString(resVO.getRegisterNo()));

		String[] display = inBean.getAll();
		json.put("category", display[0]);
		json.put("startDate",display[1]);
		json.put("endDate", display[2]);
		json.put("content", display[3]);
		json.put("registerNo", display[4]);
		System.out.println(json);
		try {
			response.setCharacterEncoding("UTF-8");
			PrintWriter out = response.getWriter();
			out.println(json);
			out.flush();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@RequestMapping(value ="/deleteForeignStudy.do", method=RequestMethod.POST)
	public void deleteForeignStudy(@RequestParam String registerNo
			,  HttpServletResponse response){
		String id = "yeeee4";
		JSONObject json = new JSONObject();
		
		String key = registerNo;
		System.out.println(key);
		
		activityDAO.deleteActivity(id, Integer.parseInt(key));
		
		json.put("registerNo", key);
		json.put("result", "삭제 성공");
		System.out.println(json);
		
		try {
			response.setCharacterEncoding("UTF-8");
			PrintWriter out = response.getWriter();
			out.println(json);
			out.flush();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@RequestMapping(value ="/addActivity.do", method=RequestMethod.POST)
	public void insertActivity(@ModelAttribute ActivityBean formData,
			@RequestParam String categoryCode, HttpServletResponse response){
		String id = "yeeee4";
		JSONObject json = new JSONObject();
		int registerNo = 0;
		System.out.println(formData);
		String category = formData.getCategory();
		String startDate = formData.getStartDate();
		String endDate = formData.getEndDate();
		String content = formData.getContent();
		
		ActivityVO tmpVO = new ActivityVO(categoryCode, category, startDate,
				endDate, content, registerNo, id);
		ActivityDTO dto = null;
		dto = new ActivityDTO(new ActivityCategoryDTO(tmpVO.getCategoryCode(), tmpVO.getCategory()), 
				tmpVO.getStartDate(), tmpVO.getEndDate(), 
				tmpVO.getContent(), tmpVO.getRegisterNo(), tmpVO.getMemberID());
		activityDAO.insertActivity(dto);
		
		registerNo = activityDAO.getNewRegisterNo();
		
		ActivityVO resVO = tmpVO;
		ActivityBean inBean = new ActivityBean(tmpVO.getCategory(),
				tmpVO.getStartDate(), tmpVO.getEndDate(), 
				tmpVO.getContent(), Integer.toString(registerNo));

		String[] display = inBean.getAll();
		json.put("category", display[0]);
		json.put("startDate",display[1]);
		json.put("endDate", display[2]);
		json.put("content", display[3]);
		json.put("registerNo", display[4]);
		System.out.println(json);
		try {
			response.setCharacterEncoding("UTF-8");
			PrintWriter out = response.getWriter();
			out.println(json);
			out.flush();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@RequestMapping(value ="/editActivity.do", method=RequestMethod.POST)
	public void updateActivity(@ModelAttribute ActivityBean formData,
			@RequestParam String categoryCode, HttpServletResponse response){
		String id = "yeeee4";
		JSONObject json = new JSONObject();
		System.out.println(formData);
		String category = formData.getCategory();
		String startDate = formData.getStartDate();
		String endDate = formData.getEndDate();
		String content = formData.getContent();
		String registerNo = formData.getRegisterNo();
		
		ActivityVO tmpVO = new ActivityVO(categoryCode, category, startDate,
				endDate, content, Integer.parseInt(registerNo), id);
		ActivityDTO dto = null;
		dto = new ActivityDTO(new ActivityCategoryDTO(tmpVO.getCategoryCode(), tmpVO.getCategory()), 
				tmpVO.getStartDate(), tmpVO.getEndDate(), 
				tmpVO.getContent(), tmpVO.getRegisterNo(), tmpVO.getMemberID());
		activityDAO.updateActivity(dto);
		
		ActivityVO resVO = tmpVO;
		ActivityBean inBean = new ActivityBean(resVO.getCategory(),
				resVO.getStartDate(), resVO.getEndDate(), 
				resVO.getContent(), Integer.toString(resVO.getRegisterNo()));

		String[] display = inBean.getAll();
		json.put("category", display[0]);
		json.put("startDate",display[1]);
		json.put("endDate", display[2]);
		json.put("content", display[3]);
		json.put("registerNo", display[4]);
		System.out.println(json);
		try {
			response.setCharacterEncoding("UTF-8");
			PrintWriter out = response.getWriter();
			out.println(json);
			out.flush();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@RequestMapping(value ="/deleteActivity.do", method=RequestMethod.POST)
	public void deleteActivity(@RequestParam String registerNo
			,  HttpServletResponse response){
		String id = "yeeee4";
		JSONObject json = new JSONObject();
		
		String key = registerNo;
		System.out.println(key);
		
		activityDAO.deleteActivity(id, Integer.parseInt(key));
		
		json.put("registerNo", key);
		json.put("result", "삭제 성공");
		System.out.println(json);
		
		try {
			response.setCharacterEncoding("UTF-8");
			PrintWriter out = response.getWriter();
			out.println(json);
			out.flush();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
