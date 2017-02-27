package com.omazing.resume.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.omazing.resume.dto.SchoolCategoryDTO;
/**
 * 학력사항 분류 카테고리 DAO 
 * @author yeeun
 *
 */
@Repository
public class SchoolCategoryDAO {
	@Autowired
	private SqlSession session;
	/**
	 * 디폴트 생성자
	 */
	public SchoolCategoryDAO() {
		super();
	}
	/**
	 * 해당 분류 코드에 해당하는 분류 카테고리 select 
	 * @param categoryCode 분류 코드
	 * @return 분류 카테고리 DTO 
	 */
	public SchoolCategoryDTO selectSchoolCategoryByCode(String categoryCode){
		SchoolCategoryDTO schoolCategoryDTO = null;
		try{
			schoolCategoryDTO = session.selectOne("SchoolCategoryMapper.selectByCode", categoryCode);
		}catch(Exception e){
			e.printStackTrace();
		}
		return schoolCategoryDTO;
	}
	/**
	 * 모든 분류 카테고리 select 
	 * @return 전체 분류 카테고리 DTO 목록
	 */
	public List<SchoolCategoryDTO> selectAll(){
		List<SchoolCategoryDTO> list = null;
		try{
			list = session.selectList("SchoolCategoryMapper.selectAll");
		}catch(Exception e){
			e.printStackTrace();
		}
		return list;
	}
}
