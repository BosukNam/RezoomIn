package com.omazing.resume.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.omazing.resume.dto.SchoolStateCategoryDTO;
/**
 * 학력사항 상태 카테고리 DAO 
 * @author yeeun
 *
 */
@Repository
public class SchoolStateCategoryDAO {
	@Autowired
	private SqlSession session;
	/**
	 * 디폴트 생성자
	 */
	public SchoolStateCategoryDAO() {
		super();
	}
	/**
	 * 해당 상태 코드에 해당하는 상태 카테고리 select 
	 * @param stateCode 상태 코드
	 * @return 상태 카테고리 DTO
	 */
	public SchoolStateCategoryDTO selectSchoolStateCategoryByCode(String stateCode){
		SchoolStateCategoryDTO schoolStateCategoryDTO = null;
		try{
			schoolStateCategoryDTO = session.selectOne("SchoolStateCategoryMapper.selectByCode");
		}catch(Exception e){
			e.printStackTrace();
		}
		return schoolStateCategoryDTO;
	}
	/**
	 * 모든 상태 카테고리 select
	 * @return 전체 상태 카테고리 DTO 목록
	 */
	public List<SchoolStateCategoryDTO> selectAll(){
		List<SchoolStateCategoryDTO> list = null;
		try{
			list = session.selectList("SchoolStateCategoryMapper.selectAll");
		}catch(Exception e){
			e.printStackTrace();
		}
		return list;
	}
}
