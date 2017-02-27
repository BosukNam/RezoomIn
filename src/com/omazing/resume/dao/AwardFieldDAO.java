package com.omazing.resume.dao;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.omazing.resume.dto.AwardCategoryDTO;
import com.omazing.resume.dto.AwardFieldDTO;

/**
 * 수상 분야 DAO
 * @author Jun Seop
 *
 */
@Repository
public class AwardFieldDAO implements Serializable {
	/**
	 * Mybatis 연동을 위한 SqlSession 객체
	 */
	@Autowired
	SqlSession session;
	/**
	 * 기본 생성자
	 */
	public AwardFieldDAO() {
	}
	/**
	 * 전체 수상 분야 목록 가져오는 메서드
	 * @return AwardFieldDTO[](전체 수상 분야 목록)
	 */
	public AwardFieldDTO[] selectAwardFieldAll(){
		List<AwardFieldDTO>list =  session.selectList(
				"AwardFieldMapper.selectAwardFieldAll");
		AwardFieldDTO[] res = new AwardFieldDTO[list.size()];
		for(int i = 0 ; i < res.length; ++i){
			res[i] = new AwardFieldDTO(list.get(i).getFieldCode(), 
					list.get(i).getField(), list.get(i).getCategoryCode());
		}
		return res;
	}
}
