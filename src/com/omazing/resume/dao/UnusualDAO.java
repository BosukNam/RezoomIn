package com.omazing.resume.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.omazing.resume.dto.UnusualDTO;
/**
 * 이력서 인적사항 - 보훈 장애사항 DAO
 * @author yeeun
 *
 */
@Repository
public class UnusualDAO {
	@Autowired
	private SqlSession session;
	/**
	 * 디폴트 생성자
	 */
	public UnusualDAO() {
		super();
	}
	/**
	 * DB에 보훈 장애사항 insert 
	 * @param unusual 보훈 장애사항 DTO
	 * @return insert 성공 여부 
	 */
	public boolean insertUnusual(UnusualDTO unusual)
	{
		Boolean res = false;
		try{
			res = session.insert("UnusualMapper.insert", unusual) > 0;
		}catch(Exception e){
			e.printStackTrace();
		}
		return res;
	}
	/**
	 * DB에 보훈 장애사항 update 
	 * @param unusual 보훈 장애사항 DTO  
	 * @return update 성공 여부
	 */
	public boolean updateUnusual(UnusualDTO unusual)
	{
		Boolean res = null;
		try{
			res = session.update("UnusualMapper.update", unusual) > 0;
		}catch(Exception e){
			e.printStackTrace();
		}
		return res;
	}
	/**
	 * DB에 보훈 장애사항 delete
	 * @param memberID 회원 아이디
	 * @return delete 성공 여부
	 */
	public boolean deleteUnusual(String memberID)
	{
		Boolean res = null;
		try{
			res = session.update("UnusualMapper.delete", memberID) > 0;
			System.out.println("unusual-delete:" + res);
		}catch(Exception e){
			e.printStackTrace();
		}
		return res;
	}
	/**
	 * DB에 보훈 장애사항 select 
	 * @param memberID 회원 아이디
	 * @return select한 보훈 장애사항
	 */
	public UnusualDTO selectUnusualByID(String memberID)
	{
		UnusualDTO unusual = null;
		try{
			unusual = session.selectOne("UnusualMapper.selectById", memberID);
		}catch(Exception e){
			e.printStackTrace();
		}
		return unusual;
	}
}
