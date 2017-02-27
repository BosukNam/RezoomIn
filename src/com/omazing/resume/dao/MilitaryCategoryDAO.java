package com.omazing.resume.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.omazing.resume.dto.MilitaryCategoryDTO;
/**
 * 군별 구분 카테고리 DAO
 * @author yeeun
 *
 */
@Repository
public class MilitaryCategoryDAO {
	@Autowired
	private SqlSession session;
	/**
	 * 디폴트 생성자
	 */
	public MilitaryCategoryDAO() {
		super();
	}
	/**
	 * 해당 군별구분 코드에 해당하는 군별구분 카테고리 select 
	 * @param categoryCode 군별구분 코드
	 * @return 군별구분 카테고리 DTO 
	 */
	public MilitaryCategoryDTO selectMilitaryCategoryByCode(String categoryCode){
		MilitaryCategoryDTO militaryCategoryDTO = null;
		try{
			militaryCategoryDTO = session.selectOne("MilitaryCategoryMapper.selectByCode", categoryCode);
		}catch(Exception e){
			e.printStackTrace();
		}
		return militaryCategoryDTO;
	}
	/**
	 * 모든 군별구분 카테고리 select 
	 * @return 전체 군별구분 카테고리 DTO 목록 
	 */
	public List<MilitaryCategoryDTO> selectAll(){
		List<MilitaryCategoryDTO> list = null;
		try{
			list = session.selectList("MilitaryCategoryMapper.selectAll");
		}catch(Exception e){
			e.printStackTrace();
		}
		return list;
	}
}
