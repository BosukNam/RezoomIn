package com.omazing.resume.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.omazing.resume.dto.SchoolTrackCategoryDTO;
/**
 * 학력사항 계열 카테고리 DAO 
 * @author yeeun
 *
 */
@Repository
public class SchoolTrackCategoryDAO {
	@Autowired
	private SqlSession session;
	/**
	 * 디폴트 생성자
	 */
	public SchoolTrackCategoryDAO() {
		super();
	}
	/**
	 * 해당 계열 코드에 해당하는 계열 카테고리 select 
	 * @param trackCode
	 * @return
	 */
	public SchoolTrackCategoryDTO selectSchoolTrackCategoryByCode(String trackCode){
		SchoolTrackCategoryDTO schoolTrackCategoryDTO = null;
		try{
			schoolTrackCategoryDTO = session.selectOne("SchoolTrackCategoryMapper.selectByCode", trackCode);
		}catch(Exception e){
			e.printStackTrace();
		}
		return schoolTrackCategoryDTO;
	}
	/**
	 * 모든 계열 카테고리 select 
	 * @return 전체 계열 카테고리 DTO 목록 
	 */
	public List<SchoolTrackCategoryDTO> selectAll(){
		List<SchoolTrackCategoryDTO> list = null;
		try{
			list = session.selectList("SchoolTrackCategoryMapper.selectAll");
		}catch(Exception e){
			e.printStackTrace();
		}
		return list;
	}
}
