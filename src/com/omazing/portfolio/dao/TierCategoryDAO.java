package com.omazing.portfolio.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.omazing.portfolio.dto.TierCategoryDTO;

@Repository
public class TierCategoryDAO {
	@Autowired
	private SqlSession sqlSession;

	public TierCategoryDAO() {
		super();
	}
	
	public List<TierCategoryDTO> selectTierCategory(){
		try {
			return sqlSession.selectList("TierCategoryMapper.selectTierCategory");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
