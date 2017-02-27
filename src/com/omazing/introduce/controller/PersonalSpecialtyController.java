package com.omazing.introduce.controller;

import java.io.IOException;
import java.io.PrintWriter;
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

import com.omazing.introduce.bean.PersonalSpecialtyBean;
import com.omazing.introduce.dao.PersonalBiographyDAO;
import com.omazing.introduce.dto.PersonalSpecialtyDTO;
import com.omazing.introduce.model.PersonalSpecialtyVO;

/**
 * 성장과정 취미특기 컨트롤
 * @author nam
 */
@Controller
public class PersonalSpecialtyController {
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
	 * 성장과정 DAO
	 */
	@Autowired
	private PersonalBiographyDAO dao;
	/**
	 * 취미특기 DTO
	 */
	private PersonalSpecialtyDTO dto;
	/**
	 * 취미특기 VO
	 */
	private PersonalSpecialtyVO vo;

	/**
	 * 취미를 등록하는 메소드
	 * @param response 응답객체
	 * @param hobbies 취미명들
	 * @param hicons 취미아이콘들
	 * @param memberID 회원ID
	 * @throws IOException 요청,응답객체에서 발생하는 익셉션
	 * @throws ServletException DAO메소드를 성공하지 못했을 때 발생하는 익셉션
	 */
	@RequestMapping(value="/specialtyhobby.do", method=RequestMethod.GET)
	public void insertHobby(HttpServletResponse response
			,@RequestParam("hobby") String[] hobbies,@RequestParam("hicon") String[] hicons
			,@RequestParam("memberID") String memberID) throws IOException, ServletException{
		response.setCharacterEncoding("utf-8");
		out = response.getWriter();
		
		if(hobbies!=null){
			PersonalSpecialtyBean bean =null;
			
			try {
				System.out.println("취미등록하러 보내는 아이디여요~"+memberID);
				if(dao.selectPersonalBiography(memberID)==null){
					System.out.println("취미쪽인데, 부모가 없으니만들러가자~~"+memberID);
					dao.insertPersonalBiography(memberID);
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
			
			// 인서트 방식이기 때문에 화면에 보이는 것만 저장하려면, 이미 저장된 값들을 지워줘야한다..
			try {
				dao.deleteHobbyAll(memberID);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			
			for (int i=0; i<hobbies.length;i++) {
				bean = new PersonalSpecialtyBean(null,"hobby", hobbies[i], hicons[i]);
				String[] all = bean.getAll();
				vo = new PersonalSpecialtyVO(memberID, all[1], all[2], all[3]);
				String[] voAll = vo.getAll();
				dto = new PersonalSpecialtyDTO(voAll[0], voAll[2], voAll[3], voAll[4]);
				try {
					if(dao.insertPersonalSpecialty(dto)){
						out.println("취미 등록 성공!!");
					}else{
						out.println("취미 등록 실패!!");
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			out.flush();
			out.close();
		}
	}
	
	/**
	 * 특기를 등록하는 메소드
	 * @param response 응답객체
	 * @param skills 특기명들
	 * @param sicons 특기아이콘들
	 * @param memberID 회원ID
	 * @throws IOException 요청,응답객체에서 발생하는 익셉션
	 * @throws ServletException DAO메소드를 성공하지 못했을 때 발생하는 익셉션
	 */
	@RequestMapping(value="/specialtyskill.do", method=RequestMethod.GET)
	public void insertSkill(HttpServletResponse response
			,@RequestParam("skill") String[] skills,@RequestParam("sicon") String[] sicons
			,@RequestParam("memberID") String memberID) throws IOException, ServletException{
		response.setCharacterEncoding("utf-8");
		out = response.getWriter();
		
		if(skills!=null){
			PersonalSpecialtyBean bean =null;
			
			try {
				System.out.println("특기등록하러 보내는 아이디여요~"+memberID);
				if(dao.selectPersonalBiography(memberID)==null){
					System.out.println("특기쪽인데, 부모가 없으니만들러가자~~"+memberID);
					dao.insertPersonalBiography(memberID);
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
			
			
			// 인서트 방식이기 때문에 화면에 보이는 것만 저장하려면, 이미 저장된 값들을 지워줘야한다..
			try {
				dao.deleteSkillAll(memberID);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			
			for (int i=0; i<skills.length;i++) {
				bean = new PersonalSpecialtyBean(null,"skill", skills[i], sicons[i]);
				String[] all = bean.getAll();
				vo = new PersonalSpecialtyVO(memberID, all[1], all[2], all[3]);
				String[] voAll = vo.getAll();
				dto = new PersonalSpecialtyDTO(voAll[0], voAll[2], voAll[3], voAll[4]);
				try {
					if(dao.insertPersonalSpecialty(dto)){
						out.println("특기 등록 성공!!");
					}else{
						out.println("특기 등록 실패!!");
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
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
	@RequestMapping(value="/specialtypage.do", method=RequestMethod.GET)
	public void gotoSpecialtyPage(HttpServletRequest request, HttpServletResponse response
			,@RequestParam("type") String type) throws IOException, ServletException{
		RequestDispatcher view = request.getRequestDispatcher("/resources/views/personal_report.jsp");
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		out = response.getWriter();
		
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
	 * 저장된 취미특기를 불러오는 메소드
	 * @param response 응답객체
	 * @param memberID 회원ID
	 * @throws IOException 요청,응답객체에서 발생하는 익셉션
	 * @throws ServletException DAO메소드를 성공하지 못했을 때 발생하는 익셉션
	 */
	@RequestMapping(value="/specialtyload.do", method=RequestMethod.GET)
	public void selectSpecialty(HttpServletResponse response
			,@RequestParam("id") String memberID) throws IOException, ServletException{
		response.setCharacterEncoding("utf-8");
		out = response.getWriter();
		
		if (memberID != null) {
			System.out.println("취미특기 값이있는 아이디여요~"+memberID);
			Iterator<PersonalSpecialtyDTO> iter = null;
			try {
				iter = dao.selectPersonalSpecialtyAlltoIter(memberID);
				if(iter==null){
					out.flush();
					out.close();
				}
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			try {
				JSONObject obj = new JSONObject();
				JSONArray hobby = new JSONArray();
				JSONArray skill = new JSONArray();
				JSONObject record = null;
				JSONObject record2 = null;
				PersonalSpecialtyBean bean = null;
				while (iter.hasNext()) {
					dto = iter.next();
					String[] all = dto.getAll();
					vo = new PersonalSpecialtyVO(all[0], all[2], all[3], all[4]);
					String[] voAll = vo.getAll();
					bean = new PersonalSpecialtyBean(voAll[1], voAll[2], voAll[3], voAll[4]);
					if (bean.getType().equals("hobby")) {
						record = new JSONObject();
						record.put("registerNo", bean.getRegisterNo());
						record.put("type", bean.getType());
						record.put("name", bean.getName());
						record.put("iconCode", bean.getIconCode());
						hobby.add(record);
					}
					else if(bean.getType().equals("skill")) {
						record2 = new JSONObject();
						record2.put("registerNo", bean.getRegisterNo());
						record2.put("type", bean.getType());
						record2.put("name", bean.getName());
						record2.put("iconCode", bean.getIconCode());
						skill.add(record2);
					}
				}
				if(hobby.size()==0 && skill.size()==0){
					System.out.println("저장된게 없으");
				}
				else{
					obj.put("hobby", hobby);
					obj.put("skill", skill);
					out.println(obj);
					System.out.println(obj);
				}
				out.flush();
				out.close();
			} 
			catch (Exception e) {
				e.printStackTrace();
			}
		} 
	}
	
	/**
	 * 취미특기를 삭제하는 메소드
	 * @param response 응답객체
	 * @param memberID 회원ID 
	 * @param from 취미특기종류
	 * @throws IOException 요청,응답객체에서 발생하는 익셉션
	 * @throws ServletException DAO메소드를 성공하지 못했을 때 발생하는 익셉션
	 */
	@RequestMapping(value="/specialtydel.do", method=RequestMethod.POST)
	public void deleteSpecialty(HttpServletResponse response
			,@RequestParam("memberID") String memberID,@RequestParam("from") String from) throws IOException, ServletException{
		response.setCharacterEncoding("utf-8");
		out = response.getWriter();
		
		if(from.equals("hobby")){
			try {
				dao.deleteHobbyAll(memberID);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			out.println("취미 삭제 성공!!");
			out.flush();
			out.close();
		}
		else if(from.equals("skill")){
			try {
				dao.deleteSkillAll(memberID);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			out.println("특기 삭제 성공!!");
			out.flush();
			out.close();
		}
	}
}
