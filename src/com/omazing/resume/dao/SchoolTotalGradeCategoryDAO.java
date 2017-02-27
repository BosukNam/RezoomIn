package com.omazing.resume.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.omazing.resume.dto.SchoolTotalGradeCategoryDTO;
/**
 * 학력사항 총 학점 카테고리 DAO 
 * @author yeeun
 *
 */
@Repository
public class SchoolTotalGradeCategoryDAO {
	@Autowired
	private SqlSession session;
	/**
	 * 디폴트 생성자
	 */
	public SchoolTotalGradeCategoryDAO() {
		super();
	}
	/**
	 * 해당 총 학점 코드에 해당하는 총 학점 카테고리 select 
	 * @param totalGradeCode 총 학점 코드
	 * @return 총 학점
	 */
	public SchoolTotalGradeCategoryDTO selectSchoolTotalGradeCategoryByCode(String totalGradeCode){
		SchoolTotalGradeCategoryDTO schoolTotalGradeCategoryDTO = null;
		try{
			schoolTotalGradeCategoryDTO = session.selectOne("SchoolTotalGradeCategoryMapper.selectByCode", totalGradeCode);
		}catch(Exception e){
			e.printStackTrace();
		}
		return schoolTotalGradeCategoryDTO;
	}
	/**
	 * 모든 총 학점 카테고리 select 
	 * @return 전체 총 학점 카테고리 DTO 목록
	 */
	public List<SchoolTotalGradeCategoryDTO> selectAll(){
		List<SchoolTotalGradeCategoryDTO> list = null;
		try{
			list = session.selectList("SchoolTotalGradeCategoryMapper.selectAll");
		}catch(Exception e){
			e.printStackTrace();
		}
		return list;
	}
}
