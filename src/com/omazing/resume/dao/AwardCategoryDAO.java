package com.omazing.resume.dao;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.omazing.resume.dto.AwardCategoryDTO;
import com.omazing.resume.dto.LanguageExamDTO;

/**
 * 수상 분류 DAO
 * @author Jun Seop
 *
 */
@Repository
public class AwardCategoryDAO implements Serializable {
	/**
	 * Mybatis 연동을 위한 SqlSession 객체
	 */
	@Autowired
	SqlSession session;
	/**
	 * 기본 생성자
	 */
	public AwardCategoryDAO() {
	}
	/**
	 * 전체 수상 분류 목록 가져오는 메서드
	 * @return AwardCategoryDTO[](전체 수상 분류 목록)
	 */
	public AwardCategoryDTO[] selectAwardCategoryAll(){
		List<AwardCategoryDTO>list =  session.selectList(
				"AwardCategoryMapper.selectAwardCategoryAll");
		AwardCategoryDTO[] res = new AwardCategoryDTO[list.size()];
		for(int i = 0 ; i < res.length; ++i){
			res[i] = new AwardCategoryDTO(list.get(i).getCategoryCode(), 
					list.get(i).getCategory());
		}
		return res;
	}
}
