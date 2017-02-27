package com.omazing.resume.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.omazing.resume.dto.PrivateMemberDTO;
/**
 * 개인회원 정보 DAO
 * @author yeeun
 *
 */
@Repository
public class PrivateMemberDAO {
	@Autowired
	private SqlSession session;
	/**
	 * 디폴트 생성자
	 */
	public PrivateMemberDAO(){
		super();
	}
	/**
	 * DB에 개인회원 정보 insert 
	 * @param privateMember 개인회원 정보 DTO 
	 * @return insert 성공 여부
	 */
	public boolean insertPrivateMember(PrivateMemberDTO privateMember)
	{
		Boolean res = false;
		try{
			System.out.println(privateMember);
			res = session.insert("PrivateMemberMapper.insert", privateMember) > 0;
		}catch(Exception e){
			e.printStackTrace();
		}
		return res;
	}
	/**
	 * DB에 개인회원 정보 update 
	 * @param privateMember 개인회원 정보 
	 * @return update 성공 여부
	 */
	public boolean updatePrivateMember(PrivateMemberDTO privateMember)
	{
		Boolean res = null;
		try{
			res = session.update("PrivateMemberMapper.update", privateMember) > 0;
		}catch(Exception e){
			e.printStackTrace();
		}
		return res;
	}
	/**
	 * DB에 해당 회원 비활성화
	 * @param memberID 회원 아이디 
	 * @return 비활성화 성공 여부
	 */
	public boolean deActiveMember(String memberID)
	{
		Boolean res = null;
		try{
			res = session.update("PrivateMemberMapper.update", memberID) > 0;
		}catch(Exception e){
			e.printStackTrace();
		}
		return res;
	}
	/**
	 * DB에 해당 회원의 개인회원 정보 delete 
	 * @param memberID 회원 아이디
	 * @return delete 성공 여부
	 */
	public boolean deletePrivateMember(String memberID)
	{
		Boolean res = null;
		try{
			res = session.delete("PrivateMemberMapper.delete", memberID) > 0;

		}catch(Exception e){
			e.printStackTrace();
		}
		return res;
	}
	/**
	 * DB에 해당 회원의 개인회원 정보 select 
	 * @param memberID 회원 아이디 
	 * @return 개인회원 정보 DTO 
	 */
	public PrivateMemberDTO selectMemberById(String memberID)
	{
		PrivateMemberDTO privateMemberDTO = null;
		try{
			privateMemberDTO = session.selectOne("PrivateMemberMapper.selectMemberById", memberID);
		}catch(Exception e){
			e.printStackTrace();
		}
		return privateMemberDTO;
	}
	/**
	 * DB에 해당 회원의 이름 select 
	 * @param memberID 회원 아이디 
	 * @return 이름
	 */
	public String selectNameById(String memberID)
	{
		String name = null;
		try{
			name = session.selectOne("PrivateMemberMapper.selectNameById", memberID);
		}catch(Exception e){
			e.printStackTrace();
		}
		return name;
	}
	/**
	 * DB에 해당 회원의 비밀번호 select 
	 * @param memberID 회원 아이디
	 * @return 비밀번호
	 */
	public String selectPasswordById(String memberID)
	{
		String password = null;
		try{
			password = session.selectOne("PrivateMemberMapper.selectPwById", memberID);
		}catch(Exception e){
			e.printStackTrace();
		}
		return password;
	}
}
