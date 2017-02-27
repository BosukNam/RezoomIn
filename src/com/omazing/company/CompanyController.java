package com.omazing.company;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.omazing.portfolio.dao.ProgrammingSkillDAO;
import com.omazing.resume.dao.CompanyMemberDAO;
import com.omazing.resume.dto.CompanyMemberDTO;
import com.omazing.resume.dto.PrivateMemberDTO;
/**
 * 기업회원 정보 Controlelr 
 * @author yeeun
 *
 */
@Controller
public class CompanyController {
	/**
	 * 보유기술 DAO 
	 */
	@Autowired
	private ProgrammingSkillDAO programmingSkillDAO;
	/**
	 * 기업회원 정보 DAO
	 */
	@Autowired
	private CompanyMemberDAO companyMemberDAO;
	/**
	 * 디폴트 생성자
	 */
	public CompanyController(){
		System.out.println("CompanyController()");
	}
	/**
	 * 회원 조회 
	 * @param search_select 기술 분야 
	 * @param search_input 기술명 
	 * @param response 응답객체 
	 */
	@RequestMapping(value="/searchMember.do")
	public void searchMember(@RequestParam String search_select,
							 @RequestParam String search_input,
							 HttpServletResponse response){
		
		System.out.println("skill - " + search_input + " / " + search_select);
		List<SearchMemberVO> list 
			= programmingSkillDAO.selectProgrammingSkillBySkill(search_select, search_input);
	
		System.out.println("company-list : " + list);
		
		JSONArray data = new JSONArray();
		for(SearchMemberVO i : list)
		{
			JSONObject obj = new JSONObject();
			String id = i.getMember_id();
			System.out.println(i);
			
			obj.put("id", id);
			obj.put("name", i.getName());
			obj.put("email", i.getEmail());
			obj.put("rank", i.getRank());
			data.add(obj);
		}
		
		response.setCharacterEncoding("UTF-8");
		PrintWriter writer = null;
		try {
			writer = response.getWriter();
//			if(list.size() != 0)
//				obj.put("msg", "SEARCH-SUCCESS");
//			else
//				obj.put("msg", "SEARCH-FAIL");
		} catch (IOException e) {
			e.printStackTrace();
		}
		writer.println(data);
	}
	/**
	 * 기업회원 로그인 
	 * @param request 요청객체 
	 * @param response 응답객체 
	 * @param id 로그인 할 아이디 
	 * @param pwd 로그인 할 비밀번호 
	 * @throws IOException
	 */
	@RequestMapping(value = "/companylogin.do", method=RequestMethod.POST)
	public void login(HttpServletRequest request,HttpServletResponse response,
			@RequestParam("id") String id,@RequestParam("pwd") String pwd) throws IOException{
		PrintWriter out = response.getWriter();
		System.out.println("아이디:"+id+"/비밀번호:"+pwd);
		
		CompanyMemberDTO dto = companyMemberDAO.selectMemberById(id);
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
	 * 로그아웃 
	 * @param request 요청객체 
	 * @param response 응답객체 
	 * @throws IOException
	 * @throws ServletException
	 */
	@RequestMapping(value = "/companylogout.do", method=RequestMethod.GET)
	public void logout(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException{
		RequestDispatcher view = request.getRequestDispatcher("/resources/views/main.jsp");
		request.getSession().removeAttribute("memberID");
		request.getSession().removeAttribute("islogin");
		view.forward(request, response);
	}
	/**
	 * 로그인 후 jsp 이동 
	 * @param request 요청객체 
	 * @param response 응답객체 
	 * @throws IOException
	 * @throws ServletException
	 */
	@RequestMapping(value = "/companypage.do", method=RequestMethod.GET)
	public void afterlogin(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException{
		RequestDispatcher view = request.getRequestDispatcher("/resources/views/search_member.jsp");
		view.forward(request, response);
	}
	/**
	 * 기업회원 회원 가입 
	 * @param request 요청객체 
	 * @param response 응답객체 
	 * @param memberID 회원 아이디 
	 * @param password 비밀번호 
	 * @param name 담당자 이름 
	 * @param email 담당자 이메일 
	 * @param companyName 기업명 
	 * @param companyNo 사업자 번호 
	 * @throws IOException
	 * @throws ServletException
	 */
	@RequestMapping(value = "/companyjoin.do", method=RequestMethod.POST)
	public void signup(HttpServletRequest request,HttpServletResponse response
			,@RequestParam("company_id") String memberID,@RequestParam("company_pw") String password
			,@RequestParam("company_manager_name") String name,@RequestParam("company_email") String email
			,@RequestParam("company_name") String companyName,@RequestParam("company_num") String companyNo
			)throws IOException, ServletException{
		
		PrintWriter out = response.getWriter();
		CompanyMemberDTO dto
		= new CompanyMemberDTO(memberID, password, name, email, companyName, companyNo, "1", "1", 0, true);
		System.out.println("디티오!"+dto);
		
		if(companyMemberDAO.insertCompanyMember(dto)){
			out.println("JOIN-SUCCESS");
		}
		else{
			out.println("JOIN-FAIL");
		}
		out.flush();
		out.close();
	}
}
