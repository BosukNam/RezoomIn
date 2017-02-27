package com.omazing.resume.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.omazing.resume.dto.MilitaryRankCategoryDTO;
/**
 * 군별계급 카테고리 DAO 
 * @author yeeun
 *
 */
@Repository
public class MilitaryRankCategoryDAO {
	@Autowired
	private SqlSession session;
	/**
	 * 디폴트 생성자
	 */
	public MilitaryRankCategoryDAO() {
		super();
	}
	/**
	 * 해당 군별계급 코드에 해당하는 군별계급 카테고리 select 
	 * @param rankCode 군별계급 코드
	 * @return 군별계급 카테고리 DTO 
	 */
	public MilitaryRankCategoryDTO selectMilitaryRankCategoryByCode(String rankCode){
		MilitaryRankCategoryDTO militaryRankCategoryDTO = null;
		try{
			militaryRankCategoryDTO = session.selectOne("MilitaryRankCategoryMapper.selectByCode", rankCode);
		}catch(Exception e){
			e.printStackTrace();
		}
		return militaryRankCategoryDTO;
	}
	/**
	 * 모든 군별계급 카테고리 반환 
	 * @return 전체 군별계급 카테고리 DTO 목록
	 */
	public List<MilitaryRankCategoryDTO> selectAll(){
		List<MilitaryRankCategoryDTO> list = null;
		try{
			list = session.selectList("MilitaryRankCategoryMapper.selectAll");
		}catch(Exception e){
			e.printStackTrace();
		}
		return list;
	}
}
