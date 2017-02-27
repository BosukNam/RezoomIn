package com.omazing.resume.dao;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.omazing.resume.dto.ActivityCategoryDTO;
import com.omazing.resume.dto.AwardFieldDTO;
import com.omazing.resume.dto.CareerDTO;
/**
 * 대외활동 분류 DAO
 * @author Jun Seop
 *
 */
@Repository
public class ActivityCategoryDAO implements Serializable {
	/**
	 * Mybatis 연동을 위한 SqlSession 객체
	 */
	@Autowired
	private SqlSession session;
	/**
	 * 전체 대외활동 분류 목록 가져오는 메서드
	 * @return ActivityCategoryDTO[](전체 대외 활동 분류 목록)
	 */
	public ActivityCategoryDTO[] selectActivityCategoryAll(){
		List<ActivityCategoryDTO>list =  session.selectList(
				"ActivityCategoryMapper.selectActivityCategoryAll");
		ActivityCategoryDTO[] res = new ActivityCategoryDTO[list.size()];
		for(int i = 0 ; i < res.length; ++i){
			res[i] = new ActivityCategoryDTO(list.get(i).getCategoryCode(), 
					list.get(i).getCategory());
		}
		return res;
	}
	
}
