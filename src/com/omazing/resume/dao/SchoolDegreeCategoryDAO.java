package com.omazing.resume.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.omazing.resume.dto.SchoolDegreeCategoryDTO;
/**
 * 학력사항 학위 카테고리 DAO 
 * @author yeeun
 *
 */
@Repository
public class SchoolDegreeCategoryDAO {
	@Autowired
	private SqlSession session;
	/**
	 * 디폴트 생성자
	 */
	public SchoolDegreeCategoryDAO() {
		super();
	}
	/**
	 * 해당 학위 코드에 해당하는 학위 카테고리 select 
	 * @param degreeCode 학위 코드
	 * @return 학위 카테고리 DTO 
	 */
	public SchoolDegreeCategoryDTO selectSchoolDegreeCategoryByCode(String degreeCode){
		SchoolDegreeCategoryDTO schoolDegreeCategoryDTO = null;
		try{
			schoolDegreeCategoryDTO = session.selectOne("SchoolDegreeCategoryMapper.selectByCode");
		}catch(Exception e){
			e.printStackTrace();
		}
		return schoolDegreeCategoryDTO;
	}
	/**
	 * 모든 학위 카테고리 DTO select 
	 * @return 전체 학위 카테고리 DTO 목록
	 */
	public List<SchoolDegreeCategoryDTO> selectAll(){
		List<SchoolDegreeCategoryDTO> list = null;
		try{
			list = session.selectList("SchoolDegreeCategoryMapper.selectAll");
		}catch(Exception e){
			e.printStackTrace();
		}
		return list;
	}
}
