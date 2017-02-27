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

import com.omazing.resume.bean.AwardBean;
import com.omazing.resume.bean.AwardCategoryBean;
import com.omazing.resume.bean.AwardFieldBean;
import com.omazing.resume.bean.CareerBean;
import com.omazing.resume.bean.CertificateBean;
import com.omazing.resume.bean.LanguageExamBean;
import com.omazing.resume.dao.AwardDAO;
import com.omazing.resume.dao.CareerDAO;
import com.omazing.resume.dao.CertificateDAO;
import com.omazing.resume.dao.LanguageExamDAO;
import com.omazing.resume.dto.AwardCategoryDTO;
import com.omazing.resume.dto.AwardDTO;
import com.omazing.resume.dto.AwardFieldDTO;
import com.omazing.resume.dto.CareerDTO;
import com.omazing.resume.dto.CertificateDTO;
import com.omazing.resume.dto.LanguageExamDTO;
import com.omazing.resume.vo.AwardVO;
import com.omazing.resume.vo.CareerVO;
import com.omazing.resume.vo.CertificateVO;
import com.omazing.resume.vo.LanguageExamVO;

@Controller
public class CareerInfoController {
	@Autowired
	private AwardDAO awardDAO;
	@Autowired
	private CareerDAO careerDAO;
	@Autowired
	private CertificateDAO certificateDAO;
	@Autowired
	private LanguageExamDAO languageExamDAO;
	/**
	 * 경력사항(직무경력)
	 */
	@RequestMapping(value = "/addAward.do", method=RequestMethod.POST)
	public void insertAward(@ModelAttribute AwardBean formData, @ModelAttribute AwardCategoryBean acb,
			 @ModelAttribute AwardFieldBean afb,
			 HttpServletResponse response){
		String id = "yeeee4";
		JSONObject json = new JSONObject();
		int registerNo = 0;
		System.out.println(formData);
		System.out.println(acb);
		System.out.println(afb);
		String category = formData.getCategory();
		String field = formData.getField();
		String target = formData.getTarget();
		String name = formData.getName();
		String date = formData.getDate();
		String publication = formData.getPublication();
		String content = formData.getContent();
		
		AwardBean inBean = new AwardBean(category, field, target, name, 
				date, publication, content, "0");
	    System.out.println(inBean);
		AwardVO vo = null;
		AwardDTO dto = null;
		vo = new AwardVO(acb.getCategoryCode(), category, afb.getFieldCode(), field, 
				target, name, date, publication, content, Integer.parseInt(inBean.getRegisterNo()), id);
		dto = new AwardDTO(new AwardCategoryDTO(vo.getCategoryCode(), vo.getCategory()), 
				new AwardFieldDTO(vo.getFieldCode(), vo.getField(), vo.getCategoryCode()), 
				vo.getTarget(), vo.getName(), vo.getDate(), vo.getPublication(), 
				vo.getContent(), vo.getRegisterNo(), vo.getMemberID());
		System.out.println(dto);
		awardDAO.insertAward(dto);
		registerNo = awardDAO.getNewRegisterNo();
		
		String[] display = inBean.getAll();
		json.put("category", display[0]);
		json.put("field",display[1]);
		json.put("target", display[2]);
		json.put("name",display[3]);
		json.put("date", display[4]);
		json.put("publication", display[5]);
		json.put("content", display[6]);
		json.put("registerNo", Integer.toString(registerNo));
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
	@RequestMapping(value = "/editAward.do", method=RequestMethod.POST)
	public void editAward(@ModelAttribute AwardBean formData,
			@RequestParam String categoryCode, @RequestParam String fieldCode,
			 HttpServletResponse response){
		String id = "yeeee4";
		JSONObject json = new JSONObject();
		System.out.println(formData);
		String category = formData.getCategory();
		String field = formData.getField();
		String target = formData.getTarget();
		String name = formData.getName();
		String date = formData.getDate();
		String publication = formData.getPublication();
		String content = formData.getContent();
		String registerNo = formData.getRegisterNo();
		
		AwardBean inBean = new AwardBean(category, field, target, name, 
				date, publication, content, registerNo);
	    System.out.println(inBean);
		AwardVO vo = null;
		AwardDTO dto = null;
		vo = new AwardVO(categoryCode, category, fieldCode, field, 
				target, name, date, publication, content, Integer.parseInt(inBean.getRegisterNo()), id);
		dto = new AwardDTO(new AwardCategoryDTO(vo.getCategoryCode(), vo.getCategory()), 
				new AwardFieldDTO(vo.getFieldCode(), vo.getField(), vo.getCategoryCode()), 
				vo.getTarget(), vo.getName(), vo.getDate(), vo.getPublication(), 
				vo.getContent(), vo.getRegisterNo(), vo.getMemberID());
		System.out.println(dto);
		awardDAO.updateAward(dto);
		
		String[] display = inBean.getAll();
		json.put("category", display[0]);
		json.put("field",display[1]);
		json.put("target", display[2]);
		json.put("name",display[3]);
		json.put("date", display[4]);
		json.put("publication", display[5]);
		json.put("content", display[6]);
		json.put("registerNo", display[7]);
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
	@RequestMapping(value = "/deleteAward.do", method=RequestMethod.POST)
	public void deleteAward(@RequestParam String registerNo
			,  HttpServletResponse response){
		String id = "yeeee4";
		JSONObject json = new JSONObject();
		
		String key = registerNo;
		System.out.println(key);
		
		awardDAO.deleteAward(id, Integer.parseInt(key));
		
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
	/**
	 * 경력사항(직무경력)
	 */
	@RequestMapping(value = "/addCareer.do", method=RequestMethod.POST)
	public void insertCareer(@ModelAttribute CareerBean formData
			,  HttpServletResponse response){
		String id = "yeeee4";
		JSONObject json = new JSONObject();
		int registerNo;
		System.out.println(formData);
		String name = formData.getName();
		String startDate = formData.getStartDate();
		String endDate = formData.getEndDate();
		String position = formData.getPosition();
		String department = formData.getDepartment();
		String task = formData.getTask();
		String reason = formData.getRetirementReason();
		
		CareerBean inBean = new CareerBean(name, startDate, endDate, position, department, task, 
				reason, "");
	    System.out.println(inBean);
		CareerVO vo = null;
		CareerDTO dto = null;
		dto = new CareerDTO(inBean.getName(), inBean.getStartDate(), 
				inBean.getEndDate(), inBean.getPosition(), 
				inBean.getDepartment(), inBean.getTask(), 
				inBean.getRetirementReason(), 0, id);
		System.out.println(dto);
		careerDAO.insertCareer(dto);
		registerNo = careerDAO.getNewRegisterNo();
		
		String[] display = inBean.getAll();
		json.put("name", display[0]);
		json.put("startDate",display[1]);
		json.put("endDate", display[2]);
		json.put("position",display[3]);
		json.put("department", display[4]);
		json.put("task", display[5]);
		json.put("reason", display[6]);
		json.put("registerNo", registerNo);
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
	@RequestMapping(value = "/editCareer.do", method=RequestMethod.POST)
	public void editCareer(@ModelAttribute CareerBean formData
			,  HttpServletResponse response){
		String id = "yeeee4";
		JSONObject json = new JSONObject();
		
		System.out.println(formData);
		String name = formData.getName();
		String startDate = formData.getStartDate();
		String endDate = formData.getEndDate();
		String position = formData.getPosition();
		String department = formData.getDepartment();
		String task = formData.getTask();
		String reason = formData.getRetirementReason();
		String registerNo = formData.getRegisterNo();
		
	    System.out.println(formData);
		CareerVO vo = null;
		CareerDTO dto = null;
		dto = new CareerDTO(formData.getName(), formData.getStartDate(), 
				formData.getEndDate(), formData.getPosition(), 
				formData.getDepartment(), formData.getTask(), 
				formData.getRetirementReason(), Integer.parseInt(registerNo), id);
		System.out.println(dto);
		careerDAO.updateCareer(dto);
		
		CareerBean inBean = new CareerBean(name, startDate, 
				endDate, position, 
				department, task, 
				reason, registerNo);
		
		String[] display = inBean.getAll();
		json.put("name", display[0]);
		json.put("startDate",display[1]);
		json.put("endDate", display[2]);
		json.put("position",display[3]);
		json.put("department", display[4]);
		json.put("task", display[5]);
		json.put("reason", display[6]);
		json.put("registerNo", display[7]);
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
	@RequestMapping(value = "/deleteCareer.do", method=RequestMethod.POST)
	public void deleteCareer(@RequestParam String registerNo
			,  HttpServletResponse response){
		String id = "yeeee4";
		JSONObject json = new JSONObject();
		
		String key = registerNo;
		System.out.println(key);
		
		careerDAO.deleteCareer(id, Integer.parseInt(key));
		
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
	/**
	 * 경력사항(자격증)
	 */
	@RequestMapping(value = "/addCertificate.do", method=RequestMethod.POST)
	public void insertCertificate(@ModelAttribute CertificateBean formData
			,  HttpServletResponse response){
		String id = "yeeee4";
		JSONObject json = new JSONObject();
		int registerNo;
		System.out.println(formData);
		String name = formData.getName();
		String date = formData.getDate();
		String publication = formData.getPublication();
		
		CertificateBean inBean = new CertificateBean(name, date, publication, "");
	    System.out.println(inBean);
		CertificateVO vo = null;
		CertificateDTO dto = null;
		dto = new CertificateDTO(inBean.getName(), inBean.getDate(),  
				inBean.getPublication(), 0, id);
		System.out.println(dto);
		certificateDAO.insertCertificate(dto);
		registerNo = certificateDAO.getNewRegisterNo();
		
		String[] display = inBean.getAll();
		json.put("name", display[0]);
		json.put("date",display[1]);
		json.put("publication", display[2]);
		json.put("registerNo", registerNo);
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
	@RequestMapping(value = "/editCertificate.do", method=RequestMethod.POST)
	public void editCertificate(@ModelAttribute CertificateBean formData
			,  HttpServletResponse response){
		String id = "yeeee4";
		JSONObject json = new JSONObject();
		
		System.out.println(formData);
		String name = formData.getName();
		String date = formData.getDate();
		String publication = formData.getPublication();
		String registerNo = formData.getRegisterNo();
		
	    System.out.println(formData);
		CertificateVO vo = null;
		CertificateDTO dto = null;
		dto = new CertificateDTO(formData.getName(), formData.getDate(), 
				formData.getPublication(), Integer.parseInt(registerNo), id);
		System.out.println(dto);
		certificateDAO.updateCertificate(dto);
		
		CertificateBean inBean = new CertificateBean(name, date, 
				publication, registerNo);
		
		String[] display = inBean.getAll();
		json.put("name", display[0]);
		json.put("date",display[1]);
		json.put("publication", display[2]);
		json.put("registerNo", display[3]);
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
	@RequestMapping(value = "/deleteCertificate.do", method=RequestMethod.POST)
	public void deleteCertificate(@RequestParam String registerNo
			,  HttpServletResponse response){
		String id = "yeeee4";
		JSONObject json = new JSONObject();
		
		String key = registerNo;
		System.out.println(key);
		
		certificateDAO.deleteCertificate(id, Integer.parseInt(key));
		
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
	/**
	 * 경력사항(어학시험)
	 */
	@RequestMapping(value = "/addLanguageExam.do", method=RequestMethod.POST)
	public void insertLanguageExam(@ModelAttribute LanguageExamBean formData
			,  HttpServletResponse response){
		String id = "yeeee4";
		JSONObject json = new JSONObject();
		int registerNo;
		System.out.println(formData);
		String name = formData.getName();
		String date = formData.getDate();
		String grade = formData.getGrade();
		
		LanguageExamBean inBean = new LanguageExamBean(name, date, grade, "");
	    System.out.println(inBean);
	    LanguageExamVO vo = null;
	    LanguageExamDTO dto = null;
		dto = new LanguageExamDTO(inBean.getName(), inBean.getDate(),  
				inBean.getGrade(), 0, id);
		System.out.println(dto);
		languageExamDAO.insertLanguageExam(dto);
		registerNo = languageExamDAO.getNewRegisterNo();
		
		String[] display = inBean.getAll();
		json.put("name", display[0]);
		json.put("date",display[1]);
		json.put("grade", display[2]);
		json.put("registerNo", registerNo);
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
	@RequestMapping(value = "/editLanguageExam.do", method=RequestMethod.POST)
	public void editLanguageExam(@ModelAttribute LanguageExamBean formData
			,  HttpServletResponse response){
		String id = "yeeee4";
		JSONObject json = new JSONObject();
		
		System.out.println(formData);
		String name = formData.getName();
		String date = formData.getDate();
		String grade = formData.getGrade();
		String registerNo = formData.getRegisterNo();
		
	    System.out.println(formData);
	    LanguageExamVO vo = null;
	    LanguageExamDTO dto = null;
		dto = new LanguageExamDTO(formData.getName(), formData.getDate(), 
				formData.getGrade(), Integer.parseInt(registerNo), id);
		System.out.println(dto);
		languageExamDAO.updateLanguageExam(dto);
		
		LanguageExamBean inBean = new LanguageExamBean(name, date, 
				grade, registerNo);
		
		String[] display = inBean.getAll();
		json.put("name", display[0]);
		json.put("date",display[1]);
		json.put("grade", display[2]);
		json.put("registerNo", display[3]);
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
	@RequestMapping(value = "/deleteLanguageExam.do", method=RequestMethod.POST)
	public void deleteLanguageExam(@RequestParam String registerNo
			,  HttpServletResponse response){
		String id = "yeeee4";
		JSONObject json = new JSONObject();
		
		String key = registerNo;
		System.out.println(key);
		
		languageExamDAO.deleteLanguageExam(id, Integer.parseInt(key));
		
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
