package com.omazing.resume.dao;

import java.util.HashMap;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.omazing.resume.dto.PersonalInfoDTO;
/**
 * 이력서 인적사항 - 개인신상정보 DAO
 * @author yeeun
 *
 */
@Repository
public class PersonalInfoDAO {
	/*
	 * 세션 자동 주입
	 */
	@Autowired
	private SqlSession session;
	/**
	 * 디폴트 생성자 
	 */
	public PersonalInfoDAO(){
		super();
	}
	/**
	 * DB에 개인 신상 정보 insert 
	 * @param personalInfo 개인 신상 정보 DTO 
	 * @return insert 성공 여부
	 */
	public boolean insertPersonalInfo(PersonalInfoDTO personalInfo)
	{
		Boolean res = false;
		try{
			res = session.insert("PersonalInfoMapper.insert", personalInfo) > 0;
		}catch(Exception e){
			e.printStackTrace();
		}
		return res;
	}
	/*
	public boolean insertPersonalInfo(String memberID, String photoURL)
	{
		Boolean res = false;
		PreparedStatement pstmt = null;
		Connection conn = null;
		String sql = "insert into personal_info_tb (member_id, photo) values(?, ?)";
		
		try{
			conn = dao.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, memberID);
			pstmt.setString(2, photoURL);
			
			res = pstmt.executeUpdate() > 0;

		}catch(Exception e){
			e.printStackTrace();
		}
		return res;
		
	}*/
	/**
	 * DB에 개인 신상 정보 update 
	 * @param personalInfo 개인 신상 정보 
	 * @return update 성공 여부
	 */
	public boolean updatePersonalInfo(PersonalInfoDTO personalInfo)
	{
		Boolean res = null;
		try{
			res = session.update("PersonalInfoMapper.update", personalInfo) > 0;
		}catch(Exception e){
			e.printStackTrace();
		}
		return res;
	}
	/**
	 * DB에 해당 회원의 사진 update 
	 * @param memberID 회원 아이디 
	 * @param url 사진 url
	 * @return update 성공 여부
	 */
	public boolean updatePersonalInfo(String memberID, String url)
	{
		Boolean res = null;
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("memberID", memberID);
		map.put("url", url);
		
		try{
			res = session.update("PersonalInfoMapper.updatePhoto", map) > 0; 
		}catch(Exception e){
			e.printStackTrace();
		}
		return res;
	}
	/**
	 * DB에 해당 회원의 개인 신상 정보 delete 
	 * @param memberID 회원 아이디
	 * @return delete 성공 여부
	 */
	public boolean deletePersonalInfo(String memberID)
	{
		Boolean res = null;
		try{
			res = session.delete("PersonalInfoMapper.delete", memberID) > 0;
		}catch(Exception e){
			e.printStackTrace();
		}
		return res;
	}
	/**
	 * DB에 해당 회원의 개인 신상 정보 select 
	 * @param memberID 회원 아이디 
	 * @return select한 개인 신상 정보 DTO 
	 */
	public PersonalInfoDTO selectPersonalInfoByID(String memberID)
	{
		PersonalInfoDTO personalInfo = null;
		try{
			personalInfo = session.selectOne("PersonalInfoMapper.selectById", memberID);
		}catch(Exception e){
			e.printStackTrace();
		}
		return personalInfo;
	}
	/**
	 * DB에 해당 회원의 사진 url select 
	 * @param memberID 회원 아이디 
	 * @return 사진 url
	 */
	public String selectPhotoByID(String memberID){
		String photo = null;
		try{
			photo = session.selectOne("PersonalInfoMapper.selectPhoto", memberID);
			
		}catch(Exception e){
			e.printStackTrace();
		}
		return photo;
	}
	
}
