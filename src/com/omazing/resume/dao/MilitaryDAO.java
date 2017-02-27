package com.omazing.resume.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.omazing.resume.dto.MilitaryDTO;
/**
 * 이력서 인적사항 - 병역사항 DAO
 * @author yeeun
 *
 */
@Repository
public class MilitaryDAO {
	@Autowired
	private SqlSession session;
	/**
	 * 디폴트 목록 
	 */
	public MilitaryDAO() {
		super();
	}
	/**
	 * DB에 병역사항 insert 
	 * @param military 병역사항 DTO 
	 * @return insert 성공 여부
	 */
	public boolean insertMilitary(MilitaryDTO military)
	{
		Boolean res = false;
		try{
			res = session.insert("MilitaryMapper.insert", military) > 0;
		}catch(Exception e){
			e.printStackTrace();
		}
		return res;
	}
	/**
	 * DB에 병역사항 update 
	 * @param military 병역사항 DTO 
	 * @return update 성공 여부
	 */
	public boolean updateMilitary(MilitaryDTO military)
	{
		Boolean res = null;
		try{
			res = session.update("MilitaryMapper.update", military) > 0;
		}catch(Exception e){
			e.printStackTrace();
		}
		return res;
	}
	/**
	 * DB에 해당 회원의 병역사항 delete
	 * @param memberID 회원 아이디 
	 * @return delete 성공 여부
	 */
	public boolean deleteMilitary(String memberID)
	{
		Boolean res = null;
		try{
			res = session.delete("MilitaryMapper.delete", memberID) > 0;
		}catch(Exception e){
			e.printStackTrace();
		}
		return res;
	}
	/**
	 * DB에 해당 회원의 병역사항 select 
	 * @param memberID 회원 아이디
	 * @return select한 병역사항 DTO 
	 */
	public MilitaryDTO selectMilitaryByID(String memberID)
	{
		MilitaryDTO military = null;
		try{
			military = session.selectOne("MilitaryMapper.selectById", memberID);
		}catch(Exception e){
			e.printStackTrace();
		}
		return military;
	}
}
