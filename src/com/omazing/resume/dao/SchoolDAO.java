package com.omazing.resume.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.omazing.resume.dto.GraduatedSchoolDTO;
import com.omazing.resume.dto.SchoolDTO;
/**
 * 이력서 - 학력사항 DAO
 * @author yeeun
 *
 */
@Repository
public class SchoolDAO {
	@Autowired
	private SqlSession session;
	/**
	 * 디폴트 생성자
	 */
	public SchoolDAO() {
		super();
	}
	/**
	 * DB에 고등학교 학력사항 insert 
	 * @param school 고등학교 학력사항 DTO 
	 * @return insert 성공 여부
	 */
	public boolean insertSchool(SchoolDTO school)
	{
		boolean res = false;
		try{
			res = session.insert("SchoolMapper.insertSchool", school) > 0;
		}catch(Exception e){
			e.printStackTrace();
		}
		return res;
	}
	/**
	 * DB에 대학교/대학원 학력사항 insert 
	 * @param school 대학교/대학원 학력사항 insert 
	 * @return insert 성공 여부
	 */
	public boolean insertGraduatedSchool(SchoolDTO school)
	{
		boolean res = false;
		try{
			res = session.insert("SchoolMapper.insertGraduatedSchool", school) > 0;
		}catch(Exception e){
			e.printStackTrace();
		}
		return res;
	}
	/**
	 * DB에 고등학교 학력사항 update 
	 * @param school 고등학교 학력사항 
	 * @return update 성공 여부 
	 */
	public boolean updateSchool(SchoolDTO school)
	{
		Boolean res = false;
		try{
			res = session.update("SchoolMapper.updateSchool", school) > 0;
		}catch(Exception e){
			e.printStackTrace();
		}
		return res;
	}
	/**
	 * DB에 대학교/대학원 학력사항 update 
	 * @param school 대학교/대학원 학력사항 
	 * @return update 성공 여부 
	 */
	public boolean updateGraduatedSchool(SchoolDTO school)
	{
		Boolean res = false;
		try{
			res = session.update("SchoolMapper.updateSchool", school) > 0;
			
			if(!res)
				return res;

			res = session.update("SchoolMapper.updateGraduatedSchool", school) > 0;
		}catch(Exception e){
			e.printStackTrace();
		}
		return res;
	}
	/**
	 * DB에 해당 회원의 모든 고등학교 학력사항 delete
	 * @param memberID 회원 아이디 
	 * @return delete 성공 여부 
	 */
	public boolean deleteSchool(String memberID)
	{
		Boolean res = false;
		try{
			res = session.delete("SchoolMapper.deleteSchoolById", memberID) > 0;
		}catch(Exception e){
			e.printStackTrace();
		}
		return res;
	}
	/**
	 * DB에 해당 고등학교 학력사항 delete  
	 * @param registerNo 고등학교 학력사항 등록번호
	 * @return delete 성공 여부
	 */
	public boolean deleteSchool(int registerNo)
	{
		Boolean res = false;
		try{
			res = session.delete("SchoolMapper.deleteSchoolByNo", registerNo) > 0;
		}catch(Exception e){
			e.printStackTrace();
		}
		return res;
	}
	/**
	 * DB에 해당 회원의 모든 대학교/대학원 학력사항 delete 
	 * @param memberID 회원 아이디
	 * @return delete 성공 여부
	 */
	public boolean deleteGraduatedSchool(String memberID)
	{
		Boolean res = false;
		try{
			res = session.delete("SchoolMapper.deleteGraduatedSchoolById", memberID) > 0;

			if(!res)
				return res;
			
			res = session.delete("SchoolMapper.deleteSchoolById", memberID) > 0;
		}catch(Exception e){
			e.printStackTrace();
		}
		return res;
	}
	/**
	 * DB에 해당 대학교/대학원 학력사항 delete
	 * @param registerNo 대학교/대학원 학력사항 등록번호 
	 * @return delete 성공 여부
	 */
	public boolean deleteGraduatedSchool(int registerNo)
	{
		Boolean res1 = false;
		Boolean res2 = false;
		try{
			res1 = session.delete("SchoolMapper.deleteGraduatedSchoolByNo", registerNo) > 0;
			
			if(!res1){
				res2 = session.delete("SchoolMapper.deleteSchoolByNo", registerNo) > 0;
				
				if(!res2){
					return false;
				}
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
		return true;
	}
	/**
	 * 해당 회원의 모든 고등학교 학력사항 select 
	 * @param memberID 회원 아이디 
	 * @return 고등학교 학력사항 DTO 목록
	 */
	public List<SchoolDTO> selectSchoolByID(String memberID)
	{
		List<SchoolDTO> list = null;
		try{
			list = session.selectList("SchoolMapper.selectSchoolById", memberID);
		}catch(Exception e){
			e.printStackTrace();
		}
		return list;
	}
	/**
	 * 해당 고등학교 학력사항 select 
	 * @param registerNo 고등학교 학력사항 등록번호
	 * @return 고등학교 학력사항 DTO 
	 */
	public SchoolDTO selectSchoolByRegisterNo(int registerNo)
	{
		SchoolDTO school = null;
		try{
			school = session.selectOne("SchoolMapper.selectSchoolByNo", registerNo);
		}catch(Exception e){
			e.printStackTrace();
		}
		return school;
	}
	/**
	 * 해당 회원의 모든 대학교/대학원 학력사항 select 
	 * @param memberID 회원 아이디 
	 * @return 대학교/대학원 학력사항 DTO 목록
	 */
	public List<SchoolDTO> selectGraduatedSchoolByID(String memberID)
	{
		List<SchoolDTO> list = null;
		try{
			list = session.selectList("SchoolMapper.selectGraduatedSchoolById", memberID);
		}catch(Exception e){
			e.printStackTrace();
		}
		return list;
	}
	/**
	 * 해당 대학교/대학원 학력사항 select 
	 * @param registerNo 대학교/대학원 학력사항 등록번호 
	 * @return 대학교/대학원 학력사항 DTO 
	 */
	public GraduatedSchoolDTO selectGraduatedSchoolByRegisterNo(int registerNo)
	{
		GraduatedSchoolDTO schoolDTO = null;
		try{
			schoolDTO = session.selectOne("SchoolMapper.selectGraduatedSchoolByNo", registerNo);
		}catch(Exception e){
			e.printStackTrace();
		}
		return schoolDTO;
	}
	/**
	 * 등록된 학력사항의 마지막 등록번호 반환
	 * @return 등록번호 
	 */
	public int getLastRegisterNo(){
      int registerNo = 0;
      
      try {
    	  registerNo = session.selectOne("SchoolMapper.selectLastRegisterNo");
      } catch (Exception e) {
         e.printStackTrace();
      }
      return registerNo;
	}
}
