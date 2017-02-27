package com.omazing.introduce.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.omazing.introduce.bean.IconURLCategoryBean;
import com.omazing.introduce.bean.PersonalBiographyBean;
import com.omazing.introduce.bean.PersonalSpecialtyBean;
import com.omazing.introduce.dao.IconURLCategoryDAO;
import com.omazing.introduce.dao.PersonalBiographyDAO;
import com.omazing.introduce.dto.IconURLCategoryDTO;
import com.omazing.introduce.dto.PersonalBiographyDTO;
import com.omazing.introduce.dto.PersonalSpecialtyDTO;
import com.omazing.introduce.model.IconURLCategoryVO;
import com.omazing.introduce.model.PersonalBiographyVO;
import com.omazing.introduce.model.PersonalSpecialtyVO;


@Controller
public class PersonalHistoryController {
	
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
	 * 성장과정 DTO
	 */
	private PersonalBiographyDTO dto;
	/**
	 * 성장과정 VO
	 */
	private PersonalBiographyVO vo;
	/**
	 * 아이콘카테고리 DAO
	 */
	@Autowired
	private IconURLCategoryDAO iconDAO;

	/**
	 * 성장과정 중 유년기,청소년기,대학생활,회사생활을 등록하는 메소드
	 * @param response 응답객체
	 * @param json 전송받은 정보값
	 * @throws IOException 요청,응답객체에서 발생하는 익셉션
	 * @throws ServletException DAO메소드를 성공하지 못했을 때 발생하는 익셉션
	 */
	@RequestMapping(value="/personal.do", method=RequestMethod.POST)
	public void insertHistory(HttpServletResponse response
			,@RequestParam("json") String json) throws IOException, ServletException{
		response.setCharacterEncoding("utf-8");
		out = response.getWriter();
		
			if(json!=null){
			JSONParser parser = new JSONParser();
			try {
				JSONObject inputObj = (JSONObject) parser.parse(json);
				String childhood = (String) inputObj.get("childhood");
				String student = (String) inputObj.get("student");
				String univ = (String) inputObj.get("univ");
				String company = (String) inputObj.get("company");
				String userID = (String) inputObj.get("id");
				PersonalBiographyBean bean = new PersonalBiographyBean(childhood, student, univ, company, null);
				String[] all = bean.getAll();

				vo = new PersonalBiographyVO(userID, all[0], all[1], all[2], all[3], all[4],null);
				String[] voAll = vo.getAll();
				dto = new PersonalBiographyDTO(voAll[0], voAll[1], voAll[2], voAll[3], voAll[4], voAll[5],null);
				try {
					if(dao.selectPersonalBiography(userID)==null){
						System.out.println("널이니까만들러가자");
						dao.insertPersonalBiography(userID);
					}
					boolean res = dao.updatePersonalBiography(dto);
					if(res==true){
						out.println("성장과정 등록 성공!!");
					}
					else{
						out.println("성장과정 등록 실패!!");
					}
				} catch (Exception e) {
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
	 * 성장과정 중 대표키워드를 등록하는 메소드
	 * @param response 응답객체
	 * @param keywords 대표키워드들
	 * @param memberID 회원ID
	 * @throws IOException 요청,응답객체에서 발생하는 익셉션
	 * @throws ServletException DAO메소드를 성공하지 못했을 때 발생하는 익셉션
	 */
	@RequestMapping(value="/personalkey.do", method=RequestMethod.POST)
	public void insertKeyword(HttpServletResponse response
			,@RequestParam("keyword") String[] keywords,@RequestParam("memberID") String memberID) throws IOException, ServletException{
		response.setCharacterEncoding("utf-8");
		out = response.getWriter();
		
		if (memberID != null) {
			if(keywords!=null){
			String keywordWithSlash="";
			int cnt=1;
				for(String tmp : keywords){
					keywordWithSlash+=tmp;
					if(cnt<keywords.length){
						keywordWithSlash+="/";
					}
					cnt++;
				}
				
				PersonalBiographyBean bean = new PersonalBiographyBean(null, null, null, null, keywordWithSlash);
				String[] all = bean.getAll();
				vo = new PersonalBiographyVO(memberID, null, null, null, null, all[4],null);
				String[] voAll = vo.getAll();
				dto = new PersonalBiographyDTO(voAll[0], voAll[1], voAll[2], voAll[3], voAll[4], voAll[5],null);
			try {
				if (dao.selectPersonalBiography(memberID) == null) {
					dao.insertPersonalBiography(memberID);
				}
				boolean res = dao.updatePersonalBiographyKeyword(memberID, dto.getKeyword());
				if (res == true) {
					out.println("대표키워드 등록 성공!!");
				} else {
					out.println("대표키워드 등록 실패!!");
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			out.flush();
			out.close();
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
	@RequestMapping(value="/personalpage.do", method=RequestMethod.GET)
	public void gotoHistoryPage(HttpServletRequest request, HttpServletResponse response
			,@RequestParam("type") String type) throws IOException, ServletException{
		RequestDispatcher view = request.getRequestDispatcher("/resources/views/personal_report.jsp");
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		try {
			Map<String, IconURLCategoryDTO> hobbyDTOMap = iconDAO.selectIconURLByType("hobby");
			Map<String, IconURLCategoryDTO> skillDTOMap = iconDAO.selectIconURLByType("skill");
			Map<String,IconURLCategoryVO> hobbyVOMap = new HashMap<>();
			Map<String,IconURLCategoryVO> skillVOMap = new HashMap<>();
			Map<String,IconURLCategoryBean> hobbyMap = new HashMap<>();
			Map<String,IconURLCategoryBean> skillMap = new HashMap<>();
			
			Set<String> hDTOKeys = hobbyDTOMap.keySet();
			Set<String> sDTOKeys = skillDTOMap.keySet();
			
			for(String key : hDTOKeys){
				IconURLCategoryDTO icondto = hobbyDTOMap.get(key);
				String[] vals =  icondto.getAll();
				
				IconURLCategoryVO iconvo = new IconURLCategoryVO(vals[0], vals[1], vals[2]);
				hobbyVOMap.put(key, iconvo);
			}
			for(String key : sDTOKeys){
				IconURLCategoryDTO icondto = skillDTOMap.get(key);
				String[] vals =  icondto.getAll();
				
				IconURLCategoryVO iconvo = new IconURLCategoryVO(vals[0], vals[1], vals[2]);
				skillVOMap.put(key, iconvo);
			}
			
			Set<String> hVOKeys = hobbyVOMap.keySet();
			Set<String> sVOKeys = skillVOMap.keySet();
			
			for(String key : hVOKeys){
				IconURLCategoryVO iconvo = hobbyVOMap.get(key);
				String[] vals =  iconvo.getAll();
				
				IconURLCategoryBean iconbean = new IconURLCategoryBean(vals[0], vals[1], vals[2]);
				hobbyMap.put(key, iconbean);
			}
			for(String key : sVOKeys){
				IconURLCategoryVO iconvo = skillVOMap.get(key);
				String[] vals =  iconvo.getAll();
				
				IconURLCategoryBean iconbean = new IconURLCategoryBean(vals[0], vals[1], vals[2]);
				skillMap.put(key, iconbean);
			}
			
			request.setAttribute("hobbyMap", hobbyMap);
			request.setAttribute("skillMap", skillMap);
			
		} catch (SQLException e2) {
			e2.printStackTrace();
		}
		
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
	 * 저장된 성장과정을 불러오는 메소드
	 * @param response 응답객체
	 * @param memberID 회원ID
	 * @throws IOException 요청,응답객체에서 발생하는 익셉션
	 * @throws ServletException DAO메소드를 성공하지 못했을 때 발생하는 익셉션
	 */
	@RequestMapping(value="/personalload.do", method=RequestMethod.GET)
	public void selectHistory(HttpServletResponse response
			,@RequestParam("id") String memberID) throws IOException, ServletException{
		response.setCharacterEncoding("utf-8");
		out = response.getWriter();
		
		if (memberID != null) {
			try {
				dto = dao.selectPersonalBiography(memberID);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			
		try{
			JSONObject obj = new JSONObject();
			JSONArray ary = new JSONArray();
			PersonalBiographyBean bean = null;
			
			if(dto != null){
				String[] dtoAll = dto.getAll();
				Map<Integer,PersonalSpecialtyDTO> dtomap = dto.getSpecialtyMap();
				Map<Integer,PersonalSpecialtyVO> vomap=null;
				JSONArray sary=null;
				if(dtomap!=null){
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
						sary = new JSONArray();
						sobj.put("registerNo", sbean.getRegisterNo());
						sobj.put("type", sbean.getType());
						sobj.put("name", sbean.getName());
						sobj.put("iconCode", sbean.getIconCode());
						sary.add(sobj);
					}
				}
				
				vo = new PersonalBiographyVO(dtoAll[0],dtoAll[1], dtoAll[2], dtoAll[3], dtoAll[4], dtoAll[5],vomap);
				String[] voAll = vo.getAll();
				bean = new PersonalBiographyBean(voAll[1], voAll[2], voAll[3], voAll[4], voAll[5]);
				if(bean.getKeyword() != null){
					StringTokenizer tok = new StringTokenizer(bean.getKeyword(),"/");
					while(tok.hasMoreTokens()){
						ary.add(tok.nextToken());
					}
				}
				
				obj.put("child", bean.getChildhood());
				obj.put("student", bean.getStudent());
				obj.put("company", bean.getCompany());
				obj.put("univ", bean.getUniv());
				obj.put("keyword", ary);
				obj.put("specialty", sary);
				out.println(obj);
				System.out.println(obj);
			} else {
				System.out.println("저장된게 없으");
			}
			out.flush();
			out.close();
		}
		catch(Exception e){
			e.printStackTrace();
			}
		}
	}
	
	/**
	 * 성장과정을 삭제하는 메소드
	 * @param response 응답객체
	 * @param memberID 회원ID
	 * @throws IOException 요청,응답객체에서 발생하는 익셉션
	 * @throws ServletException DAO메소드를 성공하지 못했을 때 발생하는 익셉션
	 */
	@RequestMapping(value="/personaldel.do", method=RequestMethod.POST)
	public void deleteHistory(HttpServletResponse response
			,@RequestParam("id") String memberID) throws IOException, ServletException{
		response.setCharacterEncoding("utf-8");
		out = response.getWriter();
		
		if (memberID != null) {
			try {
				if (dao.deletePersonalBiography(memberID)) {
					out.println("성장과정 삭제 성공!!");
				} else {
					out.println("성장과정 삭제 실패!!");
				}
				out.flush();
				out.close();
				return;
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
}
