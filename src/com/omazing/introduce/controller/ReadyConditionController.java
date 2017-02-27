package com.omazing.introduce.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.omazing.introduce.bean.PersonalReportBean;
import com.omazing.introduce.dao.PersonalReportDAO;
import com.omazing.introduce.dto.PersonalReportDTO;

/**
 * 준비과정 컨트롤러
 * @author nam
 */
@Controller
public class ReadyConditionController {
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
	 * 장점,준비과정,비전및목표 DAO
	 */
	@Autowired
	private PersonalReportDAO dao;
	/**
	 * 장점,준비과정,비전및목표 DTO
	 */
	private PersonalReportDTO dto;

	/**
	 * 준비과정을 등록하는 메소드
	 * @param response 응답객체
	 * @param json 준비과정 내용이 저장된 객체
	 * @throws IOException 요청,응답객체에서 발생하는 익셉션
	 * @throws ServletException DAO메소드를 성공하지 못했을 때 발생하는 익셉션
	 */
	@RequestMapping(value="/readycondition.do", method=RequestMethod.GET)
	public void insertReady(HttpServletResponse response
			,@RequestParam("json") String json) throws IOException, ServletException{
		response.setCharacterEncoding("utf-8");
		out = response.getWriter();
		
		if(json!=null){
			JSONParser parser = new JSONParser();
			try {
				JSONObject inputObj = (JSONObject) parser.parse(json);
				String readyCondition = (String) inputObj.get("content");
				String memberID = (String) inputObj.get("id");
				PersonalReportBean bean = new PersonalReportBean(null, readyCondition, null);
				String[] all = bean.getAll();

				dto = new PersonalReportDTO(memberID, all[0], all[1], all[2]);
				try {
					if(dao.selectPersonalReport(memberID)==null){
						dao.insertPersonalReport(memberID);
					}
					boolean res = dao.updateReadyCondition(memberID, readyCondition);
					if(res==true){
						out.println("준비과정 등록 성공!!");
					}
					else{
						out.println("준비과정 등록 실패!!");
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
			} catch (ParseException e) {
				e.printStackTrace();
			}
			out.flush();
			out.close();
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
	@RequestMapping(value="/readypage.do", method=RequestMethod.GET)
	public void gotoReadyPage(HttpServletRequest request, HttpServletResponse response
			,@RequestParam("type") String type) throws IOException, ServletException{
		RequestDispatcher view = request.getRequestDispatcher("/resources/views/ready_condition.jsp");
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
	 * 저장된 준비과정을 불러오는 메소드
	 * @param response 응답객체
	 * @param memberID 회원ID
	 * @throws IOException 요청,응답객체에서 발생하는 익셉션
	 * @throws ServletException DAO메소드를 성공하지 못했을 때 발생하는 익셉션
	 */
	@RequestMapping(value="/readyload.do", method=RequestMethod.GET)
	public void selectReady(HttpServletResponse response
			,@RequestParam("id") String memberID) throws IOException, ServletException{
		response.setCharacterEncoding("utf-8");

		out = response.getWriter();
		
		if (memberID != null) {
			try {
				dto = dao.selectPersonalReport(memberID);
			} catch (SQLException e1) {
				e1.printStackTrace();
			}

			try {
				if (dto != null) {
					JSONObject obj = new JSONObject();
					String[] all = dto.getAll();
					PersonalReportBean bean = new PersonalReportBean(all[1], all[2], all[3]);
					obj.put("ready", bean.getReadyCondition());
					out.println(obj);
					System.out.println(obj);
				} else {
					System.out.println("저장된게 없으");
				}
				out.flush();
				out.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * 준비과정을 삭제하는 메소드
	 * @param response 응답객체
	 * @param memberID 회원ID
	 * @throws IOException 요청,응답객체에서 발생하는 익셉션
	 * @throws ServletException DAO메소드를 성공하지 못했을 때 발생하는 익셉션
	 */
	@RequestMapping(value="/readydel.do", method=RequestMethod.POST)
	public void deleteReady(HttpServletResponse response,
			@RequestParam("id") String memberID) throws IOException, ServletException{
		response.setCharacterEncoding("utf-8");
		
		out = response.getWriter();
		
		if (memberID != null) {
				try {
					if(dao.deleteReadyCondition(memberID)){
						out.println("준비과정 삭제 성공!");
						out.flush();
						out.close();
						return;
					}
					else{
						out.println("준비과정 삭제 실패!");
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
