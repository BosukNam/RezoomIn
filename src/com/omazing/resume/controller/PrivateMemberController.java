package com.omazing.resume.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.omazing.resume.dao.PrivateMemberDAO;
import com.omazing.resume.dto.PrivateMemberDTO;
/**
 * 개인회원 정보 Controller 
 * @author yeeun
 *
 */
@Controller
public class PrivateMemberController {
	/**
	 * 개인회원 정보 DAO
	 */
	@Autowired
	private PrivateMemberDAO dao;
	
	/**
	 * 개인회원 로그인 
	 * @param request 요청객체 
	 * @param response 응답객체 
	 * @param id 로그인 할 아이디 
	 * @param pwd 로그인 할 비밀번호 
	 * @throws IOException
	 */
	@RequestMapping(value = "/privatelogin.do", method=RequestMethod.POST)
	public void login(HttpServletRequest request,HttpServletResponse response,
			@RequestParam("id") String id,@RequestParam("pwd") String pwd) throws IOException{
		PrintWriter out = response.getWriter();
		System.out.println("아이디:"+id+"/비밀번호:"+pwd);
		
		PrivateMemberDTO dto = dao.selectMemberById(id);
		System.out.println(dto);
		if(dto != null){
			if(pwd.equals(dto.getPassword())){
				out.println("LOGIN-SUCCESS");
				request.getSession().setAttribute("memberID", id);
				request.getSession().setAttribute("islogin", "true");
			}
			else{
				out.println("LOGIN-FAIL");
			}
		}
		else{
			out.println("NO-ID");
		}
		
		out.flush();
		out.close();
	}
	/**
	 * 로그인 후 jsp 이동 
	 * @param request 요청객체 
	 * @param response 응답객체 
	 * @throws IOException
	 * @throws ServletException
	 */
	@RequestMapping(value = "/privateafterlogin.do", method=RequestMethod.GET)
	public void afterlogin(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException{
		RequestDispatcher view = request.getRequestDispatcher("/resources/views/main.jsp");
		view.forward(request, response);
	}
	/**
	 * 로그아웃 
	 * @param request 요청객체 
	 * @param response 응답객체 
	 * @throws IOException
	 * @throws ServletException
	 */
	@RequestMapping(value = "/privatelogout.do", method=RequestMethod.GET)
	public void logout(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException{
		RequestDispatcher view = request.getRequestDispatcher("/resources/views/main.jsp");
		request.getSession().removeAttribute("memberID");
		request.getSession().removeAttribute("islogin");
		view.forward(request, response);
	}
	/**
	 * 개인회원 회원 가입 
	 * @param request 요청객체 
	 * @param response 응답객체 
	 * @param memberID 회원 아이디 
	 * @param password 비밀번호 
	 * @param name 이름 
	 * @param email 이메일 
	 * @throws IOException
	 * @throws ServletException
	 */
	@RequestMapping(value = "/privatejoin.do", method=RequestMethod.POST)
	public void signup(HttpServletRequest request,HttpServletResponse response
			,@RequestParam("private_id") String memberID,@RequestParam("private_pw") String password,
			@RequestParam("private_name") String name,@RequestParam("private_email") String email
			)throws IOException, ServletException{
		
		PrintWriter out = response.getWriter();
		PrivateMemberDTO dto = new PrivateMemberDTO(memberID, password, name, email, true);
		
		System.out.println("디티오!"+dto);
		
		if(dao.insertPrivateMember(dto)){
			out.println("JOIN-SUCCESS");
		}
		else{
			out.println("JOIN-FAIL");
		}
		out.flush();
		out.close();
	}
	
}
