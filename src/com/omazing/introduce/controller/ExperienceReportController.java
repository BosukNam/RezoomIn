package com.omazing.introduce.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.Iterator;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
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
import com.omazing.introduce.dao.ExperienceReportDAO;
import com.omazing.introduce.dto.ExperienceReportDTO;

/**
 * 극복과정 컨트롤러
 * @author nam
 */
@Controller
public class ExperienceReportController {
	
	/**
	 * SQL세션객체
	 */
	@Autowired
	private SqlSession sqlSession;
	/**
	 * 화면전송객체
	 */
	private PrintWriter out;
	/**
	 * 극복과정 DAO
	 */
	@Autowired
	private ExperienceReportDAO dao;
	/**
	 * 극복과정 DTO
	 */
	private ExperienceReportDTO dto;

	/**
	 * 극복과정을 등록하는 메소드
	 * @param response 응답객체
	 * @param problems 문제및난관들
	 * @param experiences 극복과정들
	 * @param memberID 회원ID
	 * @throws IOException 요청,응답객체에서 발생하는 익셉션
	 * @throws ServletException DAO메소드를 성공하지 못했을 때 발생하는 익셉션
	 */
	@RequestMapping(value="/experiencereport.do", method=RequestMethod.POST)
	public void insertExperience(HttpServletResponse response
			,@RequestParam("problem") String[] problems,@RequestParam("overcome") String[] experiences
			,@RequestParam("memberID") String memberID) throws IOException, ServletException{
		response.setCharacterEncoding("utf-8");
		out = response.getWriter();

		if(problems!=null){
			ExperienceReportBean bean =null;
			
			// 인서트 방식이기 때문에 화면에 보이는 것만 저장하려면, 이미 저장된 값들을 지워줘야한다..
			try {
				dao.deleteExperienceReportAll(memberID);
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			for (int i = 0; i < problems.length; i++) {
//				out.println(problems[i]);
//				out.println(overcomes[i]);
				bean = new ExperienceReportBean(null, problems[i], experiences[i]);
				String[] all = bean.getAll();
				dto = new ExperienceReportDTO(memberID, all[1], all[2]);
				
				try {
					if(dao.insertExperienceReport(dto)){
						out.println("극복과정 등록 성공!!");
					}else{
						out.println("극복과정 등록 실패!!");
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	/**
	 * 페이지 이동을 시켜주는 메소드
	 * @param request 요청객체
	 * @param response 응답객체 
	 * @param type 추가,로딩 종류
	 * @throws IOException 요청,응답객체에서 발생하는 익셉션
	 * @throws ServletException DAO메소드를 성공하지 못했을 때 발생하는 익셉션
	 */
	@RequestMapping(value="/experiencepage.do", method=RequestMethod.GET)
	public void gotoExperiencePage(HttpServletRequest request, HttpServletResponse response
			,@RequestParam("type") String type) throws IOException, ServletException{
		RequestDispatcher view = request.getRequestDispatcher("/resources/views/experience_report.jsp");
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");

		if(type.equals("load")){
			request.setAttribute("from", "load");
			view.forward(request, response);
		}
		else{
			request.setAttribute("from", "new");
			view.forward(request, response);
		}
	}
	
	/**
	 * 저장된 극복과정을 불러오는 메소드
	 * @param response 응답객체
	 * @param memberID 회원ID
	 * @throws IOException 요청,응답객체에서 발생하는 익셉션
	 * @throws ServletException DAO메소드를 성공하지 못했을 때 발생하는 익셉션
	 */
	@RequestMapping(value="/experienceload.do", method=RequestMethod.GET)
	public void selectExperience(HttpServletResponse response
			,@RequestParam("id") String memberID) throws IOException, ServletException{
		response.setCharacterEncoding("utf-8");
		out = response.getWriter();

		if (memberID != null) {
			Iterator<ExperienceReportDTO> iter = null;
			try {
				iter = dao.selectExperienceReportAll(memberID);
			} catch (SQLException e1) {
				e1.printStackTrace();
			}

			try {
				JSONObject obj = new JSONObject();
				JSONArray overcome = new JSONArray();
				JSONObject record = null;
				ExperienceReportBean bean = null;
				while (iter.hasNext()) {
					dto = iter.next();
					String[] all = dto.getAll();
					bean = new ExperienceReportBean(all[1], all[2], all[3]);
					record = new JSONObject();
					record.put("registerNo", bean.getRegisterNo());
					record.put("title", bean.getTitle());
					record.put("content", bean.getContent());
					overcome.add(record);
				}
				obj.put("overcome", overcome);
				out.println(obj);
				out.flush();
				out.close();

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	/**
	 * 극복과정을 삭제하는 메소드
	 * @param response 응답객체
	 * @param memberID 회원ID
	 * @throws IOException 요청,응답객체에서 발생하는 익셉션
	 * @throws ServletException DAO메소드를 성공하지 못했을 때 발생하는 익셉션
	 */
	@RequestMapping(value="/experiencedel.do", method=RequestMethod.POST)
	public void deleteExperience(HttpServletResponse response
			,@RequestParam("id") String memberID) throws IOException, ServletException{
		response.setCharacterEncoding("utf-8");
		out = response.getWriter();

		if (memberID != null) {
				try {
					if(dao.deleteExperienceReportAll(memberID)>0){
						out.println("극복과정 삭제 성공!");
						out.flush();
						out.close();
						return;
					}
					else{
						out.println("극복과정 삭제 실패!");
						out.flush();
						out.close();
						return;
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}
	}
}
