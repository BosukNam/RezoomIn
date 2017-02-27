package com.omazing.resume.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.omazing.resume.dto.UnusualCategoryDTO;

/**
 * 장애등급 카테고리 DAO 
 * @author yeeun
 *
 */
@Repository
public class UnusualCategoryDAO {
	@Autowired
	private SqlSession session;
	
	/**
	 * 디폴트 생성자
	 */
	public UnusualCategoryDAO() {
		super();
	}
	/**
	 * 해당 장애등급 코드에 해당하는 장애등급 카테고리 select 
	 * @param disabilityCode 장애등급 코드
	 * @return 장애등급 카테고리 DTO 
	 */
	public UnusualCategoryDTO selectUnusualCategoryByCode(String disabilityCode){
		UnusualCategoryDTO unusualCategoryDTO = null;
		try{
			unusualCategoryDTO = session.selectOne("UnusualCategoryMapper.selectByCode", disabilityCode);
		}catch(Exception e){
			e.printStackTrace();
		}
		return unusualCategoryDTO;
	}
	/**
	 * 모든 장애등급 카테고리 select 
	 * @return 전체 장애등급 카테고리 DTO 목록
	 */
	public List<UnusualCategoryDTO> selectAll(){
		List<UnusualCategoryDTO> list = null;
		
		try{
			list = session.selectList("UnusualCategoryMapper.selectAll");
			
		}catch(Exception e){
			e.printStackTrace();
		}
		return list;
	}
}
