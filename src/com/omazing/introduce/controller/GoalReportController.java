package com.omazing.introduce.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.StringTokenizer;

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

import com.omazing.introduce.bean.PersonalReportBean;
import com.omazing.introduce.dao.PersonalReportDAO;
import com.omazing.introduce.dto.PersonalReportDTO;

/**
 * 비전및목표 컨트롤러
 * @author nam
 */
@Controller
public class GoalReportController {
	
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
	 * 비전 및 목표를 등록하는 메소드
	 * @param response 응답객체
	 * @param goals 비전 및 목표들
	 * @param memberID 회원ID
	 * @throws IOException 요청,응답객체에서 발생하는 익셉션
	 * @throws ServletException DAO메소드를 성공하지 못했을 때 발생하는 익셉션
	 */
	@RequestMapping(value="/goalreport.do", method=RequestMethod.GET)
	public void insertGoal(HttpServletResponse response
			,@RequestParam("goal") String[] goals,@RequestParam("memberID") String memberID) throws IOException, ServletException{
		response.setCharacterEncoding("utf-8");
		out = response.getWriter();
		
		 if(goals!=null){
			String goalWithSlash="";
			int cnt=1;
				for(String tmp : goals){
					goalWithSlash+=tmp;
					if(cnt<goals.length){
						goalWithSlash+="/";
					}
					cnt++;
				}
				
				PersonalReportBean bean = new PersonalReportBean(null, null, goalWithSlash);
				String[] all = bean.getAll();
				dto = new PersonalReportDTO(memberID, all[0], all[1], all[2]);
			try {
				if (dao.selectPersonalReport(memberID) == null) {
					dao.insertPersonalReport(memberID);
				}
				boolean res = dao.updateGoalReport(memberID, dto.getGoal());
				if (res == true) {
					out.println("비전및목표 등록 성공!!");
				} else {
					out.println("비전및목표 등록 실패!!");
				}
			} catch (SQLException e) {
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
	@RequestMapping(value="/goalpage.do", method=RequestMethod.GET)
	public void gotoGoalPage(HttpServletRequest request, HttpServletResponse response
			,@RequestParam("type") String type) throws IOException, ServletException{
		RequestDispatcher view = request.getRequestDispatcher("/resources/views/goal_report.jsp");
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
	 * 저장된 비전 및 목표를 불러오는 메소드
	 * @param response 응답객체
	 * @param memberID 회원ID
	 * @throws IOException 요청,응답객체에서 발생하는 익셉션
	 * @throws ServletException DAO메소드를 성공하지 못했을 때 발생하는 익셉션
	 */
	@RequestMapping(value="/goalload.do", method=RequestMethod.GET)
	public void selectGoal(HttpServletResponse response
			,@RequestParam("id") String memberID) throws IOException, ServletException{
		response.setCharacterEncoding("utf-8");
		out = response.getWriter();
		
		if (memberID != null) {
			try {
				dto = dao.selectPersonalReport(memberID);
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			if(dto!=null && dto.getGoal()!=null){
			String[] all = dto.getAll();
			PersonalReportBean bean = new PersonalReportBean(all[1], all[2], all[3]);
			JSONObject obj = new JSONObject();
			JSONArray ary = new JSONArray();
				StringTokenizer tok = new StringTokenizer(bean.getGoal(), "/");
				while(tok.hasMoreTokens()){
					ary.add(tok.nextToken());
				}
				obj.put("goal", ary);
				out.println(obj);
				System.out.println(obj);
			} else {
				System.out.println("저장된게 없으");
			}
			out.flush();
			out.close();
		}
	}
	
	/**
	 * 비전 및 목표를 삭제하는 메소드
	 * @param response 응답객체
	 * @param memberID 회원ID
	 * @throws IOException 요청,응답객체에서 발생하는 익셉션
	 * @throws ServletException DAO메소드를 성공하지 못했을 때 발생하는 익셉션
	 */
	@RequestMapping(value="/goaldel.do", method=RequestMethod.POST)
	public void deleteGoal(HttpServletResponse response
			,@RequestParam("id") String memberID) throws IOException, ServletException{
		response.setCharacterEncoding("utf-8");
		out = response.getWriter();
		
		if (memberID != null) {
				try {
					if(dao.deleteGoalReport(memberID)){
						out.println("비전및목표 삭제 성공!");
						out.flush();
						out.close();
						return;
					}
					else{
						out.println("비전및목표 삭제 실패!");
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
