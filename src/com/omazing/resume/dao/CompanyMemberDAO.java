package com.omazing.resume.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.omazing.resume.dto.CompanyMemberDTO;
/**
 * 기업회원 정보 DAO
 * @author yeeun
 *
 */
@Repository
public class CompanyMemberDAO {
	@Autowired
	private SqlSession session;
	/**
	 * 디폴트 생성자
	 */
	public CompanyMemberDAO(){
		super();
	}
	/**
	 * DB에 기업회원 정보 insert 
	 * @param companyMember 기업회원 정보 DTO 
	 * @return insert 성공 여부
	 */
	public boolean insertCompanyMember(CompanyMemberDTO companyMember)
	{
		Boolean res = false;
		try{
			res = session.insert("CompanyMemberMapper.insert", companyMember) > 0;
		}catch(Exception e){
			e.printStackTrace();
		}
		return res;
	}
	/**
	 * DB에 기업회원 정보 update 
	 * @param companyMember 기업회원 정보 DTO 
	 * @return update 성공 여부
	 */
	public boolean updateCompanyMember(CompanyMemberDTO companyMember)
	{
		Boolean res = null;
		try{
			res = session.update("CompanyMemberMapper.update", companyMember) > 0;
		}catch(Exception e){
			e.printStackTrace();
		}
		return res;
	}
	 /**
	  * DB에 해당회원의 기업회원 정보 비활성화 
	  * @param memberID 회원 아이디 
	  * @return 비활성화 성공 여부
	  */
	public boolean deActiveMember(String memberID)
	{
		Boolean res = null;
		try{
			res = session.update("CompanyMemberMapper.update", memberID) > 0;
		}catch(Exception e){
			e.printStackTrace();
		}
		return res;
	}
	/**
	 * DB에 해당 회원의 기업회원 정보 delete
	 * @param memberID 회원 아이디 
	 * @return delete 성공 여부 
	 */
	public boolean deleteCompanyMember(String memberID)
	{
		Boolean res = null;
		try{
			res = session.delete("CompanyMemberMapper.delete", memberID) > 0;
		}catch(Exception e){
			e.printStackTrace();
		}
		return res;
	}
	/**
	 * DB에 해당 회원의 기업회원 정보 select 
	 * @param memberID 회원 아이디 
	 * @return select한 기업회원 정보 DTO 
	 */
	public CompanyMemberDTO selectMemberById(String memberID)
	{
		CompanyMemberDTO companyMemberDTO = null;
		try{
			companyMemberDTO = session.selectOne("CompanyMemberMapper.selectMemberById", memberID);
		}catch(Exception e){
			e.printStackTrace();
		}
		return companyMemberDTO;
	}
	/**
	 * DB에 해당 회원의 이름 select 
	 * @param memberID 회원 아이디 
	 * @return select한 기업회원 이름 
	 */
	public String selectNameById(String memberID)
	{
		String name = null;
		try{
			name = session.selectOne("CompanyMemberMapper.selectNamerById", memberID);
		}catch(Exception e){
			e.printStackTrace();
		}
		return name;
	}
	/**
	 * DB에 해당 회원의 비밀번호 select 
	 * @param memberID 회원 아이디 
	 * @return select한 기업회원 비밀번호
	 */
	public String selectPasswordById(String memberID)
	{
		String password = null;
		try{
			password = session.selectOne("CompanyMemberMapper.selectPwById", memberID);
		}catch(Exception e){
			e.printStackTrace();
		}
		return password;
	}
}
